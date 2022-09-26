package dashboardpg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import baseclass.BaseClass;
import userpg.UserPg;

public class DashboardPg extends BaseClass {
	
	public boolean actSele, actJ2ee, actPython, actPhp;
	public String parent ;
	
	@FindBy(xpath="//div[@class='small-box bg-aqua']/child::a")
	 public WebElement aqua;
	
	@FindBy(xpath="//div[@class='small-box bg-green']/child::a")
	public WebElement green;
	
	@FindBy(xpath="//div[@class='small-box bg-yellow']/child::a")
	public WebElement yellow;
	
	@FindBy(xpath="//div[@class='small-box bg-red']/child::a")
	public WebElement red;
	
	@FindBy(xpath= "//span[text()='Users']")
	public WebElement users;
	
	public DashboardPg(WebDriver driver){  
		PageFactory.initElements(driver, this);
	}
	
	public void clickSeleCourse() throws Exception{
		parent = driver.getWindowHandle();
		aqua.click();
		Thread.sleep(2000);	 
		driver.switchTo().window("file:///D:/Downloads/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/pages/pdf/selenium-testing-syllabus-jbk.pdf");
		System.out.println("Page title of new tab: " + driver.getTitle());
	    actSele = driver.getTitle().equals("Java By Kiran");
	    driver.switchTo().window(parent);

	    driver.close();
	}
	
	public void clickJ2eeCourse() throws Exception{
		parent = driver.getWindowHandle();
		green.click();
		Thread.sleep(2000);
		driver.switchTo().window("file:///D:/Downloads/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/pages/pdf/java-j2ee-syllabus-jbk.pdf");
		System.out.println("Page title of new tab: " + driver.getTitle());
		actJ2ee = driver.getTitle().equals("Java By Kiran");
		driver.switchTo().window(parent);
		driver.close();
	}
	
	public void clickPythCourse(){
		parent = driver.getWindowHandle();
		yellow.click();
		driver.switchTo().window("file:///D:/Downloads/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/pages/pdf/python-syllabus.pdf");
		System.out.println("Page title of new tab: " + driver.getTitle());
		actPython = driver.getTitle().equals("python-syllabus.pdf");
		driver.switchTo().window(parent);
		driver.close();
	}
	
	public void clickPhpCourse(){
		parent = driver.getWindowHandle();
		red.click();
		driver.switchTo().window("file:///D:/Downloads/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/pages/examples/dashboard.html#");
		System.out.println("Page title of new tab: " + driver.getTitle());
		actPhp = driver.getTitle().equals("JavaByKiran | Dashbaord");
		driver.switchTo().window(parent);
		driver.close();
	}
	
	public UserPg clickUser(){
		users.click();
		if(driver.getTitle().equals("JavaByKiran | User"))
			return new UserPg(driver);
		
		return null;
	}

}
