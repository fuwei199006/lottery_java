package com.db.mybatis;

import com.db.mybatis.biz.BizFactory;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        BizFactory.getLotteryService().getLotterById(1);
    }
}
