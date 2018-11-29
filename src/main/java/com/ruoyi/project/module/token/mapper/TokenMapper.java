package com.ruoyi.project.module.token.mapper;

import com.ruoyi.project.module.token.domain.Token;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Token 数据层
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
public interface TokenMapper 
{
	/**
     * 查询用户Token信息
     * 
     * @param userId 用户TokenID
     * @return 用户Token信息
     */
	public Token selectTokenById(Long userId);
	
	/**
     * 查询用户Token列表
     * 
     * @param token 用户Token信息
     * @return 用户Token集合
     */
	public List<Token> selectTokenList(Token token);
	
	/**
     * 新增用户Token
     * 
     * @param token 用户Token信息
     * @return 结果
     */
	public int insertToken(Token token);
	
	/**
     * 修改用户Token
     * 
     * @param token 用户Token信息
     * @return 结果
     */
	public int updateToken(Token token);
	
	/**
     * 删除用户Token
     * 
     * @param userId 用户TokenID
     * @return 结果
     */
	public int deleteTokenById(Long userId);
	
	/**
     * 批量删除用户Token
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTokenByIds(String[] userIds);

	/**
	*功能描述  根据userId查询
	*@Author  zhangpl
	*@Date 2018/11/27 10:30
	* @param  * @param token
	* @return com.ruoyi.project.module.token.domain.Token
	*/
	Token queryByUserId(@Param("userId")Long userId);


	Token queryByToken(@Param("token")String token);
	
}