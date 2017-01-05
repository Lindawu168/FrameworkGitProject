package testSuits;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import functionDriven.ReusableBusinessFunctions;
//Test framework sample
public class SanityTestSuite {
	WebDriver driver;
	ReusableBusinessFunctions func;
	@BeforeClass
	public void before(){
		func= new ReusableBusinessFunctions(driver);	
	}

	@Test
	public void userCanloginWithValidCredential(){
		func.Login("Admin", "Demo123");
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Welcome Admin"));
		func.waitForSomeTime();
		func.Logout();
	}

	@Test
	public void userCannotloginWithInvalidCredential(){
		func.Login("Admin", "Demo1234");
		Assert.assertTrue(driver.findElement(By.linkText("Forgot your password?")).isDisplayed());
		func.waitForSomeTime();
	}
	@Test
	public void userSeeForgotPasswordLinkAfterWrongAttempt(){
		func.Login("Admin", "Demo123");
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Welcome Admin"));
		func.waitForSomeTime();
	}
	@Test
	public void userCanAddSkills(){
		String skill="Java";
		//Manual test steps:  
		//login
		func.Login("Admin", "Demo123");
		//goto skills page
		func.gotoSkillsPage();
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Skills"));
		//click on add 
		func.addSkills();
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Add Skills"));
		//add the skills
		func.addSkillsDataAndSave(skill,null);
		//Check point: Verify these skills are added and listed in the grid
		Assert.assertTrue(driver.findElement(By.linkText(skill)).isDisplayed());
		//delete the skill;
		func.deleteSkill();
		//wait and logout
		func.waitForSomeTime();
		func.Logout();;
	}
	@AfterClass
	public void TearDown(){
		driver.close();
	}
}
