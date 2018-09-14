package com.ruoyi.project.module.cinema.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 电影院表 movie_cinema
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
public class Cinema extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 影院名称 */
	private String cinemaName;
	/** 影院地址 */
	private String cinemaAddress;
	/** 影院省地 */
	private String province;
	/** 城市 */
	private String city;
	/** 区县 */
	private String area;
	/** 经度 */
	private String longitude;
	/** 纬度 */
	private String latitude;
	/** 电话 */
	private String telephone;
	/** 是否有3D眼镜说明 */
	private String glassesExplain;
	/** 儿童票说明 */
	private String childExplain;
	/** 停车场说明 */
	private String parkingExplain;
	/** wifi说明 */
	private String wifiExplain;
	/** 公告 */
	private String notice;
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
	public void setCinemaName(String cinemaName) 
	{
		this.cinemaName = cinemaName;
	}

	public String getCinemaName() 
	{
		return cinemaName;
	}
	public void setCinemaAddress(String cinemaAddress) 
	{
		this.cinemaAddress = cinemaAddress;
	}

	public String getCinemaAddress() 
	{
		return cinemaAddress;
	}
	public void setProvince(String province) 
	{
		this.province = province;
	}

	public String getProvince() 
	{
		return province;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getCity() 
	{
		return city;
	}
	public void setArea(String area) 
	{
		this.area = area;
	}

	public String getArea() 
	{
		return area;
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
	public void setTelephone(String telephone) 
	{
		this.telephone = telephone;
	}

	public String getTelephone() 
	{
		return telephone;
	}
	public void setGlassesExplain(String glassesExplain) 
	{
		this.glassesExplain = glassesExplain;
	}

	public String getGlassesExplain() 
	{
		return glassesExplain;
	}
	public void setChildExplain(String childExplain) 
	{
		this.childExplain = childExplain;
	}

	public String getChildExplain() 
	{
		return childExplain;
	}
	public void setParkingExplain(String parkingExplain) 
	{
		this.parkingExplain = parkingExplain;
	}

	public String getParkingExplain() 
	{
		return parkingExplain;
	}
	public void setWifiExplain(String wifiExplain) 
	{
		this.wifiExplain = wifiExplain;
	}

	public String getWifiExplain() 
	{
		return wifiExplain;
	}
	public void setNotice(String notice) 
	{
		this.notice = notice;
	}

	public String getNotice() 
	{
		return notice;
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
            .append("cinemaName", getCinemaName())
            .append("cinemaAddress", getCinemaAddress())
            .append("province", getProvince())
            .append("city", getCity())
            .append("area", getArea())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("telephone", getTelephone())
            .append("glassesExplain", getGlassesExplain())
            .append("childExplain", getChildExplain())
            .append("parkingExplain", getParkingExplain())
            .append("wifiExplain", getWifiExplain())
            .append("notice", getNotice())
            .append("isValid", getIsValid())
            .append("createUser", getCreateUser())
            .append("createDate", getCreateDate())
            .append("updateUser", getUpdateUser())
            .append("updateDate", getUpdateDate())
            .toString();
    }
}
