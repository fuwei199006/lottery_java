package com.db.mybatis.dao;

import com.db.mybatis.model.LotteryForecastLog;

public interface LotteryForecastLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LotteryForecastLog record);

    int insertSelective(LotteryForecastLog record);

    LotteryForecastLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LotteryForecastLog record);

    int updateByPrimaryKey(LotteryForecastLog record);
}