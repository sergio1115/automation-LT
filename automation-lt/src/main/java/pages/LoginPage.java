package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

@Getter
public class LoginPage {

    private SelenideElement usernameField = $(byId("user-name"));
    private SelenideElement passwordField = $(byId("password"));

    private SelenideElement loginButton = $(byId("login-button"));

    public InventoryPage doLogin(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
        return page(InventoryPage.class);
    }
}
