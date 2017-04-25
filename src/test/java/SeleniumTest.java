import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Котя on 25.04.2017.
 */
public class SeleniumTest {

    @Test
    public void TestOne(){
        System.setProperty("webdriver.ie.driver", "U:\\IntelliJ IDEA Community Edition 2017.1.1\\IEDriverServer_x64_3.4.0\\iedriverserver.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.get("http://www.yandex.ru");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 40);
        ExpectedCondition expectedCondition = new ExpectedCondition<Object>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath(".//*[@data-id='market']"));
            };
        };

        wait.until(expectedCondition);
        WebElement elementMarket = driver.findElement(By.xpath(".//*[@data-id='market']"));

        elementMarket.click();
        wait.until(new ExpectedCondition<Object>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath(".//*[@data-department=\"Компьютеры\"]"));
            };
        });

        elementMarket = driver.findElement(By.xpath(".//*[@data-department=\"Компьютеры\"]"));
        elementMarket.click();

        elementMarket = driver.findElement(By.xpath("html/body/div[1]/div[2]/noindex/ul/li[2]/div/div/a[2]"));
        elementMarket.click();

        wait.until(new ExpectedCondition<Object>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.id("glf-pricefrom-var"));
            };
        });

        elementMarket = driver.findElement(By.id("glf-pricefrom-var"));
        elementMarket.sendKeys("20000");

        elementMarket = driver.findElement(By.id("glf-priceto-var"));
        elementMarket.sendKeys("25000");

        elementMarket = driver.findElement(By.xpath(".//*[@data-bem='{\"button\":{\"type\":\"all\"}}']"));
        elementMarket.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*wait.until(new ExpectedCondition<Object>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.id("glf-7893318-267101"));
            };
        });*/

        elementMarket = driver.findElement(By.id("glf-7893318-267101"));
        elementMarket.click();

        /*wait.until(new ExpectedCondition<Object>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.id("glf-7893318-153080"));
            };
        });*/

        elementMarket = driver.findElement(By.id("glf-7893318-8444252"));
        elementMarket.click();
        elementMarket.click();
        elementMarket = driver.findElement(By.id("glf-7893318-153080"));
        elementMarket.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
