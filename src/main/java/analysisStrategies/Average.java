package analysisStrategies;

import java.util.ArrayList;


public class Average implements AnalysisStrategies{
	
	public Average() {
	
	}
	
	public ArrayList<Double> DoCalculations(AnalysisStrategySetter c ){
		ArrayList<Double> result = new ArrayList<>();
		Double sum = 0.0;
		ArrayList<Double> data = c.getData1();
		for(int i = 0; i < data.size() ; i++) {
			sum += data.get(i);
		}
		Double avg = sum / data.size();
		Double restOfLand = 100 - avg;
	
		result.add(avg);
		result.add(restOfLand);
		return result;
	}

}
