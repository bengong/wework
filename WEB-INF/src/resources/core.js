var ioc = {
		// 公司
		corp : {
	        type : 'wework.domain.Corp', // 类型
	        singleton : true, // 是否为单例
	        fields : {
	        	   corpid: 'wwea1a491e1639ecd6',
	        	   agents: {
	        		   contacts: {refer :"agent_contacts"} ,
	        		   agent_1000002: {refer :"agent_1000002"},
	        	   }
	        }
	    },
	    // 通讯录
	    agent_contacts : {
	    	 type : 'wework.domain.Agent', // 类型
		     singleton : true, // 是否为单例
		     fields : {
    	         agentId: 'contacts',
    	         secret: 'dfGh-do1kJ_uUS168NBG4dsXyOkYPeHJpqUIVBG52ys',
	        }
	    },
	    // 其他自定义应用。
	    agent_1000002 : {
	    	type : 'wework.domain.Agent', // 类型
		     singleton : true, // 是否为单例
		     fields : {
   	         agentId: '1000002',
   	         secret: 'qAXEXCFZEYF7i8-HwcO-QsBAgtko4O3-dmFdQacCaUA',
   	      },
	    }
}