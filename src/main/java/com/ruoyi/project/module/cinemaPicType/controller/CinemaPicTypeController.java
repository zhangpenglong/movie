package com.ruoyi.project.module.cinemaPicType.controller;

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
import com.ruoyi.project.module.cinemaPicType.domain.CinemaPicType;
import com.ruoyi.project.module.cinemaPicType.service.ICinemaPicTypeService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 图片类型 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
@Controller
@RequestMapping("/module/cinemaPicType")
public class CinemaPicTypeController extends BaseController
{
    private String prefix = "module/cinemaPicType";
	
	@Autowired
	private ICinemaPicTypeService cinemaPicTypeService;
	
	@RequiresPermissions("module:cinemaPicType:view")
	@GetMapping()
	public String cinemaPicType()
	{
	    return prefix + "/cinemaPicType";
	}
	
	/**
	 * 查询图片类型列表
	 */
	@RequiresPermissions("module:cinemaPicType:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CinemaPicType cinemaPicType)
	{
		startPage();
        List<CinemaPicType> list = cinemaPicTypeService.selectCinemaPicTypeList(cinemaPicType);
		return getDataTable(list);
	}
	
	/**
	 * 新增图片类型
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存图片类型
	 */
	@RequiresPermissions("module:cinemaPicType:add")
	@Log(title = "图片类型", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CinemaPicType cinemaPicType)
	{		
		return toAjax(cinemaPicTypeService.insertCinemaPicType(cinemaPicType));
	}

	/**
	 * 修改图片类型
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		CinemaPicType cinemaPicType = cinemaPicTypeService.selectCinemaPicTypeById(id);
		mmap.put("cinemaPicType", cinemaPicType);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存图片类型
	 */
	@RequiresPermissions("module:cinemaPicType:edit")
	@Log(title = "图片类型", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CinemaPicType cinemaPicType)
	{		
		return toAjax(cinemaPicTypeService.updateCinemaPicType(cinemaPicType));
	}
	
	/**
	 * 删除图片类型
	 */
	@RequiresPermissions("module:cinemaPicType:remove")
	@Log(title = "图片类型", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(cinemaPicTypeService.deleteCinemaPicTypeByIds(ids));
	}
	
}
