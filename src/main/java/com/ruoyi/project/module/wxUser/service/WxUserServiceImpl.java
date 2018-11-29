package com.ruoyi.project.module.wxUser.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.wxUser.mapper.WxUserMapper;
import com.ruoyi.project.module.wxUser.domain.WxUser;
import com.ruoyi.project.module.wxUser.service.IWxUserService;
import com.ruoyi.common.support.Convert;

/**
 * 小程序用户 服务层实现
 * 
 * @author ruoyi
 * @date 2018-11-26
 */
@Service
public class WxUserServiceImpl implements IWxUserService 
{
	@Autowired
	private WxUserMapper wxUserMapper;

	/**
     * 查询小程序用户信息
     * 
     * @param id 小程序用户ID
     * @return 小程序用户信息
     */
    @Override
	public WxUser selectWxUserById(Integer id)
	{
	    return wxUserMapper.selectWxUserById(id);
	}
	
	/**
     * 查询小程序用户列表
     * 
     * @param wxUser 小程序用户信息
     * @return 小程序用户集合
     */
	@Override
	public List<WxUser> selectWxUserList(WxUser wxUser)
	{
	    return wxUserMapper.selectWxUserList(wxUser);
	}
	
    /**
     * 新增小程序用户
     * 
     * @param wxUser 小程序用户信息
     * @return 结果
     */
	@Override
	public int insertWxUser(WxUser wxUser)
	{
	    return wxUserMapper.insertWxUser(wxUser);
	}
	
	/**
     * 修改小程序用户
     * 
     * @param wxUser 小程序用户信息
     * @return 结果
     */
	@Override
	public int updateWxUser(WxUser wxUser)
	{
	    return wxUserMapper.updateWxUser(wxUser);
	}

	/**
     * 删除小程序用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteWxUserByIds(String ids)
	{
		return wxUserMapper.deleteWxUserByIds(Convert.toStrArray(ids));
	}

	@Override
	public WxUser queryByOpenId(String openId) {
		return wxUserMapper.queryByOpenId(openId);
	}
}
