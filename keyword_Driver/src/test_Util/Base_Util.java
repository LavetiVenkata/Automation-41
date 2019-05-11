package test_Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Xls_Reader.Xls_Reader;

public class Base_Util {
	
	public static WebDriver driver;
	public static WebElement element;
	public static Xls_Reader xls = new Xls_Reader ("C:\\Users\\Admin\\Documents\\Selenium Automation\\access_workspace\\keyword_Driver\\src\\config_Data\\TestData.xlsx");
	public static int rowCount;
	public static int rowNum;
	public static String testCaseName;
	public static String runMode_Val;
	public static String action_Name;
	public static String xpath_Value;
	public static String test_data;
	public static String results;
	
}
