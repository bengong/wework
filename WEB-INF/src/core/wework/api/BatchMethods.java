package wework.api;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mapl.Mapl;

/**
 * 异步批量接口说明
 * 
 * <p>异步批量接口用于大批量数据的处理，提交后接口即返回，企业微信会在后台继续执行任务。
 * 执行完成后，企业微信后台会通过任务事件通知企业获取结果。事件的内容是加密的，解密过程请参考 [消息的加解密处理][signure]，任务事件请参考异步任务完成事件推送。
 * 目前，仅为通讯录更新提供了异步批量接口</p>
 */
@IocBean(name="batch")
public class BatchMethods extends AbstractMethods {
	
	public BatchMethods() {
		super();
	}

	public BatchMethods(String agentid) {
		super(agentid);
	}

	/**
	 * 增量更新成员
	 * 
	 * 
	 * @param data
	 * @return jobid 异步任务id，最大长度为64字节
	 */
	public Object syncuser(Object data) {
//		{
//		    "media_id":"xxxxxx",
//		    "to_invite": true,
//		    "callback":
//		    {
//		         "url": "xxx",
//		         "token": "xxx",
//		         "encodingaeskey": "xxx"
//		    }
//		}
			
		Object result = post(String.format("/batch/syncuser?access_token=%s", gettoken()), data);		
		return (Integer)Mapl.cell(result, "jobid");
	}
	
	/**
	 * 全量覆盖成员
	 * 
	 * 
	 * @param data
	 * @return jobid 异步任务id，最大长度为64字节
	 */
	public Object replaceuser(Object data) {
//		{
//		    "media_id":"xxxxxx",
//		    "to_invite": true,
//		    "callback":
//		    {
//		         "url": "xxx",
//		         "token": "xxx",
//		         "encodingaeskey": "xxx"
//		    }
//		}
			
		Object result = post(String.format("/batch/replaceuser?access_token=%s", gettoken()), data);		
		return (Integer)Mapl.cell(result, "jobid");
	}
	
	
	/**
	 * 全量覆盖部门。
	 * 
	 * 
	 * @param data
	 * @return jobid 异步任务id，最大长度为64字节
	 */
	public Object replaceparty(Object data) {
//		{
//		    "media_id":"xxxxxx",
//		    "callback":
//		    {
//		         "url": "xxx",
//		         "token": "xxx",
//		         "encodingaeskey": "xxx"
//		    }
//		}
			
		Object result = post(String.format("/batch/replaceparty?access_token=%s", gettoken()), data);		
		return (Integer)Mapl.cell(result, "jobid");
	}
	
	/**
	 * 获取异步任务结果
	 * 
	 * 
	 * @param jobid 异步任务id，最大长度为64字节
	 * @return result
	 */
	public Object getresult(String jobid) {
//		{
//		    "errcode": 0,
//		    "errmsg": "ok",
//		    "status": 1,
//		    "type": "replace_user",
//		    "total": 3,
//		    "percentage": 33,
//		    "result": [{},{}]
//		}
		
//		"result": [
//		           {
//		                "userid":"lisi",
//		                "errcode":0,
//		                "errmsg":"ok"
//		           },
//		           {
//		                "userid":"zhangsan",
//		                "errcode":0,
//		                "errmsg":"ok"
//		           }
//		       ]
			
		return get(String.format("/batch/replaceparty?access_token=%s&jobid=", gettoken(), jobid));		
	}
}
