package analysisStrategies;

import java.util.ArrayList;


public class AnnualPercentageChange implements AnalysisStrategies{
    
	
	public AnnualPercentageChange() {
		
	}
	
	public ArrayList<Double> DoCalculations(AnalysisStrategySetter c){
		ArrayList<Double> result = new ArrayList<>();
		ArrayList<Double> data = c.getData1();
		for (int i =  1; i < data.size() ; i++) {
	        Double previous = data.get(i - 1);
	        Double current = data.get( i );

	        Double percentage = ((current - previous)/previous )* 100;

	        result.add(percentage);
	    }
		
		return result;
		
	}
	


}
