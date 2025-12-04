package dev.jminiapp.examples.shoppinglist;

import com.jminiapp.core.api.JMiniApp;
import com.jminiapp.core.api.JMiniAppConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingListApp extends JMiniApp {

    private List<ShoppingItem> items;

    public ShoppingListApp(JMiniAppConfig config) {
        super(config);
    }

    @Override
    protected void initialize() {
        Object data = context.getData();

        items = new ArrayList<>();

        if (data instanceof List<?>) {
            List<?> rawList = (List<?>) data;
            for (Object element : rawList) {
                if (element instanceof ShoppingItem) {
                    items.add((ShoppingItem) element);
                }
            }
        }
    }

    @Override
    protected void run() {
        Scanner scanner = new Scanner(System.in);
        ShoppingListMenu menu = new ShoppingListMenu(scanner, System.out);
        menu.start(items);
    }

    @Override
    protected void shutdown() {
        context.setData(items);
    }
}
