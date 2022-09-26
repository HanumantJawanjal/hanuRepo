package usefullinks;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.BaseClass;
import downloads.DownloadsPg;

public class UsefulLinkPg extends BaseClass{
	
	public DownloadsPg downloadsPg = null;
	public static int contentsize;
	public ArrayList<String> actContent;
	public static String data, srNo, content ;
	
	@FindBy(xpath="//*[@class='row']//table//tbody/tr/td[2]")
	List<WebElement> contents;
	
	@FindBy(xpath="//span[text()= 'Downloads']")
	WebElement downloads;
	

	public UsefulLinkPg(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public void findNocontentsAvail() {
	    contentsize = contents.size();
	}
	
	
	public void findContentsAvail(){
		actContent = new ArrayList<String>();
		for (WebElement webElement : contents) {
			actContent.add(webElement.getText());
		}
	}
	
	
	public void findSrNoOfCoursesContent() {
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 3; j++) {
				data = driver.findElement(By.xpath("//*[@class='row']//table//tbody/tr[" + (i + 1) + "]/td[" + j + "]"))
						.getText();
				if (data.equals("Courses")) {
					srNo = driver
							.findElement(
									By.xpath("//*[@class='row']//table//tbody/tr[" + (i + 1) + "]/td[" + (j - 1) + "]"))
							.getText();
				}
			}
		}
	}
	
	
	public void findContentOf2ndSrNo() {
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 3; j++) {
				data = driver.findElement(By.xpath("//*[@class='row']//table//tbody/tr[" + (i + 1) + "]/td[" + j + "]"))
						.getText();
				if (data.equals("02")) {
					content = driver
							.findElement(
									By.xpath("//*[@class='row']//table//tbody/tr[" + (i + 1) + "]/td[" + (j + 1) + "]"))
							.getText();
				}
			}
		}
	}
	
	public DownloadsPg clickOnDownloads(){
		downloads.click();
		if(driver.getTitle().equals("JavaByKiran | Downloads"))
			return new DownloadsPg(driver);
		return null;
		
	}
	
}
