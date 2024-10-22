package starter.SwagLabs.Test;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import starter.SwagLabs.Interations.Navigate;
import starter.SwagLabs.Interations.RemoveItemFromCart;
import starter.SwagLabs.Interations.BuyItems;
import starter.SwagLabs.Interations.Login;
import starter.SwagLabs.pageobjects.CartPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class RemoveAllItemsTest {

    @CastMember(name = "User")
    Actor user;

    @Test
    public void userShouldBeAbleToRemoveAllProducts() {
        String username = "standard_user";
        String password = "secret_sauce";
        
        user.attemptsTo(
            Navigate.toLoginPage(),
            Login.withCredentials(username, password),  
            Navigate.toHomePage(),
            BuyItems.performBuy(),
            Navigate.toCartPage()
        );

        // Elimina todos los productos del carrito
        while (!CartPage.isCartEmpty(user)) {
            user.attemptsTo(RemoveItemFromCart.fromCart());

            // Opcional: Espera para permitir que la interfaz de usuario se actualice
            try {
                Thread.sleep(100); // Pausa para que la interfaz se actualice (opcional)
            } catch (InterruptedException e) {
                // Manejo de excepciones aquí si es necesario
                Thread.currentThread().interrupt(); // Restaurar el estado de la interrupción
            }
        }

        // Verifica que el carrito esté vacío
        boolean isCartEmpty = CartPage.isCartEmpty(user);
        Assertions.assertTrue(isCartEmpty, "El carrito debería estar vacío pero no lo está.");
    }
}
