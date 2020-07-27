package wework.service;

import wework.Wework;

/**
 * 消息管理。
 */
public class MessageService {

	/**
	 * 
	 * @param access_token
	 * @param agentid
	 * @return
	 */
	public Object send(String access_token, Object data) {		
		String url =  String.format(Wework.server_url+"/message/send?access_token=%s&agentid=%s", access_token);
	
		return Wework.postJson(url, data);
	}
	
	public void test() {
//		{
//			   "touser" : "UserID1|UserID2|UserID3",
//			   "toparty" : "PartyID1|PartyID2",
//			   "totag" : "TagID1 | TagID2",
//			   "msgtype" : "text",
//			   "agentid" : 1,
//			   "text" : {
//			       "content" : "你的快递已到，请携带工卡前往邮件中心领取。\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。"
//			   },
//			   "safe":0,
//			   "enable_id_trans": 0,
//			   "enable_duplicate_check": 0,
//			   "duplicate_check_interval": 1800
//			}
		
		
	}
}
