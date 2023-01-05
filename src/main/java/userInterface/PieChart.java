package userInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import controllers.Observer;
import controllers.Subject;
import controllers.ViewersData;


@SuppressWarnings("serial")

public class PieChart extends JFrame implements Observer {
	
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
	

	public PieChart() {
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
	

	public ChartPanel createOneSeriesChart() {
	
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		for (int i = 0; i < dataSet1.size(); i++ ) {
			
			if(i == 0) {
				dataset.setValue( dataSet1Label, dataSet1.get(i));
			}
			if(i == 1) {
				dataset.setValue("Rest",dataSet1.get(i));
			}
					
		}
		 
		 JFreeChart pieChart = ChartFactory.createPieChart(title,
		 dataset, true, true, false);	
		
	
		ChartPanel chartPanel = new ChartPanel(pieChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		return chartPanel;
	}
	public ChartPanel createTwoSeriesChart() {
		return null;
	}
	public ChartPanel createThreeSeriesChart() {
		return null;
	}

}