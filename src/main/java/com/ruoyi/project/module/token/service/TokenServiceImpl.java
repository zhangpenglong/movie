package com.ruoyi.project.module.token.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.api.util.CharUtil;
import com.ruoyi.common.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.token.mapper.TokenMapper;
import com.ruoyi.project.module.token.domain.Token;
import com.ruoyi.project.module.token.service.ITokenService;
import com.ruoyi.common.support.Convert;

/**
 * 用户Token 服务层实现
 * 
 * @author ruoyi
 * @date 2018-11-27
 */
@Service
public class TokenServiceImpl implements ITokenService 
{
	@Autowired
	private TokenMapper tokenMapper;

	/**
     * 查询用户Token信息
     * 
     * @param userId 用户TokenID
     * @return 用户Token信息
     */
    @Override
	public Token selectTokenById(Long userId)
	{
	    return tokenMapper.selectTokenById(userId);
	}
	
	/**
     * 查询用户Token列表
     * 
     * @param token 用户Token信息
     * @return 用户Token集合
     */
	@Override
	public List<Token> selectTokenList(Token token)
	{
	    return tokenMapper.selectTokenList(token);
	}
	
    /**
     * 新增用户Token
     * 
     * @param token 用户Token信息
     * @return 结果
     */
	@Override
	public int insertToken(Token token)
	{
	    return tokenMapper.insertToken(token);
	}
	
	/**
     * 修改用户Token
     * 
     * @param token 用户Token信息
     * @return 结果
     */
	@Override
	public int updateToken(Token token)
	{
	    return tokenMapper.updateToken(token);
	}

	/**
     * 删除用户Token对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTokenByIds(String ids)
	{
		return tokenMapper.deleteTokenByIds(Convert.toStrArray(ids));
	}


	@Override
	public Token queryByUserId( Long userId){
		return tokenMapper.queryByUserId(userId);
	}

	/**
	 *功能描述  创建token
	 *@Author  zhangpl
	 *@Date 2018/11/27 10:35
	 * @param  * @param userId
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 */
	@Override
	public Map<String, Object> createToken(long userId) {
		//生成一个token
		String token = CharUtil.getRandomString(32);
		//当前时间
		Date now = new Date();

		//过期时间
		Date expireTime = new Date(now.getTime() + Constants.EXPIRE * 1000);

		//判断是否生成过token
		Token tokenEntity = queryByUserId(userId);
		if (tokenEntity == null) {
			tokenEntity = new Token();
			tokenEntity.setUserId(userId);
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//保存token
			insertToken(tokenEntity);
		} else {
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//更新token
			updateToken(tokenEntity);
		}

		Map<String, Object> map = new HashMap<>();
		map.put("token", token);
		map.put("expire", Constants.EXPIRE);

		return map;
	}


	@Override
	public Token queryByToken(String token){
		return tokenMapper.queryByToken(token);
	}
	
}
