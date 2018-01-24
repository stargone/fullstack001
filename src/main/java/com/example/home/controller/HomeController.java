package com.example.home.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.home.service.HomeService;

@RestController
public class HomeController {
	@Resource(name = "homeService")
	private HomeService homeService;

	@GetMapping(value = "/dbList")
	public Object home(@RequestParam Map<String, Object> map) {
		return homeService.selectDbList();
	}	
	
	@GetMapping(value = "/dbList/{seq}")
	public Object home(@PathVariable String seq) {
		return homeService.selectDb(seq);
	}
}