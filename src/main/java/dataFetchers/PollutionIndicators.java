package dataFetchers;


import java.util.ArrayList;

public class PollutionIndicators extends AnalysisTypes{
	private final String CO2Indicator = "EN.ATM.CO2E.PC";
	private final String energyUseIndicator = "EG.USE.PCAP.KG.OE";
	private final String PM25Indicator = "EN.ATM.PM25.MC.M3";
	private ArrayList<Double> CO2Emissions;
	private ArrayList<Double> energyUse;
	private ArrayList<Double> PM25airpollution;
	
	public PollutionIndicators(String country, String fromDate, String toDate) {
		super(country,fromDate,toDate);
	}
	public void getData() {
		this.CO2Emissions = super.df.fetchData(this.CO2Indicator);
		this.energyUse = super.df.fetchData(this.energyUseIndicator);
		this.PM25airpollution = super.df.fetchData(this.PM25Indicator);
	}
	
	public ArrayList<Double> getCO2emissions() {
		return this.CO2Emissions;
	}
	public ArrayList<Double> getEnergyUse() {
		return this.energyUse;
	}
	
	public ArrayList<Double> getPM25AirPollution() {
		return this.PM25airpollution;
	}
	

}
