package com.peony.design;

/**
 * 模板方法模式
 * 简易实现AOP的功能
 */
public class TemplateMethodStyleQuestion {


    public static void main(String[] args) {

        /**
         * 下单的时候，执行非业务方法，譬如日志，权限，性能及时，事务等
         */
        BaseCommand orderService = new OrderService();
        orderService.execute();
        System.out.println("\n\n---------------------------------------------------\n\n");
        BaseCommand payService = new PayService();
        payService.execute();
    }

}

class OrderService extends BaseCommand{

    @Override
    void doBusiness() {
        System.out.println("订单服务-处理业务逻辑【OrderService.doBusiness】");
    }
}

class PayService extends BaseCommand{

    @Override
    void doBusiness() {
        System.out.println("支付服务-处理业务逻辑【PayService.doBusiness】");
    }
}

abstract class BaseCommand{

    boolean execute(){

        // 处理日志
        System.out.println("处理日志【BaseCommand.execute】");

        // 处理安全
        System.out.println("处理安全【BaseCommand.execute】");

        // 开启事务
        System.out.println("开启事务【BaseCommand.execute】");

        // 性能监控
        System.out.println("性能监控[start time]【BaseCommand.execute】");

        // 执行业务方法
        doBusiness();

        // 性能监控
        System.out.println("性能监控[end time]【BaseCommand.execute】");

        // 提交/回滚事务
        System.out.println("提交/回滚事务【BaseCommand.execute】");

        return true;

    }

    abstract void doBusiness();
}
