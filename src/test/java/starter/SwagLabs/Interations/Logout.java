package starter.SwagLabs.Interations;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import starter.SwagLabs.pageobjects.HomePage;

public class Logout {

    public static Interaction fromAccount() {
        return Tasks.instrumented(PerformLogout.class);
    }

    public static class PerformLogout implements Interaction {
        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                // Abre el menú haciendo clic en el botón del menú
                Click.on(HomePage.MENU_BUTTON),
                
                // Ahora haz clic en el botón de logout que está dentro del menú
                Click.on(HomePage.LOGOUT_BUTTON)
            );
        }
    }
}
