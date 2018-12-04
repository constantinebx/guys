package com.guys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 新地球
 *
 */
public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1264691661191372930L;

	/**
	 * 默认单页显示条数
	 */
	private static int DEFAULT_PAGE_SIZE = 20;

	/**
	 * 每页记录数
	 */
	private int pageSize = DEFAULT_PAGE_SIZE;

	/**
	 * 当前页第一条数据在List中的位置，从0开始
	 */
	private long start;

	/**
	 * 当前页中存放的记录，类型一般为List
	 */
	@SuppressWarnings("rawtypes")
	public List data;

	/**
	 * 总记录数
	 */
	private long totalCount;

	/**
	 * 构造方法， 只构造空页。
	 */
	@SuppressWarnings("rawtypes")
	public Page() {
		this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList());
	}

	/**
	 * 构造方法
	 * 
	 * @param start
	 *            本页数据在数据库中的起始位置
	 * @param totalSize
	 *            数据库中总记录条数
	 * @param pageSize
	 *            本页容量
	 * @param data
	 *            本页包含的数据
	 */
	@SuppressWarnings("rawtypes")
	public Page(long start, long totalSize, int pageSize, List data) {
		this.pageSize = pageSize;
		this.start = start;
		this.totalCount = totalSize;
		this.data = data;
	}

	/**
	 * 取总记录数
	 */
	public long getTotalCount() {
		return this.totalCount;
	}

	/**
	 * 取总页数
	 */
	public long getTotalPageCount() {
		if (totalCount % pageSize == 0) {
			return totalCount / pageSize;
		} else {
			return totalCount / pageSize + 1;
		}
	}
	
	/**
	 * 取每页数据容量
	 */
	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * 取当前页中的记录
	 */
	@SuppressWarnings("rawtypes")
	public List getResult() {
		return data;
	}
	
	/**
	 * 取当前页码，页码从1开始
	 */
	public long getCurrentPageNo() {
		return start / pageSize + 1;
	}
	
	/**
	 * 该页是否有下一页
	 */
	public boolean isHasNextPage() {
		return this.getCurrentPageNo() < this.getTotalPageCount();
	}
	
	/**
	 * 该页是否有上一页
	 */
	public boolean isHasPreviousPage() {
		return this.getCurrentPageNo() > 1;
	}
	
	/**
	 * 获取任一页第一条数据在数据集的位置，每页条数使用默认值
	 * 
	 * @see #getStartOfPage(int, int)
	 */
	protected static int getStartOfPage(int pageNo) {
		return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
	}
	
	/**
	 * 获取任一页第一条数据在数据集的位置.
	 * 
	 * @param pageNo 从1开始的页号
	 * @param pageSize 每页记录条数
	 * @return 该页第一条数据
	 */
	public static int getStartOfPage(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}
}
