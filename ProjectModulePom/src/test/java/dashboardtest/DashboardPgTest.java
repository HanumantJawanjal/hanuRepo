package dashboardtest;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseclass.BaseClass;
import dashboardpg.DashboardPg;
import loginpgtest.LoginPgTest;
import userpg.UserPg;

public class DashboardPgTest extends BaseClass {

	DashboardPg dashboard = null;
	UserPg userPg = null;
	
	@Test(priority=1)
	public void verirySelePgTitle() throws Exception{
		dashboard = new DashboardPg(driver);
		LoginPgTest.dashboard.clickSeleCourse(); 
		driver.switchTo().window("file:///D:/Downloads/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/pages/pdf/selenium-testing-syllabus-jbk.pdf");
		Thread.sleep(2000);	
		System.out.println("Page title of new tab: " + driver.getTitle());
		dashboard.actSele = driver.getTitle().equals("Java By Kiran");
	    driver.switchTo().window(dashboard.parent);
		Assert.assertTrue(LoginPgTest.dashboard.actSele);
	}
	
	@Test(priority=2)
	public void veriryJ2eePgTitle() throws Exception{
		dashboard = new DashboardPg(driver);
		LoginPgTest.dashboard.clickJ2eeCourse();
		Assert.assertTrue(LoginPgTest.dashboard.actJ2ee);
	}
	
	@Test(priority=3)
	public void veriryPythonPgTitle(){
		dashboard = new DashboardPg(driver);
		LoginPgTest.dashboard.clickPythCourse();
		Assert.assertTrue(LoginPgTest.dashboard.actPython);
 	}

	@Test(priority=4)
	public void veriryPhpPgTitle(){
      dashboard = new DashboardPg(driver);
		LoginPgTest.dashboard.clickPhpCourse();
		Assert.assertTrue(LoginPgTest.dashboard.actPhp);
 	}

	@Test(priority=5)
	public void veriryUserPgLoad(){
		dashboard= new DashboardPg(driver);
		userPg = dashboard.clickUser();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
 	}
}
