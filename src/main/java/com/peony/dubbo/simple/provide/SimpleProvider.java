package com.peony.dubbo.simple.provide;

import com.peony.dubbo.common.UserService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.io.IOException;

public class SimpleProvider {

    public static void main(String[] args) throws IOException {
        // application
        // register
        // protocal
        // service
        ApplicationConfig applicationConfig = new ApplicationConfig("simple-provider");
        applicationConfig.setQosEnable(false);

        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(-1);

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("redis://127.0.0.1:6379");


        ServiceConfig<Object> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(new SimpleUserService());

        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setProtocol(protocolConfig);

        serviceConfig.export();
        // 不管用xml,还是注解，底层都是解析为这种对象
        System.out.println("服务已导出");
        System.in.read();
    }

}
