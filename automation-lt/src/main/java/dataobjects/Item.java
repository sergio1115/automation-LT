package dataobjects;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;

@Data
public class Item {
    private String name;
    private String price;
    private String description;
    private SelenideElement addToCartButton;
    private SelenideElement image;
}
