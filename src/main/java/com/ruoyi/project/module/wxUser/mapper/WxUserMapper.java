package com.ruoyi.project.module.wxUser.mapper;

import com.ruoyi.project.module.wxUser.domain.WxUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 小程序用户 数据层
 * 
 * @author ruoyi
 * @date 2018-11-26
 */
public interface WxUserMapper 
{
	/**
     * 查询小程序用户信息
     * 
     * @param id 小程序用户ID
     * @return 小程序用户信息
     */
	public WxUser selectWxUserById(Integer id);
	
	/**
     * 查询小程序用户列表
     * 
     * @param wxUser 小程序用户信息
     * @return 小程序用户集合
     */
	public List<WxUser> selectWxUserList(WxUser wxUser);
	
	/**
     * 新增小程序用户
     * 
     * @param wxUser 小程序用户信息
     * @return 结果
     */
	public int insertWxUser(WxUser wxUser);
	
	/**
     * 修改小程序用户
     * 
     * @param wxUser 小程序用户信息
     * @return 结果
     */
	public int updateWxUser(WxUser wxUser);
	
	/**
     * 删除小程序用户
     * 
     * @param id 小程序用户ID
     * @return 结果
     */
	public int deleteWxUserById(Integer id);
	
	/**
     * 批量删除小程序用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteWxUserByIds(String[] ids);

	/**
	*功能描述  根据openid查询用户
	*@Author  zhangpl
	*@Date 2018/11/27 10:12
	* @param  * @param openId
	* @return com.ruoyi.project.module.wxUser.domain.WxUser
	*/
	WxUser queryByOpenId(@Param("openId") String openId);
	
}