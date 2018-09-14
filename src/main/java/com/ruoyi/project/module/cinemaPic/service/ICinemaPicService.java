package com.ruoyi.project.module.cinemaPic.service;

import com.ruoyi.project.module.cinemaPic.domain.CinemaPic;
import java.util.List;

/**
 * 影院图片 服务层
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
public interface ICinemaPicService 
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
     * 删除影院图片信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCinemaPicByIds(String ids);

	List<CinemaPic> listByCid(Long cId);
	
}
