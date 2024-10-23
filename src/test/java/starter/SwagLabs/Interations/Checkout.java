package starter.SwagLabs.Interations;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import static starter.SwagLabs.pageobjects.CheckoutPage.*;

public class Checkout implements Task {

    private final String firstname;
    private final String lastname;
    private final String zipcode;

    public Checkout(String firstname, String lastname, String zipcode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.zipcode = zipcode;
    }

    public static Checkout withInfo(String firstname, String lastname, String zipcode) {
        return new Checkout(firstname, lastname, zipcode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(firstname).into(FIRST_NAME_FIELD),
            Enter.theValue(lastname).into(LAST_NAME_FIELD),
            Enter.theValue(zipcode).into(ZIP_CODE_FIELD),
            Click.on(CONTINUE_BUTTON)
        );
    }
}
