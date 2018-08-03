package com.db.mybatis.model;

import java.util.Date;

public class QuickThreeLottery {
    private Integer id;

    private Integer lotteryNo;

    private Integer ball1;

    private Integer ball2;

    private Integer ball3;

    private Integer ballSum;

    private String awardType;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLotteryNo() {
        return lotteryNo;
    }

    public void setLotteryNo(Integer lotteryNo) {
        this.lotteryNo = lotteryNo;
    }

    public Integer getBall1() {
        return ball1;
    }

    public void setBall1(Integer ball1) {
        this.ball1 = ball1;
    }

    public Integer getBall2() {
        return ball2;
    }

    public void setBall2(Integer ball2) {
        this.ball2 = ball2;
    }

    public Integer getBall3() {
        return ball3;
    }

    public void setBall3(Integer ball3) {
        this.ball3 = ball3;
    }

    public Integer getBallSum() {
        return ballSum;
    }

    public void setBallSum(Integer ballSum) {
        this.ballSum = ballSum;
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType == null ? null : awardType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}