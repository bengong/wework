import org.nutz.json.Json;
import org.nutz.lang.Files;
import org.nutz.lang.util.NutMap;

import wework.WeConfig;

public class WeConfigTest {

	public static void main(String[] args) {
		WeConfig weConfig = new WeConfig();
		weConfig.corpid = "wwea1a491e1639ecd6";
		NutMap data = new NutMap();
		String agentid = "contacts";
		data.put("agentid", agentid);
		data.put("secret", "dfGh-do1kJ_uUS168NBG4dsXyOkYPeHJpqUIVBG52ys");
		weConfig.agents.put("agent_"+agentid, data);
		
		data = new NutMap();
		agentid = "1000002";
		data.put("agentid", agentid);
		data.put("secret", "qAXEXCFZEYF7i8-HwcO-QsBAgtko4O3-dmFdQacCaUA");
		weConfig.agents.put("agent_"+agentid, data);
		
		Json.toJsonFile(Files.createFileIfNoExists2("config-test.js"), weConfig);
	}
}
