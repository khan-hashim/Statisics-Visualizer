package controllers;



public class MainController {
	private String country;
	private String fromYear;
	private String toYear;
	private String analysisType;
	private Facade f;
	private Subject s;
	private ViewersData data;
	
	
	public MainController(String country, String fromYear, String toYear, String analysisType, Subject s) {
		this.country = country;
		this.fromYear = fromYear;
		this.toYear = toYear;
		this.analysisType = analysisType;
		this.s = s;
		data = new ViewersData();
		
	}
	
	public void ReCalculate() {
		f = new Facade(country, fromYear, toYear, analysisType) ;
		
		if(analysisType.equals("PollutionIndicators")) { // Analysis 1
			 data = f.pollutionIndicators();
		}
		else if(analysisType.equals("AirPollutionVsForestArea")) { // Analysis2
		    data = f.AirPollutionVsForestArea();
		}
		else if(analysisType.equals("HealthVsEducationExpenditure")) { // Analysis 3
			data = f.HealthVsEducationExpenditure();
		}
		else if(analysisType.equals("GDPperCapitaVsCO2emissions")) { // Analysis 4
			data = f.GDPperCapitaVsCO2emissions();
		}
		else if(analysisType.equals("AverageForestArea")) { // Analysis 5
			data = f.AverageForestArea();	
			
		}
		else if(analysisType.equals("AverageExpenditureOnEducation")) { // Analysis 6
			data = f.AverageExpenditureOnEducation();
		}
		
		else if(analysisType.equals("GDPgrowthVsPoliticalStability")) { // Analysis 7
			data = f.GDPgrowthVsPoliticalStability();
		}
		else if(analysisType.equals("MortalityRateVsAccessToHealth")) { // Analysis 8
			data = f.MortalityRateVsAccessToHealth();
		}
		// call own method to update subjects state
		this.updateSubjectState();
		
		
	}
	public void updateSubjectState() {
		s.setState(data); 
		
	}
	public String getViewerType() {
		String s = "";
		if(analysisType.equals("PollutionIndicators")) {
			s = "Three series";
		}
		else if(analysisType.equals("AirPollutionVsForestArea") || analysisType.equals("HealthVsEducationExpenditure") ||
				analysisType.equals("GDPgrowthVsPoliticalStability") || analysisType.equals("MortalityRateVsAccessToHealth")) {
			s = "Two series";
		}
		else if(analysisType.equals("GDPperCapitaVsCO2emissions") || analysisType.equals("AverageForestArea") || analysisType.equals("AverageExpenditureOnEducation")) {
			s = "One series";
		}
		return s;
	}
	

}
