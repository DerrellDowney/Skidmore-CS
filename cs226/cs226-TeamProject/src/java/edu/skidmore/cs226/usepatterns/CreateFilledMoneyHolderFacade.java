package edu.skidmore.cs226.usepatterns;

import org.apache.log4j.Logger;

import edu.skidmore.cs226.base.CashDrawer;
import edu.skidmore.cs226.base.Coin;
import edu.skidmore.cs226.base.CoinJar;
import edu.skidmore.cs226.base.MoneyClip;
import edu.skidmore.cs226.base.PaperCurrency;
import edu.skidmore.cs226.base.PhysicalMonetaryUnit;
import edu.skidmore.cs226.base.PredefinedMonetaryUnit;

/**
 * 
 * @author Elephants
 * CreateFilledMoneyHolderFacade is a Facade for PhysicalMoneyFactory that takes amounts of money and using the 
 * PhysicalMoneyFactory creates money for the specific cases of CashDrawer, CoinJar and MoneyClip.
 *
 */
public class CreateFilledMoneyHolderFacade {
	/**
	 * The logger instance - a class-level constant.
	 */
	private static final Logger LOG;
	/**
	 * Static block for the logger
	 */
	static {
		LOG = Logger.getLogger(CreateFilledMoneyHolderFacade.class);
	}
	/**
	 * Creates Money holder facade instance
	 */
	private static CreateFilledMoneyHolderFacade instance = new CreateFilledMoneyHolderFacade();
	/**
	 * Money holder facade constructor
	 */
	private CreateFilledMoneyHolderFacade() {
	}
	/**
	 * gets the instance of money holder facade
	 */
	public static CreateFilledMoneyHolderFacade getInstance() {
		return instance;
	}
	/**
	 * Makes a cash drawer with a description and fills it with money equal to the inputed amount with the least possible number of Currency 
	 * @param description String that we put as the description of the CashDrawer we create
	 * @param amount long with the amount of money we want to put in the new CashDrawer
	 * @return newDrawer the CashDrawer filled the the amount of money we wanted
	 */
	public CashDrawer makeCashDrawer(String description, long amount) {
		CashDrawer newDrawer = new CashDrawer(description);
		LOG.info("Getting moneyFactory instance");
		PhysicalMoneyFactory moneyFactory = PhysicalMoneyFactory.getInstance();
		PhysicalMonetaryUnit[] moneylist = moneyFactory.mintMoney(amount);
		for (int i = 0; i < moneylist.length; i++) {
			newDrawer.deposit(moneylist[i]);
			LOG.debug("Depositing: " + moneylist[i]);
		}
		LOG.debug("Returning newDrawer: " + newDrawer);
		return newDrawer;
	}
	/**
	 * makes a coin jar with description and fills it with money equal to the inputed amount only in coins
	 * It does this by first finding the highest value coin then dividing amount by it, giving us a number of those coins to make.
	 * We then create that amount of highest value coins and put them in the coinjar. we then mod(%) on our original amount to find 
	 * the amount that is leftover(amountOfOtherCoins) and  since the leftover will never be greater than the highest coin we can assure
	 * that no paper money is created when we mint coins out of amountOfOtherCoins
	 * @param description String that we put as the description of the CoinJar we create
	 * @param amount long with the amount of money we want to put in the new CoinJar
	 * @return newJar the CoinJar filled with coins equaling the amount we wanted
	 */
	public CoinJar makeCoinJar(String description, long amount) {
		CoinJar newJar = new CoinJar(description);
		PhysicalMoneyFactory moneyFactory = PhysicalMoneyFactory.getInstance();
		LOG.info("Opening the CoinJar");
		newJar.open();
		PredefinedMonetaryUnit[] moneyTypes = PredefinedMonetaryUnit.values();
		int atArray = 0;
		for (int i = 0; moneyTypes[i].isCoin() == true; i++) {//false
			atArray = i;
			LOG.debug("Setting atArray to " + atArray);
		}//amountOfHighestCoin
		long amountOfHighestCoin = amount/moneyTypes[atArray].getValueInCents();
		if(amount < moneyTypes[atArray].getValueInCents()) {
			amountOfHighestCoin = 0;
		}
		long amountOfOtherCoins = amount%moneyTypes[atArray].getValueInCents();
		for (int i = 0; i<amountOfHighestCoin; i++) {
			PhysicalMonetaryUnit[] depositCoin = moneyFactory.mintMoney(moneyTypes[atArray].getValueInCents());
			Coin coin = (Coin) depositCoin[0];
			newJar.deposit(coin);
			LOG.debug("Depositing to the coin array: " + coin);
		}
		PhysicalMonetaryUnit[] otherCoins = moneyFactory.mintMoney(amountOfOtherCoins);
		for (int i = 0; i<= otherCoins.length-1; i++) {
			Coin depositOtherCoin = (Coin) otherCoins[i];
			newJar.deposit(depositOtherCoin);
			LOG.debug("Depositing to the coin array: " + otherCoins[i]);
		}
		LOG.info("Closing newJar");
		newJar.close();
		return newJar;
	}
	/**
	 * Makes a money clip with description and fills it with money equal to the inputed amount in paper currency
	 * First we find the lowest PaperCurrency then check to see if amount is divisible by that number, if not we catch it with an IllegalArgumentException
	 * If it is then we can be sure that no Coins will be added to the MoneyClip
	 * @param description String that we put as the description of the MoneyClip we create
	 * @param amount long with the amount of money we want to put in the new MoneyClip
	 * @return newClip a MoneyClip filled with PaperCurrency of the amount we wanted
	 */
	
	public MoneyClip makeMoneyClip(String description, long amount) {
		MoneyClip newClip = new MoneyClip(description);
		PhysicalMoneyFactory moneyFactory = PhysicalMoneyFactory.getInstance();
		PredefinedMonetaryUnit[] moneyTypes = PredefinedMonetaryUnit.values();
		int atArray = 0;
		for (int i = 0; moneyTypes[i].isCoin() == true; i++) {
			atArray = i;
			LOG.info("Setting atArray to: " + atArray);
		}
		atArray++;
		try {
			PhysicalMonetaryUnit[] depositPaper = moneyFactory.mintMoney(moneyTypes[atArray].getValueInCents()); 
			for (int i = 0; i < depositPaper.length; i++) {
				PaperCurrency paper = (PaperCurrency) depositPaper[i];
				newClip.deposit(paper);
				LOG.debug("Depositing " + paper);
			}
		}catch(IllegalArgumentException exc) {
			System.out.println("A MoneyClip may only contain paper currency.\n"
					+ "The amount must be a multiple of" + moneyTypes[atArray].getValueInCents() + "cents.\n"
					+ "The requested amount requires an additional " + (amount % moneyTypes[atArray].getValueInCents() ) + " cent");
		}
		return newClip;
	}



}
