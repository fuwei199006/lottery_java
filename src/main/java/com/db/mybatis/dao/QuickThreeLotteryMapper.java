package com.db.mybatis.dao;

import com.db.mybatis.model.QuickThreeLottery;

public interface QuickThreeLotteryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuickThreeLottery record);

    int insertSelective(QuickThreeLottery record);

    QuickThreeLottery selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuickThreeLottery record);

    int updateByPrimaryKey(QuickThreeLottery record);
}