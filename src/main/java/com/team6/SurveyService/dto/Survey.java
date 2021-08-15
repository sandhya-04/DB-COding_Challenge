package com.team6.SurveyService.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name="survey")
@Table(name = "SurveyTb1")
public class Survey {
	
	@EmbeddedId
	private SurveyId id;
	private int moodRating;
	private String hashtag;
	private String reason;
	
	public SurveyId getId() {
		return id;
	}
	public void setId(SurveyId id) {
		this.id = id;
	}
	public int getMoodRating() {
		return moodRating;
	}
	public void setMoodRating(int moodRating) {
		this.moodRating = moodRating;
	}
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
