package downloads;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import baseclass.BaseClass;

public class DownloadsPg extends BaseClass{
	
	public List<WebElement> vendors = null;
	public ArrayList<String> actList; 
	public ArrayList<String> actList1; 
	
	public static boolean flag,flag1;
	public static String data;
	
	@FindBy(xpath="//*[@class='row']//table//tbody/tr")
	List<WebElement> rows;
	
	@FindBy(xpath="//*[@class='row']//table//tbody//th")
	List<WebElement> cols;
	
	@FindBy(xpath="//span[text()='Logout']")
	WebElement logOut;
	
	public DownloadsPg(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public void findVendersCommonOpSystem() {
		actList = new ArrayList<String>();
		for (int i = 1; i < rows.size(); i++) {
			for (int j = 1; j < cols.size(); j++) {
				data = driver.findElement(By.xpath("//*[@class='row']//table//tbody/tr[" + (i + 1) + "]/td[" + j + "]"))
						.getText();
				if (data.equals("Common")) {
					vendors = driver.findElements(
							By.xpath("//*[@class='row']//table//tbody/tr[" + (i + 1) + "]/td[" + (j - 4) + "]"));
					for (WebElement vendor : vendors) {
						actList.add(vendor.getText());
					}
				}
			}
		}
//		for (String ven : actList) {
//			if (ven.equals("Selenium Server Source Jar") && ven.equals("Google Chrome Driver"))
//				flag = true;
//		}
//		soft.assertTrue(flag, " Considered vendors dont have common op-System");
//		soft.assertAll();
	}
	
	public void findVend32BitsOpSystem(){
		actList1 = new ArrayList<String>();
		for (int i = 1; i <rows.size(); i++) {
			for (int j = 1; j < cols.size(); j++) {
				data = driver.findElement(By.xpath("//*[@class='row']//table//tbody/tr[" + (i + 1) + "]/td[" +j+ "]"))
						.getText();
				if (data.equals("32bit")) {
				 vendors = driver
							.findElements(
									By.xpath("//*[@class='row']//table//tbody/tr[" + (i + 1) + "]/td[" + (j - 2) + "]"));
				for (WebElement vendor : vendors) {
					actList1.add(vendor.getText());
				    }
				}
			}
		}
	}
	
	
	public void clickOnLogout(){
		logOut.click();
	}
	
	
}
