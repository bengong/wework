package wework.api;

import java.util.List;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mapl.Mapl;

/**
 * 外部联系人。
 *
 */
@IocBean(name="externalcontact")
public class ExternalContactMethods  extends AbstractMethods {
	
	public ExternalContactMethods() {
		super();
	}


	public ExternalContactMethods(String agentid) {
		super(agentid);
	}


	public Object remark(Object data) {
//		{
//			   "userid":"zhangsan",
//			   "external_userid":"woAJ2GCAAAd1asdasdjO4wKmE8Aabj9AAA",
//			   "remark":"备注信息",
//			   "description":"描述信息",
//			   "remark_company":"腾讯科技",
//			   "remark_mobiles":[
//			        "13800000001",
//			        "13800000002"
//			   ],
//			   "remark_pic_mediaid":"MEDIAID"
//			}
		
		return post(String.format("/externalcontact/remark?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 获取详情。
	 * 
	 * @param external_userid
	 * @return
	 */
	public Object getinfo(String external_userid) {
		return get(String.format("/externalcontact/get?access_token=%s&external_userid=%s", gettoken(), external_userid));
	}
	
	public Object list(String userid) {
		Object result = get(String.format("/externalcontact/list?access_token=%s&userid=%s", gettoken(), userid));
		List external_userid = (List)Mapl.cell(result, "external_userid");
		return external_userid;
	}
	
	/**
	 * 获取企业标签库。
	 * 
	 * 
	 * @param data
	 * @return
	 */
	public Object get_corp_tag_list(Object data) {	
//		{
//		    "tag_id": [
//		        "etXXXXXXXXXX",
//		        "etYYYYYYYYYY"
//		    ]
//		}
		
		return post(String.format("/externalcontact/get_corp_tag_list?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 添加企业客户标签
	 * 
	 * 
	 * @param data
	 * @return
	 */
	public Object add_corp_tag(Object data) {
//		{
//		    "group_id": "GROUP_ID",
//		    "group_name": "GROUP_NAME",
//		    "order": 1,
//		    "tag": [{
//		            "name": "TAG_NAME_1",
//		            "order": 1
//		        },
//		        {
//		            "name": "TAG_NAME_2",
//		            "order": 2
//		        }
//		    ]
//		}
		
		return post(String.format("/externalcontact/add_corp_tag?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 编辑企业客户标签
	 * 
	 * 
	 * @param data
	 * @return
	 */
	public Object edit_corp_tag(Object data) {
		
//		{
//		    "group_id": "GROUP_ID",
//		    "group_name": "GROUP_NAME",
//		    "order": 1,
//		    "tag": [{
//		            "name": "TAG_NAME_1",
//		            "order": 1
//		        },
//		        {
//		            "name": "TAG_NAME_2",
//		            "order": 2
//		        }
//		    ]
//		}
		
		return post(String.format("/externalcontact/add_corp_tag?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 删除企业客户标签
	 * 
	 * 
	 * @param data
	 * @return
	 */
	public Object del_corp_tag(Object data) {
		
//		{
//		    "tag_id": [
//		        "TAG_ID_1",
//		        "TAG_ID_2"
//		    ],
//		    "group_id": [
//		        "GROUP_ID_1",
//		        "GROUP_ID_2"
//		    ]
//		}
		
		return post(String.format("/externalcontact/del_corp_tag?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 编辑客户企业标签
	 * 
	 * @see  <a href="https://work.weixin.qq.com/api/doc/90001/90143/92697">https://work.weixin.qq.com/api/doc/90001/90143/92697</a>
	 * 
	 * 
	 * @param data
	 * @return
	 */
	public Object mark_tag(Object data) {
//		{
//		    "userid":"zhangsan",
//		    "external_userid":"woAJ2GCAAAd1NPGHKSD4wKmE8Aabj9AAA",
//		    "add_tag":["TAGID1","TAGID2"],
//		    "remove_tag":["TAGID3","TAGID4"]
//		}
		
		return post(String.format("/externalcontact/del_corp_tag?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 获取客户群详情。
	 * 
	 * <p>通过客户群ID，获取详情。包括群名、群成员列表、群成员入群时间、入群方式。（客户群是由具有客户群使用权限的成员创建的外部群）</p>
	 * 
	 * 
	 * @param data
	 * @return
	 */
	public Object groupchat(Object data) {
//		{
//		    "chat_id":"wrOgQhDgAAMYQiS5ol9G7gK9JVAAAA"
//		}
		
		return post(String.format("/externalcontact/groupchat?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 发送新客户欢迎语
	 * 
	 * 
	 * 
	 * 
	 * @param data
	 * @return
	 */
	public Object send_welcome_msg(Object data) {
		
//		{
//		    "chat_id":"wrOgQhDgAAMYQiS5ol9G7gK9JVAAAA"
//		}
		
		return post(String.format("/externalcontact/send_welcome_msg?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 添加企业群发消息任务
	 * 
	 * <p>企业可通过此接口添加企业群发消息的任务并通知客服人员发送给相关客户或客户群。（注：企业微信终端需升级到2.7.5版本及以上）
	 * 注意：调用该接口并不会直接发送消息给客户/客户群，需要相关的客服人员操作以后才会实际发送（客服人员的企业微信需要升级到2.7.5及以上版本）
	 * 同一个企业每个自然月内仅可针对一个客户/客户群发送4条消息，超过限制的用户将会被忽略。</p>
	 * 
	 * 
	 * @param data
	 * @return
	 */
	public Object add_msg_template(Object data) {
//		{
//		    "chat_id":"wrOgQhDgAAMYQiS5ol9G7gK9JVAAAA"
//		}
		
		return post(String.format("/externalcontact/add_msg_template?access_token=%s", gettoken()), data);
	}

	
	/**
	 * 获取企业群发消息发送结果
	 * 
	 * 
	 * @param data
	 * @return
	 */
	public Object get_group_msg_result(Object data) {
		
//		{
//		    "msgid": "msgGCAAAXtWyujaWJHDDGi0mACAAAA"
//		}
		
		return post(String.format("/externalcontact/get_group_msg_result?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 获取离职成员的客户列表
	 * 
	 * 
	 * @param data
	 * @return
	 */
	public Object get_unassigned_list(Object data) {
		
//		{
//			  "page_id":0,
//			  "page_size":100
//			}
		
		return post(String.format("/externalcontact/get_unassigned_list?access_token=%s", gettoken()), data);
	}
	
	
	public Object transfer(Object data) {
//		{
//			   "external_userid": "woAJ2GCAAAXtWyujaWJHDDGi0mACAAAA",
//			   "handover_userid": "zhangsan",
//			   "takeover_userid": "lisi"
//			}
		
		return post(String.format("/externalcontact/transfer?access_token=%s", gettoken()), data);
	}
	
	/**
	 * 获取联系客户统计数据
	 * 
	 * 
	 * @param data
	 * @return
	 */
	public Object get_user_behavior_data(Object data) {
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
		
		return post(String.format("/externalcontact/get_user_behavior_data?access_token=%s", gettoken()), data);
	}
}
