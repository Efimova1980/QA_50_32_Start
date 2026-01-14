import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SelectorsXpath {
    WebDriver driver = new ChromeDriver();

    @Test
    public void phonebookTest(){
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://telranedu.web.app/home");
        //pause(2);
        //WebElement btnAbout = driver.findElement(By.cssSelector("a[href='/about']"));
        //-------------------------------XPATH---------------------------------------------
        //WebElement btnAbout = driver.findElement(By.xpath("//a[@href='/about']"));
        //WebElement btnAbout = driver.findElement(By.xpath("//*[@href='/about']"));
        WebElement btnAbout = driver.findElement(By.xpath("//*[text() = 'ABOUT']"));
        btnAbout.click();
        //pause(2);
        WebElement btnLogin = driver.findElement(By.xpath("//*[text() = 'LOGIN']"));
        btnLogin.click();
        //pause(2);

        WebElement fieldEmail = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        int i = new Random().nextInt(1000);
        fieldEmail.sendKeys("mail" + i + "@gmail.com");
        //pause(2);

        WebElement fieldPassword = driver.findElement(By.xpath("//*[@name='password']"));
        fieldPassword.sendKeys("Pass1234!");

        //pause(2);
        WebElement btnRegistration = driver.findElement(By.xpath("//*[@name = 'registration']"));
        btnRegistration.click();

        //pause(2);
        WebElement btnLogout = driver.findElement(By.xpath("//button[text()='Sign Out']"));
        btnLogout.click();

        //pause(2);

        List<WebElement> buttons = driver.findElements(By.xpath("//button"));
        System.out.println(buttons.size());
        for (int j = 0; j < buttons.size(); j++) {
            System.out.println(buttons.get(j).getText());
        }

        driver.quit();

    }

    @Test
    public void iLcarroXpathTest(){
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ilcarro.web.app/search");
        pause(2);

        //go to the login page
        WebElement btnLogin = driver.findElement(By.xpath("//a[contains(text(), 'Log in')]"));
        btnLogin.click();
        pause(2);

        //fill email field
        WebElement fieldEmail = driver.findElement(By.xpath("//input[@id='email']"));
        fieldEmail.sendKeys("harry@gmail.com");

        //fill password field
        WebElement fieldPass = driver.findElement(By.xpath("//input[@id='password']"));
        fieldPass.sendKeys("Pass1234!");
        pause(2);

        //click yalla btn (log in)
        WebElement btnYalla = driver.findElement(By.xpath("//button[contains(text(), 'Y’alla!')]"));
        btnYalla.click();
        pause(2);

        //click Ok on window "Logged in"
        WebElement btnOk = driver.findElement(By.xpath("//button[contains(text(), 'Ok')]"));
        btnOk.click();
        pause(4);

        //log out
        WebElement btnLogout = driver.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
        btnLogout.click();
        pause(4);

        driver.quit();
    }

    static void pause(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
