var ioc = {
		// 公司
		corp : {
	        type : 'wework.domain.Corp', // 类型
	        singleton : true, // 是否为单例
	        fields : {
	        	   corpid: 'wwea1a491e1639ecd6',
	        	   applications: {
	        		   contacts: {refer :"contacts"} ,
					  agentId_100000X: {refer :"contacts"},
	        	   }
	        }
	    },
	    // 通讯录
	    contacts : {
	    	 type : 'wework.domain.Application', // 类型
		     singleton : true, // 是否为单例
		     fields : {
    	         agentId: 'contacts',
    	         secret: 'dfGh-do1kJ_uUS168NBG4dsXyOkYPeHJpqUIVBG52ys',
	        }
	    },
	    // 其他自定义应用。
	    app_1000002 : {
	    	type : 'wework.domain.Application', // 类型
		     singleton : true, // 是否为单例
		     fields : {
   	         agentId: '1000002',
   	         secret: 'qAXEXCFZEYF7i8-HwcO-QsBAgtko4O3-dmFdQacCaUA',
   	      },
	    }
}