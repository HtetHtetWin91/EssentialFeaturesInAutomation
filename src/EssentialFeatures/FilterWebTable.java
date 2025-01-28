package EssentialFeatures;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utils.WebDriverUtil;

public class FilterWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = WebDriverUtil.getDriver();
	

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		List<String> price;
		String fruitName = "Apple";

		// scan the name column with getText ->Beans->print the price of the Rice

		do

		{

			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

			price = rows.stream().filter(s -> s.getText().contains(fruitName))

					.map(s -> getPriceVeggie(s)).collect(Collectors.toList());

			price.forEach(a -> System.out.println(a));

			if (price.size() < 1)

			{

				driver.findElement(By.cssSelector("[aria-label='Next']")).click();

			}

		} while (price.size() < 1);
		
		WebDriverUtil.closeDriver();

	}
	
	

	private static String getPriceVeggie(WebElement s) {

		// TODO Auto-generated method stub

		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}
