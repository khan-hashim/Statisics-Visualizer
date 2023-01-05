package dataFetchers;

import java.util.ArrayList;

public class HealthVsEducationExpenditure extends AnalysisTypes {
	private final String EducationIndicator = "SE.XPD.TOTL.GD.ZS";
	private final String HealthIndicator = "SH.XPD.CHEX.GD.ZS";
	private ArrayList<Double> educationExpenditure;
	private ArrayList<Double> healthExpenditure;
	
	public HealthVsEducationExpenditure(String country, String fromDate, String toDate) {
		super(country, fromDate, toDate);
	}
	
	public void getData() {
		this.educationExpenditure = super.df.fetchData(this.EducationIndicator);
		this.healthExpenditure = super.df.fetchData(this.HealthIndicator);
	}
	public ArrayList<Double> getEducationExpenditure() {
		return this.educationExpenditure ;
	}
	public ArrayList<Double> getHealthExpenditure() {
		
		return this.healthExpenditure ;
	}

}
