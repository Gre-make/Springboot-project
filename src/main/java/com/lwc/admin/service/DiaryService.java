package com.lwc.admin.service;


import com.lwc.admin.bean.Diary;
import com.lwc.admin.mapper.DiaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {

    @Autowired
    DiaryMapper diaryMapper;

    public List<Diary> getNote(){
        return diaryMapper.getNote();
    }
}
