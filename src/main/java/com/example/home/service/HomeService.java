package com.example.home.service;

import java.util.Map;

public interface HomeService {
	Map<String, Object> selectDbList();
	Map<String, Object> selectDb(String seq);
}
