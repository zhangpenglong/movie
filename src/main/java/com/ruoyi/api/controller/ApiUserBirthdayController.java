package com.ruoyi.api.controller;

import com.ruoyi.api.util.result.ResultConstans;
import com.ruoyi.api.util.result.ResultUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.oss.OSSFactory;
import com.ruoyi.project.module.userBirthday.domain.UserBirthday;
import com.ruoyi.project.module.userBirthday.service.IUserBirthdayService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dongao on 2018/11/27.
 */
@Controller
@RequestMapping("/api/userBirthday")
public class ApiUserBirthdayController  extends BaseController {


    @Autowired
    private IUserBirthdayService userBirthdayService;


    /**
     * 查询用户生日列表
     */
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserBirthday userBirthday)
    {
        startPage();
        userBirthday.setCreateUser(getApiUserId());
        userBirthday.setIsValid(1);
        List<UserBirthday> list = userBirthdayService.selectUserBirthdayList(userBirthday);
        return getDataTable(list);
    }


    /**
     * 新增保存用户生日
     */
    @PostMapping("/insert")
    @ResponseBody
    public Object addSave(){
        UserBirthday userBirthday = getJsonRequest(UserBirthday.class);
        userBirthday.setIsValid(1);
        userBirthday.setCreateUser(getApiUserId());
        userBirthday.setCreateDate(new Date());
        return toAjax(userBirthdayService.insertUserBirthday(userBirthday));
    }


    /**
     * 修改保存用户生日
     */
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult editSave(UserBirthday userBirthday){
        return toAjax(userBirthdayService.updateUserBirthday(userBirthday));
    }


    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(@RequestParam("file") MultipartFile file) throws Exception {
        //上传文件
        String url = OSSFactory.build().upload(file);
        Map map = new HashMap();
        map.put("url",url.trim());
       return ResultUtils.result(ResultConstans.SUCCESS,map);
    }



}
