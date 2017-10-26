package com.sunyard.service;

import com.sunyard.dto.UserDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Churry
 * @create 2017-10-26 10:51
 **/
@FeignClient("ERIRI")
public interface ICloudHelloService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    Object HelloWorld();

    @RequestMapping(value = "/hello-myself", method = RequestMethod.GET)
    UserDTO HelloMyself(@RequestParam("name") String name, @RequestParam("age") Integer age);

}
