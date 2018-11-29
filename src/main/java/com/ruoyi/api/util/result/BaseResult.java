package com.ruoyi.api.util.result;

/**
 * Created by zhangpl on 2018/8/1.
 * 返回类参数对象
 */
public class BaseResult {
    /**
     * 状态码：1成功，其他为失败
     */
    public int code;

    /**
     * 成功为success，其他为失败原因
     */
    public String msg;

    public BaseResult(){}

    public BaseResult(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code+"";
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
