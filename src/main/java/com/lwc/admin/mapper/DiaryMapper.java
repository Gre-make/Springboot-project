package com.lwc.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwc.admin.bean.Diary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryMapper{
    List<Diary> getNote();
}
