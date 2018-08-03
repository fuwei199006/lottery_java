package com.db.mybatis.model;

import java.util.Date;

public class QuickThreeLotteryForecast {
    private Long id;

    private Integer lotteryNo;

    private Integer forecastMethod;

    private Integer ball1;

    private Integer ball2;

    private Integer ball3;

    private Integer ballSum;

    private String awardType;

    private Integer itemCount;

    private Integer awardAmount;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLotteryNo() {
        return lotteryNo;
    }

    public void setLotteryNo(Integer lotteryNo) {
        this.lotteryNo = lotteryNo;
    }

    public Integer getForecastMethod() {
        return forecastMethod;
    }

    public void setForecastMethod(Integer forecastMethod) {
        this.forecastMethod = forecastMethod;
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

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Integer getAwardAmount() {
        return awardAmount;
    }

    public void setAwardAmount(Integer awardAmount) {
        this.awardAmount = awardAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}