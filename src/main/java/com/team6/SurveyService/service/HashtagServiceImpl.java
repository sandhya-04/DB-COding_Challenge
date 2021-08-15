package com.team6.SurveyService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team6.SurveyService.HashtagRepository.HashtagRepository;
import com.team6.SurveyService.dto.Hashtags;

@Service
public class HashtagServiceImpl implements HashtagService {

	
	@Autowired
	private HashtagRepository hashtagRepository;
	
	@Override
	public Hashtags addHashtag(Hashtags hashtags) {
		// TODO Auto-generated method stub
		return hashtagRepository.save(hashtags);
	}

	@Override
	public Hashtags getHashtag(String hashtag) {
		// TODO Auto-generated method stub
		return hashtagRepository.findById(hashtag).orElse(null);
	}

	@Override
	public int getHashtagCount(String hashtag) {
		// TODO Auto-generated method stub
		return hashtagRepository.getHashtagCount(hashtag);
	}

	@Override
	public List<String> getTrendingHashtags() {
		// TODO Auto-generated method stub
		return hashtagRepository.getTrendingHashtag();
	}
}
