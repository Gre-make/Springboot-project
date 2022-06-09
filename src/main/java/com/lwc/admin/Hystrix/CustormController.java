package com.lwc.admin.Hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custorm")
public class CustormController {

    @Autowired
    HysitxTest hysitxTest;

    @RequestMapping("/getTest")
    @ResponseBody
    public String Test() throws InterruptedException {
        Thread.sleep(7000);
        String test = hysitxTest.test();
        return test;
    }

}
