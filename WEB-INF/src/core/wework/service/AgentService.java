package wework.service;

import wework.Wework;

public class AgentService {

	public Object get_user_behavior_data(String access_token, Object data) {		
		String url =  String.format(Wework.server_url+"/externalcontact/get_user_behavior_data?access_token=%s", access_token);
		
//		{
//		    "userid": [
//		        "zhangsan",
//		        "lisi"
//		    ],
//		    "partyid":
//		    [
//		        1001,
//		        1002
//		    ],
//		    "start_time":1536508800,
//		    "end_time":1536940800
//		}
		
		return Wework.postJson(url, data);
	}
}
