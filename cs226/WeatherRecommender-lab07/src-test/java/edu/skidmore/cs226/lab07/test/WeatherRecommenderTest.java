package edu.skidmore.cs226.lab07.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;

import edu.skidmore.cs226.lab07.WeatherCondition;



public class WeatherRecommenderTest {
	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(WeatherRecommenderTest.class);
	}
	
	/**
	 * Testing the to String method in weather condition enum
	 */
	@Test
	public void testToString() {
		LOG.info("Creating a weather condition instance");
		WeatherCondition[] wc= WeatherCondition.values();
		LOG.info("checking if the toString calue is expected value");
		assertEquals("Cold and Clear", wc[0].toString());
		LOG.info("checking if the toString is notNull");
		assertNotNull(wc[0].toString());
	}
	
}
