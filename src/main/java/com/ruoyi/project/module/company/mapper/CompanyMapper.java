package com.ruoyi.project.module.company.mapper;

import com.ruoyi.project.module.company.domain.Company;
import java.util.List;	

/**
 * 合作公司 数据层
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
public interface CompanyMapper 
{
	/**
     * 查询合作公司信息
     * 
     * @param id 合作公司ID
     * @return 合作公司信息
     */
	public Company selectCompanyById(Integer id);
	
	/**
     * 查询合作公司列表
     * 
     * @param company 合作公司信息
     * @return 合作公司集合
     */
	public List<Company> selectCompanyList(Company company);
	
	/**
     * 新增合作公司
     * 
     * @param company 合作公司信息
     * @return 结果
     */
	public int insertCompany(Company company);
	
	/**
     * 修改合作公司
     * 
     * @param company 合作公司信息
     * @return 结果
     */
	public int updateCompany(Company company);
	
	/**
     * 删除合作公司
     * 
     * @param id 合作公司ID
     * @return 结果
     */
	public int deleteCompanyById(Integer id);
	
	/**
     * 批量删除合作公司
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCompanyByIds(String[] ids);
	
}