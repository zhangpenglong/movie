package com.ruoyi.api.util;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.project.module.userBirthday.domain.UserBirthday;

/**
 * Created by dongao on 2018/11/29.
 */
public class ReminderUtil {


    public static void sendReminder(UserBirthday userBirthday){
        if(null == userBirthday || null == userBirthday.getReminderType() || null == userBirthday.getReminderTime()){
            return;
        }
        Integer reminderType = userBirthday.getReminderType();
        if(Constants.ReminderType.WX.getType() == reminderType){
            //小程序题型

        }else if(Constants.ReminderType.EMAIL.getType() == reminderType){
            //邮箱

        }else if(Constants.ReminderType.PHONE.getType() == reminderType){
            //手机号


        }else if(Constants.ReminderType.WXPUBLIC.getType() == reminderType){
            //公众号

        }

    }


}
