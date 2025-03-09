package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CheckBoxAndRadBtn {

	WebDriver driver;
	@Test
	public void handlingChkBoxesRadBtns() throws InterruptedException
	{
		driver = new EdgeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		WebElement bmwRad=driver.findElement(By.id("bmwradio"));
		bmwRad.click();
		boolean chkBMWRad=driver.findElement(By.id("bmwradio")).isSelected();
		if(chkBMWRad==true)
		{
			System.out.println("BMW selected..");
		}
		else
		{
			System.out.println("BMW not selected..");
		}
		WebElement benzChkB=driver.findElement(By.id("benzcheck"));
		benzChkB.click();
		boolean isSelBenz=driver.findElement(By.id("benzcheck")).isSelected();
		WebElement hondaChkB=driver.findElement(By.id("hondacheck"));
		boolean isSelHonda=driver.findElement(By.id("hondacheck")).isSelected();
		hondaChkB.click();
		
		if(isSelBenz==true && isSelHonda==true)
		{
			System.out.println("Benz and Honda are selected...");
		}
		else
		{
			System.out.println("Benzand Honda are not selected...");
		}
		Thread.sleep(5000);
		driver.quit();
	}
}
