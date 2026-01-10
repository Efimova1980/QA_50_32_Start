import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectorCss {
    WebDriver driver = new ChromeDriver();

    @Test
    public void phoneBookTest(){
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));//sets time for page loading, if it doesn't load throws error
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //time for waiting to searching elements on the page
        //driver.get("https://telranedu.web.app/home"); //use when you want to enter page first hour
        driver.navigate().to("https://telranedu.web.app/home"); //use when you want to enter the page which you have already visited(from history)
        WebElement btnAbout = driver.findElement(By.cssSelector("a[href='/about']"));
        btnAbout.click();
        //WebElement divRoot = driver.findElement(By.cssSelector("div[id='root']"));
        //WebElement divRoot = driver.findElement(By.id("root"));
        //WebElement divRoot = driver.findElement(By.cssSelector("#root")); // the same  id = 'root'
        //WebElement divRoot = driver.findElement(By.cssSelector("*[id='root']"));//any element with id = 'root'
        //WebElement divRoot = driver.findElement(By.cssSelector("div[class='container']"));
        //WebElement divRoot = driver.findElement(By.cssSelector("*[class='container']")); //any element with class = 'container'
        WebElement divRoot = driver.findElement(By.cssSelector(".container")); // the same class = 'container'
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
        driver.get("https://ilcarro.web.app/search");
        pause(2);
        WebElement btnSearch = driver.findElement(By.cssSelector("a[id='0']"));
        btnSearch.click();
        pause(2);
        WebElement btnLetCarWork = driver.findElement(By.cssSelector("a[id='1']"));
        btnLetCarWork.click();
        pause(2);
        WebElement btnTermsOfUse = driver.findElement(By.cssSelector("a[id='2']"));
        btnTermsOfUse.click();
        pause(2);
        WebElement btnSignUp = driver.findElement(By.cssSelector("a[href*='/registration?']"));
        btnSignUp.click();
        pause(2);
        WebElement btnLogin = driver.findElement(By.cssSelector("a[href*='/login?']"));
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


    //hm: сделать еще один тест, открыть сайт, найти элементы штук 10 с id, class, click, back to main page
    //прислать ссылку на гитхаб
}
