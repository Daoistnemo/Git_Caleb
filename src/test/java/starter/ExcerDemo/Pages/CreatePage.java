package starter.ExcerDemo.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com/account_created") // Define la URL por defecto aquí
public class CreatePage extends PageObject {

    public static final Target CREATE_MESS = Target.the("Mensaje")
            .locatedBy("//*[@id=\"form\"]/div/div/div");

    public static final Target CONTINUE_BUTTON= Target.the("Continue")
            .locatedBy("//*[@id=\"form\"]/div/div/div/div/a");



    // Método para abrir la página de login usando la URL predeterminada
    public void openCreatePage() {
        open(); // Abre la página usando la URL predeterminada
    }

    // Método para verificar si la página de login está visible
    public static boolean isDisplayed(Actor actor) {
        return CREATE_MESS.resolveFor(actor).isVisible();
    }
}