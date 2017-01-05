package functionDriven;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ReusableBusinessFunctions {
	WebDriver driver;
	public ReusableBusinessFunctions(WebDriver driver){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("url");
		this.driver=driver;
	}

	public void Login(String username, String pwd) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
	}
	public void waitForSomeTime(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Logout() {
		// TODO Auto-generated method stub
		driver.findElement(By.id("welcom")).click();
		waitForSomeTime();
		driver.findElement(By.linkText("logout")).click();
	}

	public void gotoSkillsPage() {
		// TODO Auto-generated method stub
		Actions oAct1= new Actions(driver);
		oAct1.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule"))).build().perform();
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		waitForSomeTime();
		driver.findElement(By.id("menu_admin_Skills")).click();
	}

	public void addSkills() {
		// TODO Auto-generated method stub
		driver.findElement(By.id("BtnAdd")).click();
	}

	public void addSkillsDataAndSave(String skillName, String skillDesc) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("skill_name")).sendKeys(skillName);
		if(skillDesc!=null){
		driver.findElement(By.id("skill_descriptions")).sendKeys(skillDesc);}
		driver.findElement(By.id("btnSave")).click();
		
	}

	public void deleteSkill() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//*[@id=\"recordListTable\"]/tbody/tr[6]/td[1]/input")).click();
		driver.findElement(By.id("btnDelete"));
	}
	
}
