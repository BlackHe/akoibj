package com.peony.design.adapter.state.state;

import com.peony.design.adapter.state.TCPConnection;

public class TCPEstablished implements TCPState {

    private TCPEstablished() {
    }


    @Override
    public String operation(TCPConnection connection) {
        this.changeConnectionState(connection, nextState());
        return null;
    }

    public void changeConnectionState(TCPConnection connection, TCPState tcpState) {
        connection.changeState(tcpState);
    }

    @Override
    public TCPState nextState() {
        return null;
    }
}
