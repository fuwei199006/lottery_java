package com.db.mybatis.beans;

import java.util.List;

public class LotteryDto {
	
	private List<String> redBalls;
	
	private String blueBall;
	
	public List<String> getRedBalls() {
		return redBalls;
	}
	
	public void setRedBalls(List<String> redBalls) {
		this.redBalls = redBalls;
	}
	
	public String getBlueBall() {
		return blueBall;
	}
	
	public void setBlueBall(String blueBall) {
		this.blueBall = blueBall;
	}
}
