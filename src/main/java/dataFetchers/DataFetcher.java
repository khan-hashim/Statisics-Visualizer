package dataFetchers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class DataFetcher {
	private String country ;
	private String fromDate;
	private String toDate;
	private HashMap<String, String> countryCodes;
	
	public DataFetcher(String aCountry, String fromDate, String toDate) {
		this.country = aCountry;
		this.fromDate = fromDate;
		this.toDate = toDate;
		countryCodes = new HashMap<>();
		countryCodes.put("Brazil", "BRA"); countryCodes.put("Canada", "CAN"); countryCodes.put("USA", "USA");
		countryCodes.put("United Kingdom", "GBR"); countryCodes.put("France", "FRA"); countryCodes.put("Germany", "DEU");
		countryCodes.put("Pakistan", "PAK"); countryCodes.put("India", "IND"); countryCodes.put("China", "CHN");
		countryCodes.put("Philippines", "PHL");
		
	}
	public ArrayList<Double> fetchData(String Indicator) {
		String countryCode = countryCodes.get(this.country);
		String urlString = String.format(
				"http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json", countryCode , Indicator, this.fromDate, this.toDate);
		ArrayList<Double> dataR= null;
		ArrayList<Double> data = null;
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200) {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
//				int size = jsonArray.size();
				int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
				dataR = new ArrayList<>();
				data = new ArrayList<>();
				Double valueForYear = 0.0;
				for (int i = 0; i < sizeOfResults; i++) {
					if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull()) {
					}
					else {
						double value = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value")
								.getAsDouble();
						valueForYear = Double.valueOf(value);
					}
					dataR.add(valueForYear);
					
				}
				for(int i = dataR.size() - 1 ; i >= 0 ; i--) {
					data.add(dataR.get(i));
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
		return data;
	}	
		
		

}
