package com.lwc.admin.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 扩展info信息
 */

@Component
public class AppInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        HashMap<String,Object> map=new HashMap<>();
        map.put("msg","success");
        map.put("code","200");
        map.put("extend","This is a demo Project");
        builder.withDetails(map);
    }
}
