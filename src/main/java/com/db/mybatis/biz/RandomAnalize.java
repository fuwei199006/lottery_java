package com.db.mybatis.biz;

import com.db.mybatis.beans.LotteryDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAnalize extends BaseAnalize {
	@Override
	public String getMethodName() {
		return "RandomAnalize";
	}
	
	@Override
	public LotteryDto generalLotteryDto() {
		LotteryDto lotteryDto = new LotteryDto();
		List<String> ballList = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			Random random = new Random();
			int ball = random.nextInt(33) + 1;
			if (ball < 10) {
				ballList.add("0" + String.valueOf(ball));
			} else {
				ballList.add(String.valueOf(ball));
			}
			
		}
		lotteryDto.setBlueBall(String.valueOf(new Random().nextInt(16) + 1));
		//		lotteryDto.setBlueBall();
		lotteryDto.setRedBalls(ballList);
		return lotteryDto;
	}
	
	
	

	
	
	
	
}
