package cn.pprocket.bot.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpUtil;
import cn.pprocket.bot.WorkClient;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class NetWorkUtils {
    public static String sendPOST(String url) {
        Map<String,String> header = new HashMap<>();
        header.put("token",WorkClient.INSTANCE.getToken());
        header.put("sign",genSign(url));

        return  HttpUtil.createPost(url)
                .addHeaders(header)
                .execute()
                .body();
    }
    public static String sendPOSTDirectly(String url,String host) {
        return  HttpUtil.createPost(url)
                .header("Host",host)
                .contentLength(url.length())
                .execute()
                .body();
    }
    public static String sendGet(String url) {
        return HttpUtil.createGet(url)
                .execute().body();
    }
    public static String genSign(String url) {
        JSONObject obj = new JSONObject();
        url = url.substring(url.indexOf("?")+1);
        String[] arr = url.split("&");
        for(String str : arr) {
            String[] split = str.split("=");
            obj.addObject("\"" + split[0] + "\"","\"" + split[1] + "\"");
        }
        String end = obj.end(); //这是把url的参数变成json之后的字符串
        String str3  = Base64.encode(end) + "SNI4HF98M3C2DJ92835GM0972GWQP93JFNDJ28NFJ2NNFBHBJHF29JF39E2";
        return getMD5Str(str3);

    }
    /*
    public static String sendPOST2(String url, com.alibaba.fastjson2.JSONObject obj) {
        HttpUtil.createPost(url)
                .body()
    }

     */
    public static String genSign(com.alibaba.fastjson2.JSONObject obj) {
        String str3  = Base64.encode(obj.toString()) + "SNI4HF98M3C2DJ92835GM0972GWQP93JFNDJ28NFJ2NNFBHBJHF29JF39E2";
        return getMD5Str(str3);
    }
    public static String getMD5Str(String str){
        // 生成一个MD5加密计算摘要
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] hash = md.digest();
            StringBuilder secpwd = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                int v = hash[i] & 0xFF;
                if (v < 16) secpwd.append(0);
                secpwd.append(Integer.toString(v, 16));
            }
            return secpwd.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println("MD5-2加密时出现异常..." + e);
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(genSign("https://mrzy-dev.lulufind.com/mrzy/user/getUserInfo?openId=u2021083036db7137"));
    }
}
