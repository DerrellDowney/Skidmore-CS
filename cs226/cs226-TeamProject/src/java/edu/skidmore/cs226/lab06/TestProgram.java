package edu.skidmore.cs226.lab06;
import edu.skidmore.cs226.base.*;
public class TestProgram {
/**
 * Create an instance of each concrete class:
 *  
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createCoin();
		createBankAccount();
		createCashDrawer();
		createCoinJar();
		createMoneyClip();
		createMoneyExtractor();
		createPaperCurrency();
	}
/**
 * Creating a BankAccount instance
 * 
 */
	public static void createBankAccount() {
		BankAccount myAccount = new BankAccount("My account");
		myAccount.deposit();
		System.out.println(myAccount.contents());
	}
/**
 * Creating a CashDrawer instance
 * 
 */
	public static void createCashDrawer() {
		CashDrawer drawer = new CashDrawer("The drawer");
		drawer.deposit();
		System.out.println(drawer.contents());
	}
/**null
 * Creating a Coin instance
 *
 */
	public static void createCoin() {
		Coin aCoin = new Coin("Dime", (long) 0.1, null, null);
		System.out.println(aCoin.getValueInCents());
	}
/**
 * Creating a Coin instance
 * 
 */
	public static void  createCoinJar() {
		CoinJar coinJar = new CoinJar("");
		System.out.println(coinJar);
	}
/**
 * Creating a MoneyClip instance
 * 
 */
	public static void createMoneyClip() {
		MoneyClip monClip = new MoneyClip("");
		System.out.println(monClip);
	}
/**
 * Creating a MoneyExtractor instance
 *
 */
	public static void createMoneyExtractor() {
		MoneyExtractor monExt = new MoneyExtractor();
		System.out.println(monExt);
	}
/**
 * Creating a PaperCurrency instance
 * 
 */
	public static void createPaperCurrency() {
		PaperCurrency papCur = new PaperCurrency(null, 0, null, null, null);
		System.out.println(papCur);;
	}
}
