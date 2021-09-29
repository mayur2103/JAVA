package Naveen;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ComplexSVGGraph {

	public static void main(String[] args) throws ParseException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.google.com/search?q=sensex+today&sxsrf=AOaemvKuA7RlWfCQoYVyyy9kPj4eidVFLw%3A1632821737591&source=hp&ei=6eFSYe-MIcLP5OUP3YeZ6AU&iflsig=ALs-wAMAAAAAYVLv-VH_AcrmDtJXyGAg27lrZwbPj_Ak&oq=Sensex&gs_lcp=Cgdnd3Mtd2l6EAEYADILCAAQgAQQsQMQgwEyCwgAEIAEELEDEIMBMgsIABCABBCxAxCDATILCAAQgAQQsQMQgwEyCwgAEIAEELEDEIMBMgsIABCABBCxAxCDATILCAAQgAQQsQMQgwEyCwgAEIAEELEDEIMBMgsIABCABBCxAxCDATIICAAQgAQQsQM6BwgjEOoCECc6CAgAELEDEIMBOhEILhCABBCxAxCDARDHARDRAzoOCC4QgAQQsQMQxwEQowI6BQgAEIAEOgUILhCABDoECCMQJzoICC4QgAQQsQM6CwguEIAEELEDEIMBOgoIABCxAxCDARAKOgcIABCABBAKOhAILhCxAxCDARDHARDRAxAKOgsILhCABBDHARCvAVDmNVjaTWDHZmgCcAB4AIABvgGIAfkIkgEDMC43mAEAoAEBsAEK&sclient=gws-wiz");
		
		driver.findElement(By.xpath("//*[@id=\"knowledge-finance-wholepage__entity-summary\"]/div/div/g-card-section[1]/div/div[1]/div/div[4]/div/div/div")).click();
		Thread.sleep(5000);
		
		WebElement ele = driver.findElement(By.xpath("//*[local-name()='svg' and @class='uch-psvg']"));
		
		int getTopLeftY = ((ele.getSize().getHeight()) / 2) - ele.getSize().getHeight();
		int getTopLeftX = ((ele.getSize().getWidth()) / 2) - ele.getSize().getWidth();
		
		Actions act = new Actions(driver);
		
		String start_date = "30-03-2021";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
		Date d1 = sdf.parse(start_date);
		Date d2 = new Date();
		long diffInDays = TimeUnit.MILLISECONDS.toDays(d2.getTime() - d1.getTime());
		
		for(int i = 0; i < diffInDays; i++) {
			act.moveToElement(ele, getTopLeftX+i, getTopLeftY).perform();
			String data = driver.findElement(By.xpath("//*[@class='knowledge-finance-wholepage-chart__hover-card']")).getText();
			System.out.println(data);
		}
		
		

	}

}
