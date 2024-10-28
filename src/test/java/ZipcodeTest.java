import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("1111");
        browser.findElement(By.cssSelector("[value = Continue]")).click();
        String errorMessage = browser.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();
    }
}
