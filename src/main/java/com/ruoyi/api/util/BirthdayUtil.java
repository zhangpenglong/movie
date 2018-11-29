package com.ruoyi.api.util;

import com.ruoyi.project.module.userBirthday.domain.UserBirthday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by dongao on 2018/11/29.
 */
public class BirthdayUtil {


    public static void main(String[] a){
        UserBirthday birthday = new UserBirthday();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar.set(1990,4,5);
        calendar1.set(1990,4,28);
        birthday.setLunarBirthday(calendar.getTime());
        birthday.setGregorianBirthday(calendar1.getTime());
        birthday.setCalendar(1);

        UserBirthday userBirthday = updateBirthday(birthday);
        System.out.println("======================"+userBirthday.getDays());
        System.out.println("====================="+userBirthday.getBirthAge());
    }



    public static UserBirthday  updateBirthday(UserBirthday birthday){
        UserBirthday userBirthday = birthday;
        if(null == userBirthday){
            return userBirthday;
        }
        if(null == userBirthday.getCalendar() || null == userBirthday.getLunarBirthday() ||
                null == userBirthday.getGregorianBirthday()){
            return userBirthday;
        }
        Date now = new Date();
        //公历
        if( 0 == userBirthday.getCalendar()){
            //如果是公历直接计算
            Integer indexPerBasicInfo = getIndexPerBasicInfo(userBirthday.getGregorianBirthday());
            userBirthday.setDays(indexPerBasicInfo);
            int age = getAge(userBirthday.getGregorianBirthday());
            userBirthday.setBirthAge(age);
        }else{
            //农历,先将农历转换成今年的公历，再计算
            //农历生日
            Date lunarBirthday = userBirthday.getLunarBirthday();
            Calendar calendar = Calendar.getInstance();
            Calendar nowCalen = Calendar.getInstance();
            nowCalen.setTime(now);
            calendar.setTime(lunarBirthday);
            calendar.set(Calendar.YEAR,nowCalen.get(Calendar.YEAR));
            //19900505
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            String format1 = format.format(calendar.getTime());
            boolean flag = null == userBirthday.getLeapMonth() || 0 == userBirthday.getLeapMonth() ? false : true;
            Date parse = lunarToSolar(format1,flag);
            if(now.after(parse)){
                //说明今年过了，计算明年的，再次转换成公历，
                calendar.set(Calendar.YEAR,nowCalen.get(Calendar.YEAR)+1);
                format1 = format.format(calendar.getTime());
                parse = lunarToSolar(format1,flag);
            }
            Integer indexPerBasicInfo = getIndexPerBasicInfo(parse);
            userBirthday.setDays(indexPerBasicInfo);
            Calendar ageCalen = Calendar.getInstance();
            Calendar lunarBirthdayCalen = Calendar.getInstance();
            lunarBirthdayCalen.setTime(lunarBirthday);
            ageCalen.set(Calendar.YEAR,lunarBirthdayCalen.get(Calendar.YEAR));
            int age = getAge(ageCalen.getTime());
            userBirthday.setBirthAge(age);
        }

        return userBirthday;
    }


    public static Date lunarToSolar(String format1,boolean flag){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String gre = "";
        Date parse = new Date();
        try {
            gre = CalendarUtil.lunarToSolar(format1, flag);
            parse = format.parse(gre);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                gre = CalendarUtil.lunarToSolar(format1, false);
                parse = format.parse(gre);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return parse;
    }

    /*
    *功能描述  根据生日获取还有多少天生日
    *@Author  zhangpl
    *@Date 2018/11/29 11:01
    * @param  * @param birthDay
    * @return void
    */
    public static Integer getIndexPerBasicInfo(Date birthDay) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");

            Map<String, Object> perBaiscMap = new HashMap<String, Object>();
            String birthdayStr =myFormatter.format(birthDay);

            Calendar cToday = Calendar.getInstance(); // 存今天
            Calendar cBirth = Calendar.getInstance(); // 存生日
            try {
                cBirth.setTime(myFormatter.parse(birthdayStr)); // 设置生日
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cBirth.set(Calendar.YEAR, cToday.get(Calendar.YEAR)); // 修改为本年
            int days;
            if (cBirth.get(Calendar.DAY_OF_YEAR) < cToday.get(Calendar.DAY_OF_YEAR)) {
                // 生日已经过了,要算明年的了
                days = cToday.getActualMaximum(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
                days += cBirth.get(Calendar.DAY_OF_YEAR);
            } else {
                // 生日还没过
                days = cBirth.get(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
            }

            perBaiscMap.put("birthday", birthdayStr);
            perBaiscMap.put("time", birthdayStr.substring(5, 7).concat(".").concat(birthdayStr.substring(8, 10)));
            System.out.println("==========="+birthdayStr);
            System.out.println("==========="+birthdayStr.substring(5, 7).concat(".").concat(birthdayStr.substring(8, 10)));
            System.out.println("==========="+days);
            return days;

    }


    /**
    *功能描述  根据出生日期算出今天多少岁
    *@Author  zhangpl
    *@Date 2018/11/29 11:01
    * @param  * @param dateOfBirth
    * @return int
    */
    public static int getAge(Date dateOfBirth) {
        int age = 0;
        Calendar born = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        if (dateOfBirth != null) {
          now.setTime(new Date());
          born.setTime(dateOfBirth);
          if (born.after(now)) {
               throw new IllegalArgumentException("年龄不能超过当前日期");
          }
          age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
          int nowDayOfYear = now.get(Calendar.DAY_OF_YEAR);
          int bornDayOfYear = born.get(Calendar.DAY_OF_YEAR);
          System.out.println("nowDayOfYear:" + nowDayOfYear + " bornDayOfYear:" + bornDayOfYear);
          if (nowDayOfYear < bornDayOfYear) {
               age -= 1;
          }
       }
       return age;
  }
}
