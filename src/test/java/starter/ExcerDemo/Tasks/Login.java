package starter.ExcerDemo.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import starter.ExcerDemo.Pages.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private final String name;
    private final String email;

    public Login(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static Login withCredentials(String name, String email) {
        return instrumented(Login.class, name, email);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(name).into(LoginPage.NAME_FIELD),  // Asegúrate de que NAME_FIELD está definido en LoginPage
            Enter.theValue(email).into(LoginPage.EMAIL_FIELD),  // Asegúrate de que EMAIL_FIELD está definido en LoginPage
            Click.on(LoginPage.SUMIT_BUTTON)  // Asegúrate de que estás usando SUBMIT_BUTTON aquí
        );
    }
}
