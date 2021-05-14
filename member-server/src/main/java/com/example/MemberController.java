package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MemberController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private FeignClient feignClient;

    // 使用ribbon负载均衡，需要显示开启
    @RequestMapping("memTest")
    public String memTest(){
        String str = restTemplate.getForObject("http://order-server/orderTest",String.class);
        return str;
    }

    // 使用feign，不需要显示开启负载均衡
    @RequestMapping("memFeignTest")
    public String memFeignTest(){
        String str = feignClient.orderTest();
        return str;
    }

    @HystrixCommand(fallbackMethod = "testError")
    @RequestMapping("memHystrixTest")
    public String memHystrixTest(){
        String str = feignClient.orderTest();
        System.out.println("#######--------《》");     // 调用失败应该不会运行
        return str;
    }

    // fallback 方法
    public String testError(){
        //远程调用失败，调用此方法
        return "test error";
    }
}