package cn.pprocket.bot.utils;

public class JSONObject {
    String result = "{";
    public void addObject(String key,String value) {
        result = result + key + ":" + value + ",";
    }
    public String end() {
        result =  result + "}";
        StringBuilder sb = new StringBuilder(result);
        sb.deleteCharAt(result.length()-2);
        return sb.toString();
    }
}
