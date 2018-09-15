package com.ruoyi.project.module.cinemaHall.controller;

import java.util.List;

import com.ruoyi.project.module.cinema.domain.Cinema;
import com.ruoyi.project.module.cinema.service.ICinemaService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.module.cinemaHall.domain.CinemaHall;
import com.ruoyi.project.module.cinemaHall.service.ICinemaHallService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 影院影厅 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
@Controller
@RequestMapping("/module/cinemaHall")
public class CinemaHallController extends BaseController
{
    private String prefix = "module/cinemaHall";
	
	@Autowired
	private ICinemaHallService cinemaHallService;
	@Autowired
	private ICinemaService cinemaService;
	
	@RequiresPermissions("module:cinemaHall:view")
	@GetMapping()
	public String cinemaHall(ModelMap map)
	{
		List<Cinema> cinemas = cinemaService.listAll();
		map.put("cinemaList",cinemas);
		return prefix + "/cinemaHall";
	}
	
	/**
	 * 查询影院影厅列表
	 */
	@RequiresPermissions("module:cinemaHall:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CinemaHall cinemaHall)
	{
		startPage();
        List<CinemaHall> list = cinemaHallService.selectCinemaHallList(cinemaHall);
		return getDataTable(list);
	}
	
	/**
	 * 新增影院影厅
	 */
	@GetMapping("/add")
	public String add(ModelMap map)
	{
		List<Cinema> cinemas = cinemaService.listAll();
		map.put("cinemaList",cinemas);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存影院影厅
	 */
	@RequiresPermissions("module:cinemaHall:add")
	@Log(title = "影院影厅", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CinemaHall cinemaHall)
	{		
		return toAjax(cinemaHallService.insertCinemaHall(cinemaHall));
	}

	/**
	 * 修改影院影厅
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		List<Cinema> cinemas = cinemaService.listAll();
		mmap.put("cinemaList",cinemas);
		CinemaHall cinemaHall = cinemaHallService.selectCinemaHallById(id);
		mmap.put("cinemaHall", cinemaHall);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存影院影厅
	 */
	@RequiresPermissions("module:cinemaHall:edit")
	@Log(title = "影院影厅", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CinemaHall cinemaHall)
	{		
		return toAjax(cinemaHallService.updateCinemaHall(cinemaHall));
	}
	
	/**
	 * 删除影院影厅
	 */
	@RequiresPermissions("module:cinemaHall:remove")
	@Log(title = "影院影厅", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(cinemaHallService.deleteCinemaHallByIds(ids));
	}


	@RequiresPermissions("module:cinemaHall:view")
	@GetMapping("/seatList")
	public String seatList(ModelMap map, @RequestParam("id")Long id){
		CinemaHall cinemaHall = cinemaHallService.selectCinemaHallById(id);
		if(null == cinemaHall){
			return "error/500";
		}
		map.put("seat",cinemaHall.getSeatRule());
		map.put("countRow",cinemaHall.getRowNumber());
		map.put("id",id);
		return prefix + "/seatList";
	}




	/**
	 * 修改保存影院影厅
	 */
	@RequiresPermissions("module:cinemaHall:edit")
	@Log(title = "修改座位", businessType = BusinessType.UPDATE)
	@PostMapping("/inseartSeat")
	@ResponseBody
	public AjaxResult inseartSeat(CinemaHall cinemaHall){

		return toAjax(cinemaHallService.updateCinemaHall(cinemaHall));
	}




}
