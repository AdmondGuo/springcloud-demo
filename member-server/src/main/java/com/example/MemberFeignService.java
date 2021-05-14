package com.example;

import org.springframework.stereotype.Component;

@Component
public class MemberFeignService implements FeignClient {

    @Override
    public String orderTest() {
        return "服务异常";
    }
}

