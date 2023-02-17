package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CheckoutPage {

    private SelenideElement firstNameField = $("#first-name");
    private SelenideElement lastNameField = $("#last-name");
    private SelenideElement postalCodeField = $("#postal-code");

    private SelenideElement continueButton = $("#continue");

    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        firstNameField.setValue(firstName);
        lastNameField.setValue(lastName);
        postalCodeField.setValue(postalCode);
    }

    public CheckoutOverviewPage goToCheckoutOverview() {
        continueButton.click();
        return page(CheckoutOverviewPage.class);
    }
}
