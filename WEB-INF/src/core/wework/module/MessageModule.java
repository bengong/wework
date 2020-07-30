package wework.module;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;
import org.nutz.mvc.annotation.At;

import wework.api.CorpMethods;
import wework.api.MessageMethods;

/**
 * 消息管理。
 */
@IocBean
@At("message")
public class MessageModule {
	
	@Inject
	CorpMethods corpMethods;
	@Inject
	MessageMethods messageMethods;
	
	Log log = Logs.get();
	
	/**
	 * 发送消息。
	 * @param agentid
	 * @return
	 */
	@At("/send/?")
	public Object send(String agentid) {
		NutMap data = new NutMap();		

		Mapl.put(data, "userid", "zhangsan");
		Mapl.put(data, "name", "张三");
		Mapl.put(data, "alias", "jackzhang");
		Mapl.put(data, "mobile", "+86 13800000000");
		Mapl.put(data, "department", "[1, 2]");
		Mapl.put(data, "order", "[10,40]");
		
		return messageMethods.send(corpMethods.token(agentid), data);
	}
	
	
	/**
	 * 發送文本信息。
	 * 
	 * @param agentid 應用標識。
	 * @param content 發送的内容
	 * @return
	 */
	@At("/text/?/?")
	public Object text(String agentid, String content) {
		NutMap data = new NutMap();
		
//		请求示例	
//		{
//		   "touser" : "UserID1|UserID2|UserID3",
//		   "toparty" : "PartyID1|PartyID2",
//		   "totag" : "TagID1 | TagID2",
//		   "msgtype" : "text",
//		   "agentid" : 1,
//		   "text" : {
//		       "content" : "你的快递已到，请携带工卡前往邮件中心领取。\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。"
//		   },
//		   "safe":0,
//		   "enable_id_trans": 0,
//		   "enable_duplicate_check": 0,
//		   "duplicate_check_interval": 1800
//		}
		
		String touser = "bengong";
		String toparty = "";
		String totag = "";
		
		Mapl.put(data, "touser", touser);
		Mapl.put(data, "toparty", toparty);
		Mapl.put(data, "totag", totag);
		Mapl.put(data, "msgtype", "text");// 固定。
		Mapl.put(data, "agentid", agentid);
		Mapl.put(data, "text.content", content);
		
		Mapl.put(data, "safe", 0);
		Mapl.put(data, "enable_id_trans", 0);
		Mapl.put(data, "enable_duplicate_check", 0);
		Mapl.put(data, "duplicate_check_interval", 1800);

		log.info(Json.toJson(data));
		
		return messageMethods.send(corpMethods.token(agentid), data);
	}
	
	@At("/image/?/?")
	public Object image(String agentid, String media_id) {
		NutMap data = new NutMap();		
		
//		请求示例
//		{
//		   "touser" : "UserID1|UserID2|UserID3",
//		   "toparty" : "PartyID1|PartyID2",
//		   "totag" : "TagID1 | TagID2",
//		   "msgtype" : "image",
//		   "agentid" : 1,
//		   "image" : {
//		        "media_id" : "MEDIA_ID"
//		   },
//		   "safe":0,
//		   "enable_duplicate_check": 0,
//		   "duplicate_check_interval": 1800
//		}
		
		String touser = "bengong";
		String toparty = "";
		String totag = "";
		
		Mapl.put(data, "touser", touser);
		Mapl.put(data, "toparty", toparty);
		Mapl.put(data, "totag", totag);
		Mapl.put(data, "msgtype", "image");// 固定。
		Mapl.put(data, "agentid", agentid);
		// 消息内容
		Mapl.put(data, "image.media_id", media_id);
		
		Mapl.put(data, "safe", 0);
		Mapl.put(data, "enable_duplicate_check", 0);
		Mapl.put(data, "duplicate_check_interval", 1800);

		log.info(Json.toJson(data));
		
		return messageMethods.send(corpMethods.token(agentid), data);
	}

	@At("/voice/?/?")
	public Object voice(String agentid, String media_id) {
		NutMap data = new NutMap();		
		
//		请求示例
//		{
//		   "touser" : "UserID1|UserID2|UserID3",
//		   "toparty" : "PartyID1|PartyID2",
//		   "totag" : "TagID1 | TagID2",
//		   "msgtype" : "voice",
//		   "agentid" : 1,
//		   "voice" : {
//		        "media_id" : "MEDIA_ID"
//		   },
//		   "enable_duplicate_check": 0,
//		   "duplicate_check_interval": 1800
//		}
		
		String touser = "bengong";
		String toparty = "";
		String totag = "";
		
		Mapl.put(data, "touser", touser);
		Mapl.put(data, "toparty", toparty);
		Mapl.put(data, "totag", totag);
		Mapl.put(data, "msgtype", "voice");// 固定。
		Mapl.put(data, "agentid", agentid);
		// 消息内容
		Mapl.put(data, "voice.media_id", media_id);
		
		Mapl.put(data, "enable_duplicate_check", 0);
		Mapl.put(data, "duplicate_check_interval", 1800);

		log.info(Json.toJson(data));
		
		return messageMethods.send(corpMethods.token(agentid), data);
	}

	/**
	 * 视频消息.
	 * 
	 * @param agentid
	 * @param media_id
	 * @return
	 */
	@At("/video/?/?")
	public Object video(String agentid, String media_id) {
		NutMap data = new NutMap();		
		
//		请求示例
//		{
//		   "touser" : "UserID1|UserID2|UserID3",
//		   "toparty" : "PartyID1|PartyID2",
//		   "totag" : "TagID1 | TagID2",
//		   "msgtype" : "video",
//		   "agentid" : 1,
//		   "video" : {
//		        "media_id" : "MEDIA_ID",
//		        "title" : "Title", // 视频消息的标题，不超过128个字节，超过会自动截断
//		       "description" : "Description" // 视频消息的描述，不超过512个字节，超过会自动截断
//		   },
//		   "safe":0,// 表示是否是保密消息，0表示否，1表示是，默认0
//		   "enable_duplicate_check": 0, // 表示是否开启重复消息检查，0表示否，1表示是，默认0
//		   "duplicate_check_interval": 1800 // 表示是否重复消息检查的时间间隔，默认1800s，最大不超过4小时
//		}
		
		String touser = "bengong";
		String toparty = "";
		String totag = "";
		
		String title = "";
		String description = "";
		
		Mapl.put(data, "touser", touser);
		Mapl.put(data, "toparty", toparty);
		Mapl.put(data, "totag", totag);
		Mapl.put(data, "msgtype", "video");// 固定。
		Mapl.put(data, "agentid", agentid);
		// 消息内容
		Mapl.put(data, "video.media_id", media_id);
		Mapl.put(data, "video.title", title);
		Mapl.put(data, "video.description", description);
		
		Mapl.put(data, "enable_duplicate_check", 0);
		Mapl.put(data, "duplicate_check_interval", 1800);

		log.info(Json.toJson(data));
		
		return messageMethods.send(corpMethods.token(agentid), data);
	}
}