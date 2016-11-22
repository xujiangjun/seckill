<h2>seckill</h2>
+ [Java高并发秒杀API](http://www.imooc.com/learn/587)
+ 使用Maven构建项目
 + 1.需要修改web.xml中的Servlet版本为3.1
 + 2.需要将pom.xml中的Junit的版本改为4.12
+ 各层职责
 + 1.Dao层工作职责：接口设计 + SQL编写  (代码和SQL的分离，方便代码Review)
+ 定时任务
 + [Spring+Quartz实现定时任务的配置方法](http://www.oschina.net/question/8676_9032)
 + [去掉quartz中的定时检查版本更新](http://blog.csdn.net/shizhuxiong/article/details/8973412)
+ 拦截器
 + 方法一：通过实现MethodInterceptor接口
 + 方法二：通过继承HandlerInterceptorAdapter抽象类
+ AOP切面
 + 1.需要aspectjweaver.jar支持
 + 2.[AspectJ表达式语言](http://blog.csdn.net/yakoo5/article/details/17001381)
+ AutoConfig
 + [AutoConfig工具使用指南](http://openwebx.org/docs/autoconfig.html#d0e17446)
 + AutoConfig工作原理：
 <pre>
 说明：模板文件中的placeholder是从antx.properties文件中读取的。
 1.当antx.properties文件不存在时，会从auto-config.xml文件中读取属性配置，并生成antx.properties。
 2.当antx.properties文件存在时
 1）若在auto-config.xml文件中新增antx.properties中不存在的属性时，打包会提示是否更新antx.properties配置（但是只会更新新增的属性，若同时已存在字段有修改，不会被自动修改）
 2）若仅在auto-config.xml文件中修改字段属性，则打包时不会提示是否更新文件。
 </pre>

+ 问题
 + 1.JSON默认类库在转换枚举类会有问题
 + 2.DispatcherServlet对应的配置文件必须放在WEB-INF/路径下，否则会报错
 + 3.ImmutableSet.copyOf(Collection c)是一个防御性拷贝，c的变化不会影响到Immutable，可以查看示例GuavaTest的ImmutableSetTest()方法