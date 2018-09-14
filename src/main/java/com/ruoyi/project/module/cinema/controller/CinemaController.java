package com.ruoyi.project.module.cinema.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.module.cinema.domain.Cinema;
import com.ruoyi.project.module.cinema.service.ICinemaService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 电影院 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
@Controller
@RequestMapping("/module/cinema")
public class CinemaController extends BaseController
{
    private String prefix = "module/cinema";
	
	@Autowired
	private ICinemaService cinemaService;
	
	@RequiresPermissions("module:cinema:view")
	@GetMapping()
	public String cinema()
	{
	    return prefix + "/cinema";
	}
	
	/**
	 * 查询电影院列表
	 */
	@RequiresPermissions("module:cinema:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Cinema cinema)
	{
		startPage();
        List<Cinema> list = cinemaService.selectCinemaList(cinema);
		return getDataTable(list);
	}
	
	/**
	 * 新增电影院
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存电影院
	 */
	@RequiresPermissions("module:cinema:add")
	@Log(title = "电影院", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Cinema cinema)
	{
		cinema.setCreateUser(String.valueOf(getUserId()));
		return toAjax(cinemaService.insertCinema(cinema));
	}

	/**
	 * 修改电影院
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		Cinema cinema = cinemaService.selectCinemaById(id);
		mmap.put("cinema", cinema);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存电影院
	 */
	@RequiresPermissions("module:cinema:edit")
	@Log(title = "电影院", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Cinema cinema)
	{
		cinema.setUpdateUser(String.valueOf(getUserId()));
		return toAjax(cinemaService.updateCinema(cinema));
	}
	
	/**
	 * 删除电影院
	 */
	@RequiresPermissions("module:cinema:remove")
	@Log(title = "电影院", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(cinemaService.deleteCinemaByIds(ids));
	}

}
