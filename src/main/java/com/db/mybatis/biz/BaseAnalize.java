package com.db.mybatis.biz;

import com.db.mybatis.beans.LotteryDto;
import com.db.mybatis.model.Lottery;

import java.util.List;

public abstract class BaseAnalize implements IAnalizy {
	
	@Override
	public long getSingalAward(int lotteryNo, int n) {
		LotteryDto lotteryDto = generalLotteryDto();
		long revenue = ActionUtils.getRevenue(lotteryDto, lotteryNo, n);
		return revenue;
	}
	
	@Override
	public long getMutilAwardByLotteryNo(int lotteryNo) {
		long totalAward = getMutilAwardByCost(lotteryNo, Long.MAX_VALUE);
		return totalAward;
	}
	
	@Override
	public long getMutilAwardByCost(int lotteryNo, Long cost) {
		List<Lottery> topLotteryList = BizFactory.getLotteryService().getTopLotteryListByLotterNo(lotteryNo);
		LotteryDto lotteryDto = generalLotteryDto();
		int n = 0;
		int totalAward = 0;
		for (int i = 0; i < topLotteryList.size(); i++) {
			long revenue = ActionUtils.getRevenue(lotteryDto, topLotteryList.get(i), 2 << n >> 1);
			totalAward += revenue;
			if (totalAward + cost <= 0) {
				break;
			}
			if (revenue > 0) {
				n = 1;
			} else {
				n++;
			}
		}
		return totalAward;
	}
	
	@Override
	public long getMutilAwardByAI(int lotteryNo, int cost) {
		int itemCount = 1;
		int totalAward = 0;
		int totalAmout = 0;
		int n = 0;
		while (cost - itemCount * 2 + totalAward > 0) {
			LotteryDto lotteryDto = generalLotteryDto();
			itemCount = itemCount + n;
			n = Math.abs(2 * itemCount) / 5 + 1;
			totalAward += ActionUtils.getRevenue(lotteryDto, lotteryNo, n);
			totalAmout = totalAward - itemCount * 2;
			System.out.println(String.format("盈利：%s,注数：%s,总注数：%s,总盈利：%s", String.valueOf(totalAmout), String.valueOf(n), String.valueOf(itemCount), String.valueOf(n * 5)));
			if (totalAmout > 10000)
				break;
		}
		return totalAmout;
	}
	
	@Override
	public long getMutilAwardByAI(int lotteryNo) {
		return getMutilAwardByCost(lotteryNo, Long.MAX_VALUE);
	}
}
