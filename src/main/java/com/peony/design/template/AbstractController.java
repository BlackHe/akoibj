package com.peony.design.template;

public abstract class AbstractController implements BaseController {


    @Override
    public Object doDispatcher(Object obj) {
        long start = System.currentTimeMillis();
        System.out.printf("请求进入时间:%s\n", start);
        processBefore();
        process(obj);
        processAfter();
        System.out.printf("请求处理完成,耗时:%s毫秒", System.currentTimeMillis() - start);
        return null;
    }

    public abstract Object process(Object obj);

    public abstract void processBefore();

    public abstract void processAfter();
}
