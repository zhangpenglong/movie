package com.ruoyi.api.util.result;

/**
 * Created by zhangpl on 2018/8/1.
 * 课件系统接口结果常量枚举类
 */
public enum ResultConstans {


    /**
     * 失败
     */
    FAILED(0, "failed"),

    /**
     * 成功
     */
    SUCCESS(1, "success"),

    /**
     *发生异常
     */
    EXCEPTION(9, "数据异常。"),

    /**
     * 失败，data参数空
     */
    DATANULL(1001,"data参数为空。"),


    /**
     * 失败，加密参数为空
     */
    KEYNULL(1002,"加密参数为空。"),

    /**
     * 失败，密钥串错误
     */
    KEYFAILED(1003,"密钥串错误。"),

    /**
     * 失败，data解析失败
     */
    DATAFAILED(1004,"data解析失败。"),

    /**
     * 失败，有参数为空
     */
    PARAMNULL(1005,"有参数为空。");
    public int code;

    public String msg;

    ResultConstans(int code, String message) {
        this.code = code;
        this.msg = message;
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
