package com.db.mybatis.biz;

import org.junit.Test;

import static org.junit.Assert.*;

public class BaseAnalizeTest {
	
	@Test
	public void getMutilAwardByAI() {
		IAnalizy analizy=new RandomAnalize();
		analizy.getMutilAwardByAI(10186,1000);
	}
}