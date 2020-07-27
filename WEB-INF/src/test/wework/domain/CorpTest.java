package wework.domain;

import org.nutz.json.Json;
import org.nutz.lang.Files;

public class CorpTest {

	public void test() {
		Corp data  = new Corp();
		data.corpid = "wwea1a49XXXXXXXXXX";
		
		Agent agent = new Agent();
		agent.agentId = "100000X";
		agent.secret = "qAXEXCFZEXXXXX-HwcO-QsBAgtXX4O3-dmFdQacXXXX";
		data.agents.put(agent.agentId, agent);
		
		agent = new Agent();
		agent.agentId = "contacts";
		agent.secret = "qAXEXCFZEXXXXX-HwcO-QsBAgtXX4O3-dmFdQacYYYY";
		data.agents.put(agent.agentId, agent);
		
		Json.toJsonFile(Files.createFileIfNoExists2("corp-test.json"), data);
	}
	
	public static void main(String[] args) {
		new CorpTest().test();
	}
}
