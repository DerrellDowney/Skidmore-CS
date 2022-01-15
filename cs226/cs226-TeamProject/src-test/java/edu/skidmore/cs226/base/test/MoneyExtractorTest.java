package edu.skidmore.cs226.base.test;

import static org.junit.Assert.*;
import org.apache.log4j.Logger;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.List;
import javax.imageio.ImageIO;
import org.junit.Before;
import org.junit.Test;
import edu.skidmore.cs226.base.CashDrawer;
import edu.skidmore.cs226.base.Coin;
import edu.skidmore.cs226.base.MonetaryUnit;
import edu.skidmore.cs226.base.MoneyExtractor;
import edu.skidmore.cs226.base.PaperCurrency;
import edu.skidmore.cs226.base.PhysicalMonetaryUnit;


public class MoneyExtractorTest {
	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(MonetaryUnit.class);
	}
	private Coin testInstanceCoin;
	private PhysicalMonetaryUnit testInstacePaper;
	private PhysicalMonetaryUnit[] testPhysicalMonetaryUnit = new PhysicalMonetaryUnit[1];
	private CashDrawer testCashDrawer;
	private MoneyExtractor testExtractor = new MoneyExtractor();
	@Before
	public void setUp() {
        BufferedImage frontImage = null;
		BufferedImage backImage = null;
		try {
            frontImage =
                ImageIO.read(getClass().getResource("test-money-front.jpg"));
            backImage =
                ImageIO.read(getClass().getResource("test-money-back.jpg"));
        }
        catch (Throwable t) {
            LOG.warn("Unable to load test image", t);
        }

        testInstanceCoin = new Coin("Test Money", 234, frontImage, backImage);
        testInstacePaper = new PaperCurrency("Test Money", 234, frontImage, backImage, "");
    }
	@Test
	public void testExtractPhysicalMonetaryUnit() {
		testCashDrawer.deposit(testInstanceCoin);
		testPhysicalMonetaryUnit[0] = testInstanceCoin;
		//testExtractor.extractPhysicalMonetaryUnit(testCashDrawer.contents(), testPhysicalMonetaryUnit);
	}

}
