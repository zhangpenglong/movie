package com.ruoyi.project.module.token.service;

import com.ruoyi.project.module.token.domain.Token;
import java.util.List;
import java.util.Map;

/**
 * 用户Token 服务层
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
public interface ITokenService 
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
     * 删除用户Token信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTokenByIds(String ids);

	/**
	 *功能描述  根据userId查询
	 *@Author  zhangpl
	 *@Date 2018/11/27 10:30
	 * @param  * @param token
	 * @return com.ruoyi.project.module.token.domain.Token
	 */
	Token queryByUserId(Long userId);

	/**
	*功能描述  创建token
	*@Author  zhangpl
	*@Date 2018/11/27 10:35
	* @param  * @param userId
	* @return java.util.Map<java.lang.String,java.lang.Object>
	*/
	Map<String, Object> createToken(long userId);


	 Token queryByToken(String token);
	
}
