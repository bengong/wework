package wework.api;

/**
 * 日程。
 */
public class ScheduleMethods extends AbstractMethods {

	/**
	 * 添加。
	 * 
	 * @param data
	 * @return
	 */
	public Object add(Object data) {
//		请求参数
//		{
//		    "schedule": {
//		        "organizer": "userid1",
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
		
//		返回值。
//		{ 
//		    "errcode": 0,
//		    "errmsg" : "ok",
//		    "schedule_id":"17c7d2bd9f20d652840f72f59e796AAA"
//		}
		
		return post(String.format("/oa/schedule/add?access_token=%s", gettoken()), data);
	}
	
	public Object update(Object data) {
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
		
		return post(String.format("/oa/schedule/update?access_token=%s", gettoken()), data);
	}
	
	public Object get(Object data) {
//		请求参数
//		{
//		    "schedule_id_list": [
//		        "17c7d2bd9f20d652840f72f59e796AAA"
//		    ]
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
	 * 删除日历。
	 * 
	 * @param data
	 * @return
	 */
	public Object del(Object data) {
//		请求参数
//		{
//		    "schedule_id":"17c7d2bd9f20d652840f72f59e796AAA"
//		}
		
//		返回值。
//		{ 
//		    "errcode": 0,
//		    "errmsg" : "ok"
//		}
		
		return post(String.format("/oa/schedule/del?access_token=%s", gettoken()), data);
	}
	
	
	public Object get_by_calendar(Object data) {
//		请求参数
//		{
//		    "cal_id": "wcjgewCwAAqeJcPI1d8Pwbjt7nttzAAA",
//		    "offset" : 100,
//		    "limit" : 1000
//		}
		
//		返回值。
//		{
//		    "errcode": 0,
//		    "errmsg": "ok",
//		    "schedule_list": [
//		        {
//		            "schedule_id": "17c7d2bd9f20d652840f72f59e796AAA",
//		            "sequence": 100,
//		            "attendees": [
//		                {
//		                    "userid": "userid1",
//		                    "response_status": 0
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
//		            "start_time": 1571274600,
//		            "end_time": 1571320210,
//		            "status": 1,
//		            "cal_id": "wcjgewCwAAqeJcPI1d8Pwbjt7nttzAAA"
//		        }
//		    ]
//		}
		
		return post(String.format("/oa/schedule/get_by_calendar?access_token=%s", gettoken()), data);
	}
}
