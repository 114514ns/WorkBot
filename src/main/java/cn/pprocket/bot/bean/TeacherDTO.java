package cn.pprocket.bot.bean;

import com.google.gson.annotations.SerializedName;

public class TeacherDTO {
    @SerializedName("openId")
    private String openId;
    @SerializedName("userName")
    private String userName;
    @SerializedName("userGender")
    private Integer userGender;
    @SerializedName("userPhone")
    private String userPhone;
    @SerializedName("userCity")
    private String userCity;
    @SerializedName("userLoginTime")
    private String userLoginTime;
    @SerializedName("userRegTime")
    private String userRegTime;
    @SerializedName("userExist")
    private Integer userExist;
    @SerializedName("userId")
    private String userId;
    @SerializedName("userRealName")
    private String userRealName;
    @SerializedName("userAvatar")
    private String userAvatar;
    @SerializedName("userType")
    private Integer userType;
    @SerializedName("userIdentity")
    private String userIdentity;
    @SerializedName("userSubject")
    private String userSubject;
    @SerializedName("noticeNum")
    private Integer noticeNum;
    @SerializedName("userAdmin")
    private Integer userAdmin;
    @SerializedName("userCreatAdmin")
    private Integer userCreatAdmin;
    @SerializedName("realOpenId")
    private String realOpenId;
    @SerializedName("familyType")
    private Integer familyType;
    @SerializedName("fwhFlag")
    private Integer fwhFlag;
    @SerializedName("ban")
    private Integer ban;
    @SerializedName("mrid")
    private String mrid;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserLoginTime() {
        return userLoginTime;
    }

    public void setUserLoginTime(String userLoginTime) {
        this.userLoginTime = userLoginTime;
    }

    public String getUserRegTime() {
        return userRegTime;
    }

    public void setUserRegTime(String userRegTime) {
        this.userRegTime = userRegTime;
    }

    public Integer getUserExist() {
        return userExist;
    }

    public void setUserExist(Integer userExist) {
        this.userExist = userExist;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserSubject() {
        return userSubject;
    }

    public void setUserSubject(String userSubject) {
        this.userSubject = userSubject;
    }

    public Integer getNoticeNum() {
        return noticeNum;
    }

    public void setNoticeNum(Integer noticeNum) {
        this.noticeNum = noticeNum;
    }

    public Integer getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(Integer userAdmin) {
        this.userAdmin = userAdmin;
    }

    public Integer getUserCreatAdmin() {
        return userCreatAdmin;
    }

    public void setUserCreatAdmin(Integer userCreatAdmin) {
        this.userCreatAdmin = userCreatAdmin;
    }

    public String getRealOpenId() {
        return realOpenId;
    }

    public void setRealOpenId(String realOpenId) {
        this.realOpenId = realOpenId;
    }

    public Integer getFamilyType() {
        return familyType;
    }

    public void setFamilyType(Integer familyType) {
        this.familyType = familyType;
    }

    public Integer getFwhFlag() {
        return fwhFlag;
    }

    public void setFwhFlag(Integer fwhFlag) {
        this.fwhFlag = fwhFlag;
    }

    public Integer getBan() {
        return ban;
    }

    public void setBan(Integer ban) {
        this.ban = ban;
    }

    public String getMrid() {
        return mrid;
    }

    public void setMrid(String mrid) {
        this.mrid = mrid;
    }
}
