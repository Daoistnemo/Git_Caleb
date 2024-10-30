package starter.Kitchen.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("https://example.cypress.io/todo") // Define la URL por defecto aquí
public class KitchenPage extends PageObject {


        public static final Target HEADER = Target.the("HEADER")
        .locatedBy("/html/body/section/div/header/h1"); //
        public static final Target TODO_FIELD = Target.the("TODO_FIELD")
        .locatedBy("/html/body/section/div/header/input"); //
    

    // Método para verificar si la página de login está visible
    public static boolean toDoIsDisplayed(Actor actor) {
        return TODO_FIELD.resolveFor(actor).isVisible();
    }
}