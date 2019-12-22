package com.peony.design.adapter.state.state;

import com.peony.design.adapter.state.TCPConnection;

public class TCPClosed implements TCPState {
    @Override
    public String operation(TCPConnection connection) {
        connection.connect();
        return null;
    }
}
