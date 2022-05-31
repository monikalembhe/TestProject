package testClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pomClasses.ApplicationHeader;
import pomClasses.LoginPage;

public class VerifyactiTimeHeader {
public static void main(String[] args) throws InterruptedException {
	
System.setProperty("webdriver.chrome.driver", "C:\\Users\\ZEAL INSTITUTE\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");	WebDriver driver= new ChromeDriver();
driver.get("https://online.actitime.com/mlembhe/login.do");
	
    LoginPage loginPage= new LoginPage(driver);
	loginPage.sendUserName();
	loginPage.sendPassword();
	loginPage.clickonLogIn();
	
Thread.sleep(5000);
ApplicationHeader applicationHeader = new ApplicationHeader(driver);
applicationHeader.clickOnTasksTab();
	
	String url=driver.getCurrentUrl();
	String title=driver.getTitle();
	
if(url.equals("https://online.actitime.com/mlembhe/tasks/tasklist.do") && title.equals("actiTIME -  Task List"))
	{
		System.out.println("PASS");
	}
	else {
		System.out.println("FAIL");
	}
    applicationHeader.clickOnLogOut();
	
    driver.get("https://online.actitime.com/mlembhe/login.do");
	
	loginPage= new LoginPage(driver);
	loginPage.sendUserName();
	loginPage.sendPassword();
	loginPage.clickonLogIn();
	
	Thread.sleep(3000);
	applicationHeader = new ApplicationHeader(driver);
	applicationHeader.clickOnReportsTab();
	
	url=driver.getCurrentUrl();
	title=driver.getTitle();
	
	if(url.equals("https://online.actitime.com/mlembhe/reports/dashboard.do") && title.equals("actiTIME -  Reports Dashboard"))
	{
		System.out.println("PASS");
	}
	else {
		System.out.println("FAIL");
	}
	applicationHeader.clickOnLogOut();
	driver.close();
}
}
