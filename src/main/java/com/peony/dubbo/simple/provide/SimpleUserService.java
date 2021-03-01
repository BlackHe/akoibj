package com.peony.dubbo.simple.provide;

import com.peony.dubbo.common.UserService;
import com.peony.dubbo.common.UserVO;

public class SimpleUserService implements UserService {
    @Override
    public UserVO loadUser(String userId) {
        return new UserVO(userId,"black");
    }
}
