package com.sunyard.controller;

import com.sunyard.dto.UserDTO;
import com.sunyard.service.ICloudHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Churry
 * @create 2017-10-23 19:49
 **/
@Slf4j
@RestController
public class HelloController implements ICloudHelloService {

    @Autowired
    Registration registration;
    @Autowired
    DiscoveryClient client;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public Object HelloWorld() {
        log.info("request hello");
        List<ServiceInstance> list = client.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            ServiceInstance serviceInstance = list.get(0);
            log.info("provider service, host = " + serviceInstance.getHost() + ", port = " + serviceInstance.getPort() + ", service_id = " + serviceInstance.getServiceId());
            return list.get(0);
        }
        return "hello spring!";
    }

    @Override
    public UserDTO HelloMyself(@RequestParam String name, @RequestParam Integer age) {
        log.info("Eriri: request hello-myself");
        return new UserDTO(name, age);
    }

}
