package com.lwc.admin.Hystrix;


import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Component
public class Hysitx implements FallbackFactory<IRemoteCallService> {

    @Override
    public IRemoteCallService create(Throwable cause) {
        return new IRemoteCallService(){
            @Override
            public String test() {
                log.error("fall back");
                return "fall back";
            }
        };
    }
}
