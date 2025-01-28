package EssentialFeatures;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Utils.WebDriverUtil;

public class SortingWebtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = WebDriverUtil.getDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// click on column

		driver.findElement(By.xpath("//tr/th[1]")).click();

		// capture all web elements into list

		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

		// capture text of all web elements into new(original) list

		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

		// sort on the original list of step 3 -> sorted list

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// compare original list vs sorted list

		Assert.assertTrue(originalList.equals(sortedList));
		
		WebDriverUtil.closeDriver();

	}

}
