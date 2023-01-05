package errorChecking;

import java.util.ArrayList;

public class ErrorCheckExecutor {

	private ArrayList<String> countryExclusionList;
	
	public ErrorCheckExecutor() {
		countryExclusionList = new ArrayList<>();
		countryExclusionList.add("Brazil");
	}
	public boolean checkCountryError(ArrayList<String> s) {
		String country = s.get(0);
		boolean isCountryExcluded = false;

	    if (countryExclusionList.contains(country) == true) {

	        isCountryExcluded = true;
	    }

	    else {

	        isCountryExcluded = false;
	    }

	    return isCountryExcluded;
		
	}

	public boolean checkYearError(ArrayList<String> s) {
		String fromYear = s.get(0) ;
		String toYear = s.get(1);
		boolean isYearRangeValid = true;
	    int toYearInt = Integer.parseInt(toYear);
	    int fromYearInt = Integer.parseInt(fromYear);

	    if (toYearInt < fromYearInt) {

	        isYearRangeValid = false;
	    }

	    else {

	        isYearRangeValid = true;

	    }

	    return isYearRangeValid;
	}

	public boolean checkViewerError(ArrayList<String> s) {
		String viewer = s.get(0);
		String analysis = s.get(1);
		boolean check = true;
		if(viewer.equals("Pie Chart")) {
			if(!(analysis.equals("AverageForestArea") || analysis.equals("AverageExpenditureOnEducation"))) {
				check = false;
			}
		}
		return check;
	}

}
