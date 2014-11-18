package net.eleword.blog.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin 
 * @date 2014-1-30上午10:01:54
 */

public class Pagination<T> {

	public static final String ASC = "asc", DESC = "desc";

	private int pageSize = 20;

	private int startPage;

	private long totalRecords;

	private int totalPages;

	private String pageAction;

	private String orderProperty;

	private String order;

	private List<T> resultSet;

	private boolean autoCount = true;

	private int currentPage = 1;

	/**
	 * 每页记录数
	 * 
	 * @return
	 */

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 开始页
	 * @return
	 */
	public int getStartPage() {
		return ((currentPage - 1) * pageSize) + 1;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	/**
	 * 分页action
	 * 
	 * @return
	 */
	public String getPageAction() {
		return pageAction;
	}

	public void setPageAction(String pageAction) {
		this.pageAction = pageAction;
	}

	public String getOrderProperty() {
		return orderProperty;
	}

	/**
	 * 设置排序属性
	 * 
	 * @param orderProperty
	 */
	public void setOrderProperty(String orderProperty) {
		this.orderProperty = orderProperty;
	}

	/**
	 * 获取返回结果集
	 * 
	 * @return
	 */
	public List<T> getResultSet() {
		return resultSet;
	}

	public void setResultSet(List<T> resultSet) {
		this.resultSet = resultSet;
	}

	/**
	 * 设置查询时是否先查询获取总记录数
	 * 
	 * @return
	 */
	public boolean isAutoCount() {
		return autoCount;
	}

	public void setAutoCount(boolean autoCount) {
		this.autoCount = autoCount;
	}

	/**
	 * 获取总页数
	 * 
	 * @return
	 */
	public int getTotalPages() {
		int totalPages = (int) (Math.ceil((double) totalRecords / (double) pageSize));
		this.totalPages = totalPages;
		return totalPages;
	}

	/**
	 * 获取当前页
	 * 
	 * @return
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 是否已设置排序字段,无默认值.
	 * 
	 * @return
	 */
	public boolean isOrderBySetted() {
		return (StringUtils.isNotBlank(this.orderProperty) && StringUtils.isNotBlank(order));
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
