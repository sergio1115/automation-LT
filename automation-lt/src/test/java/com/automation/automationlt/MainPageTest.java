package com.automation.automationlt;

import dataobjects.Item;
import org.assertj.core.api.Assertions;
import org.testng.annotations.*;
import pages.*;

public class MainPageTest extends BaseTest{
    LoginPage loginPage = new LoginPage();

    @Test
    public void testCheckout() {
        InventoryPage inventoryPage = loginPage.doLogin("standard_user", "secret_sauce");
        Item item = inventoryPage.addToCart();
        CartPage cartPage = inventoryPage.goToCart();
        Assertions.assertThat(cartPage.getItemAddedTitle().getText()).isEqualTo(item.getName());

        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.fillCheckoutForm("John", "Doe", "12345");
        CheckoutOverviewPage checkoutOverview = checkoutPage.goToCheckoutOverview();
        Assertions.assertThat(checkoutOverview.getItemName().getText()).isEqualTo(item.getName());

        CheckoutCompletedPage checkoutCompletedPage = checkoutOverview.finishCheckout();
        Assertions.assertThat(checkoutCompletedPage.getCompleteHeader().getText()).isEqualTo("THANK YOU FOR YOUR ORDER");
        Assertions.assertThat(checkoutCompletedPage.getCompleteText().getText()).isEqualTo("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
}
