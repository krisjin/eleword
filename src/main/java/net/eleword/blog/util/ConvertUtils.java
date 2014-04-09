package net.eleword.blog.util;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin (mailto:krisjin86@163.com)
 */
public class ConvertUtils {

	static {
		registerDateConverter();
	}

	/**
	 * @param collection   来源集合.
	 * @param propertyName 要提取的属性名.
	 *
	 * @return
	 * @Title: convertElementPropertyToList
	 * @Description: 提取集合中的对象的属性(通过getter函数), 组合成List.
	 */
	@SuppressWarnings("unchecked")
	public static List convertElementPropertyToList(final Collection collection, final String propertyName) {
		List list = new ArrayList();
		try {
			for (Object obj : collection) {
				list.add(PropertyUtils.getProperty(obj, propertyName));
			}
		} catch (Exception e) {
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}
		return list;
	}

	/**
	 * @param collection   来源集合.
	 * @param propertyName 要提取的属性名.
	 * @param separator    分隔符.
	 *
	 * @return
	 * @Title: convertElementPropertyToString
	 * @Description: 提取集合中的对象的属性(通过getter函数), 组合成由分割符分隔的字符串.
	 */
	@SuppressWarnings("unchecked")
	public static String convertElementPropertyToString(final Collection collection, final String propertyName, final String separator) {
		List list = convertElementPropertyToList(collection, propertyName);
		return StringUtils.join(list, separator);
	}

	/**
	 * @param value  待转换的字符串.
	 * @param toType 转换目标类型.
	 *
	 * @return
	 * @Title: convertStringToObject
	 * @Description: 转换字符串到相应类型.
	 */
	public static Object convertStringToObject(String value, Class<?> toType) {
		try {
			return org.apache.commons.beanutils.ConvertUtils.convert(value, toType);
		} catch (Exception e) {
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}
	}

	/**
	 * @Title: registerDateConverter
	 * @Description: 定义日期Converter的格式: yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss
	 */
	private static void registerDateConverter() {
		DateConverter dc = new DateConverter();
		dc.setUseLocaleFormat(true);
		dc.setPatterns(new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"});
		org.apache.commons.beanutils.ConvertUtils.register(dc, Date.class);
	}


}
