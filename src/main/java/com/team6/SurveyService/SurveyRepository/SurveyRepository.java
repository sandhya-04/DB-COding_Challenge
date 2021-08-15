package com.team6.SurveyService.SurveyRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.team6.SurveyService.dto.Survey;
import com.team6.SurveyService.dto.SurveyId;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, SurveyId> {
	
//	@Query(value = "SELECT s.mood_rating FROM survey_tb1 s where s.time_stamp>= CURDATE()-?1 group by day(s.time_stamp)",nativeQuery = true)
	@Query("SELECT date(s.id.timeStamp),avg(s.moodRating) from survey s where DAY(s.id.timeStamp)>= (DAY(CURRENT_TIMESTAMP)- ?1) group by(DAY(s.id.timeStamp))")
	public List<List<String>> getLatestAvg(int days);
	
	@Query(value="Select * from survey_tb1 s where s.email=?1",nativeQuery = true)
	public List<Survey> getByEmail(String email);
	
	@Query(value="select * from survey_tb1 where day(current_timestamp)-?1 <= day(time_stamp)",nativeQuery = true)
	public List<Survey> getLatestData(int days);
//	
	@Query(value = "select s.mood_rating, count(*)\r\n"
			+ "from (\r\n"
			+ "  select case  \r\n"
			+ "    when mood_rating between 1 and 2 then '1 - 2'\r\n"
			+ "    when mood_rating between 3 and 4 then '3 - 4'\r\n"
			+ "    when mood_rating between 5 and 6 then '5 - 6'\r\n"
			+ "    when mood_rating between 7 and 8 then '7 - 8'\r\n"
			+ "    else '9 - 10' end as mood_rating\r\n"
			+ "  from survey_tb1 where day(current_timestamp)-?1 <= day(time_stamp)) s\r\n"
			+ "group by s.mood_rating", nativeQuery = true)
	public List<List<String>> getAvgCategoriesRating(int days);

//	get sad employee for last X days	
	@Query(value="select email, avg(mood_rating) as AVGMOOD from survey_tb1 where day(current_timestamp)-?1 <= day(time_stamp) group by email having AVGMOOD <= 4",nativeQuery = true)
	public List<List<String>>getBadMoodEmployee(int days);
	
	
}