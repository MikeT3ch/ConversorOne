package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import java.util.Map;
import java.util.Locale;

public class CurrencyConversion {
	double inputMoney, outputMoney;
	// Declaracion del esqueleto de la URL
	private static final String API_BASE_URL = "http://data.fixer.io/api/";
	private static final String ACCESS_KEY = "db7d5846e1722ec72bfceb49cd1dfaa7";
	private static final String ENDPOINT = "latest";
	
	// public String
	public CurrencyData getCurrencyData() {
		try {
			// String con la url
			String urlString = API_BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&symbols=COP,EUR,USD";
			
			// Conversion a URL para acceder a metodos propios de URL
			URL url = new URL(urlString);
			// Abrimos conexión
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			// Leemos lo que nos da la URL
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			// Constructor de String
			StringBuilder response = new StringBuilder();
			String line;
			
			// Mientras que line no sea null, une line a response.
			while ((line = reader.readLine()) != null) {
                response.append(line);
            }
			// Cerramos el lector de buffer.
            reader.close();
            
            // Desconectamos https.
            connection.disconnect();
            // Convertimos JSON a String y lo convertimos en un objeto CurrencyData
            Gson gson = new Gson();
            CurrencyData currencyData = gson.fromJson(response.toString(), CurrencyData.class);

            return currencyData;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public double doConvertion(String from, String to, double amount) {
		CurrencyConversion converter = new CurrencyConversion();
		CurrencyData currencyData = converter.getCurrencyData();
		
		if (currencyData != null) {
			Map<String, Double> rates = currencyData.getRates();
			double fromCurrency = rates.get(from);
			double toCurrency = rates.get(to);
			double convertedAmount = amount / fromCurrency * toCurrency;
			
			return convertedAmount;
		} else {
			return amount;
		}
	}
	
	/*public static void main(String[] args) {
		String from = "USD";
		String to = "COP";
		double amount = 5.0;
		CurrencyConversion testConversion = new CurrencyConversion();
		double answer = testConversion.doConvertion(from, to, amount);
		System.out.println(String.format("%.2f", answer));  
	}*/
}
