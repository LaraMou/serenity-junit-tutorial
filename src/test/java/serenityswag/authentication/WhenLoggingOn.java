package serenityswag.authentication;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.inventory.InventoryPage;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingOn extends UIInteractions {
// Managed anotation  sirve para instanciar el webdriver

//reordenando  usando Steps para hacer funcional la logica

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;
    InventoryPage inventoryPage;
    @Test
    public void usersCanLogOnViaTheHomePage(){
//        driver.get("https://www.saucedemo.com/");
        //openUrl("https://www.saucedemo.com/");

        //como estamos testeando una web. el webdriver permite detectar los css
        //del form
//        driver.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
//        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
//        driver.findElement(By.cssSelector("[data-test='login-button']")).click();

//        find("[data-test='username']").sendKeys("standard_user");
//        find("[data-test='password']").sendKeys("secret_sauce");
//        find("[data-test='login-button']").click();
//jquery sustituri por $
//        $("[data-test='username']").sendKeys("standard_user");
//        $("[data-test='password']").sendKeys("secret_sauce");
//        $("[data-test='login-button']").click();

        //se reordena el codigo  y vamos a llamar a la clase de Login
        login.asAStandardUser();

        //lo mismo vamos a crear una parte de inventraio que es donde estamos accediendo
        //when login stadard queremos ver los productos ,ejemplo  solo el title
       // assertThat($(".title").getText()).isEqualToIgnoringCase("Products");
        assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products");


    }
}
