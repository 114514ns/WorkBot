package cn.pprocket.bot;

import cn.pprocket.bot.bean.SMSLogin;
import cn.pprocket.bot.bean.WorkList;
import cn.pprocket.bot.utils.Debug;
import cn.pprocket.bot.utils.NetWorkUtils;
import com.google.gson.Gson;

import java.util.List;

public class WorkClient  {
    Gson gson = new Gson();
    String token = "";
    public String getToken() {
        return this.token;
    }
    public static WorkClient INSTANCE = null;
    public List<WorkList.DataDTO> getWorkList() {
        String res = NetWorkUtils.sendPOST("https://lulu.lulufind.com/mrzy/mrzypc/findWorkNewVersion?start=0&limit=10&num=12");
        WorkList bean = gson.fromJson(res, WorkList.class);
        Debug.Debug("请求作业列表");
        return bean.getData();
    }
    public List<WorkList.DataDTO> getWorkList(int num) {
        String res = NetWorkUtils.sendPOST("https://lulu.lulufind.com/mrzy/mrzypc/findWorkNewVersion?start=0&limit=10&num=" + num);
        WorkList bean = gson.fromJson(res, WorkList.class);
        Debug.Debug("请求作业列表");
        return bean.getData();
    }
    public void login(String username,String password) {

        String res = NetWorkUtils.sendPOSTDirectly("https://api-prod.lulufind.com/api/v1/auth/smslogin?phone=" + username + "&password=" + password,"api-prod.lulufind.com");
        SMSLogin bean = gson.fromJson(res, SMSLogin.class);
        Debug.Debug("登录");
        this.token = bean.getData().getAccounts().get(0).getToken();
    }

    public static void main(String[] args) {
        WorkClient client = new WorkClient();
        WorkClient.INSTANCE = client;
        client.login("15555519609","114514Aa");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    client.login("15555519609","114514Aa");
                    try {
                        Thread.sleep(1000*60*60*6);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t.start();
    }
}
