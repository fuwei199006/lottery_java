package com.db.mybatis.biz;

import com.db.mybatis.beans.LotteryDto;

public interface IAnalizy {
	String getMethodName();
	
	LotteryDto generalLotteryDto();
	
	long getSingalAward(int lotteryNo, int n);
	long getMutilAwardByLotteryNo(int lotteryNo);
	long getMutilAwardByCost(int lotteryNo,Long cost);
 	long getMutilAwardByAI(int lotteryNo,int cost);
 	long getMutilAwardByAI(int lotteryNo);
}
