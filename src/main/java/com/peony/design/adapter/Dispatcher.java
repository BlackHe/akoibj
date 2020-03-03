package com.peony.design.adapter;

import com.peony.design.adapter.adapter.BaseAdapter;
import com.peony.design.adapter.adapter.MysqlAdapter;
import com.peony.design.adapter.adapter.RedisAdapter;
import com.peony.design.adapter.controller.BaseController;
import com.peony.design.adapter.controller.MysqlController;
import com.peony.design.adapter.controller.RedisController;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private static final List<BaseAdapter> allAdapters = new ArrayList<BaseAdapter>();

    public static void doDispatcher() {
        BaseController handler = new RedisController();
        BaseAdapter adapter = getAdapter(handler);
        String result = adapter.hand(handler);
        System.out.println(result);


    }

    public static void main(String[] args) {
        doDispatcher();
    }

    static {
        allAdapters.add(new MysqlAdapter());
        allAdapters.add(new RedisAdapter());
    }

    public static BaseAdapter getAdapter(BaseController handler) {
        for (BaseAdapter adapter : allAdapters) {
            if (adapter.suports(handler)) {
                return adapter;
            }
        }
        return null;
    }
}
