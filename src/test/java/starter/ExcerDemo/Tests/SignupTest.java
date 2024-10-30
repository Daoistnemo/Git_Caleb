package starter.ExcerDemo.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import starter.ExcerDemo.Tasks.Singup;
import starter.ExcerDemo.Pages.HomePage;
import starter.ExcerDemo.Tasks.Login;
import starter.ExcerDemo.Tasks.Navigate;
import starter.ExcerDemo.Tasks.SelectDateOfBirth;
import starter.ExcerDemo.Pages.CreatePage;

@ExtendWith(SerenityJUnit5Extension.class)
public class SignupTest {

    private Actor Kelvin;
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Configura WebDriverManager para manejar el driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); 

        // Configura el actor
        Kelvin = Actor.named("Kelvin");
        OnStage.setTheStage(new OnlineCast()); 
        
        // Asigna la habilidad de navegar al actor
        Kelvin.can(BrowseTheWeb.with(driver)); 

        // Abre la HomePage
        HomePage homePage = new HomePage();
        homePage.open();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); 
        }
    }
    @Test
    public void userShouldBeAbleToSignup() {
        String name = "Kelvin Garcia";
        String email = "test@jejexxxxx.com"; // Correo de prueba
        String password = "password123"; // Contraseña de prueba
        String firstname = "Test";
        String lastname = "User";
        String state = "California";
        String city = "Los Angeles";
        String address = "123 Test St";
        String zipcode = "90001";
        String mobile = "1234567890";
    
        // Realiza la acción de registro
        Kelvin.attemptsTo(
            Navigate.toHomePage(),
            Click.on(HomePage.LOGIN_BUTTON),
            Login.withCredentials(name, email),
            SelectDateOfBirth.as("9", "October", "1994"),
            Singup.withCredentials(password, firstname, lastname, state, city, address, zipcode, mobile) // Completa el registro
        );
    
        // Verifica que el mensaje de creación de cuenta esté visible
        Ensure.that(CreatePage.CREATE_MESS).isDisplayed(); 
    }
    
}
