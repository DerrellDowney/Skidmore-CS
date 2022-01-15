package edu.skidmore.cs226.usepatterns;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import antlr.collections.List;
import edu.skidmore.cs226.base.Coin;
import edu.skidmore.cs226.base.PaperCurrency;
import edu.skidmore.cs226.base.PhysicalMonetaryUnit;
import edu.skidmore.cs226.base.PredefinedMonetaryUnit;

public class PhysicalMoneyFactory {
	/**
	 * The logger instance - a class-level constant.
	 */
	private static final Logger LOG;
	/**
	 * Static block for the logger
	 */
	static {
		LOG = Logger.getLogger(PhysicalMoneyFactory.class);
	}
	/**
	 * Instance of PhysicalMoneyFactory
	 */
	private static PhysicalMoneyFactory instance;
	/**
	 * PredifinedMonetaryUnit array
	 */
	
	private PredefinedMonetaryUnit[] moneyUnits = PredefinedMonetaryUnit.values();
	
	private PhysicalMoneyFactory() {
		
	}

	/**
	 * @return the instance
	 */
	public static PhysicalMoneyFactory getInstance() {
		LOG.info("Retuning instance");
		instance = new PhysicalMoneyFactory();
		return instance;
	}
	/**
	 * Returns the smallest set of possible currency for the value given
	 * @param desiredAmountInCents
	 * @return returnArray
	 */
	public PhysicalMonetaryUnit[] mintMoney(long desiredAmountInCents) {
		SerialNumberGenerator serialGen = SerialNumberGenerator.getInstance();
		
		ArrayList<PhysicalMonetaryUnit> arrlist = new ArrayList<PhysicalMonetaryUnit>();
		for(int i = moneyUnits.length -1; i >= 0; i--){
			if(desiredAmountInCents < 100) {
				LOG.debug("The value: " + desiredAmountInCents + " is less than 100, it is a coin");
				while(desiredAmountInCents>=moneyUnits[i].getValueInCents()) {
					Coin model = new Coin(""+moneyUnits[i], moneyUnits[i].getValueInCents(), null, null);
					LOG.debug("Adding " + model + " to arraylist");
					arrlist.add(model);
					desiredAmountInCents = desiredAmountInCents-moneyUnits[i].getValueInCents();
				}
			}else {
				LOG.info("The amount is greater than 100, it is paper currency");
				while(desiredAmountInCents>=moneyUnits[i].getValueInCents()) {
					PaperCurrency model = new PaperCurrency(""+moneyUnits[i], moneyUnits[i].getValueInCents(), null, null,serialGen.generateSerialNumber("" + moneyUnits[7]) );
					LOG.debug("Adding " + model + " to arraylist");
					arrlist.add(model);
					desiredAmountInCents = desiredAmountInCents-moneyUnits[i].getValueInCents();

				}
			}

		}
		LOG.info("Converting arrlist into an array");
		PhysicalMonetaryUnit[] returnArray = arrlist.toArray(new PhysicalMonetaryUnit[arrlist.size()]);
		LOG.debug("Returning: " + returnArray);
		return returnArray;
		
	}
	/**
	 * Will return the enum currency value
	 * @param unit
	 * @return model
	 */
	public PhysicalMonetaryUnit mintMoney(PredefinedMonetaryUnit unit) {
		SerialNumberGenerator serialGen = SerialNumberGenerator.getInstance();
		if(unit.getValueInCents() >= 100) {
			LOG.info("The amount is greater than 100, it is paper currency");
			PaperCurrency model = new PaperCurrency(""+unit, unit.getValueInCents(), null, null,serialGen.generateSerialNumber("" + unit) );
			LOG.debug("Creating PaperCurrency of " + model);
			return model;
			} else {
			LOG.debug("The value: " + unit + " is less than 100, it is a coin");
			Coin model = new Coin(""+unit, unit.getValueInCents(), null, null);
			LOG.debug("Creating Coin of " + model);
			return model;
		}
		
		
	}
}
