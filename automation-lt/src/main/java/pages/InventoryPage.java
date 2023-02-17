package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import dataobjects.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class InventoryPage {

    private SelenideElement cartButton = $(".shopping_cart_link");
    private ElementsCollection items = $$(".inventory_item");

    public Item addToCart() {
        List<Item> mappedItems = this.mapInventoryItems();
        Random rand = new Random();
        Item randomItem = mappedItems.get(rand.nextInt(mappedItems.size()));
        randomItem.getAddToCartButton().click();
        return randomItem;
    }

    public CartPage goToCart() {
        cartButton.click();
        return page(CartPage.class);
    }

    public List<Item> mapInventoryItems() {
        List<Item> mappedItems = new ArrayList<>();
        items.forEach(i -> {
            Item newItem = new Item();
            newItem.setName(i.$(".inventory_item_name").getText());
            newItem.setPrice(i.$(".inventory_item_price").getText());
            newItem.setDescription(i.$(".inventory_item_desc").getText());
            newItem.setAddToCartButton(i.$(".btn_inventory"));
            newItem.setImage(i.$("img.inventory_item_img"));
            mappedItems.add(newItem);
        });
        return mappedItems;
    }
}
