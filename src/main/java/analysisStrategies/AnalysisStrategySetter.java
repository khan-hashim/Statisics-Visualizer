package analysisStrategies;

import java.util.ArrayList;


public class AnalysisStrategySetter {
	
	private AnalysisStrategies strategy;
	private ArrayList<Double> data1;
	private ArrayList<Double> data2;
	
	public AnalysisStrategySetter(AnalysisStrategies as , ArrayList<Double> d1 , ArrayList<Double> d2) {
		this.strategy = as;
		this.data1 = d1;
		this.data2 = d2;
	}
	public AnalysisStrategySetter(AnalysisStrategies as , ArrayList<Double> d1) {
		this.strategy = as;
		this.data1 = d1;
	}
	
	public void setStrategy(AnalysisStrategies as) {
		this.strategy = as;
	}
	public ArrayList<Double> getData1(){
		return this.data1;
	}
	public void setData1(ArrayList<Double> data) {
		this.data1 = data;
	}
	
	public ArrayList<Double> getData2(){
		return this.data2;
	}
	public void setData2(ArrayList<Double> data) {
		this.data2 = data;
	}
	
	public ArrayList<Double> performCalculations(){
		ArrayList<Double> result = this.strategy.DoCalculations(this);
		return result;
	}
	


}
