package starter.SwagLabs.Test;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import starter.SwagLabs.Interations.BuyItems;
import starter.SwagLabs.Interations.Login;
import starter.SwagLabs.Interations.Navigate;
import starter.SwagLabs.pageobjects.CartPage;

@ExtendWith(SerenityJUnit5Extension.class)
public class BuyItemsTests {
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
        // 3. Comprar
        // 4. Ir al carrito

        user.attemptsTo(
            Navigate.toLoginPage(),                          // Navega a la página de login
            Login.withCredentials(username, password),       // Inicia sesión
            Navigate.toHomePage(),    // Navegar a la página de inicio
            BuyItems.performBuy(),      // Ejecutar la compra de los productos
            Navigate.toCartPage()

        );




        Ensure.that(CartPage.CART_LIST).isDisplayed(); // Verifica que la lista de productos en el carrito esté visible
    }
}
