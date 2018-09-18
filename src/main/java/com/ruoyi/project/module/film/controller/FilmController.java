package com.ruoyi.project.module.film.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.module.film.domain.Film;
import com.ruoyi.project.module.film.service.IFilmService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 影片 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-09-16
 */
@Controller
@RequestMapping("/module/film")
public class FilmController extends BaseController
{
    private String prefix = "module/film";
	
	@Autowired
	private IFilmService filmService;
	
	@RequiresPermissions("module:film:view")
	@GetMapping()
	public String film()
	{
	    return prefix + "/film";
	}
	
	/**
	 * 查询影片列表
	 */
	@RequiresPermissions("module:film:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Film film)
	{
		startPage();
        List<Film> list = filmService.selectFilmList(film);
		return getDataTable(list);
	}
	
	/**
	 * 新增影片
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存影片
	 */
	@RequiresPermissions("module:film:add")
	@Log(title = "影片", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Film film)
	{		
		return toAjax(filmService.insertFilm(film));
	}

	/**
	 * 修改影片
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		Film film = filmService.selectFilmById(id);
		if(!StringUtils.isEmpty(film.getLabel())){
			film.setLableArr(film.getLabel().split(","));
		}
		mmap.put("film", film);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存影片
	 */
	@RequiresPermissions("module:film:edit")
	@Log(title = "影片", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Film film)
	{		
		return toAjax(filmService.updateFilm(film));
	}
	
	/**
	 * 删除影片
	 */
	@RequiresPermissions("module:film:remove")
	@Log(title = "影片", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(filmService.deleteFilmByIds(ids));
	}


	/**
	 *功能描述  上传影片图片
	 *@Author  zhangpl
	 *@Date 2018/9/11 11:25
	 * @param  * @param file
	 * @return com.ruoyi.framework.web.domain.AjaxResult
	 */
	@PostMapping("/uploadPic")
	@ResponseBody
	public AjaxResult uploadPic(MultipartFile file){
		try{
			if (!file.isEmpty()){

				Date date = new Date();
				Calendar calendar = Calendar.getInstance();
				String da = calendar.get(Calendar.YEAR) +""+ calendar.get(Calendar.MONTH) + "" + calendar.get(Calendar.DAY_OF_MONTH);
				String cinemaPic = RuoYiConfig.getProfile() + "filmPic/"+da+"/";
				String avatar = FileUploadUtils.upload(cinemaPic,file);
				return success(RuoYiConfig.getProfileHost()+ "cinemaPic/"+da+"/"+avatar);
			}
			return error();
		}
		catch (Exception e){
			return error(e.getMessage());
		}
	}


	
}
