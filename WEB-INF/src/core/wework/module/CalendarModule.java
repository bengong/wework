package wework.module;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Dumps.HTTP;
import org.nutz.lang.random.StringGenerator;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.POST;

import wework.Wework;

/**
 * 日历
 */
@IocBean
@At("calendar")
public class CalendarModule {
	@Inject
	Wework wework;
	
	Log log = Logs.get();
	
	public CalendarModule() throws Exception {
	}
	
	/**
	 * 创建
	 * @return
	 * @throws Exception 
	 */
	@At({"/"})
	@GET
	public Object get() throws Exception {
//		请求参数
//		{ 
//		    "cal_id_list": ["wcjgewCwAAqeJcPI1d8Pwbjt7nttzAAA"]
//		}
		NutMap data = new NutMap();
		Mapl.put(data, "cal_id_list", new String[]{"wcjgewCwAAqeJcPI1d8Pwbjt7nttzAAA"});
		
		return wework.calendar.get(data);
	}
	
	/**
	 * 添加。
	 * @param msg_signature
	 * @param timestamp
	 * @param nonce
	 * @param request
	 * @return cal_id
	 * @throws Exception
	 */
	@At({"/add"})
	public Object add() throws Exception {
//		请求参数
//		{
//		    "calendar" : {
//		        "organizer" : "userid1",
//		        "summary" : "test_summary",
//		        "color" : "#FF3030",
//		        "description" : "test_describe",
//		        "shares" : [
//		            {
//		                "userid" : "userid2"
//		            },
//		            {
//		                "userid" : "userid3"
//		            }
//		        ]
//		    }
//		}
		
		NutMap data = new NutMap();
		Mapl.put(data, "calendar.organizer", "userid1");// 指定的组织者userid。注意该字段指定后不可更新
		Mapl.put(data, "calendar.summary", "test_summary");// 日历标题。1 ~ 128 字符
		Mapl.put(data, "calendar.color", "#FF3030");// 日历在终端上显示的颜色，RGB颜色编码16进制表示，例如：”#0000FF” 表示纯蓝色
		Mapl.put(data, "calendar.description", "test_describe");// 日历描述。0 ~ 512 字符
		Mapl.put(data, "calendar.shares[0].userid", "userid2");// 日历共享成员列表。最多2000人
		Mapl.put(data, "calendar.shares[1].userid", "userid3");// 日历共享成员的id
		
		return wework.calendar.add(data);
	}
}