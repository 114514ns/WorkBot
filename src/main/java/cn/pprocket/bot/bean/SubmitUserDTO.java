package cn.pprocket.bot.bean;

import com.google.gson.annotations.SerializedName;

public class SubmitUserDTO {
    @SerializedName("submitId")
    private String submitId;
    @SerializedName("openId")
    private String openId;
    @SerializedName("userName")
    private String userName;
    @SerializedName("userGender")
    private Integer userGender;
    @SerializedName("userRealName")
    private String userRealName;
    @SerializedName("userAvatar")
    private String userAvatar;
    @SerializedName("submitTime")
    private String submitTime;
    @SerializedName("submitContent")
    private String submitContent;
    @SerializedName("submitCover")
    private String submitCover;
    @SerializedName("submitFlag")
    private Integer submitFlag;
    @SerializedName("submitAudio")
    private String submitAudio;
    @SerializedName("cardId")
    private String cardId;
    @SerializedName("bubbleState")
    private Integer bubbleState;
    @SerializedName("submitScore")
    private Integer submitScore;
    @SerializedName("submitVideo")
    private String submitVideo;
    @SerializedName("isComment")
    private Integer isComment;
    @SerializedName("userNum")
    private String userNum;
    @SerializedName("status")
    private Integer status;
    @SerializedName("flag")
    private Integer flag;
    @SerializedName("bindOpenId")
    private String bindOpenId;
    @SerializedName("bindName")
    private String bindName;

    public String getSubmitId() {
        return submitId;
    }

    public void setSubmitId(String submitId) {
        this.submitId = submitId;
    }

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

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getSubmitContent() {
        return submitContent;
    }

    public void setSubmitContent(String submitContent) {
        this.submitContent = submitContent;
    }

    public String getSubmitCover() {
        return submitCover;
    }

    public void setSubmitCover(String submitCover) {
        this.submitCover = submitCover;
    }

    public Integer getSubmitFlag() {
        return submitFlag;
    }

    public void setSubmitFlag(Integer submitFlag) {
        this.submitFlag = submitFlag;
    }

    public String getSubmitAudio() {
        return submitAudio;
    }

    public void setSubmitAudio(String submitAudio) {
        this.submitAudio = submitAudio;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getBubbleState() {
        return bubbleState;
    }

    public void setBubbleState(Integer bubbleState) {
        this.bubbleState = bubbleState;
    }

    public Integer getSubmitScore() {
        return submitScore;
    }

    public void setSubmitScore(Integer submitScore) {
        this.submitScore = submitScore;
    }

    public String getSubmitVideo() {
        return submitVideo;
    }

    public void setSubmitVideo(String submitVideo) {
        this.submitVideo = submitVideo;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getBindOpenId() {
        return bindOpenId;
    }

    public void setBindOpenId(String bindOpenId) {
        this.bindOpenId = bindOpenId;
    }

    public String getBindName() {
        return bindName;
    }

    public void setBindName(String bindName) {
        this.bindName = bindName;
    }
}
