<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>


  <!-- 主侧边栏容器 -->
  <aside class="main-sidebar sidebar-light-primary elevation-4">
    <!-- 品牌 Logo -->
    <a href="" class="brand-link">
      <img src="view/image/favicon.png" alt="Logo" class="brand-image img-circle elevation-3" style="opacity: .8"><span class="brand-text font-weight-light">企業微信</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- 侧边栏用户面板（可选） -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
      <!-- 已登錄 -->
      <shiro:authenticated>
        <div class="image"><img src="view/image/user/<shiro:principal/>.jpg" class="img-circle elevation-2" alt="用户头像" onerror="this.src='view/image/user/default.jpg;this.οnerrοr=null'"></div>
        <div class="info">
          <a href="#" class="d-block">
          	<a href="user/profile/<shiro:principal/>">
          		<shiro:principal/><small>(<i class="fa fa-circle text-success"></i>在线)</small>
          	</a>
          </a>
        </div>
        </shiro:authenticated>
        <!-- 未登錄 -->
        <shiro:notAuthenticated>
        <div class="image"><img src="view/adminlte/img/user2-160x160.jpg" class="img-circle elevation-2" alt="用户头像"></div>
        <div class="info">
          <a href="#" class="d-block">
          	<a href="login"><i class="fa fa-circle text-error"></i> 登錄</a>
          </a>
        </div>
        </shiro:notAuthenticated>
      </div>

      <!-- 侧边栏菜单 -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <li class="nav-item has-treeview menu-open">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
				仪表盘
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="./index.html" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                  <p>仪表盘 v1</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="./index2.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>仪表盘 v2</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="./index3.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>仪表盘 v3</p>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>