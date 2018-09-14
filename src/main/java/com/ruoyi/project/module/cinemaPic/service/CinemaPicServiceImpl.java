package com.ruoyi.project.module.cinemaPic.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.cinemaPic.mapper.CinemaPicMapper;
import com.ruoyi.project.module.cinemaPic.domain.CinemaPic;
import com.ruoyi.project.module.cinemaPic.service.ICinemaPicService;
import com.ruoyi.common.support.Convert;
import org.springframework.util.CollectionUtils;

/**
 * 影院图片 服务层实现
 * 
 * @author ruoyi
 * @date 2018-09-10
 */
@Service
public class CinemaPicServiceImpl implements ICinemaPicService 
{
	@Autowired
	private CinemaPicMapper cinemaPicMapper;

	/**
     * 查询影院图片信息
     * 
     * @param id 影院图片ID
     * @return 影院图片信息
     */
    @Override
	public CinemaPic selectCinemaPicById(Long id)
	{
	    return cinemaPicMapper.selectCinemaPicById(id);
	}
	
	/**
     * 查询影院图片列表
     * 
     * @param cinemaPic 影院图片信息
     * @return 影院图片集合
     */
	@Override
	public List<CinemaPic> selectCinemaPicList(CinemaPic cinemaPic)	{

		List<CinemaPic> cinemaPics = cinemaPicMapper.selectCinemaPicList(cinemaPic);
		if(CollectionUtils.isEmpty(cinemaPics)){
			return cinemaPics;
		}
		for(CinemaPic pic : cinemaPics){
			if(null != pic.getCinemaId()){

			}
		}
		return cinemaPics;
	}
	
    /**
     * 新增影院图片
     * 
     * @param cinemaPic 影院图片信息
     * @return 结果
     */
	@Override
	public int insertCinemaPic(CinemaPic cinemaPic)
	{
	    return cinemaPicMapper.insertCinemaPic(cinemaPic);
	}
	
	/**
     * 修改影院图片
     * 
     * @param cinemaPic 影院图片信息
     * @return 结果
     */
	@Override
	public int updateCinemaPic(CinemaPic cinemaPic)
	{
	    return cinemaPicMapper.updateCinemaPic(cinemaPic);
	}

	/**
     * 删除影院图片对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCinemaPicByIds(String ids)
	{
		return cinemaPicMapper.deleteCinemaPicByIds(Convert.toStrArray(ids));
	}


	/**
	*功能描述  根据影院id查询影院图片
	*@Author  zhangpl
	*@Date 2018/9/10 16:47
	* @param  * @param cId
	* @return java.util.List<com.ruoyi.project.module.cinemaPic.domain.CinemaPic>
	*/
	public List<CinemaPic> listByCid(Long cId){

		return cinemaPicMapper.listByCid(cId);
	}
	
}
