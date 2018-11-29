package com.ruoyi.project.module.film.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.film.mapper.FilmMapper;
import com.ruoyi.project.module.film.domain.Film;
import com.ruoyi.project.module.film.service.IFilmService;
import com.ruoyi.common.support.Convert;

/**
 * 影片 服务层实现
 * 
 * @author ruoyi
 * @date 2018-09-16
 */
@Service
public class FilmServiceImpl implements IFilmService 
{
	@Autowired
	private FilmMapper filmMapper;

	/**
     * 查询影片信息
     * 
     * @param id 影片ID
     * @return 影片信息
     */
    @Override
	public Film selectFilmById(Long id)
	{
	    return filmMapper.selectFilmById(id);
	}
	
	/**
     * 查询影片列表
     * 
     * @param film 影片信息
     * @return 影片集合
     */
	@Override
	public List<Film> selectFilmList(Film film)
	{
	    return filmMapper.selectFilmList(film);
	}
	
    /**
     * 新增影片
     * 
     * @param film 影片信息
     * @return 结果
     */
	@Override
	public int insertFilm(Film film)
	{
	    return filmMapper.insertFilm(film);
	}
	
	/**
     * 修改影片
     * 
     * @param film 影片信息
     * @return 结果
     */
	@Override
	public int updateFilm(Film film)
	{
	    return filmMapper.updateFilm(film);
	}

	/**
     * 删除影片对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFilmByIds(String ids)
	{
		return filmMapper.deleteFilmByIds(Convert.toStrArray(ids));
	}
	
}
