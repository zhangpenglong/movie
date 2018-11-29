package com.ruoyi.project.module.groupUser.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.groupUser.mapper.GroupUserMapper;
import com.ruoyi.project.module.groupUser.domain.GroupUser;
import com.ruoyi.project.module.groupUser.service.IGroupUserService;
import com.ruoyi.common.support.Convert;

/**
 * 群组-用户 服务层实现
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
@Service
public class GroupUserServiceImpl implements IGroupUserService 
{
	@Autowired
	private GroupUserMapper groupUserMapper;

	/**
     * 查询群组-用户信息
     * 
     * @param id 群组-用户ID
     * @return 群组-用户信息
     */
    @Override
	public GroupUser selectGroupUserById(Long id)
	{
	    return groupUserMapper.selectGroupUserById(id);
	}
	
	/**
     * 查询群组-用户列表
     * 
     * @param groupUser 群组-用户信息
     * @return 群组-用户集合
     */
	@Override
	public List<GroupUser> selectGroupUserList(GroupUser groupUser)
	{
	    return groupUserMapper.selectGroupUserList(groupUser);
	}
	
    /**
     * 新增群组-用户
     * 
     * @param groupUser 群组-用户信息
     * @return 结果
     */
	@Override
	public int insertGroupUser(GroupUser groupUser)
	{
	    return groupUserMapper.insertGroupUser(groupUser);
	}
	
	/**
     * 修改群组-用户
     * 
     * @param groupUser 群组-用户信息
     * @return 结果
     */
	@Override
	public int updateGroupUser(GroupUser groupUser)
	{
	    return groupUserMapper.updateGroupUser(groupUser);
	}

	/**
     * 删除群组-用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteGroupUserByIds(String ids)
	{
		return groupUserMapper.deleteGroupUserByIds(Convert.toStrArray(ids));
	}
	
}
