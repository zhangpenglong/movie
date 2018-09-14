package com.ruoyi.project.module.company.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.company.mapper.CompanyMapper;
import com.ruoyi.project.module.company.domain.Company;
import com.ruoyi.project.module.company.service.ICompanyService;
import com.ruoyi.common.support.Convert;

/**
 * 合作公司 服务层实现
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
@Service
public class CompanyServiceImpl implements ICompanyService 
{
	@Autowired
	private CompanyMapper companyMapper;

	/**
     * 查询合作公司信息
     * 
     * @param id 合作公司ID
     * @return 合作公司信息
     */
    @Override
	public Company selectCompanyById(Integer id)
	{
	    return companyMapper.selectCompanyById(id);
	}
	
	/**
     * 查询合作公司列表
     * 
     * @param company 合作公司信息
     * @return 合作公司集合
     */
	@Override
	public List<Company> selectCompanyList(Company company)
	{
	    return companyMapper.selectCompanyList(company);
	}
	
    /**
     * 新增合作公司
     * 
     * @param company 合作公司信息
     * @return 结果
     */
	@Override
	public int insertCompany(Company company)
	{
	    return companyMapper.insertCompany(company);
	}
	
	/**
     * 修改合作公司
     * 
     * @param company 合作公司信息
     * @return 结果
     */
	@Override
	public int updateCompany(Company company)
	{
	    return companyMapper.updateCompany(company);
	}

	/**
     * 删除合作公司对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCompanyByIds(String ids)
	{
		return companyMapper.deleteCompanyByIds(Convert.toStrArray(ids));
	}
	
}
