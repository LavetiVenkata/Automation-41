package testCases;

import business_Functions.Common_Keywords;

public class TestCase_001 extends Common_Keywords{
	
	
	public static void main(String[] args) {
		
		openBrowser ("chrome");
		closeBrowser ();
		entertext("", "");
		entertext("new2", "value1");
		entertext("new3", "value3");
		
	}

}
