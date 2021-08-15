package com.team6.SurveyService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team6.SurveyService.dto.Survey;
import com.team6.SurveyService.service.HashtagService;
import com.team6.SurveyService.service.SurveyService;

@RestController
@RequestMapping("/api/survey")
public class SurveyController {

	@Autowired
	private SurveyService surveyService;
		
	
	@PostMapping
	public ResponseEntity<?> saveSurvey(@RequestBody Survey survey){
		surveyService.addSurvey(survey);
		return ResponseEntity.status(HttpStatus.CREATED).body(survey);
	}
	
}
