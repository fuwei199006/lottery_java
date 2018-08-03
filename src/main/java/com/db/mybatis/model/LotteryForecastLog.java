package com.db.mybatis.model;

import java.util.Date;

public class LotteryForecastLog {
    private Long id;

    private Integer lotteryNo;

    private Integer forecastMethod;

    private String redBall1;

    private String redBall2;

    private String redBall3;

    private String redBall4;

    private String redBall5;

    private String redBall6;

    private String blueBall;

    private Integer itemCount;

    private String awardClass;

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

    public String getRedBall1() {
        return redBall1;
    }

    public void setRedBall1(String redBall1) {
        this.redBall1 = redBall1 == null ? null : redBall1.trim();
    }

    public String getRedBall2() {
        return redBall2;
    }

    public void setRedBall2(String redBall2) {
        this.redBall2 = redBall2 == null ? null : redBall2.trim();
    }

    public String getRedBall3() {
        return redBall3;
    }

    public void setRedBall3(String redBall3) {
        this.redBall3 = redBall3 == null ? null : redBall3.trim();
    }

    public String getRedBall4() {
        return redBall4;
    }

    public void setRedBall4(String redBall4) {
        this.redBall4 = redBall4 == null ? null : redBall4.trim();
    }

    public String getRedBall5() {
        return redBall5;
    }

    public void setRedBall5(String redBall5) {
        this.redBall5 = redBall5 == null ? null : redBall5.trim();
    }

    public String getRedBall6() {
        return redBall6;
    }

    public void setRedBall6(String redBall6) {
        this.redBall6 = redBall6 == null ? null : redBall6.trim();
    }

    public String getBlueBall() {
        return blueBall;
    }

    public void setBlueBall(String blueBall) {
        this.blueBall = blueBall == null ? null : blueBall.trim();
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public String getAwardClass() {
        return awardClass;
    }

    public void setAwardClass(String awardClass) {
        this.awardClass = awardClass == null ? null : awardClass.trim();
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