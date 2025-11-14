package com.javaProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaProject.service.JavaService;

@RestController
@RequestMapping("/java")	
public class JavaController {

	@Autowired
	private JavaService javaService;
	
	@PostMapping("/reversing")
	public ResponseEntity<String> reversingString(@RequestParam String val){
		ResponseEntity<String> rev = ResponseEntity.ok(javaService.reversingString(val));
		return rev;
	}
	
	
	@PostMapping("/palindrome")
	public ResponseEntity<String> palindromeString(@RequestParam String val){
		String rev = javaService.reversingString(val);
		return ResponseEntity.ok(javaService.palindromeString(val, rev));
	}
}
