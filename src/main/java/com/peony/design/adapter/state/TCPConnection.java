package com.peony.design.adapter.state;

import com.peony.design.adapter.state.state.TCPState;

public class TCPConnection {

    private TCPState tcpState;

    public TCPConnection(TCPState tcpState) {
        this.tcpState = tcpState;
    }

    public String connect() {
        return tcpState.operation(this);
    }

    /**
     * 提供给state子类调用，以转换状态
     *
     * @param tcpState
     */
    public void changeState(TCPState tcpState) {
        this.tcpState = tcpState;
    }
}
