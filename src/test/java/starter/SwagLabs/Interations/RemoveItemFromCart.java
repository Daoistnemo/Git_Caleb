package starter.SwagLabs.Interations;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import starter.SwagLabs.pageobjects.CartPage;

public class RemoveItemFromCart implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Asegúrate de que el objeto se crea correctamente
        actor.attemptsTo(Click.on(CartPage.REMOVE_BUTTON));
    }

    public static RemoveItemFromCart fromCart() {
        return Tasks.instrumented(RemoveItemFromCart.class);
    }
}
