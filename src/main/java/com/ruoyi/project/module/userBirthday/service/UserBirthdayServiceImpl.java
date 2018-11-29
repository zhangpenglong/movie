package com.ruoyi.project.module.userBirthday.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.userBirthday.mapper.UserBirthdayMapper;
import com.ruoyi.project.module.userBirthday.domain.UserBirthday;
import com.ruoyi.project.module.userBirthday.service.IUserBirthdayService;
import com.ruoyi.common.support.Convert;

/**
 * 用户生日 服务层实现
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
@Service
public class UserBirthdayServiceImpl implements IUserBirthdayService 
{
	@Autowired
	private UserBirthdayMapper userBirthdayMapper;

	/**
     * 查询用户生日信息
     * 
     * @param id 用户生日ID
     * @return 用户生日信息
     */
    @Override
	public UserBirthday selectUserBirthdayById(Long id)
	{
	    return userBirthdayMapper.selectUserBirthdayById(id);
	}
	
	/**
     * 查询用户生日列表
     * 
     * @param userBirthday 用户生日信息
     * @return 用户生日集合
     */
	@Override
	public List<UserBirthday> selectUserBirthdayList(UserBirthday userBirthday)	{
		List<UserBirthday> userBirthdays = userBirthdayMapper.selectUserBirthdayList(userBirthday);

		return userBirthdays;
	}
	
    /**
     * 新增用户生日
     * 
     * @param userBirthday 用户生日信息
     * @return 结果
     */
	@Override
	public int insertUserBirthday(UserBirthday userBirthday)
	{
	    return userBirthdayMapper.insertUserBirthday(userBirthday);
	}
	
	/**
     * 修改用户生日
     * 
     * @param userBirthday 用户生日信息
     * @return 结果
     */
	@Override
	public int updateUserBirthday(UserBirthday userBirthday)
	{
	    return userBirthdayMapper.updateUserBirthday(userBirthday);
	}

	/**
     * 删除用户生日对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteUserBirthdayByIds(String ids)
	{
		return userBirthdayMapper.deleteUserBirthdayByIds(Convert.toStrArray(ids));
	}



	/**
	 *功能描述  查询所有的生日
	 *@Author  zhangpl
	 *@Date 2018/11/29 11:18
	 * @param  * @param
	 * @return java.util.List<com.ruoyi.project.module.userBirthday.domain.UserBirthday>
	 */
	@Override
	public List<UserBirthday> listAll(){
		return userBirthdayMapper.listAll();
	}

	/**
	 *功能描述  获取当前需要题型的生日人
	 *@Author  zhangpl
	 *@Date 2018/11/29 15:17
	 * @param  * @param
	 * @return java.util.List<com.ruoyi.project.module.userBirthday.domain.UserBirthday>
	 */
	@Override
	public List<UserBirthday> listReminder(Integer[] ids){
		return userBirthdayMapper.listReminder(ids);
	}
	
}
