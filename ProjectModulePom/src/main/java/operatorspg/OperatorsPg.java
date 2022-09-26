package operatorspg;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import baseclass.BaseClass;
import usefullinks.UsefulLinkPg;

public class OperatorsPg extends BaseClass {
	
	public static int namesCnt = 0;
	public static String mail, urTech;
	public static boolean flag;
	
	@FindBy(xpath="//span[text()='     Useful Links']")
	WebElement useFulLink;
	
	public OperatorsPg(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void findAvailAccToDays() {
		
		ArrayList<String> names = new ArrayList<String>();
		for (int i = 1; i <= 5; i++) {
			List<WebElement> timings = driver.findElements(By.xpath(
					"/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[" + (i + 1) + "]/td[6]/b"));
			for (int j = 1; j <= timings.size(); j++) {
				String time = timings.get(j - 1).getText();
				if (time.contains("Monday-Saturday"))
					names.add(mail = driver.findElement(
							By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[" + (i + 1)
									+ "]/td[" + (j + 1) + "]"))
							.getText());
			}
		}
		for (String name : names) {
//			System.out.println(name);
			namesCnt++;
		}
	}
	
	
	public void findTechPerAvail() {
		for (int j = 1; j < 6; j++) {
			List<WebElement> timings = driver.findElements(By.xpath("//*[@class='row']//table//tbody/tr/td"));
			String times = timings.get(j - 1).getText();
			if (times.contains("Urgent Technical Help")) {
				urTech = driver.findElement(By.xpath("//*[@class='row']//table//tbody/tr/td[" + (j - 1) + "]"))
						.getText();
			}
		}
	}
	
	
	public void searchKiranPhNo() {
	
		for (int j = 1; j < 6; j++) {
			List<WebElement> timings = driver.findElements(By.xpath("//*[@class='row']//table//tbody/tr[2]/td"));
			String time = timings.get(j - 1).getText();
			if (time.contains("Phone Call")) {
				flag = true;
			}
		}
	}
	
	public UsefulLinkPg clickOnUsefulLink(){
		useFulLink.click();
		if(driver.getTitle().equals("JavaByKiran | Useful Links"))
			return new UsefulLinkPg(driver);
		
		return null;
		
	}

}
