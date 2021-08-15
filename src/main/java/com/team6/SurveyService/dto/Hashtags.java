package com.team6.SurveyService.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name="hashtag")
@Table(name = "HashtagTb1")
public class Hashtags {
	
	public Hashtags() {
		super();
	}
	public Hashtags(String hashtag, int count) {
		super();
		this.hashtag = hashtag;
		this.count = count;
	}
	@Id
	private String hashtag;
	public int getCount() {
		return count;
	}
	private int count;
}
