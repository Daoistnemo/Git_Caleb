package starter.ExcerDemo.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com/login") // Define la URL por defecto aquí
public class LoginPage extends PageObject {

    public static final Target NAME_FIELD = Target.the("Name")
            .locatedBy("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");

    public static final Target EMAIL_FIELD = Target.the("Email")
            .locatedBy("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");

    public static final Target SUMIT_BUTTON = Target.the("Signup")
            .locatedBy("//*[@id=\"form\"]/div/div/div[3]/div/form/button");


    // Método para abrir la página de login usando la URL predeterminada
    public void openLoginPage() {
        open(); // Abre la página usando la URL predeterminada
    }

    // Método para verificar si la página de login está visible
    public static boolean isDisplayed(Actor actor) {
        return NAME_FIELD.resolveFor(actor).isVisible();
    }
}