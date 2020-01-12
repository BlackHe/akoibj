package com.peony.spi;

import com.peony.spi.client.OrderService;
import com.peony.spi.service.MessageService;
import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.TimeUnit;

public class OrderServiceTest {

    private MessageService messageService;

    @Test
    public void orderTest() throws InterruptedException {

        final ServiceLoader<MessageService> messageServices = ServiceLoader.load(MessageService.class);
        final Iterator<MessageService> iterator = messageServices.iterator();
        while (iterator.hasNext()){
            final MessageService next = iterator.next();
            if (next !=null){
                messageService = next;
                break;
            }
        }
        final OrderService orderService = new OrderService(messageService);
        orderService.afterOrderSave();

        TimeUnit.SECONDS.sleep(20);

    }
}
