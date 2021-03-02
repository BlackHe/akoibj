package com.peony.dubbo.simple.consume;

import com.peony.dubbo.common.UserService;
import com.peony.dubbo.common.UserVO;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class SimpleConsumer {

    public static void main(String[] args) throws IOException {
        // 客户端 配置+引用
        ApplicationConfig applicationConfig = new ApplicationConfig("simple-consumer");
        applicationConfig.setQosEnable(false);


        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("redis://127.0.0.1:6379");

        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig<UserService>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(UserService.class);
        referenceConfig.setLoadbalance("roundrobin");
        // 点对点调用方式
//        referenceConfig.setUrl("dubbo://172.18.58.33:20880/com.peony.dubbo.common.UserService?anyhost=true&application=simple-provider&bind.ip=172.18.58.33&bind.port=20880&deprecated=false&dubbo=2.0.2&dynamic=true&generic=false&interface=com.peony.dubbo.common.UserService&methods=loadUser&pid=5168&register=true&release=2.7.3&side=provider&timestamp=1614579003112");
        UserService userService = referenceConfig.get();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            if (bufferedReader.readLine().equals("quit")){
                return;
            }
            System.out.println(userService.loadUser(new Random().nextInt(100) + ""));
        }

    }
}
