package com.db.mybatis.dao;


import com.db.mybatis.model.Lottery;

import java.util.List;

public interface LotteryMapper {
	int deleteByPrimaryKey(Integer id);
	
	int insert(Lottery record);
	
	int insertSelective(Lottery record);
	
	Lottery selectByPrimaryKey(Integer id);
	
	List<Lottery> selectListById(Integer startId);
	List<Lottery> selectListByRange(Integer midStartId,Integer maxId);
	
	Lottery selectByLotteryNo(Integer lotteryNo);
	
	List<Lottery> selectListByLotteryDate(String lotteryDate);
	
	Lottery selectByLotteryDate(String lotteryDate);
	
	int selectMaxId();
	
	int updateByPrimaryKeySelective(Lottery record);
	
	int updateByPrimaryKey(Lottery record);
	
}