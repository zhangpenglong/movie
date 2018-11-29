package com.ruoyi.project.module.groupUser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 群组-用户表 birthday_group_user
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
public class GroupUser extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 群组 */
	private Long groupId;
	/** 用户 */
	private Long userId;
	/** 邀请人 */
	private Long createUser;
	/** 进入时间 */
	private Date createTime;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setGroupId(Long groupId) 
	{
		this.groupId = groupId;
	}

	public Long getGroupId() 
	{
		return groupId;
	}
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setCreateUser(Long createUser) 
	{
		this.createUser = createUser;
	}

	public Long getCreateUser() 
	{
		return createUser;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("groupId", getGroupId())
            .append("userId", getUserId())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .toString();
    }
}
