package put.selenium.linear;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import put.selenium.utils.ScreenshotAndQuitOnFailureRule;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsLinearScriptAT {

    private WebDriver driver;

    @Rule
    public ScreenshotAndQuitOnFailureRule screenshotOnFailureAndWebDriverQuitRule =
            new ScreenshotAndQuitOnFailureRule();


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver-win-109.exe");
        this.driver = new ChromeDriver();
        screenshotOnFailureAndWebDriverQuitRule.setWebDriver(driver);
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
    }

    @Test
    public void failedPayUpTest() throws Exception{
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
        driver.manage().window().setSize(new Dimension(1064, 816));
        assertThat(driver.findElement(By.linkText("Register")).getText(), is("Register"));
        driver.findElement(By.linkText("Register")).click();
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Register"));
        driver.findElement(By.name("username")).sendKeys("jankowalski1");
        driver.findElement(By.name("password")).sendKeys("janek123");
        driver.findElement(By.name("repeat_password")).sendKeys("janek123");
        driver.findElement(By.name("name")).sendKeys("Jan Kowalski");
        driver.findElement(By.name("addressData")).sendKeys("Piłsudskiego 12");
        driver.findElement(By.name("submit")).click();
        assertThat(driver.findElement(By.linkText("Register")).getText(), is("Register"));
    }


}
