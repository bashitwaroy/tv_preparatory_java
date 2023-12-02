package org.example.test;

import org.junit.jupiter.api.*;
import tv.example.ShoppingCart;

import java.util.ArrayList;
import java.util.Map;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Cases for ShoppingCart Class")
public class ShoppingCartTests {

    ShoppingCart shoppingCart;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        shoppingCart = new ShoppingCart(new ArrayList<>());
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry(Map.ofEntries(entry("test info: ", testInfo.toString())));
    }

    @Test
    void addItemsTest() {
        shoppingCart.addItem(shoppingCart.getInstance(1,20, 1));
        shoppingCart.addItem(shoppingCart.getInstance(2,10, 3));
        shoppingCart.addItem(shoppingCart.getInstance(3,20, 5));
        assertEquals(150, shoppingCart.getTotal(), "test failed when adding items to the cart");
        shoppingCart.clearCart();
    }

    @Test
    void removeItemsTest() {
        shoppingCart.addItem(shoppingCart.getInstance(1,20, 1));
        shoppingCart.addItem(shoppingCart.getInstance(2,10, 3));
        shoppingCart.removeItem(1);
        assertEquals(30, shoppingCart.getTotal(), "test failed when removing items from the cart");
    }
}
