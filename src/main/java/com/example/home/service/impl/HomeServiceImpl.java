package com.example.home.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.home.dao.HomeDao;
import com.example.home.service.HomeService;

@Service("homeService")
public class HomeServiceImpl implements HomeService {
	@Autowired
	private HomeDao homeDao;

	@Override
	public Map<String, Object> selectDbList() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> list = homeDao.selectDbList();
		resultMap.put("RESULT", list);
		return resultMap;
	}
	
	@Override
	public Map<String, Object> selectDb(String seq) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> map = homeDao.selectDb(seq);
		resultMap.put("RESULT", map);
		return resultMap;
	}
}