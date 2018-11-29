package com.ruoyi.api.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by dongao on 2018/11/26.
 */
public class MyX509TrustManager {

    public MyX509TrustManager(){}

    // 检查客户端证书
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    // 检查服务器端证书
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    // 返回受信任的X509证书数组
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
