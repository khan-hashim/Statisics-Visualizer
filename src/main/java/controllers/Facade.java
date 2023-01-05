package controllers;

import java.util.ArrayList;

import analysisStrategies.AnalysisStrategies;
import analysisStrategies.AnalysisStrategySetter;
import analysisStrategies.AnnualPercentageChange;
import analysisStrategies.Average;
import analysisStrategies.Ratio;
import dataFetchers.AirPollutionVsForestArea;
import dataFetchers.AnalysisTypes;
import dataFetchers.AverageExpenditureOnEducation;
import dataFetchers.AverageForestArea;
import dataFetchers.FactoryClass;
import dataFetchers.GDPgrowthVsPoliticalStability;
import dataFetchers.GDPperCapitaVsCO2emissions;
import dataFetchers.HealthVsEducationExpenditure;
import dataFetchers.MortalityRateVsAccessToHealth;
import dataFetchers.PollutionIndicators;

public class Facade {
	private String country;
	private String fromYear;
	private String toYear;
	private String analysisType;
	private FactoryClass factory;
	private AnalysisTypes analysis;
	private AnalysisStrategies strategy;
	private AnalysisStrategySetter context;
	private ArrayList<Double> data1;
	private ArrayList<Double> data2;
	private ArrayList<Double> data3;
	private ArrayList<Double> result1;
	private ArrayList<Double> result2;
	private ArrayList<Double> result3;
	private ViewersData data;

	public Facade(String country, String fromYear, String toYear, String analysisType) {
		this.country = country;
		this.fromYear = fromYear;
		this.toYear = toYear;
		this.analysisType = analysisType;
		data = new ViewersData();
		factory = new FactoryClass(country, fromYear, toYear, analysisType);
	}

	// Analysis 1 : Pollution Indicators , APC of Co2emmision and energyuse and
	// airpollition (3 series graph)
	public ViewersData pollutionIndicators() {
		analysis = factory.factoryMethod();
		analysis.getData();
		data1 = ((PollutionIndicators) analysis).getCO2emissions();
		data2 = ((PollutionIndicators) analysis).getEnergyUse();
		data3 = ((PollutionIndicators) analysis).getPM25AirPollution();
		strategy = new AnnualPercentageChange();
		context = new AnalysisStrategySetter(strategy, data1);
		result1 = context.performCalculations();
		context.setData1(data2);
		result2 = context.performCalculations();
		context.setData1(data3);
		result3 = context.performCalculations();
		data.setDataSet1(result1);
		data.setDataSet1Label("% change of CO2 emissions");
		data.setDataSet2(result2);
		data.setDataSet2Label("% change of Energy Use");
		data.setDataSet3(result3);
		data.setDataSet3Label("% change of Air Pollution");
		data.setTitle("Pollution Indicators");
		data.setYearRange(fromYear , toYear);
		return data;
	}

	// Analysis 2 : AirPollutionVsForestArea , APC of Airpollution and Forest area (
	// 2 series graph)
	public ViewersData AirPollutionVsForestArea() {
		analysis = factory.factoryMethod();
		analysis.getData();
		data1 = ((AirPollutionVsForestArea) analysis).getForestArea();
		data2 = ((AirPollutionVsForestArea) analysis).getPM25AirPollution();
		strategy = new AnnualPercentageChange();
		context = new AnalysisStrategySetter(strategy, data1);
		result1 = context.performCalculations();
		context.setData1(data2);
		result2 = context.performCalculations();
		data.setDataSet1(result1);
		data.setDataSet1Label("% change of Air Pollution");
		data.setDataSet2(result2);
		data.setDataSet2Label("% change of Forest Area");
		data.setTitle("Air Pollution vs Forest Area");
		data.setYearRange(fromYear , toYear);
		return data;
	}

