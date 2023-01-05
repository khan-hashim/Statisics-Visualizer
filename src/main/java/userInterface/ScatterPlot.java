package userInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;

import controllers.Observer;
import controllers.Subject;
import controllers.ViewersData;

@SuppressWarnings("serial")

public class ScatterPlot extends JFrame implements Observer {
	private ViewersData data;
	private ArrayList<Double> dataSet1;
	private String dataSet1Label;
	private ArrayList<Double> dataSet2;
	private String dataSet2Label;
	private ArrayList<Double> dataSet3;
	private String dataSet3Label;
	private ArrayList<String> yearRange;
	private String title;
	private String rangeAxisLabel;

	public ScatterPlot() {
		dataSet1 = new ArrayList<Double>();
		dataSet2 = new ArrayList<Double>();
		dataSet3 = new ArrayList<Double>();
		dataSet1Label = "";
		dataSet2Label = "";
		dataSet3Label = "";
		yearRange = new ArrayList<String>();
		title = "";

	}

	public void update(Subject subject) {
		data = subject.getState();
		dataSet1 = data.getDataSet1();
		dataSet1Label = data.getDataSet1Label();
		dataSet2 = data.getDataSet2();
		dataSet2Label = data.getDataSet2Label();
		dataSet3 = data.getDataSet3();
		dataSet3Label = data.getDataSet3Label();
		title = data.getTitle();
		rangeAxisLabel = data.getRangeAxisTitle();
		yearRange = data.getYearRange();

	}

	public ChartPanel createThreeSeriesChart() {

		TimeSeries series1 = new TimeSeries(dataSet1Label);

		for (int i = 0; i < dataSet1.size(); i++) {

			int year = Integer.parseInt(yearRange.get(i));
			series1.add(new Year(year), dataSet1.get(i));

		}

		TimeSeries series2 = new TimeSeries(dataSet2Label);

		for (int i = 0; i < dataSet2.size(); i++) {

			int year = Integer.parseInt(yearRange.get(i));
			series2.add(new Year(year), dataSet2.get(i));

		}

		TimeSeriesCollection dataset2 = new TimeSeriesCollection();
		dataset2.addSeries(series2);

		TimeSeries series3 = new TimeSeries(dataSet3Label);

		for (int i = 0; i < dataSet3.size(); i++) {

			int year = Integer.parseInt(yearRange.get(i));
			series3.add(new Year(year), dataSet3.get(i));

		}

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series3);

		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
		XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));

		plot.setDataset(1, dataset2);
		plot.setRenderer(1, itemrenderer2);
		plot.setRangeAxis(1, new NumberAxis(rangeAxisLabel));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart scatterChart = new JFreeChart(title, new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		ChartPanel chartPanel = new ChartPanel(scatterChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		return chartPanel;
	}

	public ChartPanel createTwoSeriesChart() {

		TimeSeries series1 = new TimeSeries(dataSet1Label);

		for (int i = 0; i < dataSet1.size(); i++) {

			int year = Integer.parseInt(yearRange.get(i));
			series1.add(new Year(year), dataSet1.get(i));

		}

		TimeSeries series2 = new TimeSeries(dataSet2Label);

		for (int i = 0; i < dataSet2.size(); i++) {

			int year = Integer.parseInt(yearRange.get(i));
			series2.add(new Year(year), dataSet2.get(i));

		}

		TimeSeriesCollection dataset2 = new TimeSeriesCollection();
		dataset2.addSeries(series2);

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);

		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
		XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));

		plot.setDataset(1, dataset2);
		plot.setRenderer(1, itemrenderer2);
		plot.setRangeAxis(1, new NumberAxis(rangeAxisLabel));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart scatterChart = new JFreeChart(title, new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		ChartPanel chartPanel = new ChartPanel(scatterChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		return chartPanel;
	}

	public ChartPanel createOneSeriesChart() {

		TimeSeries series1 = new TimeSeries(dataSet1Label);

		for (int i = 0; i < dataSet1.size(); i++) {

			int year = Integer.parseInt(yearRange.get(i));
			series1.add(new Year(year), dataSet1.get(i));

		}

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);

		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
		XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));

		plot.setRenderer(1, itemrenderer2);
		plot.setRangeAxis(1, new NumberAxis(rangeAxisLabel));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart scatterChart = new JFreeChart(title, new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		ChartPanel chartPanel = new ChartPanel(scatterChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		return chartPanel;
	}

}