package starter.SwagLabs.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import starter.SwagLabs.Interations.Checkout;
import starter.SwagLabs.Interations.Login;
import starter.SwagLabs.pageobjects.CheckoutPage;
import starter.SwagLabs.Interations.Navigate;
import starter.SwagLabs.Interations.BuyItems;

@ExtendWith(SerenityJUnit5Extension.class)
public class CheckoutTest {

    private Actor maria;
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Configura WebDriverManager para manejar el driver
        WebDriverManager.chromedriver().setup();
        
        // Crea una instancia del WebDriver
        driver = new ChromeDriver();

        // Configura el actor
        maria = Actor.named("Maria");
        OnStage.setTheStage(new OnlineCast()); // Configura el escenario
        
        // Asigna la habilidad de navegar al actor usando el WebDriver
        maria.can(BrowseTheWeb.with(driver));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Cierra el WebDriver
        }
    }

    @Test
    public void userShouldBeAbleToCheckout() {
        String username = "standard_user";  // Usuario de prueba
        String password = "secret_sauce";
        String firstname = "Kelvin";
        String lastname = "Garcia";
        String zipcode = "7013";
    
        maria.attemptsTo(
            Navigate.toLoginPage(),
            Login.withCredentials(username, password),
            Navigate.toHomePage(),
            BuyItems.performBuy(),
            Navigate.toCartPage(),
            Navigate.toCheckoutPage(),
            Checkout.withInfo(firstname, lastname, zipcode) // Realiza el checkout con la información
        );
    
        // Ahora verifica que el botón de continuar esté visible
        Ensure.that(CheckoutPage.CONTINUE_BUTTON).isDisplayed();
    }
    
}
