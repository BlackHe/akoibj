package com.peony.design.adapter.state.state;

import com.peony.design.adapter.state.TCPConnection;

public interface TCPState {
    String operation(TCPConnection connection);
}
