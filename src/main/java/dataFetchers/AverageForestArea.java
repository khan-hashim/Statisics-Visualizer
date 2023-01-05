package dataFetchers;

import java.util.ArrayList;

public class AverageForestArea extends AnalysisTypes{

	private final String ForestAreaIndicator = "AG.LND.FRST.ZS";
	
	private ArrayList<Double> ForestArea;
	
	public AverageForestArea(String country, String fromDate, String toDate) {
		super(country , fromDate, toDate);
	}

	public void getData() {
		this.ForestArea = super.df.fetchData(this.ForestAreaIndicator);
	}
	public ArrayList<Double> getForestArea() {
		return this.ForestArea;
	}
}
