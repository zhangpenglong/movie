package com.ruoyi.project.module.cinemaPicType.service;

import com.ruoyi.project.module.cinemaPicType.domain.CinemaPicType;
import java.util.List;

/**
 * 图片类型 服务层
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
public interface ICinemaPicTypeService 
{
	/**
     * 查询图片类型信息
     * 
     * @param id 图片类型ID
     * @return 图片类型信息
     */
	public CinemaPicType selectCinemaPicTypeById(Long id);
	
	/**
     * 查询图片类型列表
     * 
     * @param cinemaPicType 图片类型信息
     * @return 图片类型集合
     */
	public List<CinemaPicType> selectCinemaPicTypeList(CinemaPicType cinemaPicType);
	
	/**
     * 新增图片类型
     * 
     * @param cinemaPicType 图片类型信息
     * @return 结果
     */
	public int insertCinemaPicType(CinemaPicType cinemaPicType);
	
	/**
     * 修改图片类型
     * 
     * @param cinemaPicType 图片类型信息
     * @return 结果
     */
	public int updateCinemaPicType(CinemaPicType cinemaPicType);
		
	/**
     * 删除图片类型信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCinemaPicTypeByIds(String ids);


	/**
	 *功能描述  查询所有图片类型
	 *@Author  zhangpl
	 *@Date 2018/9/10 16:53
	 * @param  * @param
	 * @return java.util.List<com.ruoyi.project.module.cinemaPicType.domain.CinemaPicType>
	 */
	List<CinemaPicType> listAll();
}
