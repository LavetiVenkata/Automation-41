package business_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import test_Util.Base_Util;

public class Common_Keywords extends Base_Util {
	
	public static void executeKeywords (String testName) {
		try {
			
		rowCount = xls.getRowCount("TestCase");
		
		for (int rowNum = 2; rowNum <= rowCount; rowNum ++) {
			
	    testCaseName = xls.getCellData("TestCase", "TestCase_ID", rowNum);
	    if (testCaseName.equalsIgnoreCase(testName)) {
	    
	    runMode_Val	= xls.getCellData("TestCase", "RunMode", rowNum);
	    if (runMode_Val.equalsIgnoreCase("Y")) {
	    	
	    	action_Name = xls.getCellData("TestCase", "ActionName", rowNum);
	    	xpath_Value = xls.getCellData("TestCase", "ObjectXpath", rowNum);
	    	test_data = xls.getCellData("TestCase", "TestData", rowNum);
	    	
	    if (action_Name.equalsIgnoreCase("openBrowser"))
	    	results = openBrowser(test_data); 
	    
	    if (action_Name.equalsIgnoreCase("navigateurl"))
	    	results = navigateurl();
	    
	    if (action_Name.equalsIgnoreCase("entertext"))
	    	results = entertext(xpath_Value, test_data);
	    	
	    if (action_Name.equalsIgnoreCase("clickButton"))
	    	results = clickButton(xpath_Value);
	    
	    if (action_Name.equalsIgnoreCase("selectItem"))
	    	results = selectItem(xpath_Value, test_data);
	    
	    if (action_Name.equalsIgnoreCase("closeBrowser"))
	    	results = closeBrowser();
	    
	    }
	    
	    xls.setCellData("TestCase", "Result", rowNum, results);
	    
	    }
			
		}
			
		} catch (Exception k) {
			k.printStackTrace();
		}
		
	}
	
	// open a browser
	public static String openBrowser(String browser) {
		try {
			
			if (browser.equalsIgnoreCase("chrome")) {
				
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Selenium Automation\\access_workspace\\javaProject\\Config_Drivers\\chromedriver.exe");
		    driver = new ChromeDriver();
		    
	 //Code for IE		    
			} else if (browser.equalsIgnoreCase("IE")) {
			
				System.setProperty("webdriver.IE.driver", "C:\\Users\\Admin\\Documents\\Selenium Automation\\access_workspace\\javaProject\\Config_Drivers\\IEDriverServer.exe");
			    driver = new ChromeDriver();
				
	// Code for GECKO			
			} else if (browser.equalsIgnoreCase("gecko")) {
				
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Documents\\Selenium Automation\\access_workspace\\javaProject\\Config_Drivers\\geckodriver.exe");
			    driver = new FirefoxDriver();
			}
			else {
				System.out.println("Invalid Browser Selection");
			}
			System.out.println("User is able to open "+ browser +" Browser");
			return "PASS";
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("User is not able to open "+ browser +" Browser");
			return "FAIL";
		}
	}

	//Launch the application
	public static String navigateurl () {
		try {
			// Maximize the window
			driver.manage().window().maximize();
			driver.get("https://www.amazon.com/");
			System.out.println("User is able to launch costco application");
			return "PASS";
		} catch (Exception a) {
			a.printStackTrace();
			System.out.println("User is not able to launch costco application");
			return "FAIL";
		}
	}
	
	//Entering a value
	public static String entertext(String xpathValue, String textValue) {
		try {
			element = driver.findElement(By.xpath(xpathValue));
			element.sendKeys(textValue);
			System.out.println("USer is able to enter value, "+ textValue +" to the text field");
			return "PASS";
			
		} catch (Exception L) {
			L.printStackTrace();
			System.out.println("USer is not able to enter value, "+ textValue +" to the text field");
			return "FAIL";
		}
	}
	
	//Clicking button
	public static String clickButton (String xpathVlaue) {
		try {
			element = driver.findElement(By.xpath(xpathVlaue));
			element.click(); 
			System.out.println("User is able to click element");
			return "PASS";
			
		} catch (Exception h) {
			h.printStackTrace();
			System.out.println("User is not able to click element");
			return "FAIL";
		}
	}
	
	//Selecting items
	public static String selectItem (String xpathVlaue, String selctItems)	{
		try {
			// Identifying an element
			element = driver.findElement(By.xpath(xpathVlaue));
			Select sel = new Select(element);
			sel.selectByVisibleText(selctItems);
			System.out.println("User is able to select " + selctItems + "item");
			return "PASS";
			
		} catch (Exception g ) {
			g.printStackTrace();
			System.out.println("User is not able to select " + selctItems + "item");
			return "FAIL";
		}
	}
	
	//Closing the browser 
	public static String closeBrowser () {
		try {
			driver.close();
			driver.quit();
			System.out.println("User is able to close the browser");
			return "PASS";
			
		} catch (Exception j) {
			j.printStackTrace();
			System.out.println("User is not able to close the browser");
			return "FAIL";
		}
	}
	}
