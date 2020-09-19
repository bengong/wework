<%@ page pageEncoding="utf-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<w:base/>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${title}</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="view/image/favicon.ico">
<link rel="apple-touch-icon-precomposed" href="apple-touch-icon-precomposed.png">
<link rel="icon" href="view/image/favicon.png">
<link rel="stylesheet" href="view/plugins/fontawesome-free/css/all.min.css">
<link rel="stylesheet" href="view/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="view/adminlte/css/adminlte.css">
<style>
	.pull-left {
	    float: left!important;
	}
	
	.pull-right {
	    float: right!important;
	}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
	<%@ include file="../widgets/header.jsp"%>
	<%@ include file="../widgets/sidebar.jsp"%>

  <!-- Content Wrapper. 包含页面内容 -->
  <div class="content-wrapper">
    <!-- 内容标题（页面标题） -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">仪表盘</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">主页</a></li>
              <li class="breadcrumb-item active">仪表盘 v1</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- 主体内容 -->
    <section class="content">
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span8">
			<div class="page-header">
				<h1>
					页标题范例 <small>此处编写页标题</small>
				</h1>
			</div>
			<form class="form-horizontal">
				<div class="control-group">
					 <label class="control-label" for="inputEmail">邮箱</label>
					<div class="controls">
						<input id="inputEmail" type="text" />
					</div>
				</div>
				<div class="control-group">
					 <label class="control-label" for="inputPassword">密码</label>
					<div class="controls">
						<input id="inputPassword" type="password" />
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						 <label class="checkbox"><input type="checkbox" /> Remember me</label> <button type="submit" class="btn">登陆</button>
					</div>
				</div>
			</form>
		</div>
		<div class="span4">
		</div>
	</div>
</div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

	<%@ include file="../widgets/footer.jsp"%>
</div>
<!-- ./wrapper -->

<script src="view/plugins/jquery/jquery.min.js"></script>
<script src="view/plugins/bootstrap/js/bootstrap.js"></script>
<script src="view/adminlte/js/scripts.js"></script>
<script src="view/adminlte/js/adminlte.js"></script>

</body>
</html>
