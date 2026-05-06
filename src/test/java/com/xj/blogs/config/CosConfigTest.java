package com.xj.blogs.config;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.Bucket;

@SpringBootTest
public class CosConfigTest {

    @Autowired
    private COSClient cosClient;

    @Test
    void testCos() {
        List<Bucket> buckets = cosClient.listBuckets();
        for (Bucket bucket : buckets) {
            System.out.println(bucket.getName());
        }
    }
}
