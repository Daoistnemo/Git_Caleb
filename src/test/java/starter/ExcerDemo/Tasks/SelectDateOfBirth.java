package starter.ExcerDemo.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import starter.ExcerDemo.Pages.SingupPage;
import  net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectDateOfBirth implements Task {

    private final String day;
    private final String month;
    private final String year;

    public SelectDateOfBirth(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static SelectDateOfBirth as(String day, String month, String year) {
        return instrumented(SelectDateOfBirth.class, day, month, year);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(day).from(SingupPage.DAYS_FIELD),
                SelectFromOptions.byVisibleText(month).from(SingupPage.MONTHFIELD),
                SelectFromOptions.byVisibleText(year).from(SingupPage.YEARS_FIELD)
        );
    }
}
