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
import org.openqa.selenium.chrome.ChromeDriver; // Importa ChromeDriver

import starter.SwagLabs.Interations.Login;
import starter.SwagLabs.pageobjects.LoginPage;
import starter.SwagLabs.pageobjects.ProductPage;

@ExtendWith(SerenityJUnit5Extension.class)
public class LoginTest {

    private Actor steve;
    private LoginPage loginPage;
    private WebDriver driver; // Declara WebDriver aquí

    @BeforeEach
    public void setUp() {
        // Configura WebDriverManager para manejar el driver
        WebDriverManager.chromedriver().setup(); // Configura el driver de Chrome
        
        // Crea una instancia del WebDriver
        driver = new ChromeDriver(); // Cambia esto según el navegador que estés utilizando

        // Configura el actor
        steve = Actor.named("Steve");
        OnStage.setTheStage(new OnlineCast()); // Configura el escenario
        
        // Asigna la habilidad de navegar al actor usando el WebDriver
        steve.can(BrowseTheWeb.with(driver)); // Asigna la habilidad de navegar al actor
        
        // Crea una instancia de LoginPage
        loginPage = new LoginPage(); 
        loginPage.openLoginPage(); // Abre la página de inicio de sesión
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Cierra el WebDriver
        }
    }

    @Test
    public void userShouldBeAbleToLogin() {
        String username = "standard_user"; // Credencial de usuario estándar
        String password = "secret_sauce"; // Credencial de contraseña estándar

        // Realiza la acción de inicio de sesión
        steve.attemptsTo(
            Login.withCredentials(username, password) 
        );

        // Verifica que la lista de productos esté visible
        Ensure.that(ProductPage.PRODUCT_LIST).isDisplayed(); 
    }

    @Test
    public void userShouldSeeErrorMessageOnInvalidLogin() {
        String username = "invalid_user"; // Usuario inválido
        String password = "wrong_password"; // Contraseña incorrecta

        // Intenta iniciar sesión con credenciales inválidas
        steve.attemptsTo(
            Login.withCredentials(username, password)
        );

        // Verifica que el mensaje de error esté visible
        Ensure.that(LoginPage.ERROR_MESSAGE).isDisplayed(); 
    }
}
