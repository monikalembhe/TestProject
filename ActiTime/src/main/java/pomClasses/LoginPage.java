
package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	@FindBy (xpath="//input[@name='username']") private WebElement userName;
	@FindBy (xpath="//input[@placeholder='Password']") private WebElement password;
	@FindBy (xpath="//input[@id='keepLoggedInCheckBox']")private WebElement keepMelogin;
	@FindBy (xpath="//a[@id='loginButton']") private WebElement logIn;
	
	private WebDriver driver;
	private WebDriverWait wait;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver,20);
	}
	public void sendUserName() {
	   //WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys("lembhemonika95@gmail.com");
	}
	public void sendPassword() {
       //WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys("monika@123");
	}
	public void selectKeepmeLogin() {
		keepMelogin.click();
	}
	public void clickonLogIn() {
		logIn.click();
	}
}
