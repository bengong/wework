package wework.domain;

import org.nutz.json.Json;

import wework.WeResponse;

public class Department extends WeResponse {
	public int id;
	public String name;
	public String name_en;
	public int parentid;
	public int order;
	
	public String toString() {
		return Json.toJson(this);
	}
}
