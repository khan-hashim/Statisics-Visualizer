package dataFetchers;

import java.util.ArrayList;

public class GDPperCapitaVsCO2emissions extends AnalysisTypes{
	private final String CO2Indicator = "EN.ATM.CO2E.PC";
	private final String GDPperCapitaIndicator = "NY.GDP.PCAP.CD";
	private ArrayList<Double> CO2Emissions;
	private ArrayList<Double> GDPperCapita;
	
	
	public GDPperCapitaVsCO2emissions(String country, String fromDate, String toDate) {
		super(country, fromDate, toDate);
	}
	public void getData() {
		this.CO2Emissions = super.df.fetchData(this.CO2Indicator);
		this.GDPperCapita = super.df.fetchData(this.GDPperCapitaIndicator);
	}
	public ArrayList<Double> getCO2emissions() {
		return this.CO2Emissions ;
	}
	public ArrayList<Double> getGDPperCapita() {
		return this.GDPperCapita;
	}

}
