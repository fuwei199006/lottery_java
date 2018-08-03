package com.db.mybatis.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
	public static List<String> getMatchStrList(String partern, String content) {
		List<String> strList = new ArrayList<>();
		Pattern pattern = Pattern.compile(partern);
		// 忽略大小写的写法
		// Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(content);
		while(matcher.find()){
			matcher.start();
			matcher.end();
			strList.add(matcher.group());
		}
		return strList;
	}
	
	
	public static String getMatchStr(String partern, String content) {
		List<String> matchStrList = getMatchStrList(partern, content);
		if (matchStrList.size() > 0)
			return matchStrList.get(0);
		return "";
	}
}
