package wework.domain;

import org.nutz.json.Json;

/**
 * 消息。
 */
public class Message {
	
	public String from_userid;
	public String from_fullname;
	public String to_userid;
	public String to_fullname;
	public String message_id;
	public String messge_content;
	public String send_time;
	public String message_type = "muted" ; //  
	public String read_flag; // 未讀、已讀。
	
	public String getFrom_userid() {
		return from_userid;
	}

	public void setFrom_userid(String from_userid) {
		this.from_userid = from_userid;
	}

	public String getFrom_fullname() {
		return from_fullname;
	}

	public void setFrom_fullname(String from_fullname) {
		this.from_fullname = from_fullname;
	}

	public String getTo_userid() {
		return to_userid;
	}

	public void setTo_userid(String to_userid) {
		this.to_userid = to_userid;
	}

	public String getTo_fullname() {
		return to_fullname;
	}

	public void setTo_fullname(String to_fullname) {
		this.to_fullname = to_fullname;
	}

	public String getMessage_id() {
		return message_id;
	}

	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	public String getMessge_content() {
		return messge_content;
	}

	public void setMessge_content(String messge_content) {
		this.messge_content = messge_content;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public String getMessage_type() {
		return message_type;
	}

	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}

	public String getRead_flag() {
		return read_flag;
	}

	public void setRead_flag(String read_flag) {
		this.read_flag = read_flag;
	}

	public String toString() {
		return Json.toJson(this);
	}
}
