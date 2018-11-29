package com.ruoyi.project.module.userBirthday.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 用户生日表 birthday_user_birthday
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
public class UserBirthday extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 微信用户id，wx_user表主键 */
	private Long userId;
	/** 姓名 */
	private String userName;
	/** 备注 */
	private String remark;
	/** 头像 */
	private String avatar;
	/** 性别，0女，1男 */
	private Integer gender;
	/** 农历生日 */
	private Date lunarBirthday;
	/** 公历生日 */
	private Date gregorianBirthday;
	/** 历法，0 公历，1农历 */
	private Integer calendar;
	/** 是否闰月，0不润，1润 */
	private Integer leapMonth;
	/** 多少岁*/
	private Integer birthAge;
	/** 多少天后生日*/
	private Integer days;
	/** 爱好 */
	private String hobby;
	/** 星座，枚举 */
	private String  constellation;
	/** 生肖 */
	private String  zodiaz;
	/** 题型类型，0，不提醒，1，小程序提醒，2，邮箱提醒，3，手机号提醒，4，公众号提醒 */
	private Integer reminderType;
	/** 题型时间，定义枚举 */
	private String reminderTime;
	/** 关系， */
	private Integer relation;
	/** 组id */
	private Long groupId;
	/** 类型，0，是个人添加，1，是群组添加 */
	private Integer type;
	/** 是否删除，0，删除，1，存在 */
	private Integer isValid;
	/** 创建人 */
	private Long createUser;
	/**  */
	private Date createDate;
	/**  */
	private Long updateUser;
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
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setAvatar(String avatar) 
	{
		this.avatar = avatar;
	}

	public String getAvatar() 
	{
		return avatar;
	}
	public void setGender(Integer gender) 
	{
		this.gender = gender;
	}

	public Integer getGender() 
	{
		return gender;
	}
	public void setLunarBirthday(Date lunarBirthday) 
	{
		this.lunarBirthday = lunarBirthday;
	}

	public Date getLunarBirthday() 
	{
		return lunarBirthday;
	}
	public void setGregorianBirthday(Date gregorianBirthday) 
	{
		this.gregorianBirthday = gregorianBirthday;
	}

	public Date getGregorianBirthday() 
	{
		return gregorianBirthday;
	}
	public void setCalendar(Integer calendar) 
	{
		this.calendar = calendar;
	}

	public Integer getCalendar() 
	{
		return calendar;
	}
	public void setLeapMonth(Integer leapMonth) 
	{
		this.leapMonth = leapMonth;
	}

	public Integer getLeapMonth() 
	{
		return leapMonth;
	}
	public void setHobby(String hobby) 
	{
		this.hobby = hobby;
	}

	public String getHobby() 
	{
		return hobby;
	}
	public void setReminderType(Integer reminderType)
	{
		this.reminderType = reminderType;
	}

	public Integer getReminderType() 
	{
		return reminderType;
	}
	public void setReminderTime(String reminderTime)
	{
		this.reminderTime = reminderTime;
	}

	public String getReminderTime()
	{
		return reminderTime;
	}
	public void setRelation(Integer relation) 
	{
		this.relation = relation;
	}

	public Integer getRelation() 
	{
		return relation;
	}
	public void setGroupId(Long groupId) 
	{
		this.groupId = groupId;
	}

	public Long getGroupId() 
	{
		return groupId;
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
	public void setCreateUser(Long createUser) 
	{
		this.createUser = createUser;
	}

	public Long getCreateUser() 
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
	public void setUpdateUser(Long updateUser) 
	{
		this.updateUser = updateUser;
	}

	public Long getUpdateUser() 
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

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getZodiaz() {
		return zodiaz;
	}

	public void setZodiaz(String zodiaz) {
		this.zodiaz = zodiaz;
	}

	public Integer getBirthAge() {
		return birthAge;
	}

	public void setBirthAge(Integer birthAge) {
		this.birthAge = birthAge;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("remark", getRemark())
            .append("avatar", getAvatar())
            .append("gender", getGender())
            .append("lunarBirthday", getLunarBirthday())
            .append("gregorianBirthday", getGregorianBirthday())
            .append("calendar", getCalendar())
            .append("leapMonth", getLeapMonth())
            .append("hobby", getHobby())
            .append("constellation", getConstellation())
            .append("reminderType", getReminderType())
            .append("zodiaz", getZodiaz())
            .append("reminderTime", getReminderTime())
            .append("relation", getRelation())
            .append("groupId", getGroupId())
            .append("type", getType())
            .append("isValid", getIsValid())
            .append("createUser", getCreateUser())
            .append("createDate", getCreateDate())
            .append("updateUser", getUpdateUser())
            .append("updateDate", getUpdateDate())
            .toString();
    }
}
