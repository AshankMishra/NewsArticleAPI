package com.news.google.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.news.google.service.NewsServiceImpl;

@RestController
public class NewsController {

	@Autowired
	NewsServiceImpl newsService;

	@GetMapping("/googleNews")
	public ResponseEntity<List<Map<String, Object>>> getGoogleNews(@RequestParam("keywords") String keyWords) {
		List<Map<String, Object>> newsResponse = newsService.getGoogleNews(keyWords);
		if (newsResponse == null) {
			return ResponseEntity.notFound().build();
		} else if (newsResponse.size() == 0) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok().body(newsResponse);
		}
	}
}
