package com.ruoyi.project.module.cinemaPic.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 影院图片表 movie_cinema_pic
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
public class CinemaPic extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 图片地址 */
	private String picUrl;
	/** 图片类型 */
	private Long picType;
	/** 影院Id， */
	private Long cinemaId;
	/** 排序 */
	private Integer sequence;
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

	/**影院名称**/
	private String cinemaName;
	/**图片类型名称**/
    private String picTypeName;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setPicUrl(String picUrl) 
	{
		this.picUrl = picUrl;
	}

	public String getPicUrl() 
	{
		return picUrl;
	}
	public void setPicType(Long picType) 
	{
		this.picType = picType;
	}

	public Long getPicType() 
	{
		return picType;
	}
	public void setCinemaId(Long cinemaId) 
	{
		this.cinemaId = cinemaId;
	}

	public Long getCinemaId() 
	{
		return cinemaId;
	}
	public void setSequence(Integer sequence) 
	{
		this.sequence = sequence;
	}

	public Integer getSequence() 
	{
		return sequence;
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
            .append("picUrl", getPicUrl())
            .append("picType", getPicType())
            .append("cinemaId", getCinemaId())
            .append("sequence", getSequence())
            .append("isValid", getIsValid())
            .append("createUser", getCreateUser())
            .append("createDate", getCreateDate())
            .append("updateUser", getUpdateUser())
            .append("updateDate", getUpdateDate())
            .toString();
    }

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getPicTypeName() {
		return picTypeName;
	}

	public void setPicTypeName(String picTypeName) {
		this.picTypeName = picTypeName;
	}
}
