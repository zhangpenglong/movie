package com.ruoyi.oss;

import com.ruoyi.api.util.JsonUtil;
import com.ruoyi.api.util.SpringContextUtils;
import com.ruoyi.framework.web.service.ConfigService;
import com.ruoyi.project.system.config.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 文件上传Factory
 *
 * @author tiankong
 * @email 2366207000@qq.com
 * @date 2017-03-26 10:18
 */
@Component
public final class OSSFactory {

    @Autowired
    private  IConfigService configService1;

    @Autowired
    private static IConfigService configService;

    @PostConstruct
    public void init(){
        configService = configService1;
    }

    public static CloudStorageService build() {
        //获取云存储配置信息
        CloudStorageConfig config = JsonUtil.getObjet(configService.selectConfigByKey("CLOUDCONFIG"), CloudStorageConfig.class);
        return new QiniuCloudStorageService(config);
    }

}
