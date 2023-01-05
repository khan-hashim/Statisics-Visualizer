package controllers;

import java.util.ArrayList;

public class ViewersData {
	private ArrayList<Double> dataSet1;
	private String dataSet1Label;
	private ArrayList<Double> dataSet2;
	private String dataSet2Label;
	private ArrayList<Double> dataSet3;
	private String dataSet3Label;
	private ArrayList<String> yearRange;
	private String title;
	private String rangeAxisTitle;

	public ViewersData() {
		rangeAxisTitle = "US$";
		yearRange = new ArrayList<>();

	}

	public ArrayList<Double> getDataSet1() {
		return dataSet1;
	}

	public void setDataSet1(ArrayList<Double> dataSet1) {
		this.dataSet1 = dataSet1;
	}

	public String getDataSet1Label() {
		return dataSet1Label;
	}

	public void setDataSet1Label(String dataSet1Label) {
		this.dataSet1Label = dataSet1Label;
	}

	public ArrayList<Double> getDataSet2() {
		return dataSet2;
	}

	public void setDataSet2(ArrayList<Double> dataSet2) {
		this.dataSet2 = dataSet2;
	}

	public String getDataSet2Label() {
		return dataSet2Label;
	}

	public void setDataSet2Label(String dataSet2Label) {
		this.dataSet2Label = dataSet2Label;
	}

	public ArrayList<Double> getDataSet3() {
		return dataSet3;
	}

	public void setDataSet3(ArrayList<Double> dataSet3) {
		this.dataSet3 = dataSet3;
	}

	public String getDataSet3Label() {
		return dataSet3Label;
	}

	public void setDataSet3Label(String dataSet3Label) {
		this.dataSet3Label = dataSet3Label;
	}

	public ArrayList<String> getYearRange() {
		return yearRange;
	}

	public void setYearRange(String fromYear, String toYear) {
		Integer numStart = Integer.valueOf(fromYear);
		Integer numEnd = Integer.valueOf(toYear);
		for(int i = numStart ; i <= numEnd; i++) {
			yearRange.add(""  + i);
		}

		
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRangeAxisTitle() {
		return rangeAxisTitle;
	}

	public void setRangeAxisTitle(String rangeAxisTitle) {
		this.rangeAxisTitle = rangeAxisTitle;
	}
	

}
