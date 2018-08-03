package com.db.mybatis.biz;

import com.sun.org.apache.bcel.internal.util.ClassLoader;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SessionInstance {
	
	private static SqlSessionFactory _sqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		if (_sqlSessionFactory == null) {
			String resource = "mybatis-config.xml";
			InputStream inputStream = null;
			try {
				inputStream = ClassLoader.getSystemResourceAsStream(resource);
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				_sqlSessionFactory = sqlSessionFactory;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return _sqlSessionFactory;
	}
	
	
}
