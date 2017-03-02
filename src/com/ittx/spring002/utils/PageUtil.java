package com.ittx.spring002.utils;


public class PageUtil {
	/**每页多少条数据*/
	private int pageSize = 10;
	/**总记录条数*/
	private int totalCount;   
	/**当前页*/
	private int currentPage;
	/**总页数*/
	private int pageCount;

	public PageUtil(int pageSize, int totalCount, int currentPage) {
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.setCurrentPage(currentPage);
	}
	
	/**
	 * 当前页边界检查
	 * 最大不大于总页数，最小不小于一页
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		int activePage = currentPage <= 0 ? 1 : currentPage;
		activePage = activePage > getPageCount() ? getPageCount() : activePage;
		this.currentPage = activePage;
	}

	/**
	 * 计算总页数
	 * @return
	 */
	public int getPageCount() {
		pageCount = totalCount / pageSize;  // 26  /  10     2   
		int mod = totalCount % pageSize;    // 26  %  10     6   
		if (mod != 0) {
			pageCount++;   //3
		}
		return totalCount == 0 ? 1 : pageCount;
	}

	/**
	 *  获取开始记录序号（偏移量offset）     limit offset,pageSize
	 *  
	 *  每页显示10条记录
	 *  1页   0    0-9  
	 *  2页   10   10-19      
	 *  3页   20    20-29
	 *    .....
	 *  n页    (n-1)*pageSize
	 *    
	 */
	public int getFromIndex() {
		return (currentPage - 1) * pageSize;
	}

	/**
	 * 结束记录序号
	 * @return
	 */
	public int getToIndex() {
		return Math.min(totalCount, currentPage * pageSize);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
