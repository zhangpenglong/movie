package com.ruoyi.project.module.company.controller;

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
import com.ruoyi.project.module.company.domain.Company;
import com.ruoyi.project.module.company.service.ICompanyService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 合作公司 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
@Controller
@RequestMapping("/module/company")
public class CompanyController extends BaseController
{
    private String prefix = "module/company";
	
	@Autowired
	private ICompanyService companyService;
	
	@RequiresPermissions("module:company:view")
	@GetMapping()
	public String company()
	{
	    return prefix + "/company";
	}
	
	/**
	 * 查询合作公司列表
	 */
	@RequiresPermissions("module:company:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Company company)
	{
		startPage();
        List<Company> list = companyService.selectCompanyList(company);
		return getDataTable(list);
	}
	
	/**
	 * 新增合作公司
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存合作公司
	 */
	@RequiresPermissions("module:company:add")
	@Log(title = "合作公司", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Company company)
	{		
		return toAjax(companyService.insertCompany(company));
	}

	/**
	 * 修改合作公司
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Company company = companyService.selectCompanyById(id);
		mmap.put("company", company);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存合作公司
	 */
	@RequiresPermissions("module:company:edit")
	@Log(title = "合作公司", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Company company)
	{		
		return toAjax(companyService.updateCompany(company));
	}
	
	/**
	 * 删除合作公司
	 */
	@RequiresPermissions("module:company:remove")
	@Log(title = "合作公司", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(companyService.deleteCompanyByIds(ids));
	}
	
}
