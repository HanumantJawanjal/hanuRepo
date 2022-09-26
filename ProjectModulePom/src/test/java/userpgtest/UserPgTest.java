package userpgtest;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import operatorspg.OperatorsPg;
import userpg.UserPg;

public class UserPgTest extends BaseClass {
	
    OperatorsPg operators = null;
	UserPg userPg= null;
	ArrayList<String> expMails;
	
	@Test(priority=1)
	public void countOfMaleUsers(){
		userPg= new UserPg(driver);
		userPg.findGenderAndMobileCounts();
		Assert.assertEquals(UserPg.gender, 2);
		System.out.println(UserPg.gender);
	}
	
	@Test(priority=2)
	public void varifyMobileNoOfUsers() throws Exception{
		userPg = new UserPg(driver);
		Thread.sleep(2000);
		userPg.findGenderAndMobileCounts();
		Assert.assertEquals(UserPg.mobile, 1);
	}
	
	@Test(priority=3)
	public void varifyMahaStateOccur() throws Exception{
		userPg = new UserPg(driver);
		Thread.sleep(2000);
		userPg.findMahaStateOccurAndTheirRespMails();
		Assert.assertEquals(UserPg.location, 2);
	}
	
	
	@Test(priority=4)
	public void varifyMailsOfMahaState() throws Exception{
		userPg = new UserPg(driver);
		expMails = new ArrayList<String>();
		expMails.add("kiran@gmail.com");
		expMails.add("monica@gmail.com");
		Thread.sleep(2000);
		userPg.findMahaStateOccurAndTheirRespMails();
		Assert.assertEquals(UserPg.actMails, expMails);
	}
	
	@Test(priority=5)
	public void veriryOperatorsPgLoad(){
		operators = userPg.validOperatorPg();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Operators");
 	}
}
