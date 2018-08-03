package com.db.mybatis.biz;

import com.db.mybatis.beans.LotteryDto;
import com.db.mybatis.model.Lottery;
import com.db.mybatis.utils.RegexUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActionUtils {
	
	public static int addLotteryData(String pageHtml) {
		int total = 0;
		String tableHtml = RegexUtils.getMatchStr("<tr.+>.+</tr>", pageHtml);
		List<String> matchStrList = RegexUtils.getMatchStrList("<tr[^>]*>.+?<\\/tr>", tableHtml);
		List<Lottery> lotteryList = new ArrayList<>();
		for (String str : matchStrList) {
			List<String> ballHtmlList = RegexUtils.getMatchStrList("<td[^>]*>.+?<\\/td>", str);
			List<String> ballList = new ArrayList<>();
			for (String ballHtml : ballHtmlList) {
				String ball = RegexUtils.getMatchStr(">[^<>]+<", ballHtml).replace(">", "").replace("<", "");
				ballList.add(ball);
			}
			Lottery lotteryDb = BizFactory.getLotteryService().getLotteryByLotteryNo(Integer.parseInt(ballList.get(1)));
			if (lotteryDb != null) {
				continue;
			}
			Lottery lottery = new Lottery();
			lottery.setLotteryNo(Integer.parseInt(ballList.get(1)));
			lottery.setRedBall1(ballList.get(2));
			lottery.setRedBall2(ballList.get(3));
			lottery.setRedBall3(ballList.get(4));
			lottery.setRedBall4(ballList.get(5));
			lottery.setRedBall5(ballList.get(6));
			lottery.setRedBall6(ballList.get(7));
			lottery.setBlueBall(ballList.get(8));
			lottery.setTotalAward(Long.parseLong(ballList.get(10).replace(",", "")));
			lottery.setFirstItems(Long.parseLong(ballList.get(11).replace(",", "")));
			lottery.setFirstAward(Long.parseLong(ballList.get(12).replace(",", "")));
			lottery.setSecondItems(Long.parseLong(ballList.get(13).replace(",", "")));
			lottery.setSecondAward(Long.parseLong(ballList.get(14).replace(",", "")));
			lottery.setLotteryDate(ballList.get(16));
			lotteryList.add(lottery);
		}
		total = BizFactory.getLotteryService().insertLotteryList(lotteryList);
		return total;
	}
	
	public static long getRevenue(LotteryDto lottery, int lotteryNo, int n) {
		Lottery lotteryDb = BizFactory.getLotteryService().getLotteryByLotteryNo(lotteryNo);
		return getRevenue(lottery, lotteryDb, n);
	}
	
	public static long getRevenue(LotteryDto lottery, Lottery lotteryDb, int n) {
		if (lottery == null) {
			System.out.println("彩票数据为空");
			return 0;
		}
		if (lotteryDb == null) {
			System.out.println("DB彩票数据为空");
			return 0;
		}
		int costUnit = 2;
		int incomeUnit = 0;
		
		final List<String> dbBalls = getBallArrByLottery(lotteryDb);
		long redCount = lottery.getRedBalls().stream().filter(x -> dbBalls.contains(x)).count();
		int blueCount = 0;
		if (lottery.getBlueBall().equals(lotteryDb.getBlueBall())) {
			blueCount = 1;
		}
		if (redCount < 3 && blueCount == 1) {
			incomeUnit = 5;
		}
		if ((redCount == 4 && blueCount == 0) || (redCount == 3 && blueCount == 1)) {
			incomeUnit = 10;
		}
		if ((redCount == 4 && blueCount == 1) || (redCount == 5 && blueCount == 0)) {
			incomeUnit = 200;
		}
		if (redCount == 5 && blueCount == 1) {
			incomeUnit = 3000;
		}
		if (redCount == 6 && blueCount == 0) {
			incomeUnit = 200000;
		}
		if (redCount == 6 && blueCount == 1) {
			incomeUnit = 5000000;
		}
		long finalAward = (incomeUnit - costUnit) * n;
		System.out.println(String.format("消费：%s,中奖：%s,单次收益：%s", costUnit * n, incomeUnit * n, finalAward));
		return finalAward;
	}
	
	public static List<Lottery> getRecentData(int n) {
		int lotterMaxId = BizFactory.getLotteryService().getLotterMaxId();
		int startId = lotterMaxId - n;
		return BizFactory.getLotteryService().getTopLotteryList(startId);
	}
	
	public static Map<String, Long> getRedBallCount(List<Lottery> list) {
		List<String> redBalls = new ArrayList<>();
		for (Lottery lottery : list) {
			redBalls.addAll(getBallArrByLottery(lottery));
		}
		Map<String, Long> redMap = redBalls.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		return redMap;
	}
	
	public static Map<String, Long> getBlueBallCount(List<Lottery> list) {
		Map<String, Long> blueBalls = list.stream().collect(Collectors.groupingBy(x -> x.getBlueBall(), Collectors.counting()));
		return blueBalls;
	}
	
	private static List<String> getBallArrByLottery(Lottery lottery) {
		List<String> ballList = new ArrayList<>();
		ballList.add(lottery.getRedBall1().trim());
		ballList.add(lottery.getRedBall2().trim());
		ballList.add(lottery.getRedBall3().trim());
		ballList.add(lottery.getRedBall4().trim());
		ballList.add(lottery.getRedBall5().trim());
		ballList.add(lottery.getRedBall6().trim());
		return ballList;
	}
	
	
}
