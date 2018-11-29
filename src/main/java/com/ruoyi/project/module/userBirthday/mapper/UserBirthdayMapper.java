package com.ruoyi.project.module.userBirthday.mapper;

import com.ruoyi.project.module.userBirthday.domain.UserBirthday;
import java.util.List;	

/**
 * 用户生日 数据层
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
public interface UserBirthdayMapper 
{
	/**
     * 查询用户生日信息
     * 
     * @param id 用户生日ID
     * @return 用户生日信息
     */
	public UserBirthday selectUserBirthdayById(Long id);
	
	/**
     * 查询用户生日列表
     * 
     * @param userBirthday 用户生日信息
     * @return 用户生日集合
     */
	public List<UserBirthday> selectUserBirthdayList(UserBirthday userBirthday);
	
	/**
     * 新增用户生日
     * 
     * @param userBirthday 用户生日信息
     * @return 结果
     */
	public int insertUserBirthday(UserBirthday userBirthday);
	
	/**
     * 修改用户生日
     * 
     * @param userBirthday 用户生日信息
     * @return 结果
     */
	public int updateUserBirthday(UserBirthday userBirthday);
	
	/**
     * 删除用户生日
     * 
     * @param id 用户生日ID
     * @return 结果
     */
	public int deleteUserBirthdayById(Long id);
	
	/**
     * 批量删除用户生日
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserBirthdayByIds(String[] ids);


	/**
	 *功能描述  查询所有的生日
	 *@Author  zhangpl
	 *@Date 2018/11/29 11:18
	 * @param  * @param
	 * @return java.util.List<com.ruoyi.project.module.userBirthday.domain.UserBirthday>
	 */
	List<UserBirthday> listAll();

	/**
	 *功能描述  获取当前需要题型的生日人
	 *@Author  zhangpl
	 *@Date 2018/11/29 15:17
	 * @param  * @param
	 * @return java.util.List<com.ruoyi.project.module.userBirthday.domain.UserBirthday>
	 */
	List<UserBirthday> listReminder(Integer[] ids);
	
}