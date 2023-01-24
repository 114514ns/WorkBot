package cn.pprocket.bot.listener;

import cn.hutool.extra.pinyin.PinyinUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpUtil;
import cn.pprocket.bot.WorkClient;
import cn.pprocket.bot.bean.SubmitUserDTO;
import cn.pprocket.bot.bean.WorkDetail;
import cn.pprocket.bot.bean.WorkList;
import cn.pprocket.bot.utils.Debug;
import cn.pprocket.bot.utils.NetWorkUtils;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.promeg.pinyinhelper.Pinyin;
import com.google.gson.Gson;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.message.data.ForwardMessageBuilder;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.PlainText;
import net.mamoe.mirai.utils.ExternalResource;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MessageListener {
    Gson gson = new Gson();


    InputStream getImage(String url) {
        InputStream stream = null;
        try {
            URLConnection connection = new URL(url).openConnection();
            stream = connection.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Debug.Debug("请求图片");
        return stream;
    }
    Integer getNumber(String s ) {
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(s);
        String all = matcher.replaceAll("");
        return new Integer(all);
    }
    String getFirstLetter(String s) {
        String result = "";
        for (int i = 0;i<s.length();i++) {
            char c = s.charAt(i);
            String min =  Pinyin.toPinyin(String.valueOf(c),"").toLowerCase();
            result += min.charAt(0);
        }
        String place = "";
        return result;
    }
    static String getCardAnswer(String cardId) {
        HashMap<String,String> header = new HashMap<>();
        header.put("token",WorkClient.INSTANCE.getToken());
        String fullUrl = "https://lulu.lulufind.com/mrzy/user/getCardResult?id=" + cardId + "&type=0&classId=21418707&start=0&num=99999";
         Debug.Debug("请求答题卡答案");
        header.put("sign",NetWorkUtils.genSign(fullUrl));
        String res =  HttpUtil.createPost("https://lulu.lulufind.com/mrzy/user/getCardResult")
                .body("id=" + cardId + "&type=0&classId=21418707&start=0&num=99999","application/x-www-form-urlencoded")
                .addHeaders(header)
                .execute()
                .body();
        JSONArray obj  = JSONObject.parseObject(res).getJSONArray("data");
        final StringBuilder[] msg = {new StringBuilder("")};
        final int[] flag = {0};
        int[] order = new int[2];
        order[0] = 1;
        order[1] = 5;
        obj.forEach(ele -> {
            int from = order[0];
            int to = order[1];
            String prefix = from + "-" + to + "  ";
            JSONObject  copy = (JSONObject) ele;
            String answer = copy.getString("answer");
            String letter = "";
            if (flag[0]%5 ==0) {
                msg[0].append(prefix);
                order[0]+=5;
                order[1]+=5;
            }
            switch (answer) {
                case "1" :{
                    letter = "A";
                } break;
                case "2": {
                    letter = "B";
                } break;
                case "3": {
                    letter = "C";
                } break;
                case "4": {
                    letter = "D";
                } break;
				case "5" : {
					letter = "E";
				} break;
                default: {
                    letter = answer;
                }
            }
            flag[0]++;
            msg[0].append(letter + "   ");
            if (flag[0]%5 ==0) {
                msg[0].append("\r\n\r\n\r\n");
            }
        });
        return msg[0].toString();
    }


    public void start() {
        Listener listener = GlobalEventChannel.INSTANCE.subscribeAlways(FriendMessageEvent.class, event -> {
            MessageChain chain = event.getMessage(); // 可获取到消息内容等, 详细查阅 `GroupMessageEvent`
            String message = chain.contentToString();
            message = message.toLowerCase();
            List<WorkList.DataDTO> list = WorkClient.INSTANCE.getWorkList();
            if (message.equals("获取作业列表") || message.equals("list")) {
                StringBuilder sb = new StringBuilder();
                int[] i = new int[]{0};
                i[0] = 1;
                list.forEach(ele -> {
                    String title = ele.getWorkDetail();
                    sb.append(i[0]++ + "    " + title + "\n");
                });
                event.getSubject().sendMessage(sb.toString());
                return;
            }
            Integer inputId = getNumber(message);
            String name = message.replaceAll(String.valueOf(inputId),"").replace(" ","");
            WorkList.DataDTO list1 = list.get(inputId-1);
            String res = NetWorkUtils.sendPOST("https://lulu.lulufind.com/mrzy/mrzypc/getWorkDetail?workId=" + list1.getWorkId());
            Debug.Debug("请求作业信息");
            JSONObject obj = JSONObject.parseObject(res);
            Friend user = event.getSubject();
            ForwardMessageBuilder builder = new ForwardMessageBuilder(user);
            final JSONObject[] submitUser = {null};
            obj.getJSONObject("data").getJSONArray("submitUser").forEach(value-> {
                JSONObject copy = (JSONObject) value;
                if ((getFirstLetter(copy.getString("userRealName")).equals(name)) && copy.getString("submitCover")!= null) {
                    submitUser[0] = copy;
                }
            });
            boolean isCard = obj.getJSONObject("data").getString("cardId")!=null;
            if (submitUser[0] == null) {
                event.getSubject().sendMessage("没有这个人（或者没有交");
                return;
            }
            String imageUrl = submitUser[0].getString("submitCover");
            if (imageUrl.equals("") && (!isCard)) {
                event.getSubject().sendMessage("这个b还没有交");
                return;
            }
            if (!imageUrl.equals("") && (submitUser[0] != null)) {
                String[] imgArray = imageUrl.split("\\|");
                ExecutorService executorService = Executors.newFixedThreadPool(6); // 线程池
                for(String var : imgArray) {
                    executorService.execute(() -> {
                        Image img = ExternalResource.uploadAsImage(getImage(var), event.getFriend());
                        builder.add(event.getSubject(),img);
                    });
                }
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (builder.size() == imgArray.length) {
                        executorService.shutdown();
                        break;
                    }
                }
            }
            if (isCard) {
                builder.add(event.getSubject(),new PlainText(getCardAnswer(obj.getJSONObject("data").getString("cardId"))));
            }
            if (builder.size() != 0) {
                event.getSubject().sendMessage(builder.build());
            }
        });
        listener.start();

    }
}
