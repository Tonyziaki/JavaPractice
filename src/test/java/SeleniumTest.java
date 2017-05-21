import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

    @Test
    public void TestOne(){
        /*
        Задача:
        1. Открыть браузер и развернуть на весь экран
        2. Зайти на yandex.ru
        3. Перейти в яндекс маркет
        4. Выбрать раздел Компьютеры
        5. Выбрать раздел Планшеты
        6. Зайти в расширенный поиск
        7. Задать параметр поиска от 20000
        8. Задать параметр поиска до 25000
        9. Выбрать производителей Acer и Dell
        10. Нажать кнопку Применить
        11. Проверить что элементов на странице 10 (сделаем проверку на 12)
        12. Запомнить первый элемент списка
        13. В поисковую строку ввести запомненное значение
        14. Найти и проверить, что наименование товара соответствует запомненному значению
         */
        //Параметры теста
        int elementsFound = 12; //Должны найти элементов на странице
        int getElementFromList = 1; //Считываем элемент найденного списка, значение не должно превышать elementsFound

        System.setProperty("webdriver.ie.driver", "U:\\IntelliJ IDEA Community Edition 2017.1.1\\IEDriverServer_x64_3.4.0\\iedriverserver.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.get("http://www.yandex.ru");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 40);
        ExpectedCondition expectedCondition = new ExpectedCondition<Object>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath(".//*[@data-id='market']"));
            }
        };

        wait.until(expectedCondition);
        WebElement elementMarket = driver.findElement(By.xpath(".//*[@data-id='market']"));

        elementMarket.click();
        wait.until(new ExpectedCondition<Object>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath(".//*[@data-department=\"Компьютеры\"]"));
            }
        });

        elementMarket = driver.findElement(By.xpath(".//*[@data-department=\"Компьютеры\"]"));
        elementMarket.click();

        elementMarket = driver.findElement(By.xpath(".//a[contains(@class,'nid_54545')]"));
        elementMarket.click();

        wait.until(new ExpectedCondition<Object>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.id("glf-pricefrom-var"));
            }
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

        elementMarket = driver.findElement(By.id("glf-7893318-8444252")); // TODO Некрасиво, надо подумать как иначе пролистать этот список....
        elementMarket.click();
        elementMarket.click();
        elementMarket = driver.findElement(By.id("glf-7893318-153080"));
        elementMarket.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        elementMarket = driver.findElement(By.xpath(".//button[contains(@class,'button_action_n-filter-apply')]"));
        elementMarket.click();

        Assert.assertEquals(driver.findElements(By.xpath(".//div[contains(@class,'n-snippet-card')]")).size(),elementsFound);

        //Ищем первый элемент и выходим
        String firstElementReference="";
        String firstElementTitle="";
        int i = 1;
        for (WebElement we : driver.findElements(By.xpath(".//a[contains(@class,'snippet-card__header-link')]"))){
            if (i == getElementFromList) {
                firstElementReference = we.getAttribute("href");
                elementMarket = we.findElement(By.xpath(".//span[contains(@class,'snippet-card__header-text')]"));
                firstElementTitle = elementMarket.getText();
                System.out.println(firstElementReference);
                System.out.println(firstElementTitle);
                break;
            }
            i++;
        }

        driver.get(firstElementReference);

        elementMarket = driver.findElement(By.xpath(".//h1[contains(@class,'title_size_22')]"));
        Assert.assertEquals(firstElementTitle, elementMarket.getText());

    }

    @Test
    public void TestTwo(){
        /*
        Задача:
        1. Открыть браузер и развернуть на весь экран
        2. Зайти на yandex.ru
        3. Перейти в яндекс маркет
        4. Выбрать раздел Компьютеры
        5. Выбрать раздел Ноутбуки
        6. Зайти в расширенный поиск
        7. Задать параметр поиска до 30000
        8. Выбрать производителей HP и Lenovo
        9. Нажать кнопку Применить
        10. Проверить что элементов на странице 10 (сделаем проверку на 12)
        11. Запомнить первый элемент списка
        12. В поисковую строку ввести запомненное значение
        13. Найти и проверить, что наименование товара соответствует запомненному значению
         */

        //Параметры теста
        int elementsFound = 12; //Должны найти элементов на странице
        int getElementFromList = 1; //Считываем элемент найденного списка, значение не должно превышать elementsFound

        System.setProperty("webdriver.ie.driver", "U:\\IntelliJ IDEA Community Edition 2017.1.1\\IEDriverServer_x64_3.4.0\\iedriverserver.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.get("http://www.yandex.ru");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 40);
        ExpectedCondition expectedCondition = new ExpectedCondition<Object>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath(".//*[@data-id='market']"));
            }
        };

        wait.until(expectedCondition);
        WebElement elementMarket = driver.findElement(By.xpath(".//*[@data-id='market']"));

        elementMarket.click();
        wait.until(new ExpectedCondition<Object>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath(".//*[@data-department=\"Компьютеры\"]"));
            }
        });

        elementMarket = driver.findElement(By.xpath(".//*[@data-department=\"Компьютеры\"]"));
        elementMarket.click();

        elementMarket = driver.findElement(By.xpath(".//a[contains(@class,'nid_54544')]"));
        elementMarket.click();

        wait.until(new ExpectedCondition<Object>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.id("glf-pricefrom-var"));
            }
        });

        elementMarket = driver.findElement(By.id("glf-priceto-var"));
        elementMarket.sendKeys("30000");

        elementMarket = driver.findElement(By.xpath(".//*[@data-bem='{\"button\":{\"type\":\"all\"}}']"));
        elementMarket.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        elementMarket = driver.findElement(By.id("glf-7893318-152722"));
        elementMarket.click();
        elementMarket = driver.findElement(By.id("glf-7893318-152981"));
        elementMarket.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        elementMarket = driver.findElement(By.xpath(".//button[contains(@class,'button_action_n-filter-apply')]"));
        elementMarket.click();

        Assert.assertEquals(driver.findElements(By.xpath(".//div[contains(@class,'n-snippet-card')]")).size(),elementsFound);

        String firstElementReference="";
        String firstElementTitle="";
        int i = 1;
        for (WebElement we : driver.findElements(By.xpath(".//a[contains(@class,'snippet-card__header-link')]"))){
            if (i == getElementFromList) {
                firstElementReference = we.getAttribute("href");
                elementMarket = we.findElement(By.xpath(".//span[contains(@class,'snippet-card__header-text')]"));
                firstElementTitle = elementMarket.getText();
                System.out.println(firstElementReference);
                System.out.println(firstElementTitle);
                break;
            }
            i++;
        }

        driver.get(firstElementReference);

        elementMarket = driver.findElement(By.xpath(".//h1[contains(@class,'title_size_22')]"));
        Assert.assertEquals(firstElementTitle, elementMarket.getText());

    }
}
