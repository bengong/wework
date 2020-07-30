package wework.api;

import org.nutz.ioc.loader.annotation.IocBean;

import wework.AbstractMethods;

/**
 * 应用管理。
 */
@IocBean
public class ApprovalMethods extends AbstractMethods {

	/**
	 * 获取审批模板详情
	 * 
	 * 审批应用的Secret可获取企业自建模板及第三方服务商添加的模板详情；自建应用的Secret可获取企业自建模板的模板详情。
	 * 接口调用频率限制为600次/分钟。
	 * 
	 * @param access_token 调用接口凭证
	 * @return
	 */
	public Object gettemplatedetail(String access_token, Object data) {
		String url =  String.format("/oa/gettemplatedetail?access_token=%s", access_token);
		
//		请求示例
//		{
//		   模板的唯一标识id。可在“获取审批单据详情”、“审批状态变化回调通知”中获得，也可在审批模板的模板编辑页面浏览器Url链接中获得。
//		   "template_id" : "ZLqk8pcsAoXZ1eYa6vpAgfX28MPdYU3ayMaSPHaaa" 
//		}
		
		return postJson(url, data);
	}
	
	/**
	 * 提交审批申请
	 * 
	 * 企业可通过审批应用或自建应用Secret调用本接口，代应用可见范围内员工在企业微信“审批应用”内提交指定类型的审批申请。
	 * 
	 * @param access_token 调用接口凭证
	 * @param data
	 * @return
	 */
	public Object applyevent(String access_token, Object data) {
		String url =  String.format("/oa/applyevent?access_token=%s", access_token);
		
//		请求示例
//		{
//		    "creator_userid": "WangXiaoMing",
//		    "template_id": "3Tka1eD6v6JfzhDMqPd3aMkFdxqtJMc2ZRioeFXkaaa",
//		    "use_template_approver":0,
//		    "approver": [
//		        {
//		            "attr": 2,
//		            "userid": ["WuJunJie","WangXiaoMing"]
//		        },
//		        {
//		            "attr": 1,
//		            "userid": ["LiuXiaoGang"]
//		        }
//		    ],
//		    "notifyer":[ "WuJunJie","WangXiaoMing" ],
//		    "notify_type" : 1,
//		    "apply_data": {
//		         "contents": [
//		                {
//		                    "control": "Text",
//		                    "id": "Text-15111111111",
//		                    "value": {
//		                        "text": "文本填写的内容"
//		                    }
//		                }
//		            ]
//		    },
//		    "summary_list": [
//		        {
//		            "summary_info": [{
//		                "text": "摘要第1行",
//		                "lang": "zh_CN"
//		            }]
//		        },
//		        {
//		            "summary_info": [{
//		                "text": "摘要第2行",
//		                "lang": "zh_CN"
//		            }]
//		        },
//		        {
//		            "summary_info": [{
//		                "text": "摘要第3行",
//		                "lang": "zh_CN"
//		            }]
//		        }
//		    ]
//		}
		
		return postJson(url, data);
	}
	
	/**
	 * <p>批量获取审批单号</p>
	 * 
	 * <p>审批应用及有权限的自建应用，可通过Secret调用本接口，以获取企业一段时间内企业微信“审批应用”单据的审批编号，支持按模板类型、申请人、部门、申请单审批状态等条件筛选。
	 * 自建应用调用此接口，需在“管理后台-应用管理-审批-API-审批数据权限”中，授权应用允许提交审批单据。</p>
	 * 
	 * <p>一次拉取调用最多拉取100个审批记录，可以通过多次拉取的方式来满足需求，但调用频率不可超过600次/分。</p>
	 * 
	 * @param access_token 调用接口凭证
	 * @param data
	 * @return
	 */
	public Object getapprovalinfo(String access_token, Object data) {
		String url =  String.format("/oa/getapprovalinfo?access_token=%s", access_token);
		
//		请求示例
//		{
//		    "starttime" : "1569546000",
//		    "endtime" : "1569718800",
//		    "cursor" : 0 ,
//		    "size" : 100 ,
//		    "filters" : [
//		        {
//		            "key": "template_id",
//		            "value": "ZLqk8pcsAoaXZ1eY56vpAgfX28MPdYU3ayMaSPHaaa"
//		        },
//		        {
//		            "key" : "creator",
//		            "value" : "WuJunJie"
//		        },
//		        {
//		            "key" : "department",
//		            "value" : "1688852032415111"
//		        },       
//		        {
//		            "key" : "sp_status",
//		            "value" : "1"
//		        }     
//		    ]
//		}
		
		return postJson(url, data);
	}
	
	/**
	 * 获取审批申请详情
	 * 
	 * 企业可通过审批应用或自建应用Secret调用本接口，根据审批单号查询企业微信“审批应用”的审批申请详情。
	 * 
	 * 接口频率限制 600次/分钟
	 * 
	 * @param access_token 调用接口凭证
	 * @param data
	 * @return
	 */
	public Object getapprovaldetail(String access_token, Object data) {
		String url =  String.format("/oa/getapprovaldetail?access_token=%s", access_token);
		
//		请求示例
//		{
//		   "sp_no" : 201909270001 // 审批单编号。
//		}
		
		return postJson(url, data);
	}
}
