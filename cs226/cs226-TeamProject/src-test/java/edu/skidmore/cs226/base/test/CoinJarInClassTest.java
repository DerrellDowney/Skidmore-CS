package edu.skidmore.cs226.base.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.hamcrest.core.StringContains;

import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.skidmore.cs226.base.Coin;
import edu.skidmore.cs226.base.CoinJar;
import edu.skidmore.cs226.base.PredefinedMonetaryUnit;

/**
 * Example unit tests for CoinJar to discuss in class. Includes examples of
 * exception handling unit tests, Hamcrest assertions, and Mockito mock objects.
 * 
 * @author readda
 */
public class CoinJarInClassTest {

    /**
     * The CoinJar instance used for testing.
     */
    private CoinJar coinJar;

    /**
     * A test coin.
     */
    private Coin aCoin;

    /**
     * A mock coin.
     */
    private Coin mockCoin;

    /**
     * Setup the objects for testing.
     */
    @Before
    public void setup() {
        coinJar = new CoinJar("Test Jar");
        PredefinedMonetaryUnit penny = PredefinedMonetaryUnit.PENNY;
        aCoin = new Coin(penny.getName(), penny.getValueInCents(),
            penny.getFrontImage(), penny.getBackImage());
        mockCoin = Mockito.mock(Coin.class);
    }

    /**
     * Using try/catch and the Assert.fail() method.
     */
    @Test
    public void testDepositJarClosedTryCatch() {
        try {
            coinJar.deposit(aCoin);
            fail("Exception expected but not thrown");
        }
        catch (IllegalStateException ise) {
            if (!ise.getMessage().contains("coin jar is closed")) {
                fail("Incorrect exception message: " + ise.getMessage());
            }
        }
        catch (Throwable t) {
            if (t instanceof AssertionError) {
                throw t;
            } else {
                t.printStackTrace();
                fail("Incorrect exception thrown: " + t);
            }
        }
    }
    //null
    /**
     * JUnit 4 flavor - note that if there are multiple lines of code in the
     * test method, the test can't guarantee the exception is being thrown by
     * the one you expected to throw it.
     */
    @Test(expected = IllegalStateException.class)
    public void testDepositJarClosedAssertionJUnit4() {
        coinJar.deposit(aCoin);
    }

    /**
     * JUnit 5 and Hamcrest flavor.
     */
    @Test
    public void testDepositJarClosedAssertJUnit5() {
        Exception exception = assertThrows(IllegalStateException.class,
            () -> coinJar.deposit(aCoin));
        assertThat("Incorrect exception message: " + exception.getMessage(),
            exception.getMessage(),
            StringContains.containsString("coin jar is closed"));
    }

    /**
     * Testing the deposit method added the single coin correctly, using
     * decisions and JUnit assertions.
     */
    @Test
    public void testDepositJarOpenCheckContentsDirectly() {
        coinJar.open();
        coinJar.deposit(aCoin);
        Coin[] coins = coinJar.contents();
        if (coins.length == 1) {
            assertTrue("Coin is not in the coin jar",
                coinJar.contents()[0] == aCoin);
        } else {
            fail("Incorrect number of coins are in the coin jar");
        }
    }

    /**
     * Testing the deposit method added the single coin correctly, using
     * Hamcrest assertions.
     */
    @Test
    public void testDepositJarOpenCheckContentsHamcrest() {
        coinJar.open();
        coinJar.deposit(aCoin);
        assertThat("Coin is not in the coin jar", coinJar.contents(),
            hasItemInArray(aCoin));
        assertThat("Incorrect number of coins are in the coin jar",
            coinJar.contents(), arrayWithSize(1));
    }

    /**
     * Demonstrating the use of Mockito and Hamcrest.
     */
    @Test
    public void testDepositJarOpenCheckContentsMockCoinHamcrest() {
        coinJar.open();
        coinJar.deposit(mockCoin);
        assertThat("Coin is not in the coin jar", coinJar.contents(),
            hasItemInArray(mockCoin));
        assertThat("Incorrect number of coins are in the coin jar",
            coinJar.contents(), arrayWithSize(1));

    }

    /**
     * Test that the withdrawal function works correctly for one coin remaining.
     * Write this in class.
     */
    @Test
    public void testWithdrawalOfLastCoin() {
    	coinJar.open();
    	coinJar.deposit(mockCoin);
    	assertThat("Wrong coin returned", coinJar.withdraw(mockCoin), hasItemInArray(mockCoin));
    	assertThat("There is still a coin in the coin jar", coinJar.contents(), arrayWithSize(0));


    }

    /**
     * Test that the withdrawal function works with several coins remaining.
     * Write this in class.
     */
    @Test
    public void testWithdrawalOfNonEmptyCoinJar() {
    	coinJar.open();
    	coinJar.deposit(mockCoin);
    	for(int i = 0;i<5;i++) {
    		coinJar.deposit(Mockito.mock(Coin.class));
    	}
    	assertThat("Wrong coin returned", coinJar.withdraw(mockCoin), hasItemInArray(mockCoin));
    	assertThat("There is still a coin in the coin jar", coinJar.contents(), arrayWithSize(5));
    	
    	
    }
}
