import org.nutz.http.Http;
import org.nutz.json.Json;

public class Test {

	public static void main(String[] args) {
		String url = "https://api.bootcdn.cn/names.json";
		
		Object result =  Http.get(url).getContent();
		System.out.println(result);
	}

}
