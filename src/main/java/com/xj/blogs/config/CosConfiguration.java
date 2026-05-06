package com.xj.blogs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;

@Configuration
public class CosConfiguration {

    @Value("${tencent.cos.secretId}")
    private String secretId;

    @Value("${tencent.cos.secretKey}")
    private String secretKey;

    /**
     * 创建一个COSClient用于调用简单接口
     * @return COSClient
     */
    @Bean
    public COSClient initCosClient() {
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

        ClientConfig clientConfig = new ClientConfig(new Region("ap_shanghai"));

        return new COSClient(cred, clientConfig);
    }
}
