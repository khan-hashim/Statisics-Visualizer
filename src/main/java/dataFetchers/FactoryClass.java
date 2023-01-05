package dataFetchers;

public class FactoryClass {
	//class that creates appropriate data fetcher class according to the input. receiver Country, fromDate,toDate and type of
	//analysis from MainUI after reCalculate button is pressed. It decides according to the analysisType which class to create
	
	private String country ;
	private String fromYear;
	private String toYear;
	private String analysisType;
	private AnalysisTypes AT;
	public FactoryClass(String country, String fromDate, String toDate, String analysisType) {
		this.country = country;
		this.fromYear = fromDate;
		this.toYear = toDate;
		this.analysisType = analysisType;
	}
	public AnalysisTypes factoryMethod() {
		if(this.analysisType.equals("PollutionIndicators")) {
			AT = new PollutionIndicators(country, fromYear, toYear);
		}
		else if(this.analysisType.equals("AirPollutionVsForestArea")) {
			AT = new AirPollutionVsForestArea(country, fromYear, toYear);
		}
		else if(this.analysisType.equals("HealthVsEducationExpenditure")) {
			AT = new HealthVsEducationExpenditure(country, fromYear, toYear);
		}
		else if(this.analysisType.equals("GDPgrowthVsPoliticalStability")) {
			AT = new GDPgrowthVsPoliticalStability(country, fromYear, toYear);
		}
		else if(this.analysisType.equals("MortalityRateVsAccessToHealth")) {
			AT = new MortalityRateVsAccessToHealth(country, fromYear, toYear);
		}
		else if(this.analysisType.equals("GDPperCapitaVsCO2emissions")) {
			AT = new GDPperCapitaVsCO2emissions(country, fromYear, toYear);
		}
		else if(this.analysisType.equals("AverageForestArea")) {
			AT = new AverageForestArea(country, fromYear, toYear);
		}
		else if(this.analysisType.equals("AverageExpenditureOnEducation")) {
			AT = new AverageExpenditureOnEducation(country, fromYear, toYear);
		}
		
	
		return AT;
	}

}
