package starter.SwagLabs.pageobjects;

import net.serenitybdd.core.pages.PageObject;

import java.util.List;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

public class ProductPage extends PageObject {

    public static final Target FIRST_PRODUCT_ADD_TO_CART = Target.the("Add first product to cart")
            .located(By.id("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")); // Reemplaza con el ID

    public static final Target SECOND_PRODUCT_ADD_TO_CART = Target.the("Add second product to cart")
            .located(By.id("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button")); // Reemplaza con el ID
                                                                                         

    // Define el elemento que representa la lista de productos en la página
    public static final Target PRODUCT_LIST = Target.the("Product List")
            .locatedBy("//*[@id=\"inventory_container\"]/div"); // Asegúrate de usar el

    @FindBy(css = ".product")
    private List<WebElementFacade> products;

    @FindBy(id = "addToCartButton")
    private WebElementFacade addToCartButton;

}
