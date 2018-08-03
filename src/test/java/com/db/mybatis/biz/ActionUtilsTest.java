package com.db.mybatis.biz;

import com.db.mybatis.beans.LotteryDto;
import org.junit.Test;

public class ActionUtilsTest {
	
	@Test
	public void getRevenue() {
		LotteryDto lottery = new LotteryDto();
	
		lottery.setBlueBall("03");
		long revenue = ActionUtils.getRevenue(lottery, 18086, 1);
		System.out.println(revenue);
	}
}