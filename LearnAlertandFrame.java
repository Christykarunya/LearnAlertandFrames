package Week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlertandFrame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement mainFrame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(mainFrame);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//driver.switchTo().defaultContent();
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Simple Alert :"+text);
		
		alert.accept();
		
		String text2 = driver.findElement(By.id("demo")).getText();
		System.out.println(text2);
		if(text2.contains("You pressed OK!")) {
			System.out.println("You pressed OK!");
		}
		else {
			System.out.println("You pressed Cancel!");
		}
	}

}
