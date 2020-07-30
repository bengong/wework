package wework;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class MethodsTest {

    public static class agentMethods extends MockWeworkTestBase {
        @Test
        public void get() throws Exception {
        	String corpid = this.weWork.agentMethods.corpid();
        	System.out.println(corpid);
        }
    }
}
