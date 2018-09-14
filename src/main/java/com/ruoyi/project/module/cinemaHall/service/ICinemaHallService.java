package com.ruoyi.project.module.cinemaHall.service;

import com.ruoyi.project.module.cinemaHall.domain.CinemaHall;
import java.util.List;

/**
 * 影院影厅 服务层
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
public interface ICinemaHallService 
{
	/**
     * 查询影院影厅信息
     * 
     * @param id 影院影厅ID
     * @return 影院影厅信息
     */
	public CinemaHall selectCinemaHallById(Long id);
	
	/**
     * 查询影院影厅列表
     * 
     * @param cinemaHall 影院影厅信息
     * @return 影院影厅集合
     */
	public List<CinemaHall> selectCinemaHallList(CinemaHall cinemaHall);
	
	/**
     * 新增影院影厅
     * 
     * @param cinemaHall 影院影厅信息
     * @return 结果
     */
	public int insertCinemaHall(CinemaHall cinemaHall);
	
	/**
     * 修改影院影厅
     * 
     * @param cinemaHall 影院影厅信息
     * @return 结果
     */
	public int updateCinemaHall(CinemaHall cinemaHall);
		
	/**
     * 删除影院影厅信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCinemaHallByIds(String ids);
	
}
