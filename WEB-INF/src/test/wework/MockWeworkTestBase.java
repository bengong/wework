package wework;

import org.junit.Before;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;

public abstract class MockWeworkTestBase {

	public static Ioc ioc;
	public WeWork weWork;
	@Before
	public void setUp() throws Exception {		
        ioc = new NutIoc(new ComboIocLoader("*org.nutz.ioc.loader.json.JsonLoader", "core-test.js", "*org.nutz.ioc.loader.annotation.AnnotationIocLoader", "wework"));
        weWork = ioc.get(WeWork.class);
        System.out.println(weWork.agentMethods.corpid());
	}
}
