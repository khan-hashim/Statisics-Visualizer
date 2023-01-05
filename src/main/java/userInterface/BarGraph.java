package userInterface;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import controllers.Observer;
import controllers.Subject;
import controllers.ViewersData;

@SuppressWarnings("serial")

public class BarGraph extends JFrame implements Observer {
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
	

	public BarGraph() {
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
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < dataSet1.size(); i++) {

			dataset.setValue(dataSet1.get(i), dataSet1Label, yearRange.get(i));

		}

		for (int i = 0; i < dataSet2.size(); i++) {

			dataset.setValue(dataSet2.get(i), dataSet2Label, yearRange.get(i));

		}

		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();

		for (int i = 0; i < dataSet2.size(); i++) {

			dataset2.setValue(dataSet3.get(i), dataSet3Label, yearRange.get(i));

		}

		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();
		BarRenderer barrenderer2 = new BarRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, barrenderer1);
		CategoryAxis domainAxis = new CategoryAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));

		plot.setDataset(1, dataset2);
		plot.setRenderer(1, barrenderer2);
		plot.setRangeAxis(1, new NumberAxis(rangeAxisLabel));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart barChart = new JFreeChart(title, new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		return chartPanel;
	}

	public ChartPanel createTwoSeriesChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < dataSet1.size(); i++) {

			dataset.setValue(dataSet1.get(i), dataSet1Label, yearRange.get(i));

		}

		for (int i = 0; i < dataSet2.size(); i++) {

			dataset.setValue(dataSet2.get(i), dataSet2Label, yearRange.get(i));

		}

		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();

		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();
		BarRenderer barrenderer2 = new BarRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, barrenderer1);
		CategoryAxis domainAxis = new CategoryAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));

		plot.setDataset(1, dataset2);
		plot.setRenderer(1, barrenderer2);
		plot.setRangeAxis(1, new NumberAxis(rangeAxisLabel));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart barChart = new JFreeChart(title, new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		return chartPanel;
	}

	public ChartPanel createOneSeriesChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < dataSet1.size(); i++) {

			dataset.setValue(dataSet1.get(i), dataSet1Label, yearRange.get(i));

		}

		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, barrenderer1);
		CategoryAxis domainAxis = new CategoryAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));
		plot.setRangeAxis(1, new NumberAxis(rangeAxisLabel));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis

		JFreeChart barChart = new JFreeChart(title, new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		return chartPanel;

	}

}
