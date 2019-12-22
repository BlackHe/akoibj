package com.peony.design.adapter.state.state;

import com.peony.design.adapter.state.TCPConnection;

public class TCPEstablished implements TCPState {
    @Override
    public String operation(TCPConnection connection) {
        connection.changeState(new TCPClosed());
        return null;
    }
}
