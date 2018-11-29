package com.ruoyi.project.module.film.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 影片表 movie_film
 * 
 * @author ruoyi
 * @date 2018-09-16
 */
public class Film extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 影片ID */
	private Long id;
	/** 影片名称（中文） */
	private String filmName;
	/** 影片名称（英文） */
	private String filmNameUa;
	/** 首页图片（宣传图） */
	private String imgIndex;
	/** 中国上映日期 */
	private Date chainShow;
	/** 下线日期 */
	private Date downlineDate;
	/** 状态，0 未上映，1预收，2上映，3下映 */
	private Integer status;
	/** 标签 */
	private String label;
	/** 影片时长（单位分钟） */
	private Integer filmTime;
	/** 说明 */
	private String filmExplain;
	/** 是否删除 */
	private Integer isValid;
	/**  */
	private String createUser;
	/**  */
	private Date createDate;
	/**  */
	private String updateUser;
	/**  */
	private Date updateDate;

	private String[] lableArr;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setFilmName(String filmName) 
	{
		this.filmName = filmName;
	}

	public String getFilmName() 
	{
		return filmName;
	}
	public void setFilmNameUa(String filmNameUa) 
	{
		this.filmNameUa = filmNameUa;
	}

	public String getFilmNameUa() 
	{
		return filmNameUa;
	}
	public void setImgIndex(String imgIndex) 
	{
		this.imgIndex = imgIndex;
	}

	public String getImgIndex() 
	{
		return imgIndex;
	}
	public void setChainShow(Date chainShow) 
	{
		this.chainShow = chainShow;
	}

	public Date getChainShow() 
	{
		return chainShow;
	}
	public void setDownlineDate(Date downlineDate) 
	{
		this.downlineDate = downlineDate;
	}

	public Date getDownlineDate() 
	{
		return downlineDate;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setLabel(String label) 
	{
		this.label = label;
	}

	public String getLabel() 
	{
		return label;
	}
	public void setFilmTime(Integer filmTime) 
	{
		this.filmTime = filmTime;
	}

	public Integer getFilmTime() 
	{
		return filmTime;
	}
	public void setFilmExplain(String filmExplain)
	{
		this.filmExplain = filmExplain;
	}

	public String getFilmExplain()
	{
		return filmExplain;
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

	public String[] getLableArr() {
		return lableArr;
	}

	public void setLableArr(String[] lableArr) {
		this.lableArr = lableArr;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("filmName", getFilmName())
            .append("filmNameUa", getFilmNameUa())
            .append("imgIndex", getImgIndex())
            .append("chainShow", getChainShow())
            .append("downlineDate", getDownlineDate())
            .append("status", getStatus())
            .append("label", getLabel())
            .append("filmTime", getFilmTime())
            .append("filmExplain", getFilmExplain())
            .append("isValid", getIsValid())
            .append("createUser", getCreateUser())
            .append("createDate", getCreateDate())
            .append("updateUser", getUpdateUser())
            .append("updateDate", getUpdateDate())
            .toString();
    }
}
