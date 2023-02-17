package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CheckoutCompletedPage {

    private SelenideElement completeHeader = $(".complete-header");
    private SelenideElement completeText = $(".complete-text");
}
