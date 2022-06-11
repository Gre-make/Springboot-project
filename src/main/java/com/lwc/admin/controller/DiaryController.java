package com.lwc.admin.controller;


import com.lwc.admin.bean.Diary;
import com.lwc.admin.bean.vo.PageEntity;
import com.lwc.admin.service.AdminService;
import com.lwc.admin.service.DiaryService;
import com.lwc.admin.service.FunctionSelectService;
import com.lwc.admin.util.JsonFormat;
import com.lwc.admin.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping("/diary")
public class DiaryController {

     @Autowired
     private  DiaryService diaryService;

    /**
     * 获取记录笔记
     * @return
     */
    @ResponseBody
    @RequestMapping("/getNote")
    public List<Diary> getNote() {
        return diaryService.getNote();
    }
}
