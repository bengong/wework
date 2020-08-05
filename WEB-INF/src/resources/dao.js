var ioc = {
	// 读取数据库配置文件
    conf : {
        type : "org.nutz.ioc.impl.PropertiesProxy",
        fields : {
            paths : ["ds-uat.properties"]
        }
    },
	    
	dao : {
		    type : "org.nutz.dao.impl.NutDao",
		    args : [{refer:"dataSource"}]
	},
	
	dataSource : {
	    type : "com.alibaba.druid.pool.DruidDataSource",
	    events : {
	      depose : 'close'
	    },
	    fields : {
	       driverClassName  : {java :"$conf.get('driver')"},
	       url                        : {java :"$conf.get('url')"},
	       username             : {java :"$conf.get('username')"},
	       password             : {java :"$conf.get('password')"},
	        
	      maxActive : 20,
	      validationQuery : "SELECT 'x'",
	      testWhileIdle : true,
	      testOnBorrow : false,
	      testOnReturn : false,
	      maxWait : 35000,
	      timeBetweenEvictionRunsMillis: 18000,
	      minEvictableIdleTimeMillis: 35000
	    }
	  }
}