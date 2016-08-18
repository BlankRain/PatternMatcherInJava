package com.doube.patternmatcher.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.doube.patternmatcher.Case;
import com.doube.patternmatcher.PatternMatcher;
import com.doube.patternmatcher.match;

public class DouBee implements PatternMatcher {
	@match
	public Object value() {
		Object[] arr = new Object[] { "啦啦啦~", 123, new HashMap<>(), new ArrayList<>(), new java.util.Date() };
		int al = arr.length;
		;
		int i = new Random().nextInt(al);
		System.out.println("随机值:" + arr[i]);
		return arr[i];
	}

	@Case
	public Object a(String o) {
		System.out.println("匹配到String 正在处理~" + o);
		return null;
	}

	@Case
	public Object b(Date o) {
		System.out.println("匹配到Date 正在处理~" + o);
		return null;
	}

	@Case
	public Object c(List o) {
		System.out.println("匹配到List 正在处理~" + o);
		return null;
	}

	@Case
	public Object d(Map o) {
		System.out.println("匹配到Map 正在处理~" + o);
		return null;
	}

	@Case
	public Object e(Integer o) {
		System.out.println("匹配到Integer 正在处理~" + o);
		return null;
	}

	@Case
	public Object f(int o) {
		System.out.println("匹配到int 正在处理~" + o);
		return null;
	}

	public static void main(String[] args) {
		new DouBee().apply();
	}
}
