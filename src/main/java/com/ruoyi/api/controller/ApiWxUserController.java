package com.ruoyi.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.StringUtils;
import com.ruoyi.api.annotation.IgnoreAuth;
import com.ruoyi.api.dto.FullUserInfo;
import com.ruoyi.api.dto.UserInfo;
import com.ruoyi.api.util.CharUtil;
import com.ruoyi.api.util.CommonUtil;
import com.ruoyi.api.util.result.ResultConstans;
import com.ruoyi.api.util.result.ResultUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.module.token.service.ITokenService;
import com.ruoyi.project.module.wxUser.domain.WxUser;
import com.ruoyi.project.module.wxUser.service.IWxUserService;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by dongao on 2018/11/26.
 */
@Controller
@RequestMapping("/api/wxUser")
public class ApiWxUserController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(ApiWxUserController.class);

    @Autowired
    private IWxUserService userService;
    @Autowired
    private ITokenService tokenService;
    /**
     * 登录
     */
    @IgnoreAuth
    @RequestMapping("loginByWeixin")
    public Object loginByWeixin() {
        JSONObject jsonParam = this.getJsonRequest();
        FullUserInfo fullUserInfo = null;
        String code = "";
        if (!StringUtils.isNullOrEmpty(jsonParam.getString("code"))) {
            code = jsonParam.getString("code");
        }
        if (null != jsonParam.get("userInfo")) {
            fullUserInfo = jsonParam.getObject("userInfo", FullUserInfo.class);
        }

        Map<String, Object> resultObj = new HashMap();
        //
        UserInfo userInfo = fullUserInfo.getUserInfo();

        //获取openid
        String requestUrl = getWebAccess(code);//通过自定义工具类组合出小程序需要的登录凭证 code
        log.info("》》》组合token为：" + requestUrl);
        JSONObject sessionData = CommonUtil.httpsRequest(requestUrl, "GET", null);

        if (null == sessionData || StringUtils.isNullOrEmpty(sessionData.getString("openid"))) {
            System.out.println("-------------------------------------------------");
            return ResultUtils.result(0,"登录失败。");
        }
        //验证用户信息完整性
        String sha1 = CommonUtil.getSha1(fullUserInfo.getRawData() + sessionData.getString("session_key"));
        if (!fullUserInfo.getSignature().equals(sha1)) {
            return ResultUtils.result(0,"登录失败。");
        }
        Date nowTime = new Date();
        WxUser userVo = userService.queryByOpenId(sessionData.getString("openid"));
        if (null == userVo) {
            userVo = new WxUser();
            userVo.setUsername("微信用户" + CharUtil.getRandomString(12));
            userVo.setPassword(sessionData.getString("openid"));
            userVo.setRegisterTime(nowTime);
            userVo.setRegisterIp(this.getClientIp());
            userVo.setLastLoginIp(userVo.getRegisterIp());
            userVo.setLastLoginTime(userVo.getRegisterTime());
            userVo.setWeixinOpenid(sessionData.getString("openid"));
            userVo.setAvatar(userInfo.getAvatarUrl());
            userVo.setGender(userInfo.getGender()); // //性别 0：未知、1：男、2：女
            userVo.setNickname(userInfo.getNickName());
            userService.insertWxUser(userVo);
        } else {
            userVo.setLastLoginIp(this.getClientIp());
            userVo.setLastLoginTime(nowTime);
            userVo.setAvatar(userInfo.getAvatarUrl());
            userVo.setGender(userInfo.getGender()); // //性别 0：未知、1：男、2：女
            userVo.setNickname(userInfo.getNickName());
            userService.updateWxUser(userVo);
        }

        Map<String, Object> tokenMap = tokenService.createToken(userVo.getId());
        String token = MapUtils.getString(tokenMap, "token");

        if (null == userInfo || StringUtils.isNullOrEmpty(token)) {
            return ResultUtils.result(0,"登录失败。");
        }
        resultObj.put("token", token);
        resultObj.put("userName", userVo.getUsername());
        resultObj.put("nickname", userVo.getNickname());
        resultObj.put("avatar", userVo.getAvatar());
        return ResultUtils.result(ResultConstans.SUCCESS,resultObj);
    }



    /**
     *功能描述  由于小程序限制，对于没有获取用户信息的用户调用此登录接口，
     *@Author  zhangpl
     *@Date 2018/10/24 15:20
     * @param  * @param   code   调用微信登录返回的code
     * @return java.lang.Object
     */
    @IgnoreAuth
    @RequestMapping("loginByWeixinNoinfo")
    @ResponseBody
    public Object loginByWeixinNoInfo() {
        JSONObject jsonParam = this.getJsonRequest();
        String code = "";
        if (!StringUtils.isNullOrEmpty(jsonParam.getString("code"))) {
            code = jsonParam.getString("code");
        }

        Map<String, Object> resultObj = new HashMap();
        //

        //获取openid
        String requestUrl = getWebAccess(code);//通过自定义工具类组合出小程序需要的登录凭证 code
        log.info("》》》组合token为：" + requestUrl);
        JSONObject sessionData = CommonUtil.httpsRequest(requestUrl, "GET", null);

        if (null == sessionData || StringUtils.isNullOrEmpty(sessionData.getString("openid"))) {
            return ResultUtils.result(0,"登录失败。");
        }
        Date nowTime = new Date();
        String value = Constants.DEFAULT_HEAD_URL;
        WxUser userVo = userService.queryByOpenId(sessionData.getString("openid"));
        if (null == userVo) {
            userVo = new WxUser();
            userVo.setUsername("微信用户" + CharUtil.getRandomString(12));
            userVo.setPassword(sessionData.getString("openid"));
            userVo.setRegisterTime(nowTime);
            userVo.setRegisterIp(this.getClientIp());
            userVo.setLastLoginIp(userVo.getRegisterIp());
            userVo.setLastLoginTime(userVo.getRegisterTime());
            userVo.setWeixinOpenid(sessionData.getString("openid"));
            userVo.setAvatar(value);
            userService.insertWxUser(userVo);
        } else {
            userVo.setLastLoginIp(this.getClientIp());
            userVo.setLastLoginTime(nowTime);
            userService.updateWxUser(userVo);
        }

        Map<String, Object> tokenMap = tokenService.createToken(userVo.getId());
        String token = MapUtils.getString(tokenMap, "token");

        if ( StringUtils.isNullOrEmpty(token)) {
            return ResultUtils.result(0,"登录失败。");
        }

        resultObj.put("token", token);
        resultObj.put("userName", userVo.getUsername());
        resultObj.put("nickname", userVo.getNickname());
        resultObj.put("avatar", userVo.getAvatar());
        return ResultUtils.result(ResultConstans.SUCCESS,resultObj);
    }


    //替换字符串
    public static String getCode(String APPID, String REDIRECT_URI, String SCOPE) {
        return String.format(Constants.WXCODE, APPID, REDIRECT_URI, SCOPE);
    }

    //替换字符串
    public static String getWebAccess(String CODE) {
        return String.format(Constants.WEBACCESSTOKEN,
                Constants.APPID,
                Constants.SECRET,
                CODE);
    }

    //替换字符串
    public static String getUserMessage(String access_token, String openid) {
        return String.format(Constants.USERMESSAGE, access_token, openid);
    }

}
