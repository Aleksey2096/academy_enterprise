package by.academy.task03strategy.entity.impl;

import by.academy.task03strategy.entity.AbstractStudent;

public class StudentType1 extends AbstractStudent {

	@Override
	public double getAnalysisTime() {
		return getBaseTimeForAnalysis() / getTalent();
	}

	@Override
	public double getPracticeTime() {
		return getBaseTimeForAnalysis() / getTalent();
	}

	@Override
	public double getFlowTime() {
		return getBaseTimeForAnalysis() / getTalent();
	}
}
