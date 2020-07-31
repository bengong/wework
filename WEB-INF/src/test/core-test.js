var ioc = {
		config : {
	        type : 'wework.domain.Config', // 配置文件
	        singleton : true,
	        fields : {
        	   "corpid": "xxxx1a491e1639ecd6",
        	   "agents": {
        	      "1000002": {
        	         "agentid": "1000002",
        	         "secret": "xxxxXCFZEYF7i8-HwcO-QsBAgtko4O3-dmFdQacCaUA"
        	      },
        	      "contacts": {
        	         "agentid": "contacts",
        	         "secret": "xxxx-do1kJ_uUS168NBG4dsXyOkYPeHJpqUIVBG52ys"
        	      }
        	   }
    		}
		},
		postman : {
	        type : 'wework.util.MockPostman', // Http实现类
	        singleton : true,
		}
}