package com.ruoyi.project.module.perforer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.perforer.mapper.PerforerMapper;
import com.ruoyi.project.module.perforer.domain.Perforer;
import com.ruoyi.project.module.perforer.service.IPerforerService;
import com.ruoyi.common.support.Convert;

/**
 * 演员 服务层实现
 * 
 * @author ruoyi
 * @date 2018-09-16
 */
@Service
public class PerforerServiceImpl implements IPerforerService 
{
	@Autowired
	private PerforerMapper perforerMapper;

	/**
     * 查询演员信息
     * 
     * @param id 演员ID
     * @return 演员信息
     */
    @Override
	public Perforer selectPerforerById(Long id)
	{
	    return perforerMapper.selectPerforerById(id);
	}
	
	/**
     * 查询演员列表
     * 
     * @param perforer 演员信息
     * @return 演员集合
     */
	@Override
	public List<Perforer> selectPerforerList(Perforer perforer)
	{
	    return perforerMapper.selectPerforerList(perforer);
	}
	
    /**
     * 新增演员
     * 
     * @param perforer 演员信息
     * @return 结果
     */
	@Override
	public int insertPerforer(Perforer perforer)
	{
	    return perforerMapper.insertPerforer(perforer);
	}
	
	/**
     * 修改演员
     * 
     * @param perforer 演员信息
     * @return 结果
     */
	@Override
	public int updatePerforer(Perforer perforer)
	{
	    return perforerMapper.updatePerforer(perforer);
	}

	/**
     * 删除演员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePerforerByIds(String ids)
	{
		return perforerMapper.deletePerforerByIds(Convert.toStrArray(ids));
	}
	
}
