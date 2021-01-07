一、MapperFactoryBean
mybatis-spring中，每一个DAO接口在BeanDefinition中，它的类型都是MapperFactoryBean，
这样在实例化的bean的时候，spring不是直接去实例化我们的DAO接口，而是调用MapperFactoryBean的
getObject()方法，获取实例。这也是一个很典型的FactoryBean的应用

二、事物
当事物类没有接口时，spring会默认使用cglib代理
事物方法调用时，实际上就是在调用CglibAopProxy.DynamicAdvisedInterceptor.intercept
业务对象会被代理为切面对象，切面对象中包装了源业务对象信息，以及事物切面对象；
通过拦截器链+递归的思想，处理aop == > ReflectiveMethodInvocation.proceed
org.springframework.transaction.interceptor.TransactionInterceptor.invoke  事物拦截器，如果有事物，则会被这个方法拦截



【SqlSession频繁创建问题】
一、问题
环境：mybatis+spring环境下
问题：在debug日志下发现，同一个DAO多次执行同一个查询，每一次查询都会频繁的创建SqlSession。
当时大家都认为这是有问题的，因此，着手排查，避免留下隐患。最主要是怕配置或使用方式有问题。

二、排查结果
排查了源码，在mybatis-spring环境下，创建DAO接口的代理对象时，实际的代理类型是MapperFactory。
而MapperFactory有个属性SqlSessionFactory。所以spring实例化它的时候，会填充SqlSessionFactory这个属性，在填充的时候，又有个属性【sqlSessionTemplate】需要填充，spring直接【new SqlSessionTemplate(sqlSessionFactory)】的方式填充它，过程中又会创建一个代理对象【SqlSessionInterceptor】。
最终，在执行DAO接口方法的时候，实际就会被【SqlSessionInterceptor】拦截，然后创建新的SqlSession，这个SqlSession是局部变量，栈封闭的，mybatis-spring也是通过这种方式，保证了DAO接口方法的线程安全。但是在开启事物，执行事物方法的时候，只会有一个SqlSession;
因此，排除了不是配置或使用方式的问题，设计如此；

最终，我们在调用DAO接口方法的时候，这个DAO本身在IOC中是单例的，但是每一次查询，底层还是会创建一个新的SqlSession;