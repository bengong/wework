package wework.domain;

import org.nutz.json.Json;
import org.nutz.lang.Files;
import org.nutz.lang.util.NutMap;
import org.nutz.mapl.Mapl;

import wework.api.CorpMethods;

public class CorpTest {

	public void test() {
		CorpMethods data  = new CorpMethods();
		data.corpid = "wwea1a49XXXXXXXXXX";
		
		NutMap agent = new NutMap();
		String agentid = "100000X";
		String secret = "qAXEXCFZEXXXXX-HwcO-QsBAgtXX4O3-dmFdQacXXXX";
		Mapl.put(agent, "agentId", agentid);
		Mapl.put(agent, "secret", secret);
		
		data.agents.put("agent_"+agentid, agent);
		
		agent = new NutMap();
		agentid = "contacts";
		secret = "qAXEXCFZEXXXXX-HwcO-QsBAgtXX4O3-dmFdQacYYYY";
		data.agents.put("agent_"+agentid, agent);
		
		Json.toJsonFile(Files.createFileIfNoExists2("corp-test.json"), data);
	}
	
	public static void main(String[] args) {
		new CorpTest().test();
	}
}
