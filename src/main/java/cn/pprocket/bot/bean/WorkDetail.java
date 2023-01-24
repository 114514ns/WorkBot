package cn.pprocket.bot.bean;

import com.google.gson.annotations.SerializedName;

public class WorkDetail {

    @SerializedName("code")
    private Integer code;
    @SerializedName("desc")
    private String desc;
    @SerializedName("data")
    private DataDTO data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }
}