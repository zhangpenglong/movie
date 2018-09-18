package com.ruoyi.project.module.perforer.controller;

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
import com.ruoyi.project.module.perforer.domain.Perforer;
import com.ruoyi.project.module.perforer.service.IPerforerService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 演员 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-09-16
 */
@Controller
@RequestMapping("/module/perforer")
public class PerforerController extends BaseController
{
    private String prefix = "module/perforer";
	
	@Autowired
	private IPerforerService perforerService;
	
	@RequiresPermissions("module:perforer:view")
	@GetMapping()
	public String perforer()
	{
	    return prefix + "/perforer";
	}
	
	/**
	 * 查询演员列表
	 */
	@RequiresPermissions("module:perforer:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Perforer perforer)
	{
		startPage();
        List<Perforer> list = perforerService.selectPerforerList(perforer);
		return getDataTable(list);
	}
	
	/**
	 * 新增演员
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存演员
	 */
	@RequiresPermissions("module:perforer:add")
	@Log(title = "演员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Perforer perforer)
	{		
		return toAjax(perforerService.insertPerforer(perforer));
	}

	/**
	 * 修改演员
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		Perforer perforer = perforerService.selectPerforerById(id);
		mmap.put("perforer", perforer);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存演员
	 */
	@RequiresPermissions("module:perforer:edit")
	@Log(title = "演员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Perforer perforer)
	{		
		return toAjax(perforerService.updatePerforer(perforer));
	}
	
	/**
	 * 删除演员
	 */
	@RequiresPermissions("module:perforer:remove")
	@Log(title = "演员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(perforerService.deletePerforerByIds(ids));
	}
	
}
