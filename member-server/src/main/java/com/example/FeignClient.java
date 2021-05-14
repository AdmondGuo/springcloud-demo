package com.example;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@org.springframework.cloud.openfeign.FeignClient(value = "order-server", fallback = MemberFeignService.class)
public interface FeignClient {
    @RequestMapping("/orderTest")
    public String orderTest();
}
