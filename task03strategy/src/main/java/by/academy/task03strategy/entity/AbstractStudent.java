package by.academy.task03strategy.entity;

import java.util.Random;

public abstract class AbstractStudent {
	private Double baseTimeForAnalysis;
	private String subjectTitle;
	private final double talent = (new Random().nextInt(10) + 1) / 10.0;

	public double getTalent() {
		return talent;
	}

	public String getType() {
		return this.getClass().getSimpleName();
	}

	public Double getBaseTimeForAnalysis() {
		return baseTimeForAnalysis;
	}

	public void setBaseTimeForAnalysis(double baseTimeForAnalysis) {
		this.baseTimeForAnalysis = baseTimeForAnalysis;
	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public abstract double getAnalysisTime();

	public abstract double getPracticeTime();

	public abstract double getFlowTime();

	public double getTotalTime() {
		return getAnalysisTime() + getPracticeTime() + getFlowTime();
	}

	@Override
	public String toString() {
		return getType() + " [talent = " + talent + ", analysis time = " + getAnalysisTime()
				+ ", practice time = " + getPracticeTime() + ", flow time = " + getFlowTime()
				+ ", total time = " + getTotalTime() + "]";
	}
}
