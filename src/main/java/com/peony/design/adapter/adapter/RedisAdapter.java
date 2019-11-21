package com.peony.design.adapter.adapter;

import com.peony.design.adapter.controller.BaseController;
import com.peony.design.adapter.controller.RedisController;

public class RedisAdapter implements BaseAdapter {
    @Override
    public boolean suports(BaseController handler) {
        return handler instanceof RedisController;
    }

    @Override
    public String hand(BaseController handler) {
        return handler.doQuery();
    }
}
