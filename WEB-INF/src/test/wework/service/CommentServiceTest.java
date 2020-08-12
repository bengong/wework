package wework.service;

import java.util.ArrayList;
import java.util.List;

import wework.domain.Message;

public class CommentServiceTest {

	public static void main(String[] args) {
		List<Message> datas = new ArrayList<Message>();
		Message data = new Message();
		data.to_userid = "admin";
		data.from_userid = "bengong";
		data.message_id = "1";
		data.messge_content = "有空就打電話給我";
		data.message_type = "0";
		datas.add(data);
		
		System.out.println(datas);
	}

}
