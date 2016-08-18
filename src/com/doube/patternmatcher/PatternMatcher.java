package com.doube.patternmatcher;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public interface PatternMatcher {

	default public Object apply() {

		Class<? extends PatternMatcher> c = this.getClass();
		Method[] me = c.getDeclaredMethods();
		Method matchMethod = null;
		List<Method> caseMethods = new ArrayList<>();
		for (Method m : me) {
			match mt = m.getAnnotation(match.class);
			if (mt != null) {
				matchMethod = m;
			}
			Case ct = m.getAnnotation(Case.class);
			if (ct != null) {
				caseMethods.add(m);
			}

		}
		if (matchMethod != null) {
			/**
			 * 解析模式
			 */
			try {
				Object v = matchMethod.invoke(this, null);
				for (Method cm : caseMethods) {
					Class<?>[] cpt = cm.getParameterTypes();
					for (Class<?> cpte : cpt) {
						// 按类匹配
						if (cpte.isInstance(v)) {
							cm.invoke(this, v);
						}
					}
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
