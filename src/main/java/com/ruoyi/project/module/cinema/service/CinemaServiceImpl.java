package com.ruoyi.project.module.cinema.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.cinema.mapper.CinemaMapper;
import com.ruoyi.project.module.cinema.domain.Cinema;
import com.ruoyi.project.module.cinema.service.ICinemaService;
import com.ruoyi.common.support.Convert;

/**
 * 电影院 服务层实现
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
@Service
public class CinemaServiceImpl implements ICinemaService 
{
	@Autowired
	private CinemaMapper cinemaMapper;

	/**
     * 查询电影院信息
     * 
     * @param id 电影院ID
     * @return 电影院信息
     */
    @Override
	public Cinema selectCinemaById(Long id)
	{
	    return cinemaMapper.selectCinemaById(id);
	}
	
	/**
     * 查询电影院列表
     * 
     * @param cinema 电影院信息
     * @return 电影院集合
     */
	@Override
	public List<Cinema> selectCinemaList(Cinema cinema)
	{
	    return cinemaMapper.selectCinemaList(cinema);
	}
	
    /**
     * 新增电影院
     * 
     * @param cinema 电影院信息
     * @return 结果
     */
	@Override
	public int insertCinema(Cinema cinema)
	{
		cinema.setIsValid(1);
	    return cinemaMapper.insertCinema(cinema);
	}
	
	/**
     * 修改电影院
     * 
     * @param cinema 电影院信息
     * @return 结果
     */
	@Override
	public int updateCinema(Cinema cinema)
	{
	    return cinemaMapper.updateCinema(cinema);
	}

	/**
     * 删除电影院对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCinemaByIds(String ids)
	{
		return cinemaMapper.deleteCinemaByIds(Convert.toStrArray(ids));
	}


	/**
	 *功能描述  查詢所以影院
	 *@Author  zhangpl
	 *@Date 2018/9/11 16:16
	 * @param  * @param
	 * @return java.util.List<com.ruoyi.project.module.cinema.domain.Cinema>
	 */
	@Override
	public  List<Cinema> listAll(){
		return cinemaMapper.listAll();
	}
	
}
