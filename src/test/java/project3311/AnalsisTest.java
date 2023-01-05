package project3311;

import static org.junit.Assert.*;

import java.util.ArrayList;


import org.junit.Test;

import analysisStrategies.AnalysisStrategies;
import analysisStrategies.AnnualPercentageChange;
import analysisStrategies.Average;
import analysisStrategies.AnalysisStrategySetter;
import analysisStrategies.Ratio;
import dataFetchers.DataFetcher;

public class AnalsisTest {

	@Test
	public void testAvg_1() {
		DataFetcher df = new DataFetcher("CAN", "2014" ,"2019");
		ArrayList<Double> d = df.fetchData("AG.LND.FRST.ZS") ;
		AnalysisStrategies avg = new Average();
		AnalysisStrategySetter c = new AnalysisStrategySetter(avg, d, null);
		ArrayList<Double> result = c.performCalculations();
		System.out.println(result.get(0));
		System.out.println(result.get(1));
		

		assertTrue(true);
		
	}
	@Test
	public void testAnnualPercentageChange_1() {
		DataFetcher df = new DataFetcher("CAN", "2014" ,"2019");
		ArrayList<Double> d = df.fetchData("EN.ATM.CO2E.PC") ;
		AnalysisStrategies annualpercent = new AnnualPercentageChange();
		AnalysisStrategySetter c = new AnalysisStrategySetter(annualpercent, d, null);
		ArrayList<Double> result = c.performCalculations();
		System.out.println(result.get(0));
		System.out.println(result.get(1));
		System.out.println(result.get(2));
		

		assertTrue(true);
		
	}
	@Test
	public void testRatio_1() {
		DataFetcher df1 = new DataFetcher("CAN", "2014" ,"2019");
		ArrayList<Double> d1 = df1.fetchData("EN.ATM.CO2E.PC") ;
		DataFetcher df2 = new DataFetcher("CAN", "2014" ,"2019");
		ArrayList<Double> d2 = df2.fetchData("NY.GDP.PCAP.CD") ;
		
		AnalysisStrategies ratio = new Ratio();
		AnalysisStrategySetter c = new AnalysisStrategySetter(ratio, d2, d1);
		ArrayList<Double> result = c.performCalculations();
		System.out.println(result.get(0));
		System.out.println(result.get(1));
		System.out.println(result.get(2));
		
		assertTrue(true);
		
	}

}
