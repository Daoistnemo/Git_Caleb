package starter.ExcerDemo.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com/signup") // Define la URL por defecto aquí
public class SingupPage extends PageObject {

        public static final Target FORM = Target.the("Mr radio button")
                        .locatedBy("//input[@id='id_gender1']");
        public static final Target MR_FIELD = Target.the("Mr checkbox")
                        .locatedBy("//*[@id='id_gender1']"); //
        public static final Target MRS_FIELD = Target.the("Mrs")
                        .locatedBy("//*[@id=\"id_gender2\"]");

        public static final Target PASSWORD_FIELD = Target.the("Password field")
                        .locatedBy("//input[@data-qa='password']");
        public static final Target DAYS_FIELD = Target.the("days")
                        .locatedBy("//*[@id=\"days\"]");
        
        public static final Target MONTHFIELD = Target.the("month")
                        .locatedBy("//*[@id=\"months\"]");

        public static final Target YEARS_FIELD = Target.the("years")
                        .locatedBy("//*[@id=\"years\"]");
        public static final Target YEAR_1994 = Target.the("option29")
                        .locatedBy("//*[@id=\"years\"]/option[29]");
        public static final Target CHECKBOX_NEWS_FIELD = Target.the("newsletter")
                        .locatedBy("//*[@id=\"newsletter\"]");
        public static final Target CHECKBOX_OFFERS_FIELD = Target.the("optin")
                        .locatedBy("//*[@id=\"optin\"]");
        public static final Target FIRST_NAME_FIELD = Target.the("first_name")
                        .locatedBy("//*[@id=\"first_name\"]");
        public static final Target LAST_NAME_FIELD = Target.the("last_name")
                        .locatedBy("//*[@id=\"last_name\"]");
        public static final Target ADDRESS_FIELD = Target.the("address")
                        .locatedBy("//*[@id=\"address1\"]");
        public static final Target COUNTRY_FIELD = Target.the("country")
                        .locatedBy("//*[@id=\"country\"]");
        public static final Target COUNTRY__SELECT_FIELD = Target.the("option3")
                        .locatedBy("//*[@id=\"country\"]/option[3]");
        public static final Target STATES_FIELD = Target.the("states")
                        .locatedBy("//*[@id=\"state\"]");
        public static final Target CITY_FIELD = Target.the("city")
                        .locatedBy("//*[@id=\"city\"]");
        public static final Target ZIP_CODE_FIELD = Target.the("zipcode")
                        .locatedBy("//*[@id=\"zipcode\"]");
        public static final Target MOBILE_FIELD = Target.the("mobile_number")
                        .locatedBy("//*[@id=\"mobile_number\"]");

        public static final Target CREATE_ACCOUNT_BUTTON = Target.the("Create Account button")
                        .locatedBy("[data-qa='create-account']");

        // Método para abrir la página de login usando la URL predeterminada
        public void openSignupPage() {
                open(); // Abre la página usando la URL predeterminada
        }

        // Método para verificar si la página de login está visible
        public static boolean isDisplayed(Actor actor) {
                return FIRST_NAME_FIELD.resolveFor(actor).isVisible();
        }
}