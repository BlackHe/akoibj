package com.peony.dubbo.simple.consume;

import com.peony.dubbo.common.UserService;
import com.peony.dubbo.common.UserVO;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;

public class SimpleConsumer {

    public static void main(String[] args) {
        // 客户端 配置+引用
        ApplicationConfig applicationConfig = new ApplicationConfig("simple-consumer");

        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig<UserService>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setInterface(UserService.class);
        referenceConfig.setUrl("dubbo://172.18.58.33:20880/com.peony.dubbo.common.UserService?anyhost=true&application=simple-provider&bind.ip=172.18.58.33&bind.port=20880&deprecated=false&dubbo=2.0.2&dynamic=true&generic=false&interface=com.peony.dubbo.common.UserService&methods=loadUser&pid=5168&register=true&release=2.7.3&side=provider&timestamp=1614579003112");
        UserService userService = referenceConfig.get();
        UserVO userVO = userService.loadUser("123456");
        System.out.println(userVO);
    }
}
