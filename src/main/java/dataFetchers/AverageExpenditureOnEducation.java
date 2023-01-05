package dataFetchers;

import java.util.ArrayList;

public class AverageExpenditureOnEducation extends AnalysisTypes {
	private final String EducationIndicator = "SE.XPD.TOTL.GD.ZS";
	private ArrayList<Double> educationExpenditure;
	
	public AverageExpenditureOnEducation(String country, String fromDate, String toDate) {
		super(country, fromDate, toDate);
	}
	public void getData() {
		this.educationExpenditure = super.df.fetchData(this.EducationIndicator);
	}

	public ArrayList<Double> getEducationExpenditure() {
		return this.educationExpenditure;
	}
	

}
