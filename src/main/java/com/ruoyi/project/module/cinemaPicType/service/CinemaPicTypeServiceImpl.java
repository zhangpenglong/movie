package com.ruoyi.project.module.cinemaPicType.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.cinemaPicType.mapper.CinemaPicTypeMapper;
import com.ruoyi.project.module.cinemaPicType.domain.CinemaPicType;
import com.ruoyi.project.module.cinemaPicType.service.ICinemaPicTypeService;
import com.ruoyi.common.support.Convert;

/**
 * 图片类型 服务层实现
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
@Service
public class CinemaPicTypeServiceImpl implements ICinemaPicTypeService 
{
	@Autowired
	private CinemaPicTypeMapper cinemaPicTypeMapper;

	/**
     * 查询图片类型信息
     * 
     * @param id 图片类型ID
     * @return 图片类型信息
     */
    @Override
	public CinemaPicType selectCinemaPicTypeById(Long id)
	{
	    return cinemaPicTypeMapper.selectCinemaPicTypeById(id);
	}
	
	/**
     * 查询图片类型列表
     * 
     * @param cinemaPicType 图片类型信息
     * @return 图片类型集合
     */
	@Override
	public List<CinemaPicType> selectCinemaPicTypeList(CinemaPicType cinemaPicType)
	{
	    return cinemaPicTypeMapper.selectCinemaPicTypeList(cinemaPicType);
	}
	
    /**
     * 新增图片类型
     * 
     * @param cinemaPicType 图片类型信息
     * @return 结果
     */
	@Override
	public int insertCinemaPicType(CinemaPicType cinemaPicType)
	{
	    return cinemaPicTypeMapper.insertCinemaPicType(cinemaPicType);
	}
	
	/**
     * 修改图片类型
     * 
     * @param cinemaPicType 图片类型信息
     * @return 结果
     */
	@Override
	public int updateCinemaPicType(CinemaPicType cinemaPicType)
	{
	    return cinemaPicTypeMapper.updateCinemaPicType(cinemaPicType);
	}

	/**
     * 删除图片类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCinemaPicTypeByIds(String ids)
	{
		return cinemaPicTypeMapper.deleteCinemaPicTypeByIds(Convert.toStrArray(ids));
	}


	/**
	*功能描述  查询所有图片类型
	*@Author  zhangpl
	*@Date 2018/9/10 16:53
	* @param  * @param
	* @return java.util.List<com.ruoyi.project.module.cinemaPicType.domain.CinemaPicType>
	*/
	public List<CinemaPicType> listAll(){
		return cinemaPicTypeMapper.listAll();
	}
	
}
