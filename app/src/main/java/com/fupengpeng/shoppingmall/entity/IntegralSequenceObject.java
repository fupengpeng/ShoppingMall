package com.fupengpeng.shoppingmall.entity;

import java.io.Serializable;

/**
 * Created by fupengpeng on 2017/6/13 0013.
 * 积分排名实体类
 */

public class IntegralSequenceObject implements Serializable{
    /**
     * 用户名次
     */
    private String integralSequenceRanking;
    /**
     * 用户图像
     */
    private int integralSequenceUserPic;
    /**
     * 用户名
     */
    private String integralSequenceUsername;
    /**
     * 名次图像
     */
    private int integralSequenceRankingPic;
    /**
     * 用户积分
     */
    private String integralSequenceIntegral;

    public String getIntegralSequenceRanking() {
        return integralSequenceRanking;
    }

    public void setIntegralSequenceRanking(String integralSequenceRanking) {
        this.integralSequenceRanking = integralSequenceRanking;
    }

    public int getIntegralSequenceUserPic() {
        return integralSequenceUserPic;
    }

    public void setIntegralSequenceUserPic(int integralSequenceUserPic) {
        this.integralSequenceUserPic = integralSequenceUserPic;
    }

    public String getIntegralSequenceUsername() {
        return integralSequenceUsername;
    }

    public void setIntegralSequenceUsername(String integralSequenceUsername) {
        this.integralSequenceUsername = integralSequenceUsername;
    }

    public int getIntegralSequenceRankingPic() {
        return integralSequenceRankingPic;
    }

    public void setIntegralSequenceRankingPic(int integralSequenceRankingPic) {
        this.integralSequenceRankingPic = integralSequenceRankingPic;
    }

    public String getIntegralSequenceIntegral() {
        return integralSequenceIntegral;
    }

    public void setIntegralSequenceIntegral(String integralSequenceIntegral) {
        this.integralSequenceIntegral = integralSequenceIntegral;
    }
}
