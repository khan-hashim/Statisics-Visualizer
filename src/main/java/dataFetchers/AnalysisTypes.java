package dataFetchers;

public abstract class AnalysisTypes {
// Product class in Factory method. defines interface for  all the types of interface
	protected String country;
	protected String fromDate;
	protected String toDate;
	protected DataFetcher df;
	
	public AnalysisTypes(String country, String fromDate, String toDate) {
		this.country = country;
		this.fromDate = fromDate;
		this.toDate = toDate;
		df = new DataFetcher(this.country, this.fromDate ,this.toDate);
	}
	
	public abstract void getData();
}
