package com.fupengpeng.shoppingmall.entity;


import java.io.Serializable;

/**
 * Created by fupengpeng on 2017/6/30 0030.
 * 分享资讯列表对象
 */

public class ShareAttentionObject implements Serializable{

    private int tag;//布局标签
    private String username;//用户名
    private int userPic;//用户头像
    private String userAddress;//用户地址
    private String userIdentifying;//用户标识
    private String title;//咨询标题
    private String titleExplain;//咨询标题说明
    private int titlePicOne;//咨询图片1
    private int titlePicTwo;//咨询图片2
    private int titlePicThree;//咨询图片3
    private int browseNumber;//咨询浏览量
    private int cowrieNumber;//咨询宝贝数量
    private String cowrieClassify;//咨询宝贝分类
    private String time;//咨询发布时间
    private double cowriePrice;//宝贝价格

    public ShareAttentionObject() {
    }
    public ShareAttentionObject(int tag, String username,
                                int userPic, String userAddress,
                                String userIdentifying, String title,
                                String titleExplain, int titlePicOne,
                                int titlePicTwo, int titlePicThree,
                                int browseNumber, int cowrieNumber,
                                String cowrieClassify, String time,
                                double cowriePrice) {
        this.tag = tag;
        this.username = username;
        this.userPic = userPic;
        this.userAddress = userAddress;
        this.userIdentifying = userIdentifying;
        this.title = title;
        this.titleExplain = titleExplain;
        this.titlePicOne = titlePicOne;
        this.titlePicTwo = titlePicTwo;
        this.titlePicThree = titlePicThree;
        this.browseNumber = browseNumber;
        this.cowrieNumber = cowrieNumber;
        this.cowrieClassify = cowrieClassify;
        this.time = time;
        this.cowriePrice = cowriePrice;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserPic() {
        return userPic;
    }

    public void setUserPic(int userPic) {
        this.userPic = userPic;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserIdentifying() {
        return userIdentifying;
    }

    public void setUserIdentifying(String userIdentifying) {
        this.userIdentifying = userIdentifying;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleExplain() {
        return titleExplain;
    }

    public void setTitleExplain(String titleExplain) {
        this.titleExplain = titleExplain;
    }

    public int getTitlePicOne() {
        return titlePicOne;
    }

    public void setTitlePicOne(int titlePicOne) {
        this.titlePicOne = titlePicOne;
    }

    public int getTitlePicTwo() {
        return titlePicTwo;
    }

    public void setTitlePicTwo(int titlePicTwo) {
        this.titlePicTwo = titlePicTwo;
    }

    public int getTitlePicThree() {
        return titlePicThree;
    }

    public void setTitlePicThree(int titlePicThree) {
        this.titlePicThree = titlePicThree;
    }

    public int getBrowseNumber() {
        return browseNumber;
    }

    public void setBrowseNumber(int browseNumber) {
        this.browseNumber = browseNumber;
    }

    public int getCowrieNumber() {
        return cowrieNumber;
    }

    public void setCowrieNumber(int cowrieNumber) {
        this.cowrieNumber = cowrieNumber;
    }

    public String getCowrieClassify() {
        return cowrieClassify;
    }

    public void setCowrieClassify(String cowrieClassify) {
        this.cowrieClassify = cowrieClassify;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getCowriePrice() {
        return cowriePrice;
    }

    public void setCowriePrice(double cowriePrice) {
        this.cowriePrice = cowriePrice;
    }



}
