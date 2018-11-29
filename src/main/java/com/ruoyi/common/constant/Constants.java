package com.ruoyi.common.constant;


import io.swagger.models.auth.In;

/**
 * 通用常量信息
 * 
 * @author ruoyi
 */
public class Constants
{
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 自动去除表前缀
     */
    public static String AUTO_REOMVE_PRE = "true";

    /**
     * 当前记录起始索引
     */
    public static String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static String IS_ASC = "isAsc";

    public static final String WXCODE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=STAT#wechat_redirect";
    public static final String WEBACCESSTOKEN = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    public static final String APPID = "wx21b9057159fbbe2c";
    public static final String SECRET = "bfbe76336bdd536af5b2e52db9e32566";
    public static final String USERMESSAGE = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";
    public static final String DEFAULT_HEAD_URL = "http://jingxishop.drivecarai.com/1534153063423089639.png";

    //12小时后过期
    public final static int EXPIRE = 3600 * 12;

    public static final String LOGIN_TOKEN_KEY = "birthday-Token";
    public static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";


    //   枚举常量开始---------------

    public static enum REMINDERTIME{
        THREEA(3,"提前3天",3,"三天后"),TWO(2,"提前2天",2,"两天后"),ONE(1,"提前1天",1,"一天后"),NOW(0,"当天",0,"今天");
        private Integer type;
        private String typeName;
        private Integer days;
        private String reminder;

        private REMINDERTIME(Integer type,String typeName,Integer days,String reminder){
            this.type = type;
            this.typeName = typeName;
            this.days = days;
            this.reminder = reminder;
         }

         //根据key获取枚举
        public static REMINDERTIME getEnumByKey(Integer key){
            if(null == key){
                return null;
            }
            for(REMINDERTIME temp:REMINDERTIME.values()){
                if(temp.getType() == key){
                    return temp;
                }
            }
            return null;
        }

        //获取所有的key
        public static Integer[] getAllKey(){
            Integer[] keyArr = new Integer[]{};
            for(int i = 0; i<REMINDERTIME.values().length; i++){
                keyArr[i] = REMINDERTIME.values()[i].getType();
            }
            return keyArr;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public Integer getDays() {
            return days;
        }

        public void setDays(Integer days) {
            this.days = days;
        }

        public String getReminder() {
            return reminder;
        }

        public void setReminder(String reminder) {
            this.reminder = reminder;
        }
    }

    public static enum ReminderType{
//0，不提醒，1，小程序提醒，2，邮箱提醒，3，手机号提醒，4，公众号提醒'
        NO(0,"不提醒"),WX(1,"小程序提醒"),EMAIL(2,"邮箱提醒"),PHONE(3,"手机号提醒"),WXPUBLIC(4,"公众号提醒");

        private Integer type;
        private String typeName;


        private ReminderType(Integer type,String typeName){
            this.type = type;
            this.typeName = typeName;
        }

        public static ReminderType getByKey(Integer type){
            //根据key获取枚举
            if(null == type){
                return null;
            }
            for(ReminderType temp:ReminderType.values()){
                if(temp.getType() == type){
                    return temp;
                }
            }
            return null;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }
    }


    //枚举常量结束

}
