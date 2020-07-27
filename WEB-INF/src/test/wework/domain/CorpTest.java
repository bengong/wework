package wework.domain;

import org.nutz.json.Json;
import org.nutz.lang.Files;

public class CorpTest {

	public void test() {
		Corp data  = new Corp();
		data.corpid = "wwea1a49XXXXXXXXXX";
		
		Application application = new Application();
		application.agentId = "100000X";
		application.secret = "qAXEXCFZEXXXXX-HwcO-QsBAgtXX4O3-dmFdQacXXXX";
		data.applications.put(application.agentId, application);
		
		application = new Application();
		application.agentId = "contacts";
		application.secret = "qAXEXCFZEXXXXX-HwcO-QsBAgtXX4O3-dmFdQacYYYY";
		data.applications.put(application.agentId, application);
		
		Json.toJsonFile(Files.createFileIfNoExists2("corp-test.json"), data);
	}
	
	public static void main(String[] args) {
		new CorpTest().test();
	}
}
