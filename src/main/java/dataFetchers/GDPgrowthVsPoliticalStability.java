package dataFetchers;

import java.util.ArrayList;

public class GDPgrowthVsPoliticalStability extends AnalysisTypes {
	private final String GDPGrowthIndicator = "NY.GDP.MKTP.KD.ZG";
	private final String PoliticalStabilityIndicator = "PV.EST";
	private ArrayList<Double> GDPGrowthRate;
	private ArrayList<Double> PoliticalStability;
	
	public GDPgrowthVsPoliticalStability(String country, String fromDate, String toDate) {
		super(country , fromDate, toDate);
	}
	public void getData() {
		this.GDPGrowthRate = df.fetchData(this.GDPGrowthIndicator);
		this.PoliticalStability = df.fetchData(this.PoliticalStabilityIndicator);
	}
	public ArrayList<Double> getGDPGrowthRate() {
		
		return this.GDPGrowthRate;
	}
	public ArrayList<Double> getPoliticalStability() {
	
		return this.PoliticalStability ;
	}

}
