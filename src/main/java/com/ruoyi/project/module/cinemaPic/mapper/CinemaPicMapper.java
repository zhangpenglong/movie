package com.ruoyi.project.module.cinemaPic.mapper;

import com.ruoyi.project.module.cinemaPic.domain.CinemaPic;
import java.util.List;	

/**
 * 影院图片 数据层
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
public interface CinemaPicMapper 
{
	/**
     * 查询影院图片信息
     * 
     * @param id 影院图片ID
     * @return 影院图片信息
     */
	public CinemaPic selectCinemaPicById(Long id);
	
	/**
     * 查询影院图片列表
     * 
     * @param cinemaPic 影院图片信息
     * @return 影院图片集合
     */
	public List<CinemaPic> selectCinemaPicList(CinemaPic cinemaPic);
	
	/**
     * 新增影院图片
     * 
     * @param cinemaPic 影院图片信息
     * @return 结果
     */
	public int insertCinemaPic(CinemaPic cinemaPic);
	
	/**
     * 修改影院图片
     * 
     * @param cinemaPic 影院图片信息
     * @return 结果
     */
	public int updateCinemaPic(CinemaPic cinemaPic);
	
	/**
     * 删除影院图片
     * 
     * @param id 影院图片ID
     * @return 结果
     */
	public int deleteCinemaPicById(Long id);
	
	/**
     * 批量删除影院图片
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCinemaPicByIds(String[] ids);


	/**
	 *功能描述  根据影院id查询影院图片
	 *@Author  zhangpl
	 *@Date 2018/9/10 16:47
	 * @param  * @param cId
	 * @return java.util.List<com.ruoyi.project.module.cinemaPic.domain.CinemaPic>
	 */
	List<CinemaPic> listByCid(Long cId);
	
}