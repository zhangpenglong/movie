package com.ruoyi.project.module.cinema.mapper;

import com.ruoyi.project.module.cinema.domain.Cinema;
import java.util.List;	

/**
 * 电影院 数据层
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
public interface CinemaMapper 
{
	/**
     * 查询电影院信息
     * 
     * @param id 电影院ID
     * @return 电影院信息
     */
	public Cinema selectCinemaById(Long id);
	
	/**
     * 查询电影院列表
     * 
     * @param cinema 电影院信息
     * @return 电影院集合
     */
	public List<Cinema> selectCinemaList(Cinema cinema);
	
	/**
     * 新增电影院
     * 
     * @param cinema 电影院信息
     * @return 结果
     */
	public int insertCinema(Cinema cinema);
	
	/**
     * 修改电影院
     * 
     * @param cinema 电影院信息
     * @return 结果
     */
	public int updateCinema(Cinema cinema);
	
	/**
     * 删除电影院
     * 
     * @param id 电影院ID
     * @return 结果
     */
	public int deleteCinemaById(Long id);
	
	/**
     * 批量删除电影院
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCinemaByIds(String[] ids);


	/**
	 *功能描述  查詢所以影院
	 *@Author  zhangpl
	 *@Date 2018/9/11 16:16
	 * @param  * @param
	 * @return java.util.List<com.ruoyi.project.module.cinema.domain.Cinema>
	 */
	public List<Cinema> listAll();
}