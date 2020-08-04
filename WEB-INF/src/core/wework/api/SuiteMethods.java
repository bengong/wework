package wework.api;

import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(name="suite")
public class SuiteMethods extends AbstractMethods {
	
	public SuiteMethods() {
		super();
	}

	public SuiteMethods(String agentid) {
		super(agentid);
	}

	/**
	 * 新增成员事件
	 * 
	 * @param msg
	 * @return
	 */
	public Object receive(String msg_signature, String timestamp, String nonce) {
		
		return null;
	}
	
	public Object create_user(String msg_signature, String timestamp, String nonce) {		
//		<xml>
//	    <SuiteId><![CDATA[ww4asffe99e54c0f4c]]></SuiteId>
//	    <AuthCorpId><![CDATA[wxf8b4f85f3axxxxxx]]></AuthCorpId>
//	    <InfoType><![CDATA[change_contact]]></InfoType>
//	    <TimeStamp>1403610513</TimeStamp>
//	    <ChangeType><![CDATA[create_user]]></ChangeType>
//	    <UserID><![CDATA[zhangsan]]></UserID>
//	    <Name><![CDATA[张三]]></Name>
//	    <Department><![CDATA[1,2,3]]></Department>
//	    <IsLeaderInDept><![CDATA[1,0,0]]></IsLeaderInDept>
//	    <Mobile><![CDATA[11111111111]]></Mobile>
//	    <Position><![CDATA[产品经理]]></Position>
//	    <Gender>1</Gender>
//	    <Email><![CDATA[zhangsan@xxx.com]]></Email>
//	    <Avatar><![CDATA[http://wx.qlogo.cn/mmopen/ajNVdqHZLLA3WJ6DSZUfiakYe37PKnQhBIeOQBO4czqrnZDS79FH5Wm5m4X69TBicnHFlhiafvDwklOpZeXYQQ2icg/0]]></Avatar>
//	    <Alias><![CDATA[zhangsan]]></Alias>
//	    <Telephone><![CDATA[020-111111]]></Telephone>
//	    <ExtAttr>
//	        <Item>
//	        <Name><![CDATA[爱好]]></Name>
//	        <Type>0</Type>
//	        <Text>
//	            <Value><![CDATA[旅游]]></Value>
//	        </Text>
//	        </Item>
//	        <Item>
//	        <Name><![CDATA[卡号]]></Name>
//	        <Type>1</Type>
//	        <Web>
//	            <Title><![CDATA[企业微信]]></Title>
//	            <Url><![CDATA[https://work.weixin.qq.com]]></Url>
//	        </Web>
//	        </Item>
//	    </ExtAttr>
//	</xml>
		
		return null;
	}
	
	public Object update_user(String msg_signature, String timestamp, String nonce) {		
		
		return null;
	}
	
	public Object delete_user(String msg_signature, String timestamp, String nonce) {		
		
		return null;
	}
	
	/**
	 * 新增部门事件
	 * 
	 * @param msg_signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public Object create_party(String msg_signature, String timestamp, String nonce) {		
//		<xml>
//	    <SuiteId><![CDATA[ww4asffe99e54cxxxx]]></SuiteId>
//	    <AuthCorpId><![CDATA[wxf8b4f85f3a79xxxx]]></AuthCorpId>
//	    <InfoType><![CDATA[change_contact]]></InfoType>
//	    <TimeStamp>1403610513</TimeStamp>
//	    <ChangeType><![CDATA[create_party]]></ChangeType>
//	    <Id>2</Id>
//	    <Name><![CDATA[张三]]></Name>
//	    <ParentId><![CDATA[1]]></ParentId>
//	    <Order>1</Order>
//	</xml>
		
		
		return null;
	}
	
	
	public Object update_party(String msg_signature, String timestamp, String nonce) {		
//		<xml>
//	    <SuiteId><![CDATA[ww4asffe99e54cxxxx]]></SuiteId>
//	    <AuthCorpId><![CDATA[wxf8b4f85f3a79xxxx]]></AuthCorpId>
//	    <InfoType><![CDATA[change_contact]]></InfoType>
//	    <TimeStamp>1403610513</TimeStamp>
//	    <ChangeType><![CDATA[update_party]]></ChangeType>
//	    <Id>2</Id>
//	    <Name><![CDATA[张三]]></Name>
//	    <ParentId><![CDATA[1]]></ParentId>
//	</xml>
		
		
		return null;
	}
	
	/**
	 * 删除部门事件。
	 * 
	 * @param msg_signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public Object delete_party(String msg_signature, String timestamp, String nonce) {		
//		<xml>
//	    <SuiteId><![CDATA[ww4asffe99e54cxxxx]]></SuiteId>
//	    <AuthCorpId><![CDATA[wxf8b4f85f3a79xxxx]]></AuthCorpId>
//	    <InfoType><![CDATA[change_contact]]></InfoType>
//	    <TimeStamp>1403610513</TimeStamp>
//	    <ChangeType><![CDATA[delete_party]]></ChangeType>
//	    <Id>2</Id>
//	</xml>
		
		
		return null;
	}
	
	public Object update_tag(String msg_signature, String timestamp, String nonce) {		
//		<xml>
//	    <SuiteId><![CDATA[ww4asffe99e54cxxxx]]></SuiteId>
//	    <AuthCorpId><![CDATA[wxf8b4f85f3a79xxxx]]></AuthCorpId>
//	    <InfoType><![CDATA[change_contact]]></InfoType>
//	    <TimeStamp>1403610513</TimeStamp>
//	    <ChangeType><![CDATA[update_tag]]></ChangeType>
//	    <TagId>1</TagId>
//	    <AddUserItems><![CDATA[zhangsan,lisi]]></AddUserItems>
//	    <DelUserItems><![CDATA[zhangsan1,lisi1]]></DelUserItems>
//	    <AddPartyItems><![CDATA[1,2]]></AddPartyItems>
//	    <DelPartyItems><![CDATA[3,4]]></DelPartyItems>
//	</xml>
		
		
		return null;
	}
	
	
}
