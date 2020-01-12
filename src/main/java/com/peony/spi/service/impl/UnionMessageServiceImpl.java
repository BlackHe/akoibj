package com.peony.spi.service.impl;

import com.peony.spi.callback.AfterMessageSendCallback;
import com.peony.spi.service.MessageService;

public class UnionMessageServiceImpl implements MessageService {
    @Override
    public boolean sendMessage(AfterMessageSendCallback callback) {
        System.out.println("before send message by china union...");
        callback.execute();
        System.out.println("after send message by china union...");
        return true;
    }
}
