package by.academy.task03strategy.entity.impl;

import by.academy.task03strategy.entity.AbstractStudent;

public class StudentType3 extends AbstractStudent {

	@Override
	public double getAnalysisTime() {
		return 0;
	}

	@Override
	public double getPracticeTime() {
		return getBaseTimeForAnalysis() * 9 / getTalent();
	}

	@Override
	public double getFlowTime() {
		return 0;
	}
}
