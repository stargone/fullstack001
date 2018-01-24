package com.example.home.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeDao {
	public List<Map<String, Object>> selectDbList();
	public Map<String, Object> selectDb(String seq);
}