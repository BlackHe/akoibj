package com.peony.design.adapter.controller;

public class RedisController implements BaseController {
    @Override
    public String doQuery() {
        return "redis query";
    }
}
