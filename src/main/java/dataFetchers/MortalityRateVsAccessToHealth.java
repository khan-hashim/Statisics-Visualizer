package dataFetchers;

import java.util.ArrayList;

public class MortalityRateVsAccessToHealth extends AnalysisTypes{
	private final String AccessToHealthIndicator = "SH.ACS.MONY.Q1.ZS";
	private final String MortalityRateIndicator = "SP.DYN.IMRT.IN";
	private ArrayList<Double> AccessToHealth;
	private ArrayList<Double> MortalityRate;
	
	public MortalityRateVsAccessToHealth(String country, String fromDate, String toDate) {
		super(country, fromDate, toDate);
	}
	
	public void getData() {
		this.AccessToHealth = super.df.fetchData(this.AccessToHealthIndicator);
		this.MortalityRate = super.df.fetchData(this.MortalityRateIndicator);
	}
	public ArrayList<Double> getAccessToHealth() {
		return this.AccessToHealth ;
	}
	public ArrayList<Double> getMortalityRate() {
		return this.MortalityRate;
	}

}
