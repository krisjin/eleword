package net.eleword.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author shijingui
 * @date 2014-3-5下午01:45:50
 */
public abstract class DateUtils {

	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static final String YYYY_MM_DD = "yyyy-MM-dd";


	/**
	 * 获得格式化日期
	 *
	 * @param date
	 * @param pattern
	 *
	 * @return
	 */
	public static String getDateFormat(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 字符串格式转日期类型
	 *
	 * @param date
	 * @param pattern
	 *
	 * @return
	 * @throws ParseException
	 */
	public static Date valueOfDate(String date, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(date);
	}


	/**
	 * @param list
	 *
	 * @return
	 */
	public static List<String[]> handleArticleArchiveDate(List list) {
		if (list == null) {
			return null;
		}
		List<String[]> retList = new ArrayList<String[]>();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			String[] date = ((String) obj[0]).split("-");
			String month = "";
			if (date[1].startsWith("0")) {
				month = date[1].substring(1, 2) + "月";
			} else {
				month = date[1] + "月";
			}
			String[] newArr = {date[0] + "年" + month, String.valueOf(obj[1])};
			retList.add(newArr);
		}
		list.clear();

		for (int j = 0; j < retList.size(); j++) {
			System.out.println(retList.get(j)[0]);
		}
		return retList;
	}

	public static String handleArticleArchiveDate(String date) {
		String[] sdate = date.split("年");
		String year = sdate[0] + "-";
		String month = "";

		if (sdate[1].length() >= 3) {
			month = sdate[1].substring(0, 2);
		} else {

			month = "0" + sdate[1].substring(0, 1);
		}
		return year + month;
	}
}
