<%@ page pageEncoding="utf-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href =${basic} />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<link rel="stylesheet" href="adminlte/css/adminlte.min.css">
<link href="adminlte/css/google.css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.3/style/weui.min.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.1/css/jquery-weui.min.css">
</head>
<body class="hold-transition login-page">
	<div class="login-box">
	  <div class="card">
	    <div id="wx_reg" class="card-body login-card-body">
	    </div>
	  </div>
	</div>
	
<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/jquery-weui.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/swiper.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/city-picker.min.js"></script>
<script src="http://rescdn.qqmail.com/node/ww/wwopenmng/js/sso/wwLogin-1.0.0.js"></script>
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="adminlte/js/adminlte.min.js"></script>

<script>
	window.WwLogin({
	   "id" : "wx_reg",  
	   "appid" : "${appid}",// 企业微信的CorpID，在企业微信管理端查看
	   "agentid" : "${agentid}",// 授权方的网页应用ID，在具体的网页应用中查看
	   "redirect_uri" : "${redirect_uri}",// 重定向地址，需要进行UrlEncode
	   "state" : "${state}",// 用于保持请求和回调的状态，授权请求后原样带回给企业。该参数可用于防止csrf攻击（跨站请求伪造攻击），建议企业带上该参数，可设置为简单的随机数加session进行校验
	   "href" :  "${href}",// 自定义样式链接，企业可根据实际需求覆盖默认样式。详见文档底部FAQ
	});
</script>
</body>
</html>