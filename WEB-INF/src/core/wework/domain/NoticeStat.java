package wework.domain;

import org.nutz.json.Json;

/**
 * 通知統計。
 */
public class NoticeStat {
	
	/**
	 * 總數
	 */
	public Integer total_count;
	
	/**
	 * 郵件
	 */
	public Integer email_count;
	
	/**
	 * 好友
	 */
	public Integer friends_count;
	
	/**
	 * 報告。
	 */
	public Integer report_count;
	
	public Integer getTotal_count() {
		return total_count;
	}

	public void setTotal_count(Integer total_count) {
		this.total_count = total_count;
	}

	public Integer getEmail_count() {
		return email_count;
	}

	public void setEmail_count(Integer email_count) {
		this.email_count = email_count;
	}

	public Integer getFriends_count() {
		return friends_count;
	}

	public void setFriends_count(Integer friends_count) {
		this.friends_count = friends_count;
	}

	public Integer getReport_count() {
		return report_count;
	}

	public void setReport_count(Integer report_count) {
		this.report_count = report_count;
	}

	public String toString() {
		return Json.toJson(this);
	}
}
