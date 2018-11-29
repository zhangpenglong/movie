package com.ruoyi.project.module.wxUser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 小程序用户表 birthday_wx_user
 * 
 * @author ruoyi
 * @date 2018-11-26
 */
public class WxUser extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 用户名 */
	private String username;
	/** 密码 */
	private String password;
	/** 性别 */
	private Integer gender;
	/** 生日 */
	private Date birthday;
	/** 注册时间 */
	private Date registerTime;
	/** 最近一次登录时间 */
	private Date lastLoginTime;
	/** 最近一次登录ip */
	private String lastLoginIp;
	/** 等级 */
	private Integer userLevelId;
	/** 昵称 */
	private String nickname;
	/** 手机号 */
	private String mobile;
	/** 注册ip */
	private String registerIp;
	/** 头像 */
	private String avatar;
	/** openid */
	private String weixinOpenid;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getUsername() 
	{
		return username;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}
	public void setGender(Integer gender) 
	{
		this.gender = gender;
	}

	public Integer getGender() 
	{
		return gender;
	}
	public void setBirthday(Date birthday) 
	{
		this.birthday = birthday;
	}

	public Date getBirthday() 
	{
		return birthday;
	}
	public void setRegisterTime(Date registerTime) 
	{
		this.registerTime = registerTime;
	}

	public Date getRegisterTime() 
	{
		return registerTime;
	}
	public void setLastLoginTime(Date lastLoginTime) 
	{
		this.lastLoginTime = lastLoginTime;
	}

	public Date getLastLoginTime() 
	{
		return lastLoginTime;
	}
	public void setLastLoginIp(String lastLoginIp) 
	{
		this.lastLoginIp = lastLoginIp;
	}

	public String getLastLoginIp() 
	{
		return lastLoginIp;
	}
	public void setUserLevelId(Integer userLevelId) 
	{
		this.userLevelId = userLevelId;
	}

	public Integer getUserLevelId() 
	{
		return userLevelId;
	}
	public void setNickname(String nickname) 
	{
		this.nickname = nickname;
	}

	public String getNickname() 
	{
		return nickname;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}

	public String getMobile() 
	{
		return mobile;
	}
	public void setRegisterIp(String registerIp) 
	{
		this.registerIp = registerIp;
	}

	public String getRegisterIp() 
	{
		return registerIp;
	}
	public void setAvatar(String avatar) 
	{
		this.avatar = avatar;
	}

	public String getAvatar() 
	{
		return avatar;
	}
	public void setWeixinOpenid(String weixinOpenid) 
	{
		this.weixinOpenid = weixinOpenid;
	}

	public String getWeixinOpenid() 
	{
		return weixinOpenid;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("gender", getGender())
            .append("birthday", getBirthday())
            .append("registerTime", getRegisterTime())
            .append("lastLoginTime", getLastLoginTime())
            .append("lastLoginIp", getLastLoginIp())
            .append("userLevelId", getUserLevelId())
            .append("nickname", getNickname())
            .append("mobile", getMobile())
            .append("registerIp", getRegisterIp())
            .append("avatar", getAvatar())
            .append("weixinOpenid", getWeixinOpenid())
            .toString();
    }
}
