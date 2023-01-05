package controllers;

import org.jfree.chart.ChartPanel;

public interface Observer {

	public void update(Subject s);
	public ChartPanel createOneSeriesChart();
	public ChartPanel createTwoSeriesChart();
	public ChartPanel createThreeSeriesChart();

}
