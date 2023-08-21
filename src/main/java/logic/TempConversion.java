package logic;

public class TempConversion {
	
	public static double CelsiusToTemp(double temp, int unidad) {
		double factor, factor2;
		double resultado;
		switch (unidad) {
		case 0:
			// To Kelvin.
			factor = 273.15;
			resultado = temp + factor;
			return resultado;
		case 1:
			// To Fahrenheit.
			factor = 1.8000;
			factor2 = 32.0;
			resultado = (temp*factor)+factor2;
			return resultado;
		default:
			return temp;
		}
	}
	
	public static double KelvinToTemp(double temp, int unidad) {
		double factor, factor2, factor3;
		double resultado;
		switch (unidad) {
		case 0:
			// To Celsius.
			factor = 273.15;
			resultado = temp - factor;
			return resultado;
		case 1:
			// To Fahrenheit.
			factor = 1.8000;
			factor2 = 32.0;
			factor3 = temp - 273.15;
			resultado = (factor3*factor)+factor2;
			return resultado;
		default:
			return temp;
		}
	}

	public static double FahrenheitToTemp(double temp, int unidad) {
		double factor, factor2, factor3;
		double resultado;
		switch (unidad) {
		case 0:
			// To Celsius.
			factor = 1.8000;
			factor2 = 32.0;
			resultado = (temp-factor2)/factor;
			return resultado;
		case 1:
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