	// Analysis 3 : HealthVsEducationExpenditure , AAPC Of education and health
	// expenditure(% of GDP) (2 series graph)
	public ViewersData HealthVsEducationExpenditure() {
		analysis = factory.factoryMethod();
		analysis.getData();
		data1 = ((HealthVsEducationExpenditure) analysis).getEducationExpenditure();
		data2 = ((HealthVsEducationExpenditure) analysis).getHealthExpenditure();
		strategy = new AnnualPercentageChange();
		context = new AnalysisStrategySetter(strategy, data1);
		result1 = context.performCalculations();
		context.setData1(data2);
		result2 = context.performCalculations();
		data.setDataSet1(result1);
		data.setDataSet1Label("% change of Education Expenditure");
		data.setDataSet2(result2);
		data.setDataSet2Label("% change of Health Expenditure");
		data.setTitle("Education vs Health Expenditure");
		data.setYearRange(fromYear , toYear);
		return data;

	}

	// Analysis 4 : GDPperCapitaVsCO2emissions , RATIO : GDPperCapita: CO2emmissions
	// (1 series graph)
	public ViewersData GDPperCapitaVsCO2emissions() {
		analysis = factory.factoryMethod();
		analysis.getData();
		data1 = ((GDPperCapitaVsCO2emissions) analysis).getGDPperCapita();
		data2 = ((GDPperCapitaVsCO2emissions) analysis).getCO2emissions();
		strategy = new Ratio();
		context = new AnalysisStrategySetter(strategy, data1, data2);
		result1 = context.performCalculations();
		data.setDataSet1(result1);
		data.setDataSet1Label("Ratio of GDP per capita to CO2 emissions");
		data.setTitle("GPD per Capita vs CO2 emissions");
		data.setYearRange(fromYear, toYear);
		return data;
	}

	// Analysis 5 : AverageForestArea, Avg of forest area
	public ViewersData AverageForestArea() {
		analysis = factory.factoryMethod();
		analysis.getData();
		data1 = ((AverageForestArea) analysis).getForestArea();
		strategy = new Average();
		context = new AnalysisStrategySetter(strategy, data1);
		result1 = context.performCalculations();
		data.setDataSet1(result1);
		data.setDataSet1Label("Average Forest Area");
		data.setTitle("Average Forest Area");
		return data;
	}

	// Analysis 6 : AverageExpenditureOnEducation, Avg of govt expenditure on
	// education(% of gdp)
	public ViewersData AverageExpenditureOnEducation() {
		analysis = factory.factoryMethod();
		analysis.getData();
		data1 = ((AverageExpenditureOnEducation) analysis).getEducationExpenditure();
		strategy = new Average();
		context = new AnalysisStrategySetter(strategy, data1);
		result1 = context.performCalculations();
		data.setDataSet1(result1);
		data.setDataSet1Label("Average Expenditure on Education");
		data.setTitle("Average Expenditure on Education");
		return data;
	}

	// Analysis 7 : GDPgrowthVsPoliticalStability , no calculations
	public ViewersData GDPgrowthVsPoliticalStability() {
		analysis = factory.factoryMethod();
		analysis.getData();
		data1 = ((GDPgrowthVsPoliticalStability) analysis).getGDPGrowthRate();
		data2 = ((GDPgrowthVsPoliticalStability) analysis).getPoliticalStability();
		data.setDataSet1(data1);
		data.setDataSet1Label("GDP growth rate");
		data.setDataSet2(data2);
		data.setDataSet2Label("Political Stability");
		data.setTitle("GDP Growth rate vs Political Stabilityt");
		data.setYearRange(fromYear, toYear);
		return data;

	}

	// Analysis 8 : MortalityRateVsAccessToHealth, no calculations
	public ViewersData MortalityRateVsAccessToHealth() {
		analysis = factory.factoryMethod();
		analysis.getData();
		data1 = ((MortalityRateVsAccessToHealth) analysis).getAccessToHealth();
		data2 = ((MortalityRateVsAccessToHealth) analysis).getMortalityRate();
		data.setDataSet1(data1);
		data.setDataSet1Label("Access To Health");
		data.setDataSet2(data2);
		data.setDataSet2Label("MortalityRate(infants");
		data.setTitle("Mortality Rate vs Access To Health");
		data.setYearRange(fromYear, toYear);
		return data;

	}

}
