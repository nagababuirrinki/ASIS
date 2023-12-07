package Utility;

import org.openqa.selenium.By;

public class Xpath_Utlity {
public static String un, ps,btn, id,logout, com, hos;
	public void xpath() {
		
		un = "//input[@id=\"LoginName\"]";
		ps = "//input[@id=\"Password\"]";
		btn = "//button[@id=\"btnlogin\"]";
		id = "//a[@class=\"dropdown-toggle\"]";
		logout = "//a[text()=\"Log Out\"]";
		com = "//select[@id=\"Company\"]";
		hos = "//select[@id=\"Hospital\"]";
	}
}
