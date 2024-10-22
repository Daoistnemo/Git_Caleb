package starter.SwagLabs.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;
import java.util.List;

import net.serenitybdd.core.pages.WebElementFacade;



@DefaultUrl("https://www.saucedemo.com/v1/cart.html") // URL de la página del carrito
public class CartPage extends PageObject {

    // Lista de productos en el carrito
    public static final Target CART_LIST = Target.the("Cart list")
    .locatedBy("//*[@id='cart_contents_container']/div/div[1]/div[contains(@class, 'cart_item')]");


    public static final Target CART_ITEMS = Target.the("Product in cart")
            .locatedBy("//*[@id='cart_contents_container']/div/div[1]/div[contains(@class, 'cart_item')]");

    // Botón para eliminar un producto del carrito
    public final static Target REMOVE_BUTTON = Target.the("Remove button for cart item")
    .locatedBy("//*[@id='cart_contents_container']/div/div[1]/div[contains(@class, 'cart_item')]/div[2]/div[2]/button");                                                                                          // selector según
                                                                                                       
    // Botón para proceder con el checkout
    public static final Target CHECKOUT_BUTTON = Target.the("Checkout button")
            .locatedBy("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]"); // Selector del botón de checkout


    // Método para eliminar el primer producto del carrito
    public void removeFirstItem(Actor actor) {
        actor.attemptsTo(Click.on(REMOVE_BUTTON));
    }

public static boolean isCartEmpty(Actor actor) {
    try {
        // Resuelve la lista de elementos en el carrito
        List<WebElementFacade> items = CART_ITEMS.resolveAllFor(actor);
        System.out.println("Número de items en el carrito: " + items.size());

        // Verifica si todos los elementos son "removed_cart_item"
        boolean allRemovedItems = items.stream()
            .allMatch(item -> item.getAttribute("class").contains("removed_cart_item"));

        // Retorna true si no hay items o si todos son "removed_cart_item"
        return items.isEmpty() || allRemovedItems;
    } catch (Exception e) {
        // Manejo de excepciones
        System.err.println("Error verificando si el carrito está vacío: " + e.getMessage());
        throw new RuntimeException("Error al verificar el carrito", e);
    }
}

    
public static int getNumberOfItemsInCart(Actor actor) {
    List<WebElementFacade> items = CART_ITEMS.resolveAllFor(actor);
    System.out.println("Número de artículos en el carrito: " + items.size()); // Para depuración
    return items.size();
}

    // Método para eliminar un producto del carrito
    public static void removeItem(Actor actor) {
        actor.attemptsTo(
                Click.on(REMOVE_BUTTON));
    }
}
