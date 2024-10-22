package starter.SwagLabs.Interations;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import starter.SwagLabs.pageobjects.HomePage;

public class BuyItems {

    public static class PerformBuy implements Interaction {
        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                Click.on(HomePage.ADD_TO_CART_BUTTON.of("1")) // Agregar primer producto al carrito
                // Click.on(HomePage.ADD_TO_CART_BUTTON.of("2")),  // Agregar segundo producto al carrito
                // Click.on(HomePage.ADD_TO_CART_BUTTON.of("3"))  // Agregar tercero producto al carrito
            );
        }
    }

    public static PerformBuy performBuy() {
        return Tasks.instrumented(PerformBuy.class);
    }
}
