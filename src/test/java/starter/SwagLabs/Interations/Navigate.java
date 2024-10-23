package starter.SwagLabs.Interations;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import starter.SwagLabs.pageobjects.LoginPage;
import starter.SwagLabs.pageobjects.CartPage;
import starter.SwagLabs.pageobjects.CheckoutPage;
import starter.SwagLabs.pageobjects.HomePage;


public class Navigate {

    public static Interaction toLoginPage() {
        return Tasks.instrumented(NavigateToLogin.class);
    }

    public static Interaction toHomePage() {
        return Tasks.instrumented(NavigateToHome.class);
    }

    public static Interaction toCartPage() {
        return Tasks.instrumented(NavigateToCart.class); // Agrega esta línea
    }
    public static Interaction toCheckoutPage() {
        return Tasks.instrumented(NavigateToCheck.class); // Agrega esta línea
    }


// Implementaciones de las interacciones específicas

class NavigateToLogin implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(new LoginPage()));
    }
}

class NavigateToHome implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(new HomePage()));
    }


}
class NavigateToCheck implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(new CheckoutPage()));
    }


}

    class NavigateToCart implements Interaction { // Agrega esta clase
        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(Open.browserOn(new CartPage())); // Abre la página del carrito
        }

}}

