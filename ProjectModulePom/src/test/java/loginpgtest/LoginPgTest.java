package loginpgtest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseclass.BaseClass;
import loginpg.LoginPg;
import baseclass.LoginPgPassBase;
import dashboardpg.DashboardPg;

public class LoginPgTest extends BaseClass {

	LoginPg loginpg = null; 
	LoginPgPassBase passbase = new LoginPgPassBase();
	public static DashboardPg dashboard = null;
	SoftAssert soft = new SoftAssert();

	@BeforeSuite
	public void beforesuite(){
		reportInhit();
	}
	
	@BeforeMethod
	public void beforeMethod(){
	initilization();
	loginpg = new LoginPg(driver);
	}
//	@AfterSuite
//	public void afterSuite(){
//	    driver.quit();
//	}
	
    @Test(priority=1)
	public void varifyEmailBySymbol(){

		loginpg.enterMailCredn("kiran@gmail.com");
		boolean act = loginpg.email.contains("@");
//		soft.assertTrue(act);
//		soft.assertAll();
		Assert.assertTrue(act);
	}
    
    
	@Test(priority=2)
	public void varifyEmailByExtn(){
		
		loginpg.enterMailCredn("kiran@gmail.com");
		boolean actText = loginpg.email.endsWith(".com");
//		soft.assertTrue(actText, "Your mail should be end with '.com' extension");
//		soft.assertAll();
		Assert.assertTrue(actText);
	}

	@Test(priority=3)
	public void varifyPasswordByUpCase(){
		
		loginpg.enterPassCredn("123456");
		passbase.passBasRequisites("123456");
		boolean actPass = passbase.passUpCaseCondt();
//		soft.assertTrue(actPass, "Password should contains at least one UpperCase");
//		soft.assertAll();
		Assert.assertTrue(actPass);
	}
	
	@Test(priority=4)
	public void varifyPasswordByLowCase(){

		loginpg.enterPassCredn("123456");
		passbase.passBasRequisites("123456");
		boolean actPass = passbase.passLowCaseCondt();
//		soft.assertTrue(actPass, "Password should contains at least one lowerCase");
//		soft.assertAll();
		Assert.assertTrue(actPass);
	}

	@Test(priority=5)
	public void varifyPasswordByDigits(){

		loginpg.enterPassCredn("123456");
		passbase.passBasRequisites("123456");
		boolean actPass = passbase.passDigitCondt();
//		soft.assertTrue(actPass, "Password should contains at least one digit");
//		soft.assertAll();
		Assert.assertTrue(actPass);
	}

	@Test(priority=6)
	public void varifyNewPgLoad(){ // this page is getting failed by giving message of 4th case

		dashboard = loginpg.enterAndSubmitCreden("kiran@gmail.com", "123456");
//		soft.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
//		soft.assertAll();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
}
