package com.kaizenko.temperatureconverter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TemperatureConverterTest {
	
	// potential test cases
	// C	|	F
	// -------------
	// 0	|	32
	// 100	|	212
	// -40	|	-40
	// 10	| 	50
	// 37	|	98.6

	@Test
	void convertCtoF_When0C_Expect32F() {		
		TemperatureConverter tempConverter = new TemperatureConverter();
		double tempInF = tempConverter.convertCtoF(0);
		assertEquals(32, tempInF);
	}
	
	@Test
	void convertCtoF_When100C_Expect212F() {		
		TemperatureConverter tempConverter = new TemperatureConverter();
		double tempInF = tempConverter.convertCtoF(100);
		assertEquals(212, tempInF);
	}
	
	@Test
	void convertCtoF_WhenNegative40C_ExpectNegative40F() {		
		TemperatureConverter tempConverter = new TemperatureConverter();
		double tempInF = tempConverter.convertCtoF(-40);
		assertEquals(-40, tempInF);
	}
	
	@Test
	void convertCtoF_When10C_Expect50F() {		
		TemperatureConverter tempConverter = new TemperatureConverter();
		double tempInF = tempConverter.convertCtoF(10);
		assertEquals(50, tempInF);
	}
	
	@Test
	void convertCtoF_When37C_Expect98Point6F() {		
		TemperatureConverter tempConverter = new TemperatureConverter();
		double tempInF = tempConverter.convertCtoF(37);
		assertEquals(98.6, tempInF);
	}
}
