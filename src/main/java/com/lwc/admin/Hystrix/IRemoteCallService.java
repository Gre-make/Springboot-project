package com.lwc.admin.Hystrix;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name = "IRemoteCallService" ,fallbackFactory = Hysitx.class)
public interface IRemoteCallService {

    @RequestMapping(value = "/custorm/getTest", method = RequestMethod.POST)
    String test();

}
