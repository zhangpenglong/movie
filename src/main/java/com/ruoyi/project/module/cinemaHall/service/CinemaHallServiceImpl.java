package com.ruoyi.project.module.cinemaHall.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.cinemaHall.mapper.CinemaHallMapper;
import com.ruoyi.project.module.cinemaHall.domain.CinemaHall;
import com.ruoyi.project.module.cinemaHall.service.ICinemaHallService;
import com.ruoyi.common.support.Convert;

/**
 * 影院影厅 服务层实现
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
@Service
public class CinemaHallServiceImpl implements ICinemaHallService 
{
	@Autowired
	private CinemaHallMapper cinemaHallMapper;

	/**
     * 查询影院影厅信息
     * 
     * @param id 影院影厅ID
     * @return 影院影厅信息
     */
    @Override
	public CinemaHall selectCinemaHallById(Long id)
	{
	    return cinemaHallMapper.selectCinemaHallById(id);
	}
	
	/**
     * 查询影院影厅列表
     * 
     * @param cinemaHall 影院影厅信息
     * @return 影院影厅集合
     */
	@Override
	public List<CinemaHall> selectCinemaHallList(CinemaHall cinemaHall)
	{
	    return cinemaHallMapper.selectCinemaHallList(cinemaHall);
	}
	
    /**
     * 新增影院影厅
     * 
     * @param cinemaHall 影院影厅信息
     * @return 结果
     */
	@Override
	public int insertCinemaHall(CinemaHall cinemaHall)
	{
	    return cinemaHallMapper.insertCinemaHall(cinemaHall);
	}
	
	/**
     * 修改影院影厅
     * 
     * @param cinemaHall 影院影厅信息
     * @return 结果
     */
	@Override
	public int updateCinemaHall(CinemaHall cinemaHall)
	{
	    return cinemaHallMapper.updateCinemaHall(cinemaHall);
	}

	/**
     * 删除影院影厅对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCinemaHallByIds(String ids)
	{
		return cinemaHallMapper.deleteCinemaHallByIds(Convert.toStrArray(ids));
	}
	
}
