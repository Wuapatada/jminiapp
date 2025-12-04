package dev.jminiapp.examples.shoppinglist;

import com.jminiapp.core.engine.JMiniAppRunner;

public class ShoppingListAppRunner {

    public static void main(String[] args) {
        JMiniAppRunner
                .forApp(ShoppingListApp.class)
                .withState(ShoppingItem.class)
                .run(args);
    }
}
