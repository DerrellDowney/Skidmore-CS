package edu.skidmore.cs226.lab11indiv;

import org.apache.log4j.Logger;

/**
 * Class representing the data of the movies
 * @author ddowney
 *
 */
public class Movie {
	
	/**
	 * Log attribute
	 */
	private static final Logger LOG;

	/**
	 * Setting up the logger
	 */
	static {
		LOG = Logger.getLogger(Movie.class);
	}
	
	/**
	 * Title of the movie
	 */
	private String title;
	/**
	 * director of the movie
	 */
	private String director;
	/**
	 * run time of the movie
	 */
	private String runTime;
	/**
	 * release of the movie
	 */
	private String release;
	/**
	 * due date of the movie
	 */
	private String dueDate = null;
	
	/**
	 * @return the log
	 */
	public static Logger getLog() {
		return LOG;
	}




	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}




	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}




	/**
	 * @return the runTime
	 */
	public String getRunTime() {
		return runTime;
	}




	/**
	 * @return the release
	 */
	public String getRelease() {
		return release;
	}




	/**
	 * @return the dueDate
	 */
	public String getDueDate() {
		return dueDate;
	}



	/**
	 * Constructor of the movie
	 */
	public Movie() {
	LOG.info("Movie constructor");
	}
	
	
	
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}




	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}




	/**
	 * @param runTime the runTime to set
	 */
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}




	/**
	 * @param release the release to set
	 */
	public void setRelease(String release) {
		this.release = release;
	}




	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}



	/**
	 * overriding toString to return data of the movie
	 */
	public String toString() {
		LOG.info("returning the information about the movie");
		String info = "Film title: " + title + ", Director: " + director + ", Running Time: " + runTime + " minutes, Year of Release: " + release + ", Due Date: " + dueDate ;
		return info;
	}
}
