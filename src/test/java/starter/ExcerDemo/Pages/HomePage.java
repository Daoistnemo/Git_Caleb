package starter.ExcerDemo.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com/")

public class HomePage extends PageObject {

    // Selecciona la lista de productos
    public static final Target LOGO = Target.the("Logo")
            .locatedBy("//*[@id=\"header\"]/div/div/div/div[1]/div");


    // Selector para el botón "Add to Cart" usando un parámetro de índice
    public static final Target LOGIN_BUTTON = Target.the("Login")
            .locatedBy("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    // Selector para el botón "Add to Cart" usando un parámetro de índice
    public static final Target LOGOUT_BUTTON = Target.the("Logout")
            .locatedBy("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    public static final Target DELETE_BUTTON = Target.the("Delete")
            .locatedBy("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");


    // Método para abrir la página de login usando la URL predeterminada
    public void openHomePage() {
        open(); // Abre la página usando la URL predeterminada
    }

}
