package by.academy.task03strategy.entity.impl;

import by.academy.task03strategy.entity.AbstractStudent;

public class StudentType2 extends AbstractStudent {

	@Override
	public double getAnalysisTime() {
		return getBaseTimeForAnalysis() * 3 / getTalent();
	}

	@Override
	public double getPracticeTime() {
		return getBaseTimeForAnalysis() * 3 / getTalent();
	}

	@Override
	public double getFlowTime() {
		return 0;
	}
}
