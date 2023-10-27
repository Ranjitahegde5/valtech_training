package com.valtech.training.mobile.ranking;

import java.util.List;

import com.valtech.training.pattern.checker.PatternCheckerService;
import com.valtech.training.pattern.checker.PatternCheckerServiceImpl;

public class MobileRankingServiceImpl implements MobileRankingService {
	
	private PatternCheckerService patternCheckerService = new PatternCheckerServiceImpl();

	@Override
	public int rankMobile(String mobile) {
		List<String> patterns = patternCheckerService.listPatterns(mobile);
		//logic for rating...
		return 0;
	}

}
