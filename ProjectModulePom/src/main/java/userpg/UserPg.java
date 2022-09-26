package userpg;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import baseclass.BaseClass;
import operatorspg.OperatorsPg;

public class UserPg extends BaseClass {

	public static ArrayList<String> actMails;
	public static int gender = 0, location, mobile=0;
	public static  String mail;
	
	@FindBy(tagName="tr")
	List<WebElement> rows ;
	
	@FindBy(xpath="//span[text()='Operators']")
	WebElement opr;
	
	public UserPg(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void findGenderAndMobileCounts(){
	    for (int row = 0; row < rows.size(); row++) {
	    	 List<WebElement> cols_list = rows.get(row).findElements(By.tagName("td"));
	    	 for (int cell = 1;  cell<cols_list.size(); cell++) {
	    		String cellValue = cols_list.get(cell).getText();
	    		if(cellValue.contentEquals("Male"))
	      	    gender++; 
	    		if(cellValue.equals("9898989898")){// if use matches then ?
				mobile++;
	    		}
	    	 }
	    }
	}
	
	
	public void findMahaStateOccurAndTheirRespMails(){
		 actMails= new ArrayList<String>();
			for (int i = 1; i <= 5; i++) {
				List<WebElement> states = driver.findElements(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[7]"));
				for (int j = 1; j <= states.size(); j++) {
					String state = states.get(j-1).getText();
					if(state.equals("Maharashtra")){
						location++;
						actMails.add(mail = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr["+i+"]/td["+(j+2)+"]")).getText()) ;  
					}
				}
			}
	    }
	 
	public OperatorsPg validOperatorPg(){
		opr.click();
		if(driver.getTitle().equals("JavaByKiran | Operators"))
			return new OperatorsPg(driver);
		
		return null;
	}

}
