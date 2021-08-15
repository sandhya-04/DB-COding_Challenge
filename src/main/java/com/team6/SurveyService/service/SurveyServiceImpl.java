package com.team6.SurveyService.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team6.SurveyService.HashtagRepository.HashtagRepository;
import com.team6.SurveyService.SurveyRepository.SurveyRepository;
import com.team6.SurveyService.dto.Hashtags;
import com.team6.SurveyService.dto.Survey;
import com.team6.SurveyService.dto.SurveyId;
import com.team6.SurveyService.util.getHashtagFromReason;


@Service
public class SurveyServiceImpl implements SurveyService {

	@Autowired
	private SurveyRepository surveyRepository;
	
	@Autowired
	private HashtagRepository hashtagRepository;
	
	@Override
	public Survey addSurvey(Survey survey) {
		// TODO Auto-generated method stub
		String reason = survey.getReason();

//		function To seperate hashtags and reason
		List<String> result = new getHashtagFromReason().getHashTags(reason);
		
		result.addAll(Arrays.asList(survey.getHashtag().split(",")));
		
		for(String hashtag: result) {
			if(hashtagRepository.findById(hashtag).isPresent()) {
				int count = hashtagRepository.getHashtagCount(hashtag) + 1;
				hashtagRepository.save(new Hashtags(hashtag, count));
			}
			else {
				hashtagRepository.save(new Hashtags(hashtag, 1));
			}
		}
		
//		hashtagRepository.save(new Hashtags(hashtag, 1));
		survey.setHashtag(String.join(",", result));
		
		return surveyRepository.save(survey);
	}

	@Override
	public List<Survey> getAllSurvey() {
		// TODO Auto-generated method stub
		return surveyRepository.findAll();
	}

	@Override
	public List<List<String>> getLatestAvg(int days) {
		// TODO Auto-generated method stub
		return surveyRepository.getLatestAvg(days);
	}

	@Override
	public List<Survey> getByEmail(String email) {
		// TODO Auto-generated method stub
		return surveyRepository.getByEmail(email);
	}

	@Override
	public List<Survey> getLatestData(int days) {
		// TODO Auto-generated method stub
		return surveyRepository.getLatestData(days);
	}

	@Override
	public List<List<String>> getAvgCategoriesRating(int days) {
		// TODO Auto-generated method stub
		return surveyRepository.getAvgCategoriesRating(days);
	}

	@Override
	public List<List<String>> getBadMoodEmployee(int days) {
		// TODO Auto-generated method stub
		return surveyRepository.getBadMoodEmployee(days);
	}



	
}
