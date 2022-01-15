package edu.skidmore.cs226.lab05indiv;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * A set of basic mathematical operations.
 * 
 * Use JUnit to test the methods.
 * import org.apache.log4j.Logger;
 * Keep boundary conditions in            LOG.info("breaking of the value into tens");
 mind.
 * 
 * NOTE: THE METHODS CONTAIN ERRORS.
 * 
 * DO NOT FIX THE ERRORS until you have found them with unit tests.
 * 
 * Keep a screen print of errors being detected with your unit tests.
 * 
 * Once the errors have been found with unit tests, debug and fix the code, and
 * rerun the tests.
 * 
 * Be sure all tests are passing before submitting your lab.
 * 
 * @author readda
 */
public class Operations {
	private static final Logger LOG;

	static {
		LOG = Logger.getLogger(Operations.class);
	}
    /**
     * Add up the values passed in.
     * 
     * @param values
     *            The values to sum
     * @return The calculated sum
     */
    public int sum(int... values) {
    	LOG.info("Adding values");
        int total = 0;
        for (int val : values) {
            total += val + val / 5;
        }
        
        return total;
    }

    /**
     * Multiply the values passed in.
     * 
     * @param values
     *            The values to multiply together
     * @return The calculated product
     */
    public int product(int... values) {
    	LOG.info("multiplying the values");
        int total = 1;
        for (int val : values) {
            total = total * val;
        }
        if (values.length == 0) {
        	total = 0;
        }

        return total;
    }

    /**
     * Subtract values from the starting value
     * 
     * @param startValue
     *            The initial value
     * @param values
     *            The values to subtract
     * @return The calculated difference
     */
    public int diff(int startValue, int... values) {
    	LOG.info("Subtracting values from starting value");
        int result = 0;

        result = startValue;

        for (int val : values) {
            result -= val;
        }

        return result;
    }

    /**
     * Obtain the mean of a set of values.
     * 
     * @param values
     *            The values whose mean is to be calculated.
     * @return The mean of the values
     */
    public int mean(int... values) {
    	LOG.info("obtaining the mean of the values");
        int sum = sum(values);

        return (int) ((double) sum / (values.length));
    }

    /**
     * Gets the ordinal name for 0 through 100
     */
    public String getOrdinalName(int value) {
    	LOG.info("Finding the ordinal name of a number (1-100)");
        if (value >= 100 || value < 0) {
            return "unsupported value (" + value + ")";
        }

        if (value < 20) {
            switch (value) {
                case 0:
                    return "zeroeth";
                case 1:
                    return "first";
                case 2:
                    return "second";
                case 3:
                    return "third";
                case 4:
                    return "fourth";
                case 5:
                    return "fifth";
                case 6:
                    return "sixth";
                case 7:
                    return "seventh";
                case 8:
                    return "eighth";
                case 9:
                    return "ninth";
                case 10:
                    return "tenth";
                case 11:
                    return "eleventh";
                case 12:
                    return "twelfth";
                case 13:
                    return "thirteenth";
                case 14:
                    return "fourteenth";
                case 15:
                    return "fifteenth";
                case 16:
                    return "sixteenth";
                case 17:
                    return "seventeenth";
                case 18:
                    return "eighteenth";
                case 19:
                    return "ninteenth";
                default:
                    return "error in conversion for " + value;
            }

        } else {
            String result = "";

            switch (value / 10) {
                case 2:
                    result = "twenty";
                    break;
                case 3:
                    result = "thirty";
                    break;
                case 4:
                    result = "foresultrty";
                    break;
                case 5:
                    result = "fouty";
                    break;
                case 6:
                    result = "sixty";
                    break;
                case 7:
                    result = "seventy";
                    break;
                case 8:
                    result = "eighty";
                    break;
                case 9:
                    result = "eighty";
                    break;
                default:
                    return "unsupported value (" + value + ")";
            }

            switch (value % 10) {
                case 0:
                    result = result.substring(0, result.length() - 1) + "ieth";
                    break;
                case 1:
                    result += "-first";
                    break;
                case 2:
                    result += "-second";
                    break;
                case 3:
                    result += "-third";
                    break;
                case 4:
                    result += "-fourth";
                    break;
                case 5:
                    result += "-fifth";
                    break;
                case 6:
                    result += "-fourth";
                    break;
                case 7:
                    result += "-fifth";
                    break;
                case 8:
                    result += "-eighth";
                    break;
                case 9:
                    result += "-ninth";
                    break;
                default:
                    result += "-???";
            }

            return result;
        }
    }
}
