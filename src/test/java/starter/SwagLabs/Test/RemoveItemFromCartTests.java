package starter.SwagLabs.Test;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.SwagLabs.Interations.Navigate;
import starter.SwagLabs.Interations.BuyItems;
import starter.SwagLabs.Interations.Login;
import starter.SwagLabs.Interations.RemoveItemFromCart;
import starter.SwagLabs.pageobjects.CartPage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class RemoveItemFromCartTests {

    @CastMember(name = "User")
    Actor user;

    @Test
    public void userShouldBeAbleToRemoveProductFromCart() {
        String username = "standard_user";
        String password = "secret_sauce";
        user.attemptsTo(
            Navigate.toLoginPage(),                          // Navega a la página de login
            Login.withCredentials(username, password),  
            Navigate.toHomePage(),
            BuyItems.performBuy(), // Asegúrate de que este método agrega un producto al carrito
            Navigate.toCartPage()
        );
    
        // Remover el primer producto del carrito
        user.attemptsTo(RemoveItemFromCart.fromCart());
        // Verifica que el carrito está vacío después de eliminar
        // CartPage cartPage = new CartPage();
        // Ensure.that(cartPage.isCartEmpty()).isTrue(); 
    }}
    