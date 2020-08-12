<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>


  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="./" class="nav-link">主页</a>
      </li>
    </ul>

    <!-- 搜索表单 -->
    <form class="form-inline ml-3">
      <div class="input-group input-group-sm">
        <input class="form-control form-control-navbar" type="search" placeholder="搜索" aria-label="Search">
        <div class="input-group-append">
          <button class="btn btn-navbar" type="submit">
            <i class="fas fa-search"></i>
          </button>
        </div>
      </div>
    </form>

    <!-- 右侧导航栏链接 -->
    <ul class="navbar-nav ml-auto">
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-comments"></i><span class="badge badge-danger navbar-badge">3</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">

          <c:forEach items="${messages}" var="message">
          <a href="#" class="dropdown-item">
            <!-- 消息开始 -->
            <div class="media">
              <img src="view/image/dummy/${message.from_userid}.jpg" alt="用户头像" class="img-size-50 img-circle mr-3">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  ${message.from_fullname}
                  <span class="float-right text-sm text-${message.message_type}"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">${message.messge_content}</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i>${message.send_time} 前 </p>
              </div>
            </div>
            <!-- 消息结束 -->
          </a>
          <div class="dropdown-divider"></div>
          </c:forEach>
          
          
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">查看所有消息</a>
        </div>
      </li>
      <!-- 通知下拉菜单 -->
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-bell"></i>
          <span class="badge badge-warning navbar-badge">${noticestat.total_count}</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <span class="dropdown-item dropdown-header">${noticestat.total_count} 条通知</span>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-envelope mr-2"></i> ${noticestat.email_count} 条新消息
            <span class="float-right text-muted text-sm">3 分钟前</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-users mr-2"></i> ${noticestat.friends_count} 个好友请求
            <span class="float-right text-muted text-sm">12 小时前</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-file mr-2"></i> ${noticestat.report_count} 个新报告
            <span class="float-right text-muted text-sm">2 天前</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">查看所有通知</a>
        </div>
      </li>

    </ul>

	<shiro:authenticated>
	<div class="navbar-custom-menu">
		<ul class="nav navbar-nav">
				<li class="dropdown user user-menu open"><a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fas fa-th-large"></i>
				</a>
					<ul class="dropdown-menu">
						<li class="user-header"><img src="view/image/user/<shiro:principal/>.jpg" class="img-circle" alt="用户头像" onerror="this.src='view/image/user/default.jpg;this.οnerrοr=null'">
							<p>
								<shiro:principal type="wework.domain.User" property="fullname"/>
								<small><shiro:principal type="wework.domain.User" property="description"/></small>
							</p></li>

						<li class="user-footer">
								<div class="pull-left">
									<a href="user/edit/bengong" class="btn btn-default btn-flat">设置</a>
								</div>
							
							<div class="pull-right">
								<a href="./logout" class="btn btn-default btn-flat">注销</a>
							</div></li>
					</ul></li>
		</ul>
	</div>
	</shiro:authenticated>
  </nav>
  <!-- /.navbar -->