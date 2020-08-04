package wework.api;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mapl.Mapl;

/**
 * 日历。
 */
@IocBean(name="calendar")
public class CalendarMethods extends AbstractMethods {

	/**
	 * 添加。
	 * 
	 * @param data
	 * @return cal_id
	 */
	public Object add(Object data) {
//		返回值。
//		{ 
//		    "errcode": 0,
//		    "errmsg" : "ok",
//		    "cal_id":"wcjgewCwAAqeJcPI1d8Pwbjt7nttzAAA"
//		}
		
		Object result = post(String.format("/oa/calendar/add?access_token=%s", gettoken()), data);
		return Mapl.cell(result, "cal_id");
	}
	
	public Object update(Object data) {
//		请求参数
//		{
//		    "calendar" : {
//		        "cal_id":"wcjgewCwAAqeJcPI1d8Pwbjt7nttzAAA",
//		        "summary" : "test_summary",
//		        "color" : "#FF3030",
//		        "description" : "test_describe_1",
//		        "shares" : [
//		            {
//		                "userid" : "userid1"
//		            },
//		            {
//		                "userid" : "userid2"
//		            }
//		        ]
//		    }
//		}
		
////		返回值。
//		{ 
//		    "errcode": 0,
//		    "errmsg" : "ok"
//		}
		
		return post(String.format("/oa/calendar/update?access_token=%s", gettoken()), data);
	}
	
	public Object get(Object data) {
//		请求参数
//		{ 
//		    "cal_id_list": ["wcjgewCwAAqeJcPI1d8Pwbjt7nttzAAA"]
//		}
		
//		返回值。
//		{
//		    "errcode": 0,
//		    "errmsg": "ok",
//		    "calendar_list": [
//		        {
//		            "cal_id": "wcjgewCwAAqeJcPI1d8Pwbjt7nttzAAA",
//		            "organizer": "userid1",
//		            "summary" : "test_summary",
//		            "color" : "#FF3030",
//		            "description": "test_describe_1",
//		            "shares": [
//		                {
//		                    "userid": "userid2"
//		                },
//		                {
//		                    "userid": "userid1"
//		                }
//		            ]
//		        }
//		    ]
//		}
		
		return post(String.format("/oa/calendar/get?access_token=%s", gettoken()), data);
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
//		    "cal_id":"wcjgewCwAAqeJcPI1d8Pwbjt7nttzAAA"
//		}
		
////		返回值。
//		{ 
//		    "errcode": 0,
//		    "errmsg" : "ok"
//		}
		
		return post(String.format("/oa/calendar/del?access_token=%s", gettoken()), data);
	}
}
