package facebook;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Resources.Base;
import Resources.ExcelUtilities;

public class KeywordExecutor extends Base{

	@Test
	public void setup() {
		String path = "C:\\workSpace\\MyWorkspace\\BaseProject\\xlsx folder\\document.xlsx";
		ExcelUtilities.setExcel(path,0);
		
		
		for(int i=1; i<8; i++) {
			String keyword = ExcelUtilities.getData(i, 2);
			if(keyword.equalsIgnoreCase("Setup")) {
				String browser = ExcelUtilities.getData(i, 5);
				browserSetup(browser);
				Keyword key = new Keyword(driver);
			}
			else if(keyword.equalsIgnoreCase("Navigate")) {
				String url = ExcelUtilities.getData(i, 5).toString();
				//System.out.println(url);
				Keyword key = new Keyword(driver);
				key.NavigateTo("https://www.facebook.com");
			}
			else if(keyword.equalsIgnoreCase("SendKeys")) {
				String locatorType = ExcelUtilities.getData(i, 3);
				String locatorValue = ExcelUtilities.getData(i, 4);
				String param = ExcelUtilities.getData(i, 5);
				Keyword key = new Keyword(driver);
				key.provideText(locatorType, locatorValue, param);
			}
			else if(keyword.equalsIgnoreCase("Click")) {
				String locatorType = ExcelUtilities.getData(i, 3);
				String locatorValue = ExcelUtilities.getData(i, 4);
				locatorValue=locatorValue.replace("’", "'");
				locatorValue=locatorValue.replace("”", "");
				locatorValue=locatorValue.replace("“", "");
				//System.out.println(locatorValue);
				Keyword key = new Keyword(driver);
				key.clickElement(locatorType, locatorValue);
			}
		}
	}
	
	@AfterTest
	public void closeBrowser() {
	driver.close();
	}
}
