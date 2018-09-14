package com.ruoyi.project.module.company.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 合作公司表 wx_company
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
public class Company extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 公司名称 */
	private String companyName;
	/** 开始合作时间 */
	private Date startTime;
	/** 结束合作时间 */
	private Date endTime;
	/** 主营范围 */
	private String mainScope;
	/** 地址 */
	private String address;
	/** 经度 */
	private String longitude;
	/** 纬度 */
	private String latitude;
	/** 联系人 */
	private String contacts;
	/** 联系人电弧 */
	private String phone;
	/** 微信号 */
	private String wxNumber;
	/** 公司介绍 */
	private String companyIntroduction;
	/** 状态（0正常 1停用） */
	private String status;
	/** 删除 */
	private String isValid;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新人 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setCompanyName(String companyName) 
	{
		this.companyName = companyName;
	}

	public String getCompanyName() 
	{
		return companyName;
	}
	public void setStartTime(Date startTime) 
	{
		this.startTime = startTime;
	}

	public Date getStartTime() 
	{
		return startTime;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}
	public void setMainScope(String mainScope) 
	{
		this.mainScope = mainScope;
	}

	public String getMainScope() 
	{
		return mainScope;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setLongitude(String longitude) 
	{
		this.longitude = longitude;
	}

	public String getLongitude() 
	{
		return longitude;
	}
	public void setLatitude(String latitude) 
	{
		this.latitude = latitude;
	}

	public String getLatitude() 
	{
		return latitude;
	}
	public void setContacts(String contacts) 
	{
		this.contacts = contacts;
	}

	public String getContacts() 
	{
		return contacts;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setWxNumber(String wxNumber) 
	{
		this.wxNumber = wxNumber;
	}

	public String getWxNumber() 
	{
		return wxNumber;
	}
	public void setCompanyIntroduction(String companyIntroduction) 
	{
		this.companyIntroduction = companyIntroduction;
	}

	public String getCompanyIntroduction() 
	{
		return companyIntroduction;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setIsValid(String isValid) 
	{
		this.isValid = isValid;
	}

	public String getIsValid() 
	{
		return isValid;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("companyName", getCompanyName())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("mainScope", getMainScope())
            .append("address", getAddress())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("contacts", getContacts())
            .append("phone", getPhone())
            .append("wxNumber", getWxNumber())
            .append("companyIntroduction", getCompanyIntroduction())
            .append("status", getStatus())
            .append("isValid", getIsValid())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
