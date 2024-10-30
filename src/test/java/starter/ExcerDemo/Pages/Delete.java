package starter.ExcerDemo.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com/delete_account") // Define la URL por defecto aquí
public class Delete extends PageObject {

    public static final Target DELETE = Target.the("Mensaje")
            .locatedBy("//*[@id=\"form\"]/div/div/div");

    public static final Target CONTINUE_BUTTON_DELETE= Target.the("Continue")
            .locatedBy("//*[@id=\"form\"]/div/div/div/div/a");



    // Método para abrir la página de login usando la URL predeterminada
    public void openDeletePage() {
        open(); // Abre la página usando la URL predeterminada
    }

    // Método para verificar si la página de login está visible
    public static boolean isDisplayed(Actor actor) {
        return DELETE.resolveFor(actor).isVisible();
    }
}