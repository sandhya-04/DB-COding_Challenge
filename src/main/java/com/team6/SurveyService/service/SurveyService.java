package com.team6.SurveyService.service;

import java.util.List;

import com.team6.SurveyService.dto.Hashtags;
import com.team6.SurveyService.dto.Survey;

public interface SurveyService {
	
	public Survey addSurvey(Survey survey);
	
	public List<Survey> getAllSurvey();
	
	public List<List<String>> getLatestAvg(int days);
	
	public List<Survey> getByEmail(String email);
	
	public List<Survey> getLatestData(int days);
	
	public List<List<String>> getAvgCategoriesRating(int days);

	public List<List<String>>getBadMoodEmployee(int days);
}
