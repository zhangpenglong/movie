package com.ruoyi.project.module.userBirthday.controller;

import java.util.List;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
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
import com.ruoyi.project.module.userBirthday.domain.UserBirthday;
import com.ruoyi.project.module.userBirthday.service.IUserBirthdayService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 用户生日 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
@Controller
@RequestMapping("/module/userBirthday")
public class UserBirthdayController extends BaseController
{
    private String prefix = "module/userBirthday";
	
	@Autowired
	private IUserBirthdayService userBirthdayService;
	
	@RequiresPermissions("module:userBirthday:view")
	@GetMapping()
	public String userBirthday()
	{
	    return prefix + "/userBirthday";
	}
	
	/**
	 * 查询用户生日列表
	 */
	@RequiresPermissions("module:userBirthday:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(UserBirthday userBirthday)
	{
		startPage();
        List<UserBirthday> list = userBirthdayService.selectUserBirthdayList(userBirthday);
		return getDataTable(list);
	}
	
	/**
	 * 新增用户生日
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户生日
	 */
	@RequiresPermissions("module:userBirthday:add")
	@Log(title = "用户生日", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(){
		UserBirthday userBirthday = getJsonRequest(UserBirthday.class);
		return toAjax(userBirthdayService.insertUserBirthday(userBirthday));
	}

	/**
	 * 修改用户生日
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		UserBirthday userBirthday = userBirthdayService.selectUserBirthdayById(id);
		mmap.put("userBirthday", userBirthday);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户生日
	 */
	@RequiresPermissions("module:userBirthday:edit")
	@Log(title = "用户生日", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(UserBirthday userBirthday)
	{		
		return toAjax(userBirthdayService.updateUserBirthday(userBirthday));
	}
	
	/**
	 * 删除用户生日
	 */
	@RequiresPermissions("module:userBirthday:remove")
	@Log(title = "用户生日", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(userBirthdayService.deleteUserBirthdayByIds(ids));
	}
	
}
