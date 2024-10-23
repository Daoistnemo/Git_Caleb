package starter.SwagLabs.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("https://www.saucedemo.com/v1/") // Define la URL por defecto aquí
public class LoginPage extends PageObject {

    public static final Target USERNAME_FIELD = Target.the("username field")
            .locatedBy("//*[@id=\"user-name\"]");

    public static final Target PASSWORD_FIELD = Target.the("password field")
            .locatedBy("//*[@id=\"password\"]");

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .locatedBy("//*[@id=\"login-button\"]");

    public static final Target ERROR_MESSAGE = Target.the("error message")
            .locatedBy("//*[@id=\"login_button_container\"]/div/form/h3");

    // Método para abrir la página de login usando la URL predeterminada
    public void openLoginPage() {
        open(); // Abre la página usando la URL predeterminada
    }

    // Método para verificar si la página de login está visible
    public static boolean isDisplayed(Actor actor) {
        return USERNAME_FIELD.resolveFor(actor).isVisible();
    }
}
