package com.ruoyi.api.util.result;

/**
 * Created by zhangpl on 2018/8/2.
 * 此类继承ResultUtil类的result属性，本类主要属性为body，
 * 此类的出现主要解决了在接口失败时，不返回body
 */
public class BodyResult extends ResultUtils {


    public Object body;


    public BodyResult(){         }

    public BodyResult(BaseResult result, Object body){
        this.code = result.code;
        this.msg = result.msg;
        this.body = body;
    }


    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
