package wework.service;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import wework.domain.Message;
import wework.domain.Permission;
import wework.util.EntityServiceImpl;

@IocBean(args = { "refer:dao" })
public class MessageService extends EntityServiceImpl<Permission> {

	public MessageService(Dao dao) {
		super(dao);
	}
	
	public List<Message> dummy() {
		List<Message> datas = new ArrayList<Message>();
		Message data = new Message();
		data.to_userid = "admin";
		data.from_userid = "bengong";
		data.from_fullname = "Ben Gong";
		data.message_id = "1";
		data.messge_content = "有空就打電話給我";
		data.message_type = "danger";
		data.send_time = "4小時";
		datas.add(data);
		
		data = new Message();
		data.to_userid = "admin";
		data.from_userid = "johnpierce";
		data.from_fullname = "John Pierce";
		data.message_id = "2";
		data.messge_content = "我收到您的消息了";
		data.message_type = "muted";
		data.send_time = "8小時";
		datas.add(data);
		
		data = new Message();
		data.to_userid = "admin";
		data.from_userid = "norasilvester";
		data.from_fullname = "Nora Silvester";
		data.message_id = "3";
		data.messge_content = "主題在這裡";
		data.message_type = "warning";
		data.send_time = "12小時";
		datas.add(data);
		
		return datas;
	}
}
