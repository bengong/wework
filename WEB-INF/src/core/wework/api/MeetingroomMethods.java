package wework.api;

/**
 * 会议室。
 */
public class MeetingroomMethods extends AbstractMethods {

	/**
	 * 添加。
	 * 
	 * @param data
	 * @return
	 */
	public Object add(Object data) {
//		请求参数
//		{
//			  "name":"18F-会议室",
//			  "capacity":10,
//			  "city":"深圳",
//			  "building":"腾讯大厦",
//			  "floor":"18F",
//			  "equipment":[1,2,3],
//			  "coordinate":
//			  {
//			    "latitude":"22.540503",
//			    "longitude":"113.934528"
//			  }
//			}
		
//		返回值。
//		{
//		   "errcode": 0,
//		   "errmsg": "ok",
//		   "meetingroom_id":1
//		}
		
		return post(String.format("/oa/meetingroom/add?access_token=%s", gettoken()), data);
	}

	/**
	 * 查询。
	 * 
	 * @param data
	 * @return
	 */
	public Object list(Object data) {
//		请求参数
//		{
//			  "city":"深圳",
//			  "building":"腾讯大厦",
//			  "floor":"18F",
//			  "equipment":[1,2,3]
//			}
		
////		返回值。
//		{
//			   "errcode": 0,
//			   "errmsg": "ok",
//			   "meetingroom_list":
//			   [
//			   {
//			    "meetingroom_id":1,
//			    "name":"18F-会议室",
//			    "capacity":10,
//			    "city":"深圳",
//			    "building":"腾讯大厦",
//			    "floor":"18F",
//			    "equipment":[1,2,3],
//			    "coordinate":
//			    {
//			     "latitude":"22.540503",
//			     "longitude":"113.934528"
//			    }
//			   },
//			   {
//			    "meetingroom_id":2,
//			    "name":"19F-会议室",
//			    "capacity":20,
//			    "city":"深圳",
//			    "building":"腾讯大厦",
//			    "floor":"19F",
//			    "equipment":[2,3],
//			    "coordinate":
//			    {
//			     "latitude":"22.540503",
//			     "longitude":"113.934528"
//			    }
//			   },
//			   ]
//			}
		
		return post(String.format("/oa/meetingroom/list?access_token=%s", gettoken()), data);
	}	
	
	/**
	 * 编辑。
	 * 
	 * @param data
	 * @return
	 */
	public Object edit(Object data) {
//		请求参数
//		{
//		    "schedule": {
//		        "organizer": "userid1",
//		        "schedule_id": "17c7d2bd9f20d652840f72f59e796AAA",
//		        "start_time": 1571274600,
//		        "end_time": 1571320210,
//		        "attendees": [
//		            {
//		                "userid": "userid2"
//		            }
//		        ],
//		        "summary": "test_summary",
//		        "description": "test_description",
//		        "reminders": {
//		            "is_remind": 1,
//		            "remind_before_event_secs": 3600,
//		            "is_repeat": 1,
//		            "repeat_type": 7
//		        },
//		        "location": "test_place",
//		        "cal_id": "wcjgewCwAAqeJcPI1d8Pwbjt7nttzAAA"
//		    }
//		}
		
////		返回值。
//		{ 
//		    "errcode": 0,
//		    "errmsg" : "ok"
//		}
		
		return post(String.format("/oa/schedule/edit?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 获取。
	 * 
	 * @param data
	 * @return
	 */
	public Object get(Object data) {
//		请求参数
//		{
//		  "meetingroom_id":2,
//		  "name":"18F-会议室",
//		  "capacity":10,
//		  "city":"深圳",
//		  "building":"腾讯大厦",
//		  "floor":"18F",
//		  "equipment":[1,2,3],
//		  "coordinate":
//		  {
//		    "latitude":"22.540503",
//		    "longitude":"113.934528"
//		  }
//		}
		
//		返回值。
//		{
//		    "errcode": 0,
//		    "errmsg": "ok",
//		    "schedule_list": [
//		        {
//		            "schedule_id": "17c7d2bd9f20d652840f72f59e796AAA",
//		            "organizer": "userid1",
//		            "attendees": [
//		                {
//		                    "userid": "userid2",
//		                    "response_status": 1
//		                }
//		            ],
//		            "summary": "test_summary",
//		            "description": "test_content",
//		            "reminders": {
//		                "is_remind": 1,
//		                "is_repeat": 1,
//		                "remind_before_event_secs": 3600,
//		                "repeat_type": 7
//		            },
//		            "location": "test_place",
//		            "cal_id": "wcjgewCwAAqeJcPI1d8Pwbjt7nttzAAA",
//		            "start_time": 1571274600,
//		            "end_time": 1571320210,
//		            "status": 1
//		        }
//		    ]
//		}
		
		return post(String.format("/oa/schedule/get?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 删除。
	 * 
	 * @param data
	 * @return
	 */
	public Object del(Object data) {
//		请求参数
//		{
//		  "meetingroom_id":1,
//		}
		
//		返回值。
//		{ 
//		    "errcode": 0,
//		    "errmsg" : "ok"
//		}
		
		return post(String.format("/oa/schedule/del?access_token=%s", gettoken()), data);
	}
	
	
	public Object get_booking_info(Object data) {
//		请求参数
//		{
//		  "meetingroom_id":1,
//		  "start_time":1593532800,
//		  "end_time":1593619200,
//		  "city":"深圳",
//		  "building":"腾讯大厦",
//		  "floor":"18F"
//		}
		
//		返回值。
//		{
//		   "errcode": 0,
//		   "errmsg": "ok",
//		   "booking_list":
//		   [
//		   {
//		    "meetingroom_id":1,
//		    "schedule":
//		    [
//		        {
//		            "meeting_id":"mtebsada6e027c123cbafAAA",
//		            "schedule_id":"17c7d2bd9f20d652840f72f59e796AAA",
//		            "start_time":1593532800,
//		            "end_time":1593662400,
//		            "booker":"zhangsan"
//		        }
//		    ]
//		   },
//		   {
//		   "meetingroom_id":2,
//		    "schedule":
//		    [
//		    ]
//		   }
//		   ]
//		}
		
		return post(String.format("/oa/schedule/get_booking_info?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 预定会议室
	 * 
	 * 企业可通过此接口预定会议室并自动关联日程。
	 * 
	 * @param data
	 * @return
	 */
	public Object book(Object data) {
//		请求参数
//		{
//		  "meetingroom_id":1,
//		  "subject":"周会",
//		  "start_time":1593532800,
//		  "end_time":1593619200,
//		  "booker":"zhangsan",
//		  "attendees":["lisi", "wangwu"]
//		}
		
//		返回值。
//		{
//		   "errcode": 0,
//		   "errmsg": "ok"
//		   "meeting_id":"mtgsaseb6e027c123cbafAAA",
//		   "schedule_id":"17c7d2bd9f20d652840f72f59e796AAA"
//		}
		
		return post(String.format("/oa/schedule/book?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 取消预定会议室
	 * 
	 * 企业可通过此接口取消会议室的预定
	 * 
	 * @param data
	 * @return
	 */
	public Object cancel_book(Object data) {
//		请求参数
//		{
//		  "meeting_id":"mt42b34949gsaseb6e027c123cbafAAA", // 会议的id
//		  "keep_schedule":1 // 是否保留日程，0-同步删除 1-保留
//		}
		
//		返回值。
//		{
//		   "errcode": 0,
//		   "errmsg": "ok"
//		}
		
		return post(String.format("/oa/schedule/cancel_book?access_token=%s", gettoken()), data);
	}
}
