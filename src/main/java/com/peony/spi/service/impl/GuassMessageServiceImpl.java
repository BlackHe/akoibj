package com.peony.spi.service.impl;

import com.peony.spi.callback.AfterMessageSendCallback;
import com.peony.spi.service.MessageService;

public class GuassMessageServiceImpl implements MessageService {
    @Override
    public boolean sendMessage(AfterMessageSendCallback callback) {
        System.out.println("before send by Guass Message...");
        callback.execute();
        System.out.println("after send by Guass Message...");
        return true;
    }
}
