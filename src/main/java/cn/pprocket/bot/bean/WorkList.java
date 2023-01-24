package cn.pprocket.bot.bean;

import java.util.List;

@lombok.NoArgsConstructor
@lombok.Data
public class WorkList {

    @com.fasterxml.jackson.annotation.JsonProperty("code")
    private Integer code;
    @com.fasterxml.jackson.annotation.JsonProperty("desc")
    private String desc;
    @com.fasterxml.jackson.annotation.JsonProperty("data")
    private List<DataDTO> data;

    @lombok.NoArgsConstructor
    @lombok.Data
    public static class DataDTO {
        @com.fasterxml.jackson.annotation.JsonProperty("workId")
        private Integer workId;
        @com.fasterxml.jackson.annotation.JsonProperty("workType")
        private Integer workType;
        @com.fasterxml.jackson.annotation.JsonProperty("workClass")
        private Integer workClass;
        @com.fasterxml.jackson.annotation.JsonProperty("workTime")
        private String workTime;
        @com.fasterxml.jackson.annotation.JsonProperty("workDetail")
        private String workDetail;
        @com.fasterxml.jackson.annotation.JsonProperty("workRemark")
        private String workRemark;
        @com.fasterxml.jackson.annotation.JsonProperty("workCover")
        private String workCover;
        @com.fasterxml.jackson.annotation.JsonProperty("isSubmit")
        private Integer isSubmit;
        @com.fasterxml.jackson.annotation.JsonProperty("submit")
        private Integer submit;
        @com.fasterxml.jackson.annotation.JsonProperty("classNum")
        private Integer classNum;
        @com.fasterxml.jackson.annotation.JsonProperty("classGroup")
        private Integer classGroup;
        @com.fasterxml.jackson.annotation.JsonProperty("needSubmit")
        private Integer needSubmit;
        @com.fasterxml.jackson.annotation.JsonProperty("classCnt")
        private Integer classCnt;
        @com.fasterxml.jackson.annotation.JsonProperty("isSchedule")
        private Integer isSchedule;
        @com.fasterxml.jackson.annotation.JsonProperty("status")
        private Integer status;
        @com.fasterxml.jackson.annotation.JsonProperty("enrollmentYear")
        private Integer enrollmentYear;
        @com.fasterxml.jackson.annotation.JsonProperty("workConfig")
        private String workConfig;
        @com.fasterxml.jackson.annotation.JsonProperty("realExtraData")
        private String realExtraData;
        @com.fasterxml.jackson.annotation.JsonProperty("workKind")
        private Integer workKind;
        @com.fasterxml.jackson.annotation.JsonProperty("submitInfo")
        private DataDTO.SubmitInfoDTO submitInfo;
        @com.fasterxml.jackson.annotation.JsonProperty("cardId")
        private String cardId;
        @com.fasterxml.jackson.annotation.JsonProperty("cardName")
        private String cardName;
        @com.fasterxml.jackson.annotation.JsonProperty("groupId")
        private Integer groupId;
        @com.fasterxml.jackson.annotation.JsonProperty("groupInfo")
        private String groupInfo;

        @lombok.NoArgsConstructor
        @lombok.Data
        public static class SubmitInfoDTO {
            @com.fasterxml.jackson.annotation.JsonProperty("submitId")
            private String submitId;
            @com.fasterxml.jackson.annotation.JsonProperty("submitUser")
            private String submitUser;
            @com.fasterxml.jackson.annotation.JsonProperty("submitWorkId")
            private Integer submitWorkId;
            @com.fasterxml.jackson.annotation.JsonProperty("submitTime")
            private String submitTime;
            @com.fasterxml.jackson.annotation.JsonProperty("submitContent")
            private String submitContent;
            @com.fasterxml.jackson.annotation.JsonProperty("submitCover")
            private String submitCover;
            @com.fasterxml.jackson.annotation.JsonProperty("submitScore")
            private Integer submitScore;
            @com.fasterxml.jackson.annotation.JsonProperty("cardId")
            private String cardId;
            @com.fasterxml.jackson.annotation.JsonProperty("userNum")
            private String userNum;
            @com.fasterxml.jackson.annotation.JsonProperty("status")
            private Integer status;
            @com.fasterxml.jackson.annotation.JsonProperty("flag")
            private Integer flag;
        }
    }
}
