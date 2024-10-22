package starter.SwagLabs.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("https://www.saucedemo.com/v1/cart.html")  // URL de la página del carrito
public class CartPage extends PageObject {

    // Lista de productos en el carrito
    public static final Target CART_LIST = Target.the("Cart list")
            .locatedBy("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]"); // Ajusta el selector según el HTML de la página

    // Botón para eliminar un producto del carrito
    public final Target REMOVE_ITEM_BUTTON = Target.the("Remove item button")
            .locatedBy("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/button"); // Ajusta el selector según el HTML

    // Botón para proceder con el checkout
    public static final Target CHECKOUT_BUTTON = Target.the("Checkout button")
            .locatedBy("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]"); // Selector del botón de checkout

    // Mensaje de carrito vacío (si existe en tu página)
    public static final Target EMPTY_CART_MESSAGE = Target.the("Empty cart message")
            .locatedBy(".cart_empty_message"); // Ajusta según el HTML

             // Método para eliminar el primer producto del carrito
    public void removeFirstItem(Actor actor) {
        actor.attemptsTo(Click.on(REMOVE_ITEM_BUTTON));
    }
    public static boolean isCartEmpty(Actor actor) {
        try {
            // Intenta resolver la lista de elementos en el carrito
            return CART_LIST.resolveAllFor(actor).isEmpty();
        } catch (Exception e) {
            // Usa un logger en lugar de System.err para un mejor manejo en proyectos grandes
            System.err.println("Error verificando si el carrito está vacío: " + e.getMessage());
            // Opcionalmente, puedes lanzar una excepción personalizada para que el error no pase desapercibido
            throw new RuntimeException("Error al verificar el carrito", e);
        }
    }
    

}
