package testClass;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import pomClasses.ApplicationHeader;
import pomClasses.LoginPage;

public class TestClass {
WebDriver driver;
LoginPage loginPage;
ApplicationHeader applicationHeader;

@Parameters("browserName")
@BeforeTest
public void launchBrowser(String browser) {
	System.out.println(browser);
	
	if (browser.equals("chrome")) {
		driver=Browser.openChromeBrowser();
		}
	if (browser.equals("Firefox")) {
		driver=Browser.openFirefoxBrowser();
	}
	if (browser.equals("Opera")) {
		driver=Browser.openOperaBrowser();
	}
	//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
	@BeforeClass 
	public void createPOMObject() {
	
		applicationHeader= new ApplicationHeader(driver);
		loginPage=new LoginPage(driver);
	}
	@BeforeMethod
	public void loginToApplication() throws InterruptedException
	{
		driver.get("https://online.actitime.com/mlembhe/login.do");
		
	    loginPage = new LoginPage(driver);
		loginPage.sendUserName();
		loginPage.sendPassword();
		loginPage.clickonLogIn();
		
		Thread.sleep(3000);
		 applicationHeader = new ApplicationHeader(driver);
	}
	@Test
	public void verifyTaskTab() throws InterruptedException
	{
		applicationHeader.clickOnTasksTab();
		
		 String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		Assert.assertEquals("https://online.actitime.com/mlembhe/tasks/tasklist.do",url);
		Assert.assertEquals("actiTIME - Task List",title);
		Thread.sleep(3000);
//if(url.equals("https://online.actitime.com/mlembhe/tasks/tasklist.do") && title.equals("actiTIME -  Task List"))
//		{
//			System.out.println("PASS");
//		}
//		else {
//			System.out.println("FAIL");
//		}
	}
	@Test
	public void verifyReportsTab() throws InterruptedException {
	applicationHeader.clickOnReportsTab();
		
	String url=driver.getCurrentUrl();
	String title=driver.getTitle();
		
Assert.assertEquals("https://online.actitime.com/mlembhe/reports/dashboard.do",url);
Assert.assertEquals("actiTIME - Reports Dashboard",title);
Thread.sleep(3000);

//if(url.equals("https://online.actitime.com/mlembhe/reports/dashboard.do") && title.equals("actiTIME -  Reports Dashboard"))
//		{
//			System.out.println("PASS");
//		}
//		else {
//			System.out.println("FAIL");
//		}
	}
	@AfterMethod
	public void logoutFromApplication()
	{
		applicationHeader.clickOnLogOut();
	}
	@AfterClass
	public void clearObject()
	{
		loginPage=null;
		applicationHeader=null;
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc();
		
		
	}
	
}

	
	
