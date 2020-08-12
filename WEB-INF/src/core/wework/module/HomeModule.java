package wework.module;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.lang.util.Context;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import wework.Wework;
import wework.domain.Message;
import wework.domain.NoticeStat;
import wework.service.MessageService;
import wework.service.NoticeStatService;

@IocBean
@At("home")
public class HomeModule {	
	@Inject
	Wework wework;
	@Inject
	MessageService messageService;
	@Inject
	NoticeStatService noticeStatService;
	
	Log log = Logs.get();
	
	@At("/")
	@Ok("jsp:/home/home")
	public Object home() {
		Context context = Lang.context();
		
		// 消息
		List<Message> messages =  messageService.dummy();
		context.set("messages", messages);
		
		NoticeStat noticestat = noticeStatService.dummy();
		context.set("noticestat", noticestat);
		
		return context;
	}
}
