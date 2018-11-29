package com.ruoyi.project.module.token.controller;

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
import com.ruoyi.project.module.token.domain.Token;
import com.ruoyi.project.module.token.service.ITokenService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 用户Token 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
@Controller
@RequestMapping("/module/token")
public class TokenController extends BaseController
{
    private String prefix = "module/token";
	
	@Autowired
	private ITokenService tokenService;
	
	@RequiresPermissions("module:token:view")
	@GetMapping()
	public String token()
	{
	    return prefix + "/token";
	}
	
	/**
	 * 查询用户Token列表
	 */
	@RequiresPermissions("module:token:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Token token)
	{
		startPage();
        List<Token> list = tokenService.selectTokenList(token);
		return getDataTable(list);
	}
	
	/**
	 * 新增用户Token
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户Token
	 */
	@RequiresPermissions("module:token:add")
	@Log(title = "用户Token", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Token token)
	{		
		return toAjax(tokenService.insertToken(token));
	}

	/**
	 * 修改用户Token
	 */
	@GetMapping("/edit/{userId}")
	public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
	{
		Token token = tokenService.selectTokenById(userId);
		mmap.put("token", token);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户Token
	 */
	@RequiresPermissions("module:token:edit")
	@Log(title = "用户Token", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Token token)
	{		
		return toAjax(tokenService.updateToken(token));
	}
	
	/**
	 * 删除用户Token
	 */
	@RequiresPermissions("module:token:remove")
	@Log(title = "用户Token", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tokenService.deleteTokenByIds(ids));
	}
	
}
