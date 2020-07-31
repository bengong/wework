package wework.api;

/**
 * 直播。
 */
public class LivingMethods extends AbstractMethods {

	/**
	 * 添加。
	 * 
	 * @param data
	 * @return
	 */
	public Object get_user_livingid(Object data) {
//		请求参数
//		{
//		    "userid": "USERID",
//		    "begin_time": 1586136317,
//		    "end_time": 1586236317,
//		    "next_key": "NEXT_KEY",
//		    "limit": 100
//		}
		
//		返回值。
//		{
//		   "errcode": 0,
//		   "errmsg": "ok",
//		   "ending":1,
//		   "next_key": "NEXT_KEY",
//		   "livingid_list":[
//		        "livingid1",
//		        "livingid2"
//		   ]
//		}
		
		return post(String.format("/oa/meetingroom/get_user_livingid?access_token=%s", gettoken()), data);
	}

	/**
	 * 查询。
	 * 
	 * @param data
	 * @return
	 */
	public Object get_living_info(String livingid) {
//		返回值。
//		{
//		   "errcode": 0,
//		   "errmsg": "ok",
//		   "living_info":{
//		        "theme": "直角三角形讲解",
//		        "living_start": 1586405229,
//		        "living_duration": 1800,
//		        "anchor_userid": "zhangsan",
//		        "main_department": 1,
//		        "viewer_num": 100,
//		        "comment_num": 110,
//		        "mic_num": 120,
//		        "open_replay": 1
//		    }
//		}
		
		return get(String.format("/oa/meetingroom/get_living_info?access_token=%s&livingid=%s", gettoken(), livingid));
	}	
	
	/**
	 * 获取看直播统计
	 * 
	 * 通过该接口可以获取所有观看直播的人员统计
	 * 
	 * @param data
	 * @return
	 */
	public Object get_watch_stat(Object data) {
//		请求参数
//		{
//		    "livingid": "livingid1", // 直播的id
//		    "next_key": "NEXT_KEY" // 上一次调用时返回的next_key，初次调用可以填”0”
//		}
		
//		返回值。
//		{
//		   "errcode": 0,
//		   "errmsg": "ok",
//		   "ending":1,
//		   "next_key": "NEXT_KEY",
//		   "stat_info":{
//		        "users":[
//		            {
//		                "userid": "userid",
//		                "watch_time": 30,
//		                "is_comment": 1,
//		                "is_mic": 1
//		            }
//		        ],
//		        "external_users":[
//		            {
//		                "external_userid": "external_userid1",
//		                "type": 1,
//		                "name": "user name",
//		                "watch_time": 30,
//		                "is_comment": 1,
//		                "type": 1,
//		                "is_mic": 1
//		            },
//		            {
//		                "external_userid": "external_userid2",
//		                "type": 2,
//		                "name": "user_name",
//		                "watch_time": 30,
//		                "is_comment": 1,
//		                "is_mic": 1
//		            }
//		        ],
//		   }
//		}
		
		return post(String.format("/oa/schedule/get_watch_stat?access_token=%s", gettoken()), data);
	}
}
