package com.ruoyi.project.module.film.mapper;

import com.ruoyi.project.module.film.domain.Film;
import java.util.List;	

/**
 * 影片 数据层
 * 
 * @author ruoyi
 * @date 2018-09-16
 */
public interface FilmMapper 
{
	/**
     * 查询影片信息
     * 
     * @param id 影片ID
     * @return 影片信息
     */
	public Film selectFilmById(Long id);
	
	/**
     * 查询影片列表
     * 
     * @param film 影片信息
     * @return 影片集合
     */
	public List<Film> selectFilmList(Film film);
	
	/**
     * 新增影片
     * 
     * @param film 影片信息
     * @return 结果
     */
	public int insertFilm(Film film);
	
	/**
     * 修改影片
     * 
     * @param film 影片信息
     * @return 结果
     */
	public int updateFilm(Film film);
	
	/**
     * 删除影片
     * 
     * @param id 影片ID
     * @return 结果
     */
	public int deleteFilmById(Long id);
	
	/**
     * 批量删除影片
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFilmByIds(String[] ids);
	
}