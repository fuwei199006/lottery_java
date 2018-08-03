package com.db.mybatis.dao;

import com.db.mybatis.model.QuickThreeLotteryForecast;

public interface QuickThreeLotteryForecastMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QuickThreeLotteryForecast record);

    int insertSelective(QuickThreeLotteryForecast record);

    QuickThreeLotteryForecast selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuickThreeLotteryForecast record);

    int updateByPrimaryKey(QuickThreeLotteryForecast record);
}