package webdriver;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * An abstract class that describes the basic test application contains
 * methods for logging and field test settings (options)
 */
public abstract class BaseRealTest extends BaseEntity{

	public String producer;
	public String pricefrom;
	public String priceto;
	public String priceyear;
	public String valuediagfrom;
	public String valuediagto;
	/**
	 * To override.
	 */
	public abstract void runRealTest() throws Throwable;


	/**
	 * Test
	 * @throws Throwable Throwable
	 */
	@Parameters({ "producer", "price-from", "price-to", "priceyear", "valuediagfrom", "valuediagto" })
	@Test
	public void xRealTest(String producer1, String pricefrom1, String priceto1, String priceyear1, String valuediagfrom1, String valuediagto1) throws Throwable {
		producer=producer1;
		pricefrom=pricefrom1;
		priceto=priceto1;
		priceyear=priceyear1;
		valuediagfrom=valuediagfrom1;
		valuediagto=valuediagto1;
		Class<? extends BaseRealTest> currentClass = this.getClass();
		
		try {
			logger.logTestName(currentClass.getName());
			browser.navigate(Browser.getBaseUrl2());
			runRealTest();
			logger.logTestEnd(currentClass.getName());
		} catch (Throwable e) {
			
				logger.warn("");
				logger.warnRed(getLoc("loc.test.failed"));
				logger.warn("");
				logger.fatal(e.getMessage());
			}
		
	}



	/**
	 * Format logging
	 * @param message Message
	 * @return Message
	 */
	protected String formatLogMsg(final String message) {
		return message;
	}

}
