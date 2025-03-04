package serenityswag.authentication;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingOn  {
// Managed anotation  sirve para instanciar el webdriver
    @Managed
    WebDriver driver;

    @Test
    public void usersCanLogOnViaTheHomePage(){
        driver.get("https://www.saucedemo.com/");

        //como estamos testeando una web. el webdriver permite detectar los css
        //del form
        driver.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();

        //when login stadard queremos ver los productos ,ejemplo  solo el title
        assertThat(driver.findElement(By.cssSelector(".title")).getText()).isEqualToIgnoringCase("Products");


    }
}
