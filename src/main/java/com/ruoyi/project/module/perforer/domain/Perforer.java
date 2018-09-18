package com.ruoyi.project.module.perforer.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 演员表 movie_perforer
 * 
 * @author ruoyi
 * @date 2018-09-16
 */
public class Perforer extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 演员表id */
	private Long id;
	/** 姓名 */
	private String perforerName;
	/** 演员饰名字 */
	private String perforerNames;
	/** 影片 */
	private Long filmId;
	/** 图片 */
	private String accountImg;
	/** 类型，0，导演，1演员 */
	private Integer type;
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
	public void setPerforerName(String perforerName) 
	{
		this.perforerName = perforerName;
	}

	public String getPerforerName() 
	{
		return perforerName;
	}
	public void setPerforerNames(String perforerNames) 
	{
		this.perforerNames = perforerNames;
	}

	public String getPerforerNames() 
	{
		return perforerNames;
	}
	public void setFilmId(Long filmId) 
	{
		this.filmId = filmId;
	}

	public Long getFilmId() 
	{
		return filmId;
	}
	public void setAccountImg(String accountImg) 
	{
		this.accountImg = accountImg;
	}

	public String getAccountImg() 
	{
		return accountImg;
	}
	public void setType(Integer type) 
	{
		this.type = type;
	}

	public Integer getType() 
	{
		return type;
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
            .append("perforerName", getPerforerName())
            .append("perforerNames", getPerforerNames())
            .append("filmId", getFilmId())
            .append("accountImg", getAccountImg())
            .append("type", getType())
            .append("isValid", getIsValid())
            .append("createUser", getCreateUser())
            .append("createDate", getCreateDate())
            .append("updateUser", getUpdateUser())
            .append("updateDate", getUpdateDate())
            .toString();
    }
}
