package wework.api;

import java.util.List;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mapl.Mapl;

/**
 * 
 */
@IocBean(name="tag")
public class TagMethods extends AbstractMethods {
	
	Log log = Logs.get();

	public TagMethods(String agentid) {
		super(agentid);
	}

	public TagMethods() {
		super();
	}
	
	/**
	 * 創建。
	 * 
	 * @param data
	 * @return
	 */
	public Integer create(Object data) {
		Object result = post(String.format("/tag/create?access_token=%s", gettoken()), data);		
		return (Integer)Mapl.cell(result, "tagid");
	}
	
	/**
	 * 更新标签名字
	 * 
	 * @param data
	 */
	public Object update(Object data) {
		return post(String.format("/tag/update?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 刪除。
	 * 
	 * @param tagid
	 */
	public Object delete(String tagid) {
		return get(String.format("/tag/delete?access_token=%s&tagid=%s", gettoken(), tagid));
	}

	/**
	 * 获取标签成员
	 * 
	 * @param tagid
	 * @return
	 */
	public Object gettag(String tagid) {
		return get(String.format("/tag/get?access_token=%s&tagid=%s", gettoken(), tagid));
	}
	
	/**
	 * 增加标签成员
	 * 
	 * @param data
	 * @return
	 */
	public Object addtagusers(Object data) {
		return post(String.format("/tag/addtagusers?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 删除标签成员
	 * 
	 * @param data
	 * @return
	 */
	public Object deltagusers(Object data) {
		return post(String.format("/tag/deltagusers?access_token=%s", gettoken()), data);
	}
	
	
	
	/**
	 * 获取标签列表
	 * 
	 * @return taglist
	 */
	public List list(String department_id, String fetch_child) {
		Object result = get(String.format("/tag/list?access_token=%s", gettoken()));
		return (List)Mapl.cell(result, "taglist");
	}
}
