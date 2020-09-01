import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_1 {
    WebDriver driver;
    String name_account = null;

    @BeforeTest
    public void preCondition () throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
      //  ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("https://outlook.live.com/mail/");

    }

    @Test
    public void test_1 () throws InterruptedException
    {

        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/header/div/aside/div/nav/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("kryvosheina.test@outlook.com");
        driver.findElement(By.xpath("//*[@id=\"i0281\"]/div/div/div[1]/div[2]/div[2]/div/div/div/div[4]/div/div/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("test1245789");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
        if (driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).isEnabled())
        {
            driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
        }
        // проверить, что зашел в аккаунт
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"O365_MainLink_MePhoto\"]/div/div/div/div[2]/img")).click();
        name_account = driver.findElement(By.xpath("//*[@id=\"FlexPane_MeControl\"]/h1")).getText();
        System.out.println(name_account);
        // if (name_account == "Моя учетная запись")
       // {
            System.out.println("Открыт аккаунт : " + driver.findElement(By.xpath("//*[@id=\"FlexPane_MeControl\"]/div/div/div[2]/span[1]")).getText());
       // }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"id__3\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div[1]/div[1]/div[1]/div/div[1]/div/div/div/div/div[1]/div/div/input")).sendKeys("mariakryvosheina@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"TextField479\"]")).sendKeys("auto test");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[1]")).sendKeys("auto test");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div[1]/div[3]/div[2]/div[1]/div/span/button[1]")).click();
        Thread.sleep(2000);
        // проверка, что письмо отправлено
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div[1]/div/div[2]/div[5]/div/span[1]")).click();
      //  driver.findElement(By.xpath("//*[@id=\"AQAAAAAAAQkBAAAAaLUVYgAAAAA=\"]/div/div/div/div/div[1]/div[2]/span")).getText();
    }

    @AfterTest
    public void afterTest()
    {
        driver.close();
    }
}
