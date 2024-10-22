package starter.SwagLabs.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("https://www.saucedemo.com/v1/inventory.html")

public class HomePage extends PageObject {

    // Selecciona la lista de productos
    public static final Target PRODUCT_LIST = Target.the("Product list container")
            .locatedBy("//*[@id=\"inventory_container\"]");


    // Selector para el botón "Add to Cart" usando un parámetro de índice
    public static final Target ADD_TO_CART_BUTTON = Target.the("Add to Cart button for product {0}")
            .locatedBy("//*[@id='inventory_container']/div/div[{0}]/div[3]/button");

    // Botón del menú que abre el menú desplegable
    public static final Target MENU_BUTTON = Target.the("menu button")
            .locatedBy("//*[@id=\"menu_button_container\"]/div/div[3]/div");

    public static final Target CART_BUTTON = Target.the("cart button")
            .locatedBy("//*[@id=\"shopping_cart_container\"]/a");

    // Botón de logout dentro del menú desplegable
    public static final Target LOGOUT_BUTTON = Target.the("logout button")
            .locatedBy("//*[@id='logout_sidebar_link']");
}
