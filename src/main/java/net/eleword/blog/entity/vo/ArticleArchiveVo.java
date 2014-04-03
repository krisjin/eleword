package net.eleword.blog.entity.vo;

import java.io.Serializable;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-3下午5:20:35
 */

public class ArticleArchiveVo implements Serializable {
	
	private String months;
	
	private int counts;

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

}
