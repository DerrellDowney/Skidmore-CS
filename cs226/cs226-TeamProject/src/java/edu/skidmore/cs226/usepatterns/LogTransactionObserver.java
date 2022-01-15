package edu.skidmore.cs226.usepatterns;

import edu.skidmore.cs226.base.MonetaryUnit;
import edu.skidmore.cs226.base.MoneyHolder;
import edu.skidmore.cs226.base.PhysicalMonetaryUnit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class LogTransactionObserver implements MonetaryTransactionObserver{

	/**
	 * The logger instance - a class-level constant.
	 */
	private static final Logger LOG;
	/**
	 * Static block for the logger
	 */
	static {
		LOG = Logger.getLogger(LogTransactionObserver.class);
	}
	/**
     * Logs the transaction to separate files for each account.
     * 
     * @param source
     *            The account backing the transaction
     * @param transactionType
     *            The type of transaction (Deposit, Withdrawal...)
     * @param transaction
     *            The currency involved in the transaction
     */
    private void logTransaction(MoneyHolder<? extends MonetaryUnit> source,
        String transactionType, PhysicalMonetaryUnit... transaction) {
    	LOG.info("running logTransaction for transaction: " + transactionType);
        String fileName = null;
        PrintWriter out = null;
        Date now = new Date();
        File transactionLogsDir = new File("transactionLogs");
        SimpleDateFormat dateFormat =
            new SimpleDateFormat("MM/dd/yyyy@HH:mm:ss");
        long value = 0;
        if (!transactionLogsDir.exists()) {
            if (!transactionLogsDir.mkdir()) {
            	LOG.error("Unable to create the " + transactionLogsDir
                        + " directory");
                System.err.println("Unable to create the " + transactionLogsDir
                    + " directory");
            }
        }

        for (PhysicalMonetaryUnit unit : transaction) {
            value += unit.getValueInCents();
        }
        LOG.info("the value for transaction: " + transactionType + " is: " + value);
        try {
            fileName = source.toString().replaceAll("[^a-zA-Z0-9]", "");
            if (fileName.length() == 0) {
                fileName = "UndefinedAccount";
            }
            fileName = "transactionLogs/" + fileName + ".Transactions.log";
            out = new PrintWriter(new FileWriter(fileName, true));
            out.printf("%19.19s %-20.20s %-10.10s $%10.2f\n",
                dateFormat.format(now), source.toString(), transactionType,
                (value / 100.0));
        }
        catch (IOException ioe) {
            System.err.println("Error writing transaction log to " + fileName);
            LOG.error("Error writing transaction log to " + fileName);
            ioe.printStackTrace();
        }
        finally {
            if (out != null) {
                out.close();
            }
        }
    }
	
	@Override
	public void update(MoneyHolder<? extends MonetaryUnit> source, String transactionType, PhysicalMonetaryUnit... transaction) {
		// TODO Auto-generated method stub
		LOG.info("running update for transaction: " + transactionType);
		logTransaction(source, transactionType, transaction);
	}

}
