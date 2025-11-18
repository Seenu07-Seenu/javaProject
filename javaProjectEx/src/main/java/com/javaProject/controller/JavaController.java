package com.javaProject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaProject.entity.Detailes;
import com.javaProject.repository.JavaRepository;
import com.javaProject.service.JavaService;

@RestController
@RequestMapping("/java")
public class JavaController {

	@Autowired
	private JavaService javaService;
	
	@Autowired
	private JavaRepository javaRepository;

	@PostMapping("/reversing")
	public ResponseEntity<String> reversingString(@RequestParam String val) {
		ResponseEntity<String> rev = ResponseEntity.ok(javaService.reversingString(val));
		return rev;
	}

	@PostMapping("/palindrome")
	public ResponseEntity<String> palindromeString(@RequestParam String val) {
		String rev = javaService.reversingString(val);
		return ResponseEntity.ok(javaService.palindromeString(val, rev));
	}

	@PostMapping("/checkPrime")
	public ResponseEntity<Map<String, List<Integer>>> isPrime(@RequestParam Integer[] val) {
		Map<String, List<Integer>> arr = javaService.isPrime(val);
		return ResponseEntity.ok(arr);
	}

	@PostMapping("/checkAnagram")
	public ResponseEntity<String> isAnagram(@RequestParam String val1, @RequestParam String val2) {
		String anagram = javaService.isAnagram(val1, val2);
		return ResponseEntity.ok(anagram);
	}

	@PostMapping("/checkArmstrong")
	public ResponseEntity<String> isArmstrong(@RequestParam int val) {
		String arm = javaService.isArmstrong(val);
		return ResponseEntity.ok(arm);
	}

	@PostMapping("/checkparameter")
	public ResponseEntity<String> chackParam(@RequestParam String val) {
		Boolean param = javaService.chackParam(val);
		Detailes det = new Detailes();
		String out;
		if (param) {
			out = val + " This param sequence is correct";
		} else {
			out = val + " This param sequence is not correct";
		}
		det.setProgram_name("check sequence param");
		det.setInput(val);
		det.setOutput(out);
		javaRepository.save(det);
		return ResponseEntity.ok(out);
	}
}
