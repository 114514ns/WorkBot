package cn.pprocket.bot.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DataDTO {

    @SerializedName("workId")
    private Integer workId;
    @SerializedName("workType")
    private Integer workType;
    @SerializedName("workClass")
    private Integer workClass;
    @SerializedName("workTime")
    private String workTime;
    @SerializedName("exist")
    private Integer exist;
    @SerializedName("workDetail")
    private String workDetail;
    @SerializedName("workRemark")
    private String workRemark;
    @SerializedName("workCover")
    private String workCover;
    @SerializedName("openId")
    private String openId;
    @SerializedName("submitUser")
    private List<SubmitUserDTO> submitUser;
    @SerializedName("submit")
    private Integer submit;
    @SerializedName("classNum")
    private Integer classNum;
    @SerializedName("classGroup")
    private Integer classGroup;
    @SerializedName("teacher")
    private TeacherDTO teacher;
    @SerializedName("submitInfo")
    private SubmitInfoDTO submitInfo;
    @SerializedName("needSubmit")
    private Integer needSubmit;
    @SerializedName("isOpen")
    private Integer isOpen;
    @SerializedName("classCnt")
    private Integer classCnt;
    @SerializedName("answerType")
    private Integer answerType;
    @SerializedName("teacherIsOpen")
    private Integer teacherIsOpen;
    @SerializedName("isCorrect")
    private Integer isCorrect;
    @SerializedName("repairType")
    private Integer repairType;
    @SerializedName("nowTime")
    private String nowTime;
    @SerializedName("cardCaseSensitive")
    private Integer cardCaseSensitive;
    @SerializedName("enrollmentYear")
    private Integer enrollmentYear;
    @SerializedName("workConfig")
    private String workConfig;
    @SerializedName("correctUser")
    private List<?> correctUser;
    @SerializedName("workKind")
    private Integer workKind;
    @SerializedName("isBegin")
    private Integer isBegin;
}
