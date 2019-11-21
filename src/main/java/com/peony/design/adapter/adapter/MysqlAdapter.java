package com.peony.design.adapter.adapter;

import com.peony.design.adapter.controller.BaseController;
import com.peony.design.adapter.controller.MysqlController;

public class MysqlAdapter implements BaseAdapter {
    @Override
    public boolean suports(BaseController handler) {
        return handler instanceof MysqlController;
    }

    @Override
    public String hand(BaseController handler) {
        return handler.doQuery();
    }
}
