package starter.ExcerDemo.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import starter.ExcerDemo.Pages.CreatePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ContinueCreate implements Task {

    public static ContinueCreate continueCreating() {
        return instrumented(ContinueCreate.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Verifica que el mensaje CREATE_MESS sea visible
        boolean isMessageVisible = WebElementQuestion.the(CreatePage.CREATE_MESS).answeredBy(actor).isPresent();

        if (isMessageVisible) {
            // Si el mensaje es visible, hace clic en el botón CONTINUE
            actor.attemptsTo(
                Click.on(CreatePage.CONTINUE_BUTTON)
            );
        } else {
            throw new RuntimeException("El mensaje de creación no es visible.");
        }
    }
}
