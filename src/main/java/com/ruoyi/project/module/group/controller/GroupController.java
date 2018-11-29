package com.ruoyi.project.module.group.controller;

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
import com.ruoyi.project.module.group.domain.Group;
import com.ruoyi.project.module.group.service.IGroupService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 生日群 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
@Controller
@RequestMapping("/module/group")
public class GroupController extends BaseController
{
    private String prefix = "module/group";
	
	@Autowired
	private IGroupService groupService;
	
	@RequiresPermissions("module:group:view")
	@GetMapping()
	public String group()
	{
	    return prefix + "/group";
	}
	
	/**
	 * 查询生日群列表
	 */
	@RequiresPermissions("module:group:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Group group)
	{
		startPage();
        List<Group> list = groupService.selectGroupList(group);
		return getDataTable(list);
	}
	
	/**
	 * 新增生日群
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存生日群
	 */
	@RequiresPermissions("module:group:add")
	@Log(title = "生日群", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Group group)
	{		
		return toAjax(groupService.insertGroup(group));
	}

	/**
	 * 修改生日群
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		Group group = groupService.selectGroupById(id);
		mmap.put("group", group);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存生日群
	 */
	@RequiresPermissions("module:group:edit")
	@Log(title = "生日群", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Group group)
	{		
		return toAjax(groupService.updateGroup(group));
	}
	
	/**
	 * 删除生日群
	 */
	@RequiresPermissions("module:group:remove")
	@Log(title = "生日群", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(groupService.deleteGroupByIds(ids));
	}
	
}
