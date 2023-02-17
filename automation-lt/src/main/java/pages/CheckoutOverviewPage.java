package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

@Getter
public class CheckoutOverviewPage {

    private SelenideElement itemName = $(".inventory_item_name");
    private SelenideElement finishButton = $("#finish");

    public CheckoutCompletedPage finishCheckout() {
        finishButton.click();
        return page(CheckoutCompletedPage.class);
    }
}
