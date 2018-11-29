package com.ruoyi.project.module.group.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 生日群表 birthday_group
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
public class Group extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 组名称 */
	private String groupName;
	/** 类型 */
	private Integer type;
	/** 群主 */
	private Long groupOwner;
	/** 组头像 */
	private String groupAvatar;
	/** 群介绍 */
	private String presend;
	/** 创建时间 */
	private Date createTime;
	/** 创建人 */
	private Long createUser;
	/** 是否解散 */
	private Integer isValid;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setGroupName(String groupName) 
	{
		this.groupName = groupName;
	}

	public String getGroupName() 
	{
		return groupName;
	}
	public void setType(Integer type) 
	{
		this.type = type;
	}

	public Integer getType() 
	{
		return type;
	}
	public void setGroupOwner(Long groupOwner) 
	{
		this.groupOwner = groupOwner;
	}

	public Long getGroupOwner() 
	{
		return groupOwner;
	}
	public void setGroupAvatar(String groupAvatar) 
	{
		this.groupAvatar = groupAvatar;
	}

	public String getGroupAvatar() 
	{
		return groupAvatar;
	}
	public void setPresend(String presend) 
	{
		this.presend = presend;
	}

	public String getPresend() 
	{
		return presend;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setCreateUser(Long createUser) 
	{
		this.createUser = createUser;
	}

	public Long getCreateUser() 
	{
		return createUser;
	}
	public void setIsValid(Integer isValid) 
	{
		this.isValid = isValid;
	}

	public Integer getIsValid() 
	{
		return isValid;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("groupName", getGroupName())
            .append("type", getType())
            .append("groupOwner", getGroupOwner())
            .append("groupAvatar", getGroupAvatar())
            .append("presend", getPresend())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .append("isValid", getIsValid())
            .toString();
    }
}
