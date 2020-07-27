package wework.service;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;
import org.nutz.service.Service;

import wework.Wework;
import wework.domain.Token;

@IocBean
public class DepartmentService  extends Service {	
	
	Log log = Logs.get();

	public DepartmentService() {
		super();
	}
	
	
	public Integer create(String access_token, Mapl data) {		
		String url = Wework.server_url+"/department/create?access_token=%s";
		
		Mapl result = Wework.as(Wework.postJson(String.format(url, access_token), data));
		
		return (Integer)Mapl.cell(result, "id");
	}
	
	/**
	 * 
	 * @param access_token
	 * @param data
	 * @return
	 */
	public Token list(String access_token, String id) {		
		String url = Wework.server_url+"department/list?access_token=%s&id=%s";
		
		return Wework.as(Token.class, Wework.get(String.format(url, access_token, id)));
	}
}
