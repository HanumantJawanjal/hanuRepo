package downloadstest;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import downloads.DownloadsPg;

public class DownloadsTest extends BaseClass{
	
	DownloadsPg downloadPg = null;
	public static ArrayList<String> expList;
	public static ArrayList<String> expList1;
	
	@Test
	public void validVendCommonOpSystem(){
		downloadPg = new DownloadsPg(driver);
		downloadPg.findVendersCommonOpSystem();
		expList= new ArrayList<String>();
		expList.add("Selenium Server Source Jar");
		expList.add("Google Chrome Driver");
		Assert.assertEquals(downloadPg.actList, expList, "Considered vendors dont have Common op-System");
	}
	
	@Test
	public void validvalidVendCommonOpSystem(){
		downloadPg = new DownloadsPg(driver);
		downloadPg.findVend32BitsOpSystem();
		expList1 = new ArrayList<String>();
		expList1.add("Java Development Kit (JDK)");
		expList1.add("Google Chrome");
		expList1.add("Mozilla Firefox");
		expList1.add("Gecko Driver for Latest firefox");
		Assert.assertEquals(downloadPg.actList1, expList1,"Considered vendors dont have 32bit op-System");
	}
	
	@Test
	public void validLogoutPg(){
		downloadPg = new DownloadsPg(driver);
		downloadPg.clickOnLogout();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
}
