package scenarios;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SwitchingWindows {

	WebDriver driver;
	@Test
	public void switchWin() throws InterruptedException
	{
		driver = new EdgeDriver();
		driver.get("https://www.w3schools.com/Jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		Set<String> allWinIds=driver.getWindowHandles();
		System.out.println("Total Window id="+allWinIds.size());
		String win1=null;
		String win2=null;
		Iterator<String> itr=allWinIds.iterator();
		if(itr.hasNext())
		{
			win1=itr.next();
			win2=itr.next();
		}
		System.out.println(win1);
		System.out.println(win2);
		System.out.println("window1--"+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("window2--"+driver.getTitle());
		boolean chkLogin=driver.findElement(By.linkText("Log in")).isEnabled();
		System.out.println(chkLogin);
		if(chkLogin==true)
		{
			System.out.println("Login Button Enabled...");
		}
		else
		{
			System.out.println("Login Button Disabled...");
		}
		Thread.sleep(4000);
		driver.quit();
	}
}
