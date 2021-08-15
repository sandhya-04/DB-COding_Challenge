package com.team6.SurveyService.util;

import java.util.ArrayList;
import java.util.List;

public class getHashtagFromReason {
	public List<String> getHashTags(String reason) {
		List<String> result = new ArrayList<>();

		String[] words = reason.split(" ");
		for (String w : words) {
			if (w.charAt(0) == '#') {
				result.add(w);
			}
		}


		return result;
	}
}
