var ioc = {
		config : {
	        type : 'wework.Config', // 类型
	        singleton : true, // 是否为单例
	        fields : {
        	   "corpid": "wwea1a491e1639ecd6",
        	   "agents": {
        	      "1000002": {
        	         "agentid": "1000002",
        	         "secret": "qAXEXCFZEYF7i8-HwcO-QsBAgtko4O3-dmFdQacCaUA"
        	      },
        	      "contacts": {
        	         "agentid": "contacts",
        	         "secret": "dfGh-do1kJ_uUS168NBG4dsXyOkYPeHJpqUIVBG52ys"
        	      }
        	   }
    		}
		},
		postman : {
	        type : 'wework.util.NutPostman', // 类型
	        singleton : true, // 是否为单例
		}
}