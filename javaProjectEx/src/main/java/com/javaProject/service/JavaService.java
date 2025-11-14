package com.javaProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaProject.entity.Detailes;
import com.javaProject.repository.JavaRepository;

import jakarta.transaction.Transactional;

@Service
public class JavaService {

	@Autowired
	private JavaRepository javaRepository;

	//Reverse A String
	public String reversingString(String val) {
		Detailes det = new Detailes();
		StringBuilder rev = new StringBuilder(val).reverse();

		det.setProgram_name("Reverse a String");
		det.setInput(val);
		det.setOutput(String.valueOf(rev));

		javaRepository.save(det);

		return String.valueOf(rev);
	}

	//palindrome
	@Transactional
	public String palindromeString(String val, String rev) {

		Detailes det = new Detailes();
		String out;
		
		if (val.equals(rev)) {
			out = val + " is palindrome";
		} else {
			out = val + " is not palindrome";
		}

		det.setProgram_name("palindrome");
		det.setInput(val);
		det.setOutput(out);

		javaRepository.save(det);
		return out;
	}

}
