package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHeader {

	@FindBy (xpath="//a[@class='content tasks']") private WebElement tasks;
	@FindBy (xpath="//a[@class='content reports']") private WebElement reports;
	@FindBy (xpath="//a[@class='content users']") private WebElement user;
	@FindBy (xpath="//a[text()='Logout']") private WebElement logOut;
	public  ApplicationHeader(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    public void clickOnTasksTab() {
    	tasks.click();
    }
   public void clickOnReportsTab()
    {
    	reports.click();
    }
    public void clickOnUsersTab()
    {
    	user.click();
    }
    public void clickOnLogOut()
    {
    	logOut.click();
    }
	
   }
