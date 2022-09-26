package userfullinktest;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import usefullinks.UsefulLinkPg;

public class UsefulLinktest extends BaseClass{

	UsefulLinkPg usefulLinks = null;
	ArrayList<String> expContent ;
	
	@Test(priority=1)
	public void validNoOfContent(){
		usefulLinks= new UsefulLinkPg(driver);
		usefulLinks.findNocontentsAvail();
		Assert.assertEquals(UsefulLinkPg.contentsize, 6, " No of content is wrong");
	}
	
	@Test(priority=2)
	public void validOfContentAvail(){
		usefulLinks= new UsefulLinkPg(driver);
		usefulLinks.findContentsAvail();
		expContent= new ArrayList<String>();
		expContent.add("Schedule");expContent.add("Video Lactures All Topics");expContent.add("Selenium Interview Questions");
		expContent.add("Java Interview Questions");expContent.add("Courses");expContent.add("Placement");
		Assert.assertEquals(usefulLinks.actContent,expContent);
	}
	
	@Test(priority=3)
	public void validsrNoOfCoursesContent(){
		usefulLinks= new UsefulLinkPg(driver);
		usefulLinks.findSrNoOfCoursesContent();
		Assert.assertEquals(UsefulLinkPg.srNo, "05");
	}
	
	@Test(priority=4)
	public void validcontentOf2ndSrNo(){
		usefulLinks= new UsefulLinkPg(driver);
		usefulLinks.findContentOf2ndSrNo();
		Assert.assertEquals(UsefulLinkPg.content, "Video Lactures All Topics");
	}
	
	@Test(priority=5)
	public void validDownloadsPg(){
		usefulLinks= new UsefulLinkPg(driver);
		usefulLinks.downloadsPg = usefulLinks.clickOnDownloads();
	
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Downloads");
	}
}
