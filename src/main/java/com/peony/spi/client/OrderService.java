package com.peony.spi.client;

import com.peony.spi.service.MessageService;

public class OrderService {

    public OrderService(MessageService messageService) {
        if (messageService == null) {
            throw new RuntimeException("instantiation fail");
        }
        this.messageService = messageService;
    }

    private MessageService messageService;

    public void afterOrderSave() {
        messageService.sendMessage(this::sending);
    }

    private void sending() {
        System.out.println("after order save then to send message");
    }
}

