package userInterface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import controllers.Observer;
import controllers.Subject;
import controllers.ViewersData;

@SuppressWarnings("serial")

public class LineGraph extends JFrame implements Observer{

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
	

	public LineGraph() {
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

		XYSeries series1 = new XYSeries(dataSet1Label);

		for (int i = 0; i < dataSet1.size(); i++) {

			int year = Integer.parseInt(yearRange.get(i));
			series1.add(year, dataSet1.get(i));

		}

		XYSeries series2 = new XYSeries(dataSet2Label);

		for (int i = 0; i < dataSet2.size(); i++) {

			int year = Integer.parseInt(yearRange.get(i));
			series2.add(year, dataSet2.get(i));

		}

		XYSeries series3 = new XYSeries(dataSet3Label);

		for (int i = 0; i < dataSet3.size(); i++) {

			int year = Integer.parseInt(yearRange.get(i));
			series3.add(year, dataSet3.get(i));

		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);

		JFreeChart chart = ChartFactory.createXYLineChart(title, "Year", "", dataset, PlotOrientation.VERTICAL, true,
				true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(new TextTitle(title, new Font("Serif", java.awt.Font.BOLD, 18)));

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		
		return chartPanel;
	}

	public ChartPanel createTwoSeriesChart() {

		XYSeries series1 = new XYSeries(dataSet1Label);

		for (int i = 0; i < dataSet1.size(); i++) {

			int year = Integer.parseInt(yearRange.get(i));
			series1.add(year, dataSet1.get(i));

		}

		XYSeries series2 = new XYSeries(dataSet2Label);

		for (int i = 0; i < dataSet2.size(); i++) {

			int year = Integer.parseInt(yearRange.get(i));
			series2.add(year, dataSet2.get(i));

		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);

		JFreeChart chart = ChartFactory.createXYLineChart(title, "Year", "", dataset, PlotOrientation.VERTICAL, true,
				true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(new TextTitle(title, new Font("Serif", java.awt.Font.BOLD, 18)));

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		return chartPanel;
	}

	public ChartPanel createOneSeriesChart() {

		XYSeries series1 = new XYSeries(dataSet1Label);

		for (int i = 0; i < dataSet1.size(); i++) {

			int year = Integer.parseInt(yearRange.get(i));
			series1.add(year, dataSet1.get(i));

		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);

		JFreeChart chart = ChartFactory.createXYLineChart(title, "Year", "", dataset, PlotOrientation.VERTICAL, true,
				true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(new TextTitle(title, new Font("Serif", java.awt.Font.BOLD, 18)));

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		return chartPanel;

	}

}
