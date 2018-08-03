package com.db.mybatis.biz;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomAnalizeTest {
	
	@Test
	public void getAward() {
		IAnalizy analizy=new RandomAnalize();
		long mutilAwardByLotteryNo = analizy.getMutilAwardByLotteryNo(17001);
		System.out.println(mutilAwardByLotteryNo);
	}
}