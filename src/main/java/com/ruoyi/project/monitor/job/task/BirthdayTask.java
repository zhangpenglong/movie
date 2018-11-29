package com.ruoyi.project.monitor.job.task;

import com.ruoyi.api.util.BirthdayUtil;
import com.ruoyi.project.module.userBirthday.domain.UserBirthday;
import com.ruoyi.project.module.userBirthday.service.IUserBirthdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dongao on 2018/11/29.
 */
@Component("birthdayTask")
public class BirthdayTask {


    @Autowired
    private IUserBirthdayService userBirthdayService;

    /**
    *功能描述  定时任务，每天凌晨00:00:00计算所有用户的距离多少天过生日，以及多少岁
    *@Author  zhangpl
    *@Date 2018/11/29 11:16
    * @param  * @param
    * @return void
    */
    public void countBirthday(){
        List<UserBirthday> userBirthdays = userBirthdayService.listAll();
        if(null == userBirthdays || 0 == userBirthdays.size()){
            return;
        }
        //遍历
        for(UserBirthday birthday : userBirthdays){
            UserBirthday userBirthday = BirthdayUtil.updateBirthday(birthday);
            userBirthdayService.updateUserBirthday(userBirthday);
        }
    }
}
