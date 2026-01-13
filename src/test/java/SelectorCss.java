import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.By.*;

public class SelectorCss {
    WebDriver driver = new ChromeDriver();

    @Test
    public void phoneBookTest(){
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));//sets time for page loading, if it doesn't load throws error
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //time for waiting to searching elements on the page
        //driver.get("https://telranedu.web.app/home"); //use when you want to enter page first hour
        driver.navigate().to("https://telranedu.web.app/home"); //use when you want to enter the page which you have already visited(from history)
        WebElement btnAbout = driver.findElement(cssSelector("a[href='/about']"));
        btnAbout.click();
        //WebElement divRoot = driver.findElement(By.cssSelector("div[id='root']"));
        //WebElement divRoot = driver.findElement(By.id("root"));
        //WebElement divRoot = driver.findElement(By.cssSelector("#root")); // the same  id = 'root'
        //WebElement divRoot = driver.findElement(By.cssSelector("*[id='root']"));//any element with id = 'root'
        //WebElement divRoot = driver.findElement(By.cssSelector("div[class='container']"));
        //WebElement divRoot = driver.findElement(By.cssSelector("*[class='container']")); //any element with class = 'container'
        WebElement divRoot = driver.findElement(cssSelector(".container")); // the same class = 'container'
        System.out.println(divRoot.getAttribute("class")); //get the value of given attribute
        System.out.println(divRoot.getAttribute("id")); //get the value of given attribute

        //pause(3);
        driver.navigate().refresh(); //refresh the current page
        //pause(3);
        driver.navigate().to("https://telranedu.web.app/login");
        //pause(3);
        driver.navigate().back(); //go to the previous page
        //driver.close(); //close the current window
        driver.quit();//close the driver and all associated windows
    }

    @Test
    public void iLcarroTest(){
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ilcarro.web.app/search");
        pause(2);
        WebElement btnLogo = driver.findElement(cssSelector("img[alt='logo']")); //first elem
        btnLogo.click();
        pause(2);
        WebElement btnSearch = driver.findElement(cssSelector("a[id='0']"));
        btnSearch.click();
        pause(2);
        //WebElement btnLetCarWork = driver.findElement(By.cssSelector("a[id='1']"));
        WebElement btnLetCarWork = driver.findElement(By.cssSelector("a#\\31.navigation-link")); //id = 1, in css specification \\31 (code in utf-8)
        //WebElement btnLetCarWork = driver.findElement(By.linkText("Let the car work")); //by text of the link (<a> text </a>)
        //WebElement btnLetCarWork = driver.findElement(By.partialLinkText("Let the car")); //part of text
        btnLetCarWork.click();
        pause(2);
        WebElement btnTermsOfUse = driver.findElement(cssSelector("a[id='2']"));
        btnTermsOfUse.click();
        pause(2);
        //WebElement btnSignUp = driver.findElement(cssSelector("a[href*='/registration?']"));
        WebElement btnSignUp = driver.findElement(cssSelector("div.header a.navigation-link:nth-child(5)"));
        btnSignUp.click();
        pause(2);
        //WebElement btnLogin = driver.findElement(cssSelector("a[href*='/login?']"));
        WebElement btnLogin = driver.findElement(cssSelector("div.header a.navigation-link:last-child"));


        btnLogin.click();
        pause(2);

        driver.navigate().to("https://ilcarro.web.app/search");
        pause(2);
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
