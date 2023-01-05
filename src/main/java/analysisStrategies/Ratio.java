package analysisStrategies;

import java.util.ArrayList;


public class Ratio implements AnalysisStrategies{
	
	
	public Ratio() {
		
	}
	
	public ArrayList<Double> DoCalculations(AnalysisStrategySetter c){
		ArrayList<Double> result = new ArrayList<>();
		ArrayList<Double> data1 = c.getData1(); // GPD per capita
		ArrayList<Double> data2 = c.getData2(); // co2 emmissions
		for (int i = 0 ; i < data1.size()  ; i++) {
	        Double ratio = data1.get(i)/data2.get(i);
	        result.add(ratio);
	    }
		
		return result;
	}
	

}
