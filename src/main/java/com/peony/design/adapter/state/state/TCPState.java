package com.peony.design.adapter.state.state;

import com.peony.design.adapter.state.TCPConnection;

/**
 * 状态对象通常是singleton
 */
public interface TCPState {
    String operation(TCPConnection connection);

    TCPState nextState();
}
