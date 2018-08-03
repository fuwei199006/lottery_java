package com.db.mybatis.biz;

import org.apache.ibatis.session.SqlSession;

public class BaseService {
	
	private SqlSession sqlSession;
	
	protected SqlSession getSqlSession() {
		return sqlSession;
	}
	
	protected void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public BaseService() {
		 this.sqlSession=SessionInstance.getSqlSessionFactory().openSession();
	}
}
