package starter.ExcerDemo.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import starter.ExcerDemo.Pages.SingupPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Singup implements Task {  

    private final String password;
    private final String firstname;  
    private final String lastname;
    private final String state;
    private final String city;
    private final String address;
    private final String zipcode;
    private final String mobile;

    public Singup(String password, String firstname, String lastname, String state, String city, String address, String zipcode, String mobile) {
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.state = state;
        this.city = city;
        this.address = address;
        this.zipcode = zipcode;
        this.mobile = mobile;
    }

    public static Singup withCredentials(String password, String firstname, String lastname, String state, String city, String address, String zipcode, String mobile) {
        return instrumented(Singup.class, password, firstname, lastname, state, city, address, zipcode, mobile);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            // Seleccionar el checkbox MR_FIELD
            Click.on(SingupPage.FORM),
            Click.on(SingupPage.MR_FIELD),

            // Información del usuario
            Enter.theValue(firstname).into(SingupPage.FIRST_NAME_FIELD),
            Enter.theValue(lastname).into(SingupPage.LAST_NAME_FIELD),
            Enter.theValue(password).into(SingupPage.PASSWORD_FIELD),
            
            // Selección de fecha
            Click.on(SingupPage.DAYS_FIELD),
            Click.on(SingupPage.MONTHFIELD),
            Click.on(SingupPage.YEARS_FIELD),

            // Suscripciones
            Click.on(SingupPage.CHECKBOX_NEWS_FIELD),
            
            // Información de la dirección
            Enter.theValue(address).into(SingupPage.ADDRESS_FIELD),
            Click.on(SingupPage.COUNTRY_FIELD),
            Click.on(SingupPage.COUNTRY__SELECT_FIELD),
            Enter.theValue(city).into(SingupPage.CITY_FIELD),
            Enter.theValue(state).into(SingupPage.STATES_FIELD),
            Enter.theValue(zipcode).into(SingupPage.ZIP_CODE_FIELD),
            Enter.theValue(mobile).into(SingupPage.MOBILE_FIELD),

            // Crear cuenta
            Scroll.to(SingupPage.CREATE_ACCOUNT_BUTTON),
            WaitUntil.the(SingupPage.CREATE_ACCOUNT_BUTTON, isVisible()).forNoMoreThan(5).seconds(),
            Click.on(SingupPage.CREATE_ACCOUNT_BUTTON)
        );
    }
}
