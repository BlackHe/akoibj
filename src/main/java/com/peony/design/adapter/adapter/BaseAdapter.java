package com.peony.design.adapter.adapter;

import com.peony.design.adapter.controller.BaseController;

public interface BaseAdapter {

    boolean suports(BaseController handler);

    String hand(BaseController handler);
}
