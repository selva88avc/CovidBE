package com.stackroute.bookmarkservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;

@SpringBootApplication
public class BookmarkserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarkserviceApplication.class, args);
	}
	@Autowired
	private CacheManager cacheManager;

}
