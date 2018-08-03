package com.db.mybatis;


import com.db.mybatis.biz.ActionUtils;
import com.db.mybatis.utils.HttpUtils;
import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws IOException {
		String pageHtml = HttpUtils.doGet("http://datachart.500.com/ssq/history/history.shtml", 50000, "gb2312");
		System.out.println(pageHtml);
		InputStream dataStream = ClassLoader.getSystemResourceAsStream(pageHtml);
		BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(dataStream));
		
		StringBuffer tStringBuffer = new StringBuffer();
		String sTempOneLine = new String("");
		while ((sTempOneLine = tBufferedReader.readLine()) != null) {
			tStringBuffer.append(sTempOneLine);
		}
		ActionUtils.addLotteryData(tStringBuffer.toString());
	}
}
