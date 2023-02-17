package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

@Getter
public class CartPage {

    private SelenideElement itemAddedTitle = $(".inventory_item_name");
    private SelenideElement checkoutButton = $("#checkout");

    public CheckoutPage goToCheckout() {
        checkoutButton.click();
        return page(CheckoutPage.class);
    }
}
