package com.team6.SurveyService.service;

import java.util.List;

import com.team6.SurveyService.dto.Hashtags;

public interface HashtagService {
	
	public List<String> getTrendingHashtags();

	public Hashtags addHashtag(Hashtags hashtags);
	
	public Hashtags getHashtag(String Hashtag);
	
	public int getHashtagCount(String Hashtag);
	
}
