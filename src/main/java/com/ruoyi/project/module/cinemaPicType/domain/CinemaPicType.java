package com.ruoyi.project.module.cinemaPicType.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 图片类型表 movie_cinema_pic_type
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
public class CinemaPicType extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 图片类型名称 */
	private String picTypeName;
	/** 图片类型 */
	private Integer picType;
	/**  */
	private Integer isValid;
	/**  */
	private String createUser;
	/**  */
	private Date createDate;
	/**  */
	private String updateUser;
	/**  */
	private Date updateDate;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setPicTypeName(String picTypeName) 
	{
		this.picTypeName = picTypeName;
	}

	public String getPicTypeName() 
	{
		return picTypeName;
	}
	public void setPicType(Integer picType) 
	{
		this.picType = picType;
	}

	public Integer getPicType() 
	{
		return picType;
	}
	public void setIsValid(Integer isValid) 
	{
		this.isValid = isValid;
	}

	public Integer getIsValid() 
	{
		return isValid;
	}
	public void setCreateUser(String createUser) 
	{
		this.createUser = createUser;
	}

	public String getCreateUser() 
	{
		return createUser;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setUpdateUser(String updateUser) 
	{
		this.updateUser = updateUser;
	}

	public String getUpdateUser() 
	{
		return updateUser;
	}
	public void setUpdateDate(Date updateDate) 
	{
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() 
	{
		return updateDate;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("picTypeName", getPicTypeName())
            .append("picType", getPicType())
            .append("isValid", getIsValid())
            .append("createUser", getCreateUser())
            .append("createDate", getCreateDate())
            .append("updateUser", getUpdateUser())
            .append("updateDate", getUpdateDate())
            .toString();
    }
}
