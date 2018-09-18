package com.ruoyi.project.module.perforer.service;

import com.ruoyi.project.module.perforer.domain.Perforer;
import java.util.List;

/**
 * 演员 服务层
 * 
 * @author ruoyi
 * @date 2018-09-16
 */
public interface IPerforerService 
{
	/**
     * 查询演员信息
     * 
     * @param id 演员ID
     * @return 演员信息
     */
	public Perforer selectPerforerById(Long id);
	
	/**
     * 查询演员列表
     * 
     * @param perforer 演员信息
     * @return 演员集合
     */
	public List<Perforer> selectPerforerList(Perforer perforer);
	
	/**
     * 新增演员
     * 
     * @param perforer 演员信息
     * @return 结果
     */
	public int insertPerforer(Perforer perforer);
	
	/**
     * 修改演员
     * 
     * @param perforer 演员信息
     * @return 结果
     */
	public int updatePerforer(Perforer perforer);
		
	/**
     * 删除演员信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePerforerByIds(String ids);
	
}
