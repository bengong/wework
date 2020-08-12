package wework.service;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import wework.domain.NoticeStat;
import wework.domain.Permission;
import wework.util.EntityServiceImpl;

@IocBean(args = { "refer:dao" })
public class NoticeStatService extends EntityServiceImpl<Permission> {

	public NoticeStatService(Dao dao) {
		super(dao);
	}
	
	public NoticeStat dummy() {
		NoticeStat data = new NoticeStat();
		
		data.total_count = 15;
		data.email_count = 4;
		data.friends_count = 8;
		data.report_count = 3;
		
		return data;
	}
}
