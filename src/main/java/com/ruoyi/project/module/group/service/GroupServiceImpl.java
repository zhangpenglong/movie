package com.ruoyi.project.module.group.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.group.mapper.GroupMapper;
import com.ruoyi.project.module.group.domain.Group;
import com.ruoyi.project.module.group.service.IGroupService;
import com.ruoyi.common.support.Convert;

/**
 * 生日群 服务层实现
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
@Service
public class GroupServiceImpl implements IGroupService 
{
	@Autowired
	private GroupMapper groupMapper;

	/**
     * 查询生日群信息
     * 
     * @param id 生日群ID
     * @return 生日群信息
     */
    @Override
	public Group selectGroupById(Long id)
	{
	    return groupMapper.selectGroupById(id);
	}
	
	/**
     * 查询生日群列表
     * 
     * @param group 生日群信息
     * @return 生日群集合
     */
	@Override
	public List<Group> selectGroupList(Group group)
	{
	    return groupMapper.selectGroupList(group);
	}
	
    /**
     * 新增生日群
     * 
     * @param group 生日群信息
     * @return 结果
     */
	@Override
	public int insertGroup(Group group)
	{
	    return groupMapper.insertGroup(group);
	}
	
	/**
     * 修改生日群
     * 
     * @param group 生日群信息
     * @return 结果
     */
	@Override
	public int updateGroup(Group group)
	{
	    return groupMapper.updateGroup(group);
	}

	/**
     * 删除生日群对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteGroupByIds(String ids)
	{
		return groupMapper.deleteGroupByIds(Convert.toStrArray(ids));
	}
	
}
