package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");

        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(3);
        clickLinkWithText("back to home", driver);
        sleep(3);

        element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        Random r = new Random();

        element = driver.findElement(By.name("username"));
        element.sendKeys("Purilaisrosvo" + r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("salakala");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salakala");
        element = driver.findElement(By.name("signup"));

        sleep(2);
        element.submit();
        sleep(3);
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        sleep(2);
        element = driver.findElement(By.linkText("logout"));
        element.click();

        sleep(2);
        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }

    private static void clickLinkWithText(String text, WebDriver driver) {
        int trials = 0;
        while (trials++ < 5) {
            try {
                WebElement element = driver.findElement(By.linkText(text));
                element.click();
                break;
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}
