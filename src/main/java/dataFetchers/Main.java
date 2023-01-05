package dataFetchers;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// This is the class to test the Data Fetching code. User can input The Country, from year, to year and the 
	// type of analysis to perform. The results of the fetched data will be printed.
	public void printarraylist(ArrayList<Double> d, String fromyear, String toyear) {
		int ty = Integer.parseInt(toyear);
		for(int i = 0 ; i < d.size();i++) {
			System.out.println(ty + ": " + d.get(i));
			ty -=1;
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
		System.out.println("Enter Country with the right Country Code");  
	    String country= sc.nextLine();  
		System.out.println("Enter From year- ");  
		String fromyear= sc.nextLine();  
		System.out.println("Enter To year- ");  
		String toyear= sc.nextLine();
		System.out.println("Enter type of Analysis(Use proper name as identified in if else statement"); // COPY PASTE from Factory class
		String analysistype= sc.nextLine();
		sc.close();
		
		FactoryClass factory = new FactoryClass(country, fromyear ,toyear, analysistype);
		AnalysisTypes analysis =  factory.factoryMethod();
		analysis.getData();
		ArrayList<Double> d;
		Main m = new Main();
		// prints the data fetched for the analysis seleceted
		if(analysistype.equals("PollutionIndicators")) {
		   d = ((PollutionIndicators) analysis).getCO2emissions();
		   System.out.println("CO2 emissions");
		   m.printarraylist(d, fromyear, toyear);
		   d = ((PollutionIndicators) analysis).getEnergyUse();
		   System.out.println("Energy Use");
		   m.printarraylist(d, fromyear, toyear);
		   d = ((PollutionIndicators) analysis).getPM25AirPollution();
		   System.out.println("PM2.5 Air Pollution");
		   m.printarraylist(d, fromyear, toyear);
		}
		else if(analysistype.equals("AirPollutionVsForestArea")) {
			d = ((AirPollutionVsForestArea) analysis).getForestArea();
			System.out.println("Forest Area");
			m.printarraylist(d, fromyear, toyear);
			d = ((AirPollutionVsForestArea) analysis).getPM25AirPollution();
			System.out.println("PM2.5 Air Pollution");
			m.printarraylist(d, fromyear, toyear);
		}
		else if(analysistype.equals("HealthVsEducationExpenditure")) {
			d = ((HealthVsEducationExpenditure) analysis).getEducationExpenditure();
			System.out.println("Education Expenditure");
			m.printarraylist(d, fromyear, toyear);
			d = ((HealthVsEducationExpenditure) analysis).getHealthExpenditure();
			System.out.println("Health Expenditure");
			m.printarraylist(d, fromyear, toyear);
		}
		else if(analysistype.equals("GDPgrowthVsPoliticalStability")) {
			d = ((GDPgrowthVsPoliticalStability) analysis).getGDPGrowthRate();
			System.out.println("GDP Growth Rate");
			m.printarraylist(d, fromyear, toyear);
			d = ((GDPgrowthVsPoliticalStability) analysis).getPoliticalStability();
			System.out.println("Political Stability");
			m.printarraylist(d, fromyear, toyear);
		}
		else if(analysistype.equals("MortalityRateVsAccessToHealth")) {
			d = ((MortalityRateVsAccessToHealth) analysis).getAccessToHealth();
			System.out.println("Acces to Health");
			m.printarraylist(d, fromyear, toyear);
			d = ((MortalityRateVsAccessToHealth) analysis).getMortalityRate();
			System.out.println("Mortaility Rate, infant");
			m.printarraylist(d, fromyear, toyear);
		}
		else if(analysistype.equals("GDPperCapitaVsCO2emissions")) {
			d = ((GDPperCapitaVsCO2emissions) analysis).getCO2emissions();
			System.out.println("CO2 Emissions");
			m.printarraylist(d, fromyear, toyear);
			d = ((GDPperCapitaVsCO2emissions) analysis).getGDPperCapita();
			System.out.println("GDP per Capita");
			m.printarraylist(d, fromyear, toyear);
		}
		else if(analysistype.equals("AverageForestArea")) {
			d = ((AverageForestArea) analysis).getForestArea();
			System.out.println("Forest Area");
			m.printarraylist(d, fromyear, toyear);
		}
		else if(analysistype.equals("AverageExpenditureOnEducation")) {
			d = ((AverageExpenditureOnEducation) analysis).getEducationExpenditure();
			System.out.println("Education Expenditure");
			m.printarraylist(d, fromyear, toyear);
		}

	}
	

}
