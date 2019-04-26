## annotation develop

* 主配置类
    @Configuration


* 给容器注册自定义组件
    @Bean,@Import,@ImportSelector,FactoryBean
    默认都是单实例，
    @scope 控制作用域
        prototype 原型模式，每次获取实例的时候都会创建一个对象，spring不会管理这种bean的生命周期
        singleton 单例模式，应用从启动到关闭，只有产生一个实例，可以是在IOC容器启动的时候实例化，也可以在第一次获取实例的时候实例化，ioc容器管理这些bean的全生命周期
        request    web
        session     web
    @Conditional 满足条件的bean才注册到IOC容器
        
* 自动扫描组件,自定义扫描规则
    @ComponentScan
    @ComponentScans
    
* 组件的生命周期管理
    初始化之前
    初始化
    初始化之后

* 

