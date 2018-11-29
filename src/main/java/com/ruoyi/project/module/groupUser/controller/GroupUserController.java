package com.ruoyi.project.module.groupUser.controller;

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
import com.ruoyi.project.module.groupUser.domain.GroupUser;
import com.ruoyi.project.module.groupUser.service.IGroupUserService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 群组-用户 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
@Controller
@RequestMapping("/module/groupUser")
public class GroupUserController extends BaseController
{
    private String prefix = "module/groupUser";
	
	@Autowired
	private IGroupUserService groupUserService;
	
	@RequiresPermissions("module:groupUser:view")
	@GetMapping()
	public String groupUser()
	{
	    return prefix + "/groupUser";
	}
	
	/**
	 * 查询群组-用户列表
	 */
	@RequiresPermissions("module:groupUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(GroupUser groupUser)
	{
		startPage();
        List<GroupUser> list = groupUserService.selectGroupUserList(groupUser);
		return getDataTable(list);
	}
	
	/**
	 * 新增群组-用户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存群组-用户
	 */
	@RequiresPermissions("module:groupUser:add")
	@Log(title = "群组-用户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(GroupUser groupUser)
	{		
		return toAjax(groupUserService.insertGroupUser(groupUser));
	}

	/**
	 * 修改群组-用户
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		GroupUser groupUser = groupUserService.selectGroupUserById(id);
		mmap.put("groupUser", groupUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存群组-用户
	 */
	@RequiresPermissions("module:groupUser:edit")
	@Log(title = "群组-用户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(GroupUser groupUser)
	{		
		return toAjax(groupUserService.updateGroupUser(groupUser));
	}
	
	/**
	 * 删除群组-用户
	 */
	@RequiresPermissions("module:groupUser:remove")
	@Log(title = "群组-用户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(groupUserService.deleteGroupUserByIds(ids));
	}
	
}
