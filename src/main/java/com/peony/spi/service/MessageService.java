package com.peony.spi.service;


import com.peony.spi.callback.AfterMessageSendCallback;

public interface MessageService {

    boolean sendMessage(AfterMessageSendCallback callback);

}
