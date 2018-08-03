package com.db.mybatis.biz;

import com.db.mybatis.model.Lottery;
import org.junit.Test;

public class LotteryServiceTest {
	
	@Test
	public void getLotteryDao() {
		Lottery lottery = BizFactory.getLotteryService().getLotterById(2092);
		System.out.println(lottery.getBlueBall());
	}
	
	@Test
	public void setLotteryDao() {
	}
	
	@Test
	public void getLotterById() {
	}
	
	@Test
	public void getLotterMaxId() {
	}
	
	@Test
	public void getLotteryByLotteryNo() {
		int i=0;
		while (true) {
			i++;
			Lottery lottery = BizFactory.getLotteryService().getLotterById(2292);
			System.out.println(String.format("id:%s index:%s",lottery.getId(),i));
			System.out.println("-------------------");
		}
	}
	
	@Test
	public void insertLottery() {
	}
	
	@Test
	public void insertLotteryList() {
	}
	
	@Test
	public void getTopLotteryList() {
	}
	
	@Test
	public void getTopLotteryListById() {
	}
	
	@Test
	public void getTopLotteryListByLotterNo() {
	}
}