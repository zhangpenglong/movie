package com.ruoyi.api.util.result;

/**
 * Created by zhangpl on 2018/8/1.
 * 课件系统统一返回结果类。
 */
public class ResultUtils {

    /**
     * 状态码：1成功，其他为失败
     */
    public int code;

    /**
     * 成功为success，其他为失败原因
     */
    public String msg;


    public ResultUtils() {}


    public ResultUtils(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResultUtils(ResultConstans cwResultConstans){
        this.code = cwResultConstans.code;
        this.msg = cwResultConstans.msg;
    }


    public static ResultUtils result(ResultConstans cwResultConstans, Object body){
        return new BodyResult(new BaseResult(cwResultConstans.code,cwResultConstans.msg),body);
    }
    public static ResultUtils result(int code, String msg, Object body){
        return new BodyResult(new BaseResult(code,msg),body);
    }

    public static ResultUtils result(ResultConstans cwResultConstans){
        return new ResultUtils(cwResultConstans);
    }

    public static ResultUtils result(int code, String msg){
        return new ResultUtils(code,msg);
    }

    public static ResultUtils success(Object body){
        return new BodyResult(new BaseResult(ResultConstans.SUCCESS.code,ResultConstans.SUCCESS.msg),body);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
