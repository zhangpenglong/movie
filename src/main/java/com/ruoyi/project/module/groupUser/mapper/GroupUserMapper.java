package com.ruoyi.project.module.groupUser.mapper;

import com.ruoyi.project.module.groupUser.domain.GroupUser;
import java.util.List;	

/**
 * 群组-用户 数据层
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
public interface GroupUserMapper 
{
	/**
     * 查询群组-用户信息
     * 
     * @param id 群组-用户ID
     * @return 群组-用户信息
     */
	public GroupUser selectGroupUserById(Long id);
	
	/**
     * 查询群组-用户列表
     * 
     * @param groupUser 群组-用户信息
     * @return 群组-用户集合
     */
	public List<GroupUser> selectGroupUserList(GroupUser groupUser);
	
	/**
     * 新增群组-用户
     * 
     * @param groupUser 群组-用户信息
     * @return 结果
     */
	public int insertGroupUser(GroupUser groupUser);
	
	/**
     * 修改群组-用户
     * 
     * @param groupUser 群组-用户信息
     * @return 结果
     */
	public int updateGroupUser(GroupUser groupUser);
	
	/**
     * 删除群组-用户
     * 
     * @param id 群组-用户ID
     * @return 结果
     */
	public int deleteGroupUserById(Long id);
	
	/**
     * 批量删除群组-用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteGroupUserByIds(String[] ids);
	
}