package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Tester {

    public static void login(WebDriver driver, String username, String password) {
        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        driver.quit();
    }
    
    public static void createAndLogOut(WebDriver driver) {
        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(100);

        element = driver.findElement(By.name("username"));
        element.sendKeys("asdasd");
        element = driver.findElement(By.name("password"));
        element.sendKeys("asdasd");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("asdasd");
        element = driver.findElement(By.name("signup"));
        
        sleep(50);
        element.submit();

        sleep(3);
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        
        sleep(100);
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        driver.quit();
    }
    
    public static void main(String[] args) {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        
        login(driver, "pekka", "akkep");
        login(driver, "pekka", "LOL");
        login(driver, "asdasd", "asdasd");
        createAndLogOut(driver);
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
