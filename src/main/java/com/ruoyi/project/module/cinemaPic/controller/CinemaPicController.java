package com.ruoyi.project.module.cinemaPic.controller;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.module.cinemaPicType.domain.CinemaPicType;
import com.ruoyi.project.module.cinemaPicType.service.ICinemaPicTypeService;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.module.cinemaPic.domain.CinemaPic;
import com.ruoyi.project.module.cinemaPic.service.ICinemaPicService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 影院图片 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
@Controller
@RequestMapping("/module/cinemaPic")
public class CinemaPicController extends BaseController
{
    private String prefix = "module/cinemaPic";
	
	@Autowired
	private ICinemaPicService cinemaPicService;
	@Autowired
	private ICinemaPicTypeService cinemaPicTypeService;
	
	@RequiresPermissions("module:cinemaPic:view")
	@GetMapping()
	public String cinemaPic(@RequestParam(value = "cId")Long cId, ModelMap mmap)
	{
		List<CinemaPicType> cinemaPicTypes = cinemaPicTypeService.listAll();
		mmap.put("cinemaPicTypeList",cinemaPicTypes);
		mmap.put("cId",cId);
		return prefix + "/cinemaPic";
	}
	
	/**
	 * 查询影院图片列表
	 */
	@RequiresPermissions("module:cinemaPic:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CinemaPic cinemaPic)
	{
		startPage();
        List<CinemaPic> list = cinemaPicService.selectCinemaPicList(cinemaPic);
		return getDataTable(list);
	}
	
	/**
	 * 新增影院图片
	 */
	@GetMapping("/add")
	public String add( @RequestParam(value = "cId")Long cId, ModelMap mmap)
	{
		List<CinemaPicType> cinemaPicTypes = cinemaPicTypeService.listAll();
		mmap.put("cinemaPicTypeList",cinemaPicTypes);
		mmap.put("cId",cId);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存影院图片
	 */
	@RequiresPermissions("module:cinemaPic:add")
	@Log(title = "影院图片", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CinemaPic cinemaPic)
	{
		String picUrl = cinemaPic.getPicUrl();
		if(StringUtils.isEmpty(picUrl)){
			return error("参数为空");
		}else{
			String[] split = picUrl.split(";");
			for(String pic : split){
				CinemaPic cinemaPicTemp = new CinemaPic();
				cinemaPicTemp.setPicType(cinemaPic.getPicType());
				cinemaPicTemp.setSequence(cinemaPic.getSequence());
				cinemaPicTemp.setCinemaId(cinemaPic.getCinemaId());
				cinemaPicTemp.setPicUrl(pic);
				cinemaPicTemp.setCreateUser(getUserId().toString());
				cinemaPicService.insertCinemaPic(cinemaPicTemp);
			}
			return success();
		}
	}

	/**
	 * 修改影院图片
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		List<CinemaPicType> cinemaPicTypes = cinemaPicTypeService.listAll();
		mmap.put("cinemaPicTypeList",cinemaPicTypes);
		CinemaPic cinemaPic = cinemaPicService.selectCinemaPicById(id);
		mmap.put("cinemaPic", cinemaPic);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存影院图片
	 */
	@RequiresPermissions("module:cinemaPic:edit")
	@Log(title = "影院图片", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CinemaPic cinemaPic)
	{		
		return toAjax(cinemaPicService.updateCinemaPic(cinemaPic));
	}
	
	/**
	 * 删除影院图片
	 */
	@RequiresPermissions("module:cinemaPic:remove")
	@Log(title = "影院图片", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(cinemaPicService.deleteCinemaPicByIds(ids));
	}



	/**
	*功能描述  上传影院图片
	*@Author  zhangpl
	*@Date 2018/9/11 11:25
	* @param  * @param file
	* @return com.ruoyi.framework.web.domain.AjaxResult
	*/
	@PostMapping("/uploadPic")
	@ResponseBody
	public AjaxResult uploadPic(MultipartFile file,@RequestParam(value = "cId")Long cId){
		try{
			if (!file.isEmpty()){

				String cinemaPic = RuoYiConfig.getProfile() + "cinemaPic/"+cId+"/";
				String avatar = FileUploadUtils.upload(cinemaPic,file);
				return success(RuoYiConfig.getProfileHost()+ "cinemaPic/"+cId+"/"+avatar);
			}
			return error();
		}
		catch (Exception e){
			return error(e.getMessage());
		}
	}


}
