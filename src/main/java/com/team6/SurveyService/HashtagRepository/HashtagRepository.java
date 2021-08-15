package com.team6.SurveyService.HashtagRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.team6.SurveyService.dto.Hashtags;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtags, String> {	
	@Query("select h.count from hashtag h where h.hashtag=?1")
	public int getHashtagCount(String hashtag);
	
	@Query("select h.hashtag from hashtag h order by h.count desc")
	public List<String> getTrendingHashtag();
	
	
}
