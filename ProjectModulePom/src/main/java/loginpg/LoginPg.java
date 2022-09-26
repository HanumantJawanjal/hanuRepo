package loginpg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.BaseClass;
import dashboardpg.DashboardPg;

public class LoginPg extends BaseClass {
	
	public String email;
	WebDriver driver= null;
	
	@FindBy(id="email")
	WebElement userId;
	
	@FindBy(id="password")
	WebElement pass;
	
	@FindBy(xpath="//button")
	WebElement submit;
	
	public LoginPg(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterMailCredn(String user){
		userId.sendKeys(user);
		email = userId.getAttribute("value");
	}

	public void enterPassCredn(String password){
		pass.sendKeys(password);
	}
	
	public DashboardPg enterAndSubmitCreden(String user, String password){
		userId.sendKeys(user);
		pass.sendKeys(password);
		submit.click();
		
	    if(driver.getTitle().equals("JavaByKiran | Dashboard"))
	    	return new DashboardPg(driver);
	    return null;
	}
	
}
