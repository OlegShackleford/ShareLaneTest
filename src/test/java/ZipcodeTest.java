import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipcodeTest {

    @Test
    public void test(){

        /*
        Открыть браузер
        Открыть страницу https://www.sharelane.com/cgi-bin/register.py
        В полу zipcode ввести 1111
        Нажать кнопку continue
        Проверить появление ошибки
        Закрыть браузер
        <input type="text" name="zip_code" value="">
         */
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        driver.findElement(By.name("zip_code")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Continue]")).click();
        String errorMessage = driver.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        driver.quit();
    }
}
