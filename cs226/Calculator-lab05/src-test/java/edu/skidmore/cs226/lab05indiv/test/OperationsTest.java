package edu.skidmore.cs226.lab05indiv.test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.apache.log4j.Logger;
import edu.skidmore.cs226.lab05indiv.Operations;
import org.junit.Test;

public class OperationsTest {
	private static final Logger LOG;

	static {
		LOG = Logger.getLogger(OperationsTest.class);
	}
	
	@Test
	public void testSumActual() {
		LOG.debug("testing the sum method");
		Operations testOperations = new Operations();
		assertEquals("sum didn't work", 10, testOperations.sum(1,2,3,4));
		assertEquals("sum didn't work", 0, testOperations.sum());

	}
	
	@Test
	public void testProductActual() {
		LOG.debug("testing the product method");
		Operations testOperations = new Operations();
		assertEquals("product didn't work", 8, testOperations.product(2,4));
		assertEquals("product didn't work", 0, testOperations.product());
	}
	
	@Test
	public void testDiffActual() {
		LOG.debug("testing the diff method");
		Operations testOperations = new Operations();
		assertEquals("diff didn't work", 15, testOperations.diff(30, 10, 5));
		assertEquals("diff didn't work", 30, testOperations.diff(30));
	}
	
	@Test
	public void testMeanActual() {
		LOG.debug("testing the mean method");
		Operations testOperations = new Operations();
		assertEquals("mean didn't work", 4, testOperations.mean(2,4,6));
		assertEquals("mean didn't work", 0, testOperations.mean());
	}
	
	@Test
	public void testGetOrdinalNameActual() {
		LOG.debug("testing the getOrdinalName method");
		Operations testOperations = new Operations();
		assertEquals("getOrdinalName didn't work", "thirtieth", testOperations.getOrdinalName(30));
		

	}
}
