package logic;

public class TempConverter2 {
	
	public double doTempConvert(double temp, String unit) {
		double factor, factor2, factor3;
		double resultado;
		switch (unit) {
		case "C°toK°":
			// To Kelvin.
			factor = 273.15;
			resultado = temp + factor;
			return resultado;
		case "C°toF°":
			// To Fahrenheit.
			factor = 1.8000;
			factor2 = 32.0;
			resultado = (temp*factor)+factor2;
			return resultado;
		case "K°toC°":
			// To Celsius.
			factor = 273.15;
			resultado = temp - factor;
			return resultado;
		case "K°toF°":
			// To Fahrenheit.
			factor = 1.8000;
			factor2 = 32.0;
			factor3 = temp - 273.15;
			resultado = (factor3*factor)+factor2;
			return resultado;
		case "F°toC°":
			// To Celsius.
			factor = 1.8000;
			factor2 = 32.0;
			resultado = (temp-factor2)/factor;
			return resultado;
		case "F°toK°":
			// To Kelvin.
			factor = 1.8000;
			factor2 = 32.0;
			factor3 = 273.15;
			resultado = ((temp-factor2)/factor)+factor3;
			return resultado;
		default:
			return temp;
		}
	}
}