package com.ruoyi.project.module.group.mapper;

import com.ruoyi.project.module.group.domain.Group;
import java.util.List;	

/**
 * 生日群 数据层
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
public interface GroupMapper 
{
	/**
     * 查询生日群信息
     * 
     * @param id 生日群ID
     * @return 生日群信息
     */
	public Group selectGroupById(Long id);
	
	/**
     * 查询生日群列表
     * 
     * @param group 生日群信息
     * @return 生日群集合
     */
	public List<Group> selectGroupList(Group group);
	
	/**
     * 新增生日群
     * 
     * @param group 生日群信息
     * @return 结果
     */
	public int insertGroup(Group group);
	
	/**
     * 修改生日群
     * 
     * @param group 生日群信息
     * @return 结果
     */
	public int updateGroup(Group group);
	
	/**
     * 删除生日群
     * 
     * @param id 生日群ID
     * @return 结果
     */
	public int deleteGroupById(Long id);
	
	/**
     * 批量删除生日群
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteGroupByIds(String[] ids);
	
}