package com.ruoyi.project.module.wxUser.controller;

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
import com.ruoyi.project.module.wxUser.domain.WxUser;
import com.ruoyi.project.module.wxUser.service.IWxUserService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 小程序用户 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-11-26
 */
@Controller
@RequestMapping("/module/wxUser")
public class WxUserController extends BaseController
{
    private String prefix = "module/wxUser";
	
	@Autowired
	private IWxUserService wxUserService;
	
	@RequiresPermissions("module:wxUser:view")
	@GetMapping()
	public String wxUser()
	{
	    return prefix + "/wxUser";
	}
	
	/**
	 * 查询小程序用户列表
	 */
	@RequiresPermissions("module:wxUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(WxUser wxUser)
	{
		startPage();
        List<WxUser> list = wxUserService.selectWxUserList(wxUser);
		return getDataTable(list);
	}
	
	/**
	 * 新增小程序用户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存小程序用户
	 */
	@RequiresPermissions("module:wxUser:add")
	@Log(title = "小程序用户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(WxUser wxUser)
	{		
		return toAjax(wxUserService.insertWxUser(wxUser));
	}

	/**
	 * 修改小程序用户
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		WxUser wxUser = wxUserService.selectWxUserById(id);
		mmap.put("wxUser", wxUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存小程序用户
	 */
	@RequiresPermissions("module:wxUser:edit")
	@Log(title = "小程序用户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(WxUser wxUser)
	{		
		return toAjax(wxUserService.updateWxUser(wxUser));
	}
	
	/**
	 * 删除小程序用户
	 */
	@RequiresPermissions("module:wxUser:remove")
	@Log(title = "小程序用户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(wxUserService.deleteWxUserByIds(ids));
	}
	
}
