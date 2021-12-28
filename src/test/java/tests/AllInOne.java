import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.time.Duration;
import java.util.Random;

public class AllInOne  {


    @Test(priority = 1)
    public void main1() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe"); //Запуск драйвера
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Хром на весь екран

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Явна затримка
        driver.get("http://skelia.com"); // Перехід на сайт
        String title = driver.getTitle();

        Assert.assertTrue(title.equals("Skelia | Cross-border IT, Engineering and Outsourcing Services")); //Перевірка Title сайту
        driver.close();
    }

    @Test(priority = 2)
    public void main2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe"); //Запуск драйвера
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Хром на весь екран
        driver.get("https://skelia.com/contact"); // Перехід на сайт Скелія/Контакт АС
        Thread.sleep(500);

        //ТЕСТ блоку CONTACT US
        //КАРТА МІСТА
        WebElement element002 = driver.findElement(By.xpath("//*[@title='SKELIA USA – WEST COAST']")); //Клік на WEST COAST
        WebElement element003 = driver.findElement(By.xpath("//*[@title='SKELIA USA – EAST COAST']")); //Клік на EAST COAST
        WebElement element004 = driver.findElement(By.xpath("//*[@title='SKELIA UK']")); //Клік на SKELIA UK
        WebElement element005 = driver.findElement(By.xpath("//*[@title='SKELIA NETHERLANDS']")); //Клік на SKELIA NETHERLANDS
        WebElement element006 = driver.findElement(By.xpath("//*[@title='SKELIA HQ']")); //Клік на SKELIA HQ
        WebElement element007 = driver.findElement(By.xpath("//*[@title='SKELIA POLAND']")); //Клік на SKELIA POLAND
        WebElement element008 = driver.findElement(By.xpath("//*[@title='SKELIA UKRAINE'][2]")); //Клік на SKELIA UKRAINE LVIV
        WebElement element009 = driver.findElement(By.xpath("//*[@title='SKELIA UKRAINE'][1]")); //Клік на SKELIA UKRAINE KYIV

        Actions actions01 = new Actions(driver);
        actions01.moveToElement(element002).click().pause(500).moveToElement(element003).click().pause(500).
                moveToElement(element004).click().pause(500).moveToElement(element005).click().pause(500).
                moveToElement(element006).click().pause(500).moveToElement(element007).click().pause(500).
                moveToElement(element008).click().pause(500).moveToElement(element009).click().pause(500).
                release().build().perform();
        driver.close();
    }

    @Test(priority = 3)
    public void main3() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe"); //Запуск драйвера
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Хром на весь екран
        driver.get("https://skelia.com/contact"); // Перехід на сайт Скелія/Контакт АС
        Thread.sleep(500);

        //КАРТА FULLSCREEN,ZOOM+,ZOOM-
        WebElement element009 = driver.findElement(By.xpath("//*[@aria-label='Map']")); //Клік на карту
        element009.click();
        Thread.sleep(500);

        WebElement element010 = driver.findElement(By.xpath("//*[@title='Toggle fullscreen view']")); //Клік на Fullscreen View
        element010.click();
        Thread.sleep(500);

        WebElement element011 = driver.findElement(By.xpath("//button[@title='Zoom in']")); //Подвійний клік на Zoom+
        Actions builder1 = new Actions(driver);
        builder1.doubleClick(element011).pause(500).build().perform();

        WebElement element012 = driver.findElement(By.xpath("//*[@title='Zoom out']")); //Подвійний клік на Zoom-
        Actions builder2 = new Actions(driver);
        builder2.doubleClick(element012).pause(500).build().perform(); //Клік на Fullscreen View (для виходу)*/

        driver.close();
    }

    @Test(priority = 4)
    public void main4() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe"); //Запуск драйвера
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Хром на весь екран
        driver.get("https://skelia.com/contact"); // Перехід на сайт Скелія/Контакт АС

        WebDriverWait wait = new WebDriverWait(driver,10); // затримка на 10 секунд

        //КОНТАКТНА ФОРМА
        Random random1 = new Random();
        int n = random1.nextInt(100)+1; //рендомне число від 1 до 100

        String login = ("ivan" + n);
        String email = ("@gmail.com");

        driver.findElement(By.name("your-name")).sendKeys(login); //Текст у поле FullName *
        driver.findElement(By.name("email")).sendKeys(login+email); //Текст у поле Business email *

        int num1, num2, num3; //3 numbers in area code
        int set2, set3; //sequence 2 and 3 of the phone number

        Random generator = new Random();

        //Area code number; Will not print 8 or 9
        num1 = generator.nextInt(7) + 1; //add 1 so there is no 0 to begin
        num2 = generator.nextInt(8); //randomize to 8 becuase 0 counts as a number in the generator
        num3 = generator.nextInt(8);

        // Sequence two of phone number
        // the plus 100 is so there will always be a 3 digit number
        // randomize to 643 because 0 starts the first placement so if i randomized up to 642 it would only go up yo 641 plus 100
        // and i used 643 so when it adds 100 it will not succeed 742
        set2 = generator.nextInt(6430) + 100;

        //Sequence 3 of numebr
        // add 1000 so there will always be 4 numbers
        //8999 so it wont succed 9999 when the 1000 is added
        set3 = generator.nextInt(899999) + 1000;

        String phone = ( "(" + num1 + "" + num2 + "" + num3 + ")" + set2 + set3 );
        //System.out.println ( "(" + num1 + "" + num2 + "" + num3 + ")" + "-" + set2 + "-" + set3 );

        driver.findElement(By.name("phone")).sendKeys("+" + phone); //Текст у поле Phone *
        driver.findElement(By.name("message")).sendKeys("This is the test maggage!"); //Текст у поле Message *

        WebElement element018 = driver.findElement(By.xpath("//*[text()='* I have read and accepted the']")); //Галочка 1 *
        Actions builder3 = new Actions(driver);
        builder3.doubleClick(element018).build().perform();

        WebElement element019 = driver.findElement(By.xpath("//*[text()='I would like to receive news, updates and thought leadership once in a while']")); //Галочка 2 *
        element019.click();

        WebElement element020 = driver.findElement(By.xpath("//*[@value='Dedicated Team']")); //Клік на Dedicated Team
        element020.click();
        WebElement element021 = driver.findElement(By.xpath("//*[@value='Team Transfer']"));//Клік на Team Transfer
        element021.click();
        WebElement element022 = driver.findElement(By.xpath("//*[@value='Mobile Lab']")); //Клік на Mobile Lab
        element022.click();
        WebElement element023 = driver.findElement(By.xpath("//*[@value='TestLab']")); //Клік на TestLab
        element023.click();
        WebElement element024 = driver.findElement(By.xpath("//*[@value='RPA']")); //Клік на RPA
        element024.click();
        WebElement element025 = driver.findElement(By.xpath("//*[@value='Ukraine']")); //Клік на Ukraine
        element025.click();
        WebElement element026 = driver.findElement(By.xpath("//*[@value='Poland']")); //Клік на Poland
        element026.click();
        WebElement element027 = driver.findElement(By.xpath("//*[@value='Other']")); //Клік на Other
        element027.click();
        WebElement element028 = driver.findElement(By.xpath("//*[@id=\"wpcf7-f20063-p7678-o1\"]/form/div[2]/div[7]/div/div/span/span/span[4]/label/input")); //Клік на I don't care
        element028.click();

        Actions builder2 = new Actions(driver); //Повторний клік на усі кнопки
        builder2.click(element020).click(element021).click(element022).click(element023).click(element024).
                click(element025).click(element026).click(element027).click(element028).
                build().perform();
        driver.close();
    }
   }