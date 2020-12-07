# 线程池小计

## 线程复用原理
* 执行任务的线程在while循环中一直阻塞等待，一旦任务队列中有新的任务，就开始执行，以此往复，这就实现了线程复用

## 大于核心线程数的销毁
* 线程在while循环中阻塞等待，获取任务是有超时时间的，如果带有超时时间，则BlockQuere.pull(timeout),否则BlockQueue.take().
一旦BlockQuere.pull返回null,就退出了while循环， 进入了线程的销毁流程