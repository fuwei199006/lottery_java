package com.db.mybatis.biz;

public class BizFactory {
	
	public static LotteryService getLotteryService(){
		return new LotteryService();
	}
}
