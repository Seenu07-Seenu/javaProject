package com.javaProject.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaProject.entity.Detailes;
import com.javaProject.repository.JavaRepository;

import jakarta.transaction.Transactional;

@Service
public class JavaService {

	@Autowired
	private JavaRepository javaRepository;

	// Reverse A String
	public String reversingString(String val) {
		Detailes det = new Detailes();
		StringBuilder rev = new StringBuilder(val).reverse();

		det.setProgram_name("Reverse a String");
		det.setInput(val);
		det.setOutput(String.valueOf(rev));

		javaRepository.save(det);

		return String.valueOf(rev);
	}

	// palindrome
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

	// chack prime number
	public Map<String, List<Integer>> isPrime(Integer[] val) {
		Detailes det = new Detailes();
		List<Integer> prime = new ArrayList<>();
		List<Integer> notPrime = new ArrayList<>();
		Map<String, List<Integer>> primeVal = new HashMap<>();

		for (int i = 0; i < val.length; i++) {
			if (val[i] == 2) {
				prime.add(val[i]);
			} else if (val[i] % 2 == 0 || val[i] % 3 == 0 || val[i] % 5 == 0) {
				notPrime.add(val[i]);
			} else {
				prime.add(val[i]);
			}
		}
		primeVal.put("prime", prime);
		primeVal.put("not Prime", notPrime);

		det.setInput(Arrays.toString(val));
		det.setOutput(String.valueOf(primeVal));
		det.setProgram_name("find prime number");
		javaRepository.save(det);
		return primeVal;
	}

	// find a anagram
	public  String isAnagram(String val1, String val2) {
		Detailes det = new Detailes();
		String sort1 = isSort(val1);
		String sort2 = isSort(val2);
		
		String out = "";
		
		if(sort1.equals(sort2)) {
			out =  "is Anagram";
		}else {
			out = "is not Anagram";
		}
		
		det.setInput(val1+", "+val2);
		det.setOutput(out);
		det.setProgram_name("Anagram");
		javaRepository.save(det);
		return val1+" "+out+" "+val2;
	}

	// sort a String
	public static String isSort(String val) {
		char[] arr = val.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			int minTemp = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minTemp]) {
					minTemp = j;
				}
			}
			char temp = arr[i];
			arr[i] = arr[minTemp];
			arr[minTemp] = temp;
		}
		return new String(arr);
	}

	//Armstrong Number
	public String isArmstrong(int val) {
		
		int in = val;
		String output = "";
		int out = 0;
		while(val>0) {
			int temp = val%10;
			out += temp*temp*temp;
			val = val/10;
		}
		
		if(in == out) {
			output = in+" is Armstrong Number "+ out;
		}else {
			output = in+" is Not Armstrong Number "+ out;
		}
		Detailes det = new Detailes();
		det.setInput(String.valueOf(in));
		det.setOutput(String.valueOf(out));
		det.setProgram_name("ArmStrong");
		javaRepository.save(det);
		
		return output;
	}

}
