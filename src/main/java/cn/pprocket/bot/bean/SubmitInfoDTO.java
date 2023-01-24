package cn.pprocket.bot.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SubmitInfoDTO {
    @SerializedName("submitId")
    private String submitId;
    @SerializedName("submitUser")
    private String submitUser;
    @SerializedName("submitWorkId")
    private Integer submitWorkId;
    @SerializedName("submitTime")
    private String submitTime;
    @SerializedName("submitContent")
    private String submitContent;
    @SerializedName("submitCover")
    private String submitCover;
    @SerializedName("submitScore")
    private Integer submitScore;
    @SerializedName("cardId")
    private String cardId;
    @SerializedName("userNum")
    private String userNum;
    @SerializedName("status")
    private Integer status;
    @SerializedName("flag")
    private Integer flag;
}
