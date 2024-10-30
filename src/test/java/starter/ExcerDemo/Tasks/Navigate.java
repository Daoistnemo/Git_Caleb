package starter.ExcerDemo.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import starter.ExcerDemo.Pages.LoginPage;
import starter.ExcerDemo.Pages.HomePage;
import starter.ExcerDemo.Pages.Delete;
import starter.ExcerDemo.Pages.CreatePage;
import starter.ExcerDemo.Pages.SingupPage;

public class Navigate {

    // Métodos de navegación
    public static Interaction toLoginPage() {
        return Tasks.instrumented(NavigateToLogin.class);
    }

    public static Interaction toHomePage() {
        return Tasks.instrumented(NavigateToHome.class);
    }

    public static Interaction toCreatePage() {
        return Tasks.instrumented(NavigateToCreate.class); // Navega a la página de creación
    }

    public static Interaction toDeletePage() {
        return Tasks.instrumented(NavigateToDelete.class); // Navega a la página de eliminación
    }

    public static Interaction toSignupPage() {
        return Tasks.instrumented(NavigateToSignup.class); // Navega a la página de registro (Signup)
    }

    // Implementaciones de las interacciones específicas
    public static class NavigateToLogin implements Interaction {
        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(Open.browserOn(new LoginPage()));
        }
    }

    public static class NavigateToHome implements Interaction {
        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(Open.browserOn(new HomePage()));
        }
    }

    public static class NavigateToCreate implements Interaction { // Clase que navega a la página "CreatePage"
        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(Open.browserOn(new CreatePage())); // Abre la página de creación
        }
    }

    public static class NavigateToDelete implements Interaction { // Clase que navega a la página "Delete"
        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(Open.browserOn(new Delete())); // Abre la página de eliminación
        }
    }

    public static class NavigateToSignup implements Interaction { // Clase que navega a la página "SignupPage"
        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(Open.browserOn(new SingupPage())); // Abre la página de registro
        }
    }
}
