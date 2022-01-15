package edu.skidmore.cs226.lab09.test;

import static org.junit.Assert.*;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mortbay.log.Log;

import edu.skidmore.cs226.lab09.Movie;


public class MovieTest {
	private static final Logger LOG;

	static {
		LOG = Logger.getLogger(MovieTest.class);
	}
	
	/**
	 * Testing the get and set Title method
	 */
	@Test
	public void testGetSetTitle() {
		LOG.info("creating a movie");
		Movie movie = new Movie();
		LOG.info("creatinga a title");
		movie.setTitle("title");
		assertEquals("title", movie.getTitle());
		
	}
	
	/**
	 * Testing the get and set Director method
	 */
	@Test
	public void testGetSetDirector() {
		LOG.info("creating a movie");
		Movie movie = new Movie();
		LOG.info("setting a director");
		movie.setDirector("director");
		assertEquals("director", movie.getDirector());
	}
	
	/**
	 * Testing the get and set RunTime method
	 */
	@Test
	public void testGetSetRunTime() {
		LOG.info("creating a movie");
		Movie movie = new Movie();
		LOG.info("setting a runtime");
		movie.setRunTime("120 minutes");
		assertEquals("120 minutes", movie.getRunTime());
	}
	
	/**
	 * Testing the get and set Release method
	 */
	@Test
	public void testGetSetRelease() {
		LOG.info("creating a movie");
		Movie movie = new Movie();
		LOG.info("setting a release");
		movie.setRelease("release");
		assertEquals("release", movie.getRelease());
	}
	
	/**
	 * Testing the get and set DueDate method
	 */
	@Test
	public void testGetSetDueDate() {
		LOG.info("creating a movie");
		Movie movie = new Movie();
		LOG.info("setting a duedate");
		movie.setDueDate("March");
		assertEquals("March", movie.getDueDate());
	}
}
