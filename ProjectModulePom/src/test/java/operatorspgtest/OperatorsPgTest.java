package operatorspgtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import operatorspg.OperatorsPg;
import usefullinks.UsefulLinkPg;

public class OperatorsPgTest extends BaseClass{

	OperatorsPg op = null;
	UsefulLinkPg usefullink = null;
	
	@Test(priority=1)
	public void varifyAvailOpByDays(){
		op = new OperatorsPg(driver);
		op.findAvailAccToDays();
		Assert.assertEquals(OperatorsPg.namesCnt, 2);
		
	}
	
	@Test(priority=2)
	public void varifyAvailTechPerson(){
		op = new OperatorsPg(driver);
		op.findTechPerAvail();
		Assert.assertEquals(OperatorsPg.urTech, "Kiran", " No Urgent Technical person available");
		
	}
	
	@Test(priority=3)
	public void varifyPhNoOfKiran(){
		op = new OperatorsPg(driver);
		op.searchKiranPhNo();
		Assert.assertFalse(OperatorsPg.flag);
	}
	
	@Test(priority=4)
	public void varifyUsefulLinksPg(){
		op= new OperatorsPg(driver);
		usefullink = op.clickOnUsefulLink();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Useful Links");
		
	}
}
