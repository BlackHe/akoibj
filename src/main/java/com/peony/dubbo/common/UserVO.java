package com.peony.dubbo.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVO implements Serializable {

    private String userId;
    private String userName;

    public UserVO(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public UserVO() {
    }
}
