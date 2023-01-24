package cn.pprocket.bot.utils;

public class Debug {

    public final static boolean DEBUG = true;
    public static String Debug(String info) {
        if (DEBUG) {
            System.out.println(info);
        }
        return "";
    }
}
