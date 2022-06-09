package com.lwc.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwc.admin.bean.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper  extends BaseMapper<Admin> {

    Integer getAdmin(String username,String password);

    List<Admin> allUser(Map param);

    Integer allUserCount(Map param);

//   Integer insertUserInfo(Admin admin);
    void updateInfo(String password,String username);

}
