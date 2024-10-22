package starter.SwagLabs.Test;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.SwagLabs.Interations.Navigate;
import starter.SwagLabs.Interations.Login;
import starter.SwagLabs.Interations.Logout;
import starter.SwagLabs.pageobjects.LoginPage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class LogoutTests {

    @CastMember(name = "User")
    Actor user;

    @Test
    public void userShouldBeAbleToLogOut() {
        // Credenciales de inicio de sesión
        String username = "standard_user";
        String password = "secret_sauce";

        // Flujo de prueba:
        // 1. Iniciar sesión
        // 2. Navegar a la página principal
        // 3. Cerrar sesión
        // 4. Verificar que la página de login esté visible

        user.attemptsTo(
            Navigate.toLoginPage(),                          // Navega a la página de login
            Login.withCredentials(username, password),       // Inicia sesión
            Navigate.toHomePage(),                           // Navega a la página principal (home)
            Logout.fromAccount()                             // Cierra sesión
        );

        // Verifica que el usuario haya sido redirigido a la página de login
        Ensure.that(LoginPage.isDisplayed(user)).isTrue();  // Comprueba que la página de login esté visible
    }
}
