/**
 * BTI - BAAN for Technology And Trade IntL. 
 * Copyright @ 2017 BTI. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF BTI. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF BTI.
 */
package com.cache.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Description: The DTO class for Search Operations 
 * Name of Project: BTI
 * Created on: May 19, 2017
 * Modified on: May 19, 2017 12:19:38 PM
 * @author seasia
 * Version: 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoSearch {

	private String searchKeyword;
	private Integer pageNumber;
	private Integer pageSize;
	private Integer totalCount;
	private Object records;
	private String sortOn;
	private String sortBy;
	private Integer id;
	private List<String> ids;
	private String condition;

	/**
	 * @return the searchKeyword
	 */
	public String getSearchKeyword() {
		return searchKeyword;
	}

	/**
	 * @param searchKeyword the searchKeyword to set
	 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	/**
	 * @return the pageNumber
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the totalCount
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the records
	 */
	public Object getRecords() {
		return records;
	}

	/**
	 * @param records the records to set
	 */
	public void setRecords(Object records) {
		this.records = records;
	}

	public String getSortOn() {
		return sortOn;
	}

	public void setSortOn(String sortOn) {
		this.sortOn = sortOn;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
}

