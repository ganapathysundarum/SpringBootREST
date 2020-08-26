package com.external.api.consume.rest.model;

import java.util.List;

public class TopStoryBean {
	
	private String status;
	private String copyright;
	private String section;
	private String last_updated;
	private String num_results;
	private List<TopStoryResultsBean> results;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}
	public String getNum_results() {
		return num_results;
	}
	public void setNum_results(String num_results) {
		this.num_results = num_results;
	}
	public List<TopStoryResultsBean> getResults() {
		return results;
	}
	public void setResults(List<TopStoryResultsBean> results) {
		this.results = results;
	}
	
	@Override
	public String toString() {
		return "TopStoryBean [status=" + status + ", copyright=" + copyright + ", section=" + section
				+ ", last_updated=" + last_updated + ", num_results=" + num_results + ", results=" + results + "]";
	}
	
	
	
}
