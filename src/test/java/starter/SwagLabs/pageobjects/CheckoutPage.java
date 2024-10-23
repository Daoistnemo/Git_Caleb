package starter.SwagLabs.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;



@DefaultUrl("https://www.saucedemo.com/v1/checkout-step-one.html") // URL de la página del carrito

public class CheckoutPage extends PageObject {

    
        public static final Target FIRST_NAME_FIELD = Target.the("First name field")
        .locatedBy("#first-name"); // Selector por ID

public static final Target LAST_NAME_FIELD = Target.the("Last name field")
        .locatedBy("#last-name"); // Selector por ID

public static final Target ZIP_CODE_FIELD = Target.the("Zip code field")
        .locatedBy("#postal-code"); // Selector por ID

public static final Target CONTINUE_BUTTON = Target.the("Continue button")
        .locatedBy("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input"); // Selector por ID, asegúrate de que sea correcto

public static final Target CANCEL_BUTTON = Target.the("Cancel button")
        .locatedBy("//*[@id=\"checkout_info_container\"]/div/form/div[2]/a"); // Selector por ID, asegúrate de que sea correcto
}

