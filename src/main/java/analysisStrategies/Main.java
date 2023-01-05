package analysisStrategies;

import java.util.ArrayList;

import dataFetchers.DataFetcher;

public class Main {
	// Prints Results for Annual %age change for CO2 emmisions , Avg Forest Area and Ratio of GDP per Capita and CO2 emissions
	public static void main(String[] args) {
		DataFetcher df = new DataFetcher("CAN", "2014" ,"2019");
		ArrayList<Double> d = df.fetchData("EN.ATM.CO2E.PC");
		AnalysisStrategies AnalysisStrategy = new AnnualPercentageChange();
		AnalysisStrategySetter context = new AnalysisStrategySetter(AnalysisStrategy, d, null);
		ArrayList<Double> result = context.performCalculations();
	    int toyear = Integer.parseInt("2019");
	    
	    System.out.println("Annual Percentage Change of CO2 emmisions from 2015 to 2019");
		for(int i = 0 ; i < result.size();i++) {
			System.out.println(toyear + ": " + result.get(i));
			toyear--;
		}
		d = df.fetchData("AG.LND.FRST.ZS");
		AnalysisStrategy = new Average();
		context.setStrategy(AnalysisStrategy);
		context.setData1(d);
		result = context.performCalculations();
		System.out.println("Average percentage of Forest Area and Land for other uses ");
		System.out.println("Average Forest Area from 2014 to 2019: " + result.get(0));
		System.out.println("Average Area for other uses from 2014 to 2019: " + result.get(1));
		
		toyear = 2019;
		AnalysisStrategy = new Ratio();
		context.setStrategy(AnalysisStrategy);
		d = df.fetchData("NY.GDP.PCAP.CD");
		context.setData1(d);
		d = df.fetchData("EN.ATM.CO2E.PC");
		context.setData2(d);
		result = context.performCalculations();
		System.out.println("Ratio of GDP per Capita to CO2 emissions");
		for(int i = 0 ; i < result.size();i++) {
			System.out.println(toyear + ": " + result.get(i));
			toyear--;
		}

	}	

}
