package cn.pprocket.bot.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class SMSLogin {

    @JsonProperty("code")
    private Integer code;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("accounts")
        private List<AccountsDTO> accounts;

        @NoArgsConstructor
        @Data
        public static class AccountsDTO {
            @JsonProperty("token")
            private String token;
            @JsonProperty("user")
            private UserDTO user;
            @JsonProperty("openId")
            private String openId;
            @JsonProperty("login")
            private Long login;

            @NoArgsConstructor
            @Data
            public static class UserDTO {
                @JsonProperty("openId")
                private String openId;
                @JsonProperty("userRealName")
                private String userRealName;
                @JsonProperty("userAvatar")
                private String userAvatar;
                @JsonProperty("userPhone")
                private String userPhone;
                @JsonProperty("unionId")
                private Object unionId;
                @JsonProperty("userSubject")
                private String userSubject;
                @JsonProperty("familyType")
                private Integer familyType;
                @JsonProperty("userType")
                private Integer userType;
                @JsonProperty("mrid")
                private Integer mrid;
                @JsonProperty("school")
                private Object school;
                @JsonProperty("groups")
                private List<?> groups;
                @JsonProperty("operator")
                private Boolean operator;
                @JsonProperty("userNum")
                private Object userNum;
                @JsonProperty("userIdentity")
                private String userIdentity;
                @JsonProperty("userExist")
                private Integer userExist;
                @JsonProperty("divSubject")
                private Object divSubject;
            }
        }
    }
}
