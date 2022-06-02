package com.news.google.service;

import java.util.List;
import java.util.Map;

public interface NewsServiceImpl {

	List<Map<String, Object>> getGoogleNews(String keyWords);

}
