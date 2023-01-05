package userInterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

import controllers.MainController;
import controllers.Observer;
import controllers.Subject;
import errorChecking.Command;
import errorChecking.CountryErrorCheck;
import errorChecking.ErrorCheckExecutor;
import errorChecking.Invoker;
import errorChecking.ViewerErrorCheck;
import errorChecking.YearErrorCheck;

public class MainPage extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private static MainPage instance;

	public static MainPage getInstance() {
		if (instance == null)
			instance = new MainPage();

		return instance;
	}
	private JComboBox<String> countriesList;
    private JComboBox<String> fromList;
	private JComboBox<String> toList;
	private JComboBox<String> analysisList;
	private JComboBox<String> viewsList;
	
	private String country;
	private String fromYear;
	private String toYear;
	private String analysisType;
	private String viewerSelected;
	
	private ErrorCheckExecutor receiver;
	private Invoker errorCheck;
	private Subject subject;
	private Command command;
	private ArrayList<Observer> viewers;
	private BarGraph bargraph;
	private LineGraph linegraph;
	private ScatterPlot scattergraph;
	private PieChart piechart;
	
	private JPanel west; 
	
 

	private MainPage() {
		// Set window title

		super("Country Statistics");
		subject = new Subject();
		errorCheck = new Invoker();
		receiver = new ErrorCheckExecutor();
		viewers = new ArrayList<>();

		// Set top bar
		JLabel chooseCountryLabel = new JLabel("Choose a country: ");
		Vector<String> countriesNames = new Vector<String>();
		countriesNames.add("USA");countriesNames.add("Pakistan");
		countriesNames.add("Canada");countriesNames.add("India");
		countriesNames.add("France");countriesNames.add("Germany");
		countriesNames.add("China");countriesNames.add("United Kingdom");
		countriesNames.add("Brazil");countriesNames.add("Philippines");
		countriesNames.sort(null);
         
	    // country selecter with error checking and extracts country name
		countriesList = new JComboBox<String>(countriesNames);
		ActionListener countriesActionListener = new ActionListener() {// add actionlistner to listen for change
			@Override
			public void actionPerformed(ActionEvent e) {
				country = (String) countriesList.getSelectedItem();// get the selected item
				ArrayList<String> s = new ArrayList<>();
				s.add(country);
				command = new CountryErrorCheck(receiver);
				errorCheck.setCommand(command);
				boolean check = errorCheck.executeErrorChecking(s);
				if(check) {
					JOptionPane.showMessageDialog(null,"Analysis for this country are not available.","Error", JOptionPane.WARNING_MESSAGE);
				}

			}
		};
		countriesList.addActionListener(countriesActionListener);

		JLabel from = new JLabel("From");
		JLabel to = new JLabel("To");
		Vector<String> years = new Vector<String>();

		for (int i = 2019; i >= 2000; i--) {
			years.add("" + i);
		}
        // From year selecter extracting from Year selected
		fromList = new JComboBox<String>(years);
		ActionListener fromListActionListener = new ActionListener() {// add actionlistner to listen for change
			@Override
			public void actionPerformed(ActionEvent e) {

				fromYear = (String) fromList.getSelectedItem();// get the selected item
				System.out.println(fromYear);

			}
		};
		fromList.addActionListener(fromListActionListener);
        
		//To year selecter with error checking and extracting to year selected
		toList = new JComboBox<String>(years);
		ActionListener toListActionListener = new ActionListener() {// add actionlistner to listen for change
			@Override
			public void actionPerformed(ActionEvent e) {

				toYear = (String) toList.getSelectedItem();// get the selected item
				ArrayList<String> s = new ArrayList<>();
				s.add(fromYear);
				s.add(toYear);
				command = new YearErrorCheck(receiver);
				errorCheck.setCommand(command);
				boolean check = errorCheck.executeErrorChecking(s);
				if(!check) {
					JOptionPane.showMessageDialog(null,"To year less than From Year","Error", JOptionPane.WARNING_MESSAGE);
				}

			}
		};
		toList.addActionListener(toListActionListener);

	    // addd items to  Top bar
		JPanel north = new JPanel();
		north.add(chooseCountryLabel);
		north.add(countriesList);
		north.add(from);
		north.add(fromList);
		north.add(to);
		north.add(toList);

		// Set bottom bar
		
		JButton recalculate = new JButton(new AbstractAction("Recalculate") {

			@Override
			public void actionPerformed(ActionEvent e) {
				west.removeAll();
				MainController controller = new MainController(country, fromYear, toYear, analysisType , subject);
				controller.ReCalculate(); 
				System.out.println("Recalculation initiated");
				String s = controller.getViewerType();
				viewers = subject.getViewers();
				renderViewers(s);

			}
		});

		JLabel viewsLabel = new JLabel("Available Views: ");

		Vector<String> viewsNames = new Vector<String>();
		viewsNames.add("Pie Chart");
		viewsNames.add("Line Chart");
		viewsNames.add("Bar Chart");
		viewsNames.add("Scatter Chart");
		// viewer selected list extracts name of viewer selected
		viewsList = new JComboBox<String>(viewsNames);
		ActionListener viewsListActionListener = new ActionListener() {// add actionlistner to listen for change
			@Override
			public void actionPerformed(ActionEvent e) {

				viewerSelected = (String) viewsList.getSelectedItem();// get the selected item
				System.out.println(viewerSelected);

			}
		};
		viewsList.addActionListener(viewsListActionListener);

		JButton addView = new JButton(new AbstractAction("+") {
			public void actionPerformed(ActionEvent ae) {
				command = new ViewerErrorCheck(receiver);
				errorCheck.setCommand(command);
				ArrayList<String> s = new ArrayList<>();
				s.add(viewerSelected);
				s.add(analysisType);
				boolean check = errorCheck.executeErrorChecking(s);
				if(!check) {
					JOptionPane.showMessageDialog(null,viewerSelected + " not allowed for this Analysis Type","Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(viewerSelected.equals("Bar Chart")) {
						bargraph = new BarGraph();
						subject.attach(bargraph);
					} 
					else if(viewerSelected.equals("Line Chart")){
						linegraph = new LineGraph();
						subject.attach(linegraph);
					}
					else if(viewerSelected.equals("Scatter Chart")) {
						scattergraph = new ScatterPlot();
						subject.attach(scattergraph);
					}
					else if(viewerSelected.equals("Pie Chart")) {
						piechart = new PieChart();
						subject.attach(piechart);
						
					}
					
				}
				
				
			}
		});

		JButton removeView = new JButton(new AbstractAction("-") {
			public void actionPerformed(ActionEvent ae) {
				if(viewerSelected.equals("Bar Chart")) {
					subject.detach(bargraph);
				} 
				else if(viewerSelected.equals("Line Chart")){
					subject.detach(linegraph);
				}
				else if(viewerSelected.equals("Scatter Chart")) {
					subject.detach(scattergraph);
				}
				else if(viewerSelected.equals("Pie Chart")) {
					subject.detach(piechart);
				}
				
				System.out.println("Viever "+ viewerSelected +"has been removed");
				
			}
		});

		JLabel methodLabel = new JLabel("        Choose analysis method: ");

		Vector<String> analysisNames = new Vector<String>();
		analysisNames.add("PollutionIndicators");
		analysisNames.add("AirPollutionVsForestArea");
		analysisNames.add("HealthVsEducationExpenditure");
		analysisNames.add("GDPperCapitaVsCO2emissions");
		analysisNames.add("AverageForestArea");
		analysisNames.add("AverageExpenditureOnEducation");
		analysisNames.add("GDPgrowthVsPoliticalStability");
		analysisNames.add("MortalityRateVsAccessToHealth");
		
		
        // Analysis Types selecter and extracts analysis selected;
		analysisList = new JComboBox<String>(analysisNames);
		ActionListener analysisListActionListener = new ActionListener() {// add actionlistner to listen for change
			@Override
			public void actionPerformed(ActionEvent e) {

				analysisType = (String) analysisList.getSelectedItem();// get the selected item
				System.out.println(analysisType);

			}
		};
		analysisList.addActionListener(analysisListActionListener);

		JPanel south = new JPanel();
		south.add(viewsLabel);
		south.add(viewsList);
		south.add(addView);
		south.add(removeView);

		south.add(methodLabel);
		south.add(analysisList);
		south.add(recalculate);
		JPanel east = new JPanel();

		// Set charts region
		west = new JPanel();
		west.setLayout(new GridLayout(2, 0));
		
		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(east, BorderLayout.EAST);
		getContentPane().add(south, BorderLayout.SOUTH);
		getContentPane().add(west, BorderLayout.WEST);

	}

	public void actionPerformed(ActionEvent ae) {// pass action listener as a parameter
	}
	public void renderViewers(String series) {
		ChartPanel chart;
		if(series.equals("One series")) {
			for(int i = 0 ; i < viewers.size() ; i++) {
				chart = viewers.get(i).createOneSeriesChart();
				west.add(chart);
			}
		
		}
		else if(series.equals("Two series")) {
			for(int i = 0; i < viewers.size() ; i++) {
				chart = viewers.get(i).createTwoSeriesChart();
				west.add(chart);
			}
		}
		else if(series.equals("Three series")) {
			for(int i = 0; i < viewers.size() ; i++) {
				chart = viewers.get(i).createThreeSeriesChart();
				west.add(chart);
			}
		
		}
	}

}
