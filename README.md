# 企业微信开放接口实现

基于Nutz实现。

## Nutz

Nutz， 它是一组轻便小型的框架的集合， 各个部分可以被独立使用。 而 Nutz 的目标 就是
 - Dao -- 针对 JDBC 的薄封装，事务模板，无缓存
 - Ioc -- JSON 风格的配置文件，声明时切片支持
 - Mvc -- 注解风格的配置，内置多文件上传功能
 - Json -- 解析和渲染
 - Castors -- Java 对象类型转换
 - Lang -- 更简洁的 Java 函数以及更丰富的反射支持
 - Aop -- 轻便快速的切面编程支持
 - Resource -- 资源扫描
 - 它所有的功能均不强制依赖第三方 jar 包

这就意味着：

 - 如果一个 Web 应用，你在 WEB-INF/lib 下只 需要放置一个 nutz.jar 就够了
当然你要使用连接池，数据库驱动, websocket等功能，还需要自行添置 jar 包。

### 支持的环境
 - JDK5+, 推荐JDK8
 - 任意SQL数据库,例如MySQL,Oracle,SqlServer等等
 - 任意支持servlet 2.5的web容器, 推荐Tomcat 8.5+/Jetty 9.2+

## jqweui

jQuery WeUI 是专为微信公众账号开发而设计的一个简洁而强大的UI库，包含全部WeUI官方的CSS组件，并且额外提供了大量的拓展组件，丰富的组件库可以极大减少前端开发时间。

jQuery WeUI 的最大特点是它只提供UI组件，并不会对项目所使用的框架和其他库有任何的限制，几乎可以在任何环境下使用。无论你的项目是基于jQuery，还是 React, Angular, Vue， 你都会发现 jQuery WeUI 能非常方便的和他们结合使用。既是你的项目是一个有很悠久历史的老项目，也几乎可以做到拿来即用。

jQuery WeUI 提供了总共30+ 个非常实用的组件：列表，表单，卡片，对话框，下拉刷新等。

jQuery WeUI 的定位正如 jQuery 的定位：做一把锋利易用的小刀，而不是做一个笨重的大炮。

 - 简单易用，无上手难度
 - 丰富强大的组件库，并且还在不断完善中
 - 轻量，无限制，可以结合任何主流JS框架使用，比如 `Vue, Angular, React` 等
 - 高性能的 CSS3 动画，低端手机上依然可以较流畅运行
 - 详尽完善的官方文档
 - 标准稳定的API，基本可以保证版本透明更新
 - 基于 MIT 协议发布，免费开源

## 参考资料

 - Nutz (https://nutzam.com/core/nutz_preface.html)
 - JQuery weui (https://jqweui.cn)