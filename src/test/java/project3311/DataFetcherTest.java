package project3311;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dataFetchers.AnalysisTypes;
import dataFetchers.AverageForestArea;
import dataFetchers.DataFetcher;
import dataFetchers.FactoryClass;
import dataFetchers.PollutionIndicators;

public class DataFetcherTest {

	@Test
	public void CO2data() {
		FactoryClass factory = new FactoryClass("CAN", "2014" ,"2019", "PollutionIndicators");
		AnalysisTypes type =  factory.factoryMethod();
		
	
		
		type.getData();
		ArrayList<Double> d = ((PollutionIndicators) type).getCO2emissions();
		System.out.println(d.get(0));
		System.out.println(d.get(1));
		System.out.println(d.get(2));
		System.out.println(d.get(3));
		assertTrue(true);
		
	}
	@Test
	public void ForestAreaData() {
		FactoryClass factory = new FactoryClass("BRA", "2014" ,"2019", "AverageForestArea");
		AnalysisTypes type =  factory.factoryMethod();
		type.getData();
		ArrayList<Double> d = ((AverageForestArea) type).getForestArea();
		System.out.println(d.get(0));
		System.out.println(d.get(1));
		System.out.println(d.get(2));
		System.out.println(d.get(3));
		assertTrue(true);
		
	}

}
