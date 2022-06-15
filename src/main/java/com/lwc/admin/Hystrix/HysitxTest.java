package com.lwc.admin.Hystrix;


import com.lwc.admin.bean.Admin;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


@Service
public class HysitxTest implements IRemoteCallService {

    @Override
    public String test() {
        String b=1+"";
        Integer a=Integer.valueOf(b)/0;
        return b;
    }

    public static void main(String[] args) {
        Admin admin = new Admin();
    }
}
