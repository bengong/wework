package wework;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.nutz.json.Json;
import org.nutz.lang.Files;
import org.nutz.mapl.Mapl;


@RunWith(Enclosed.class)
public class MethodsTest {

    public static class agentMethods extends MockWeworkTestBase {
        @Test
        public void config() throws Exception {
        	String corpid = this.wework.agent.config.corpid;
        	System.out.println(corpid);
        }
        
        @Test
        public void gettoken() throws Exception {
        	this.wework.agent.postman.setPath("mock-data/agent/gettoken.json");
        	String token = this.wework.agent.gettoken("contacts");
        	assertThat(token, is("accesstoken000001"));
        }
        
        @Test
        public void get() throws Exception {        	
        	this.wework.agent.postman.setPath("mock-data/agent/get.json");
        	
        	String access_token = "";
        	Object result = this.wework.agent.get(access_token, "1000005");
        	
        	Integer errcode = (Integer)Mapl.cell(result, "errcode");
        	String errmsg = (String)Mapl.cell(result, "errmsg");
        	Integer agentid = (Integer)Mapl.cell(result, "agentid");
        	String name = (String)Mapl.cell(result, "name");
        	String square_logo_url = (String)Mapl.cell(result, "square_logo_url");
        	String description = (String)Mapl.cell(result, "description");
        	assertThat(errcode, is(0));
        	assertThat(errmsg, is("ok"));        	
        	assertThat(agentid, is(1000005));        	
        	assertThat(name, is("HR助手"));
        	assertThat(square_logo_url, is("https://p.qlogo.cn/bizmail/FicwmI50icF8GH9ib7rUAYR5kicLTgP265naVFQKnleqSlRhiaBx7QA9u7Q/0"));
        	assertThat(description, is("HR服务与员工自助平台"));

        	List user = (List)Mapl.cell(result, "allow_userinfos.user");
        	List allow_partys_partyid = (List)Mapl.cell(result, "allow_partys.partyid");
        	List allow_tags_tagid = (List)Mapl.cell(result, "allow_tags.tagid");
        	assertThat(Mapl.cell(user.get(0), "userid"), is("zhangshan"));
        	assertThat(Mapl.cell(user.get(1), "userid"), is("lisi"));
        	
        	assertThat(allow_partys_partyid, is(Arrays.asList(new Integer[] {1})));
        	assertThat(allow_tags_tagid, is(Arrays.asList(new Integer[] {1,2,3})));
        	        	
        	Integer close = (Integer)Mapl.cell(result, "close");
        	String redirect_domain = (String)Mapl.cell(result, "redirect_domain");
        	Integer report_location_flag = (Integer)Mapl.cell(result, "report_location_flag");
        	Integer isreportenter = (Integer)Mapl.cell(result, "isreportenter");
        	String home_url = (String)Mapl.cell(result, "home_url");        	
        	assertThat(close, is(0));
        	assertThat(redirect_domain, is("open.work.weixin.qq.com"));
        	assertThat(isreportenter, is(0));
        	assertThat(report_location_flag, is(0));
        	assertThat(home_url, is("https://open.work.weixin.qq.com"));
        }
        
        @Test
        public void set() throws Exception {        	
        	String access_token = "";
        	
        	String path = ("mock-data/agent/set-request.json");
        	Object data = Json.fromJson(Files.read(path));
        	Integer agentid = (Integer)Mapl.cell(data, "agentid");
        	Integer report_location_flag = (Integer)Mapl.cell(data, "report_location_flag");
        	String logo_mediaid = (String)Mapl.cell(data, "logo_mediaid");
        	
        	String description = (String)Mapl.cell(data, "description");
        	String redirect_domain = (String)Mapl.cell(data, "redirect_domain");
        	Integer isreportenter = (Integer)Mapl.cell(data, "isreportenter");
        	String home_url = (String)Mapl.cell(data, "home_url");
        	
        	
        	assertThat(agentid, is(1000005));
        	assertThat(report_location_flag, is(0));
        	assertThat(logo_mediaid, is("j5Y8X5yocspvBHcgXMSS6z1Cn9RQKREEJr4ecgLHi4YHOYP-plvom-yD9zNI0vEl"));
        	
        	assertThat(description, is("内部财经服务平台"));
        	assertThat(redirect_domain, is("open.work.weixin.qq.com"));
        	assertThat(isreportenter, is(0));
        	assertThat(home_url, is("https://open.work.weixin.qq.com"));
        	
        	this.wework.agent.postman.setPath("mock-data/agent/set-response.json");

        	Object result = this.wework.agent.set(access_token, data);
        	Integer errcode = (Integer)Mapl.cell(result, "errcode");
        	String errmsg = (String)Mapl.cell(result, "errmsg");
        	        	
        	assertThat(errcode, is(0));
        	assertThat(errmsg, is("ok"));
        }
        
        @Test
        public void list() throws Exception {
        	this.wework.agent.postman.setPath("mock-data/agent/list.json");
        	Object result = this.wework.agent.list(null);
        	
        	Integer agentid = (Integer)Mapl.cell(result, "agentlist[0].agentid");
        	String name = (String)Mapl.cell(result, "agentlist[0].name");
        	String square_logo_url = (String)Mapl.cell(result, "agentlist[0].square_logo_url");
        	
        	assertThat(agentid, is(1000005));
        	assertThat(name, is("HR助手"));
        	assertThat(square_logo_url, is("https://p.qlogo.cn/bizmail/FicwmI50icF8GH9ib7rUAYR5kicLTgP265naVFQKnleqSlRhiaBx7QA9u7Q/0"));
        }
    }
}
