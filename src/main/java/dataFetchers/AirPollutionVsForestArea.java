package dataFetchers;

import java.util.ArrayList;

public class AirPollutionVsForestArea extends AnalysisTypes{
	private final String ForestAreaIndicator = "AG.LND.FRST.ZS";
	private final String PM25Indicator = "EN.ATM.PM25.MC.M3";
	private ArrayList<Double> ForestArea;
	private ArrayList<Double> PM25airpollution;
	
	public AirPollutionVsForestArea(String country, String fromDate, String toDate) {
		super(country , fromDate, toDate);
	}
	
	public void getData() {
		this.PM25airpollution = super.df.fetchData(this.PM25Indicator);
		this.ForestArea = super.df.fetchData(this.ForestAreaIndicator);
	}
	
	public ArrayList<Double> getPM25AirPollution(){
		return this.PM25airpollution;
	}
	
	public ArrayList<Double> getForestArea() {
		return this.ForestArea;
	}
	
	

}
