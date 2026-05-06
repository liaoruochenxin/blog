package com.xj.blogs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xj.blogs.mapper")
public class BlogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogsApplication.class, args);
		System.out.println("(♥◠‿◠)ﾉﾞ  启动成功,愿此行无BUG   ლ(´ڡ`ლ)ﾞ  \n");
	}

}
