package wework.domain;

import java.util.HashMap;
import java.util.Map;

public class Corp {
	public String corpid;	
	/** 其他应用 */
	public Map<String, Agent> agents = new HashMap<String, Agent>();
}