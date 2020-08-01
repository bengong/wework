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

## 参考资料

 - Nutz (https://nutzam.com/core/nutz_preface.html)
 - JQuery weui (https://jqweui.cn)