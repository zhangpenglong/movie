package com.ruoyi.project.module.token.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 用户Token表 birthday_token
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
public class Token extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long userId;
	/** token */
	private String token;
	/** 过期时间 */
	private Date expireTime;
	/** 更新时间 */
	private Date updateTime;

	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setToken(String token) 
	{
		this.token = token;
	}

	public String getToken() 
	{
		return token;
	}
	public void setExpireTime(Date expireTime) 
	{
		this.expireTime = expireTime;
	}

	public Date getExpireTime() 
	{
		return expireTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("token", getToken())
            .append("expireTime", getExpireTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
