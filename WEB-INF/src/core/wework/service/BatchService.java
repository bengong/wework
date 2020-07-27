package wework.service;

import org.nutz.mapl.Mapl;

import wework.Wework;

/**
 * 异步批量接口说明
 * 
 * <p>异步批量接口用于大批量数据的处理，提交后接口即返回，企业微信会在后台继续执行任务。
 * 执行完成后，企业微信后台会通过任务事件通知企业获取结果。事件的内容是加密的，解密过程请参考 [消息的加解密处理][signure]，任务事件请参考异步任务完成事件推送。
 * 目前，仅为通讯录更新提供了异步批量接口</p>
 */
public class BatchService {
	
	/**
	 * 增量更新成员
	 * 
	 * @param access_token
	 * @param data
	 * @return
	 */
	public Object syncuser(String access_token, Object data) {
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
		
		String url = String.format(Wework.server_url+"/batch/syncuser?access_token=%s", access_token);	
		Object result = Wework.postJson(url, data);		
		return (Integer)Mapl.cell(result, "jobid");// 异步任务id，最大长度为64字节
	}
	
	/**
	 * 全量覆盖成员
	 * 
	 * @param access_token
	 * @param data
	 * @return
	 */
	public Object replaceuser(String access_token, Object data) {
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
		
		String url = String.format(Wework.server_url+"/batch/replaceuser?access_token=%s", access_token);	
		Object result = Wework.postJson(url, data);		
		return (Integer)Mapl.cell(result, "jobid");// 异步任务id，最大长度为64字节
	}
	
	
	/**
	 * 全量覆盖部门。
	 * 
	 * @param access_token
	 * @param data
	 * @return
	 */
	public Object replaceparty(String access_token, Object data) {
//		{
//		    "media_id":"xxxxxx",
//		    "callback":
//		    {
//		         "url": "xxx",
//		         "token": "xxx",
//		         "encodingaeskey": "xxx"
//		    }
//		}
		
		String url = String.format(Wework.server_url+"/batch/replaceparty?access_token=%s", access_token);	
		Object result = Wework.postJson(url, data);		
		return (Integer)Mapl.cell(result, "jobid");// 异步任务id，最大长度为64字节
	}
	
	/**
	 * 获取异步任务结果
	 * 
	 * @param access_token 调用接口凭证
	 * @param jobid 异步任务id，最大长度为64字节
	 * @return result
	 */
	public Object getresult(String access_token, String jobid) {
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
		
		String url = String.format(Wework.server_url+"/batch/replaceparty?access_token=%s&jobid=", access_token, jobid);	
		return Wework.get(url);		
	}
}
