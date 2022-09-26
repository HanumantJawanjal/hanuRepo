package baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public static WebDriver driver = null;
	public static ExtentReports report = null;
	public static ExtentSparkReporter sparc = null;
	public static ExtentTest test = null;
  
	public void initilization(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"file:///D:/Downloads/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.manage().window().maximize();
	}
	
    
	public void reportInhit(){
		report = new ExtentReports();
		sparc = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
	    report.attachReporter(sparc);
	}
	
	
	
	
//	public static void main(String[] args) {
//		BaseClass bc = new BaseClass();
//		bc.initilization();
//		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
//		driver.findElement(By.id("password")).sendKeys("123456");
//		driver.findElement(By.xpath("//button")).click();
//		driver.findElement(By.xpath("//span[text()='Users']")).click();
//		bc.usersMaleOccur();
//		System.out.println(BaseClass.gender);
//		System.out.println(BaseClass.mobile);
//	}
}
