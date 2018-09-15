package com.ruoyi.project.module.cinemaHall.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 影院影厅表 movie_cinema_hall
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
public class CinemaHall extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 电影厅名字 */
	private String hallName;
	/** 座位数量 */
	private Integer seatNumber;
	/** 排数 */
	private Integer rowNumber;
	/** 列数量 */
	private Integer columnNumber;
	/** 座位排列规则 */
	private String seatRule;
	/** 影院ID */
	private Long cinemaId;
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
	private Integer status;

	/**影院名称**/
	private String cinemaName;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setHallName(String hallName) 
	{
		this.hallName = hallName;
	}

	public String getHallName() 
	{
		return hallName;
	}
	public void setSeatNumber(Integer seatNumber) 
	{
		this.seatNumber = seatNumber;
	}

	public Integer getSeatNumber() 
	{
		return seatNumber;
	}
	public void setRowNumber(Integer rowNumber) 
	{
		this.rowNumber = rowNumber;
	}

	public Integer getRowNumber() 
	{
		return rowNumber;
	}
	public void setColumnNumber(Integer columnNumber) 
	{
		this.columnNumber = columnNumber;
	}

	public Integer getColumnNumber() 
	{
		return columnNumber;
	}
	public void setSeatRule(String seatRule) 
	{
		this.seatRule = seatRule;
	}

	public String getSeatRule() 
	{
		return seatRule;
	}
	public void setCinemaId(Long cinemaId) 
	{
		this.cinemaId = cinemaId;
	}

	public Long getCinemaId() 
	{
		return cinemaId;
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
            .append("hallName", getHallName())
            .append("seatNumber", getSeatNumber())
            .append("rowNumber", getRowNumber())
            .append("columnNumber", getColumnNumber())
            .append("seatRule", getSeatRule())
            .append("cinemaId", getCinemaId())
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
