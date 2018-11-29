package com.ruoyi.project.monitor.job.task;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.project.module.userBirthday.domain.UserBirthday;
import com.ruoyi.project.module.userBirthday.service.IUserBirthdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 此定时任务是每天八点题型用户好友的生日
 * Created by dongao on 2018/11/29.
 */
@Component("birthdayTask")
public class ReminderTask {
    @Autowired
    private IUserBirthdayService userBirthdayService;


    //提醒用户生日
    public void reminderUser(){

        List<UserBirthday> userBirthdays = userBirthdayService.listReminder(Constants.REMINDERTIME.getAllKey());
        if(null == userBirthdays || 0 == userBirthdays.size()){
            return;
        }

        for(UserBirthday userBirthday : userBirthdays){
            //题型时间
            String reminderTime = userBirthday.getReminderTime();
            String[] split = reminderTime.split(",");
            for(String str : split){
                if(Constants.REMINDERTIME.getEnumByKey(Integer.valueOf(str)).getDays() == userBirthday.getDays()){

                }
            }
        }

    }
}
