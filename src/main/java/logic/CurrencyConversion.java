package logic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import java.util.Map;

public class CurrencyConversion {
	double inputMoney, outputMoney;
	private static final String API_BASE_URL = "http://data.fixer.io/api/";
	private static final String ACCESS_KEY = "db7d5846e1722ec72bfceb49cd1dfaa7";
	private static final String ENDPOINT = "latest";
	
	// public String
	public CurrencyData getCurrencyData() {
		try {
			String urlString = API_BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&symbols=COP,EUR";
			URL url = new URL(urlString);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			
			String line;
			while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            connection.disconnect();
            // return response.toString();
            Gson gson = new Gson();
            CurrencyData currencyData = gson.fromJson(response.toString(), CurrencyData.class);

            return currencyData;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public static void main(String[] args) {
        CurrencyConversion converter = new CurrencyConversion();
        CurrencyData currencyData = converter.getCurrencyData();

        if (currencyData != null) {
            // Ahora puedes acceder a la propiedad "rates" y realizar cálculos con sus valores
            Map<String, Double> rates = currencyData.getRates();
            double copRate = rates.get("COP");
            double eurRate = rates.get("EUR");

            // Ejemplo de cálculo
            double amountInCOP = 5000.0;
            double convertedAmount = amountInCOP / copRate * eurRate;

            System.out.println("COP to EUR: " + convertedAmount);
        } else {
            System.out.println("Error al obtener los datos.");
        }
    }
}
