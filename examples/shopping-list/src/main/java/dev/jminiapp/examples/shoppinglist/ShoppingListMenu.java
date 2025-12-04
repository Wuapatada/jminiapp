package dev.jminiapp.examples.shoppinglist;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ShoppingListMenu {

    private final Scanner scanner;
    private final PrintStream out;

    public ShoppingListMenu(Scanner scanner, PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }

    public void start(List<ShoppingItem> items) {
        boolean running = true;

        while (running) {
            printMenu(items);
            out.print("Choose an option: ");
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1" -> addItem(items);
                case "2" -> updateQuantity(items);
                case "3" -> togglePurchased(items);
                case "4" -> removeItem(items);
                case "5" -> running = false;
                default -> out.println("Invalid option.");
            }
        }
    }

    private void printMenu(List<ShoppingItem> items) {
        out.println();
        out.println("==== SHOPPING LIST ====");
        if (items.isEmpty()) {
            out.println("No items yet.");
        } else {
            int i = 1;
            for (ShoppingItem item : items) {
                out.printf("%d) %s x%d [%s]%n",
                        i++,
                        item.getName(),
                        item.getQuantity(),
                        item.isPurchased() ? "purchased" : "pending");
            }
        }
        out.println("-----------------------");
        out.println("1) Add item");
        out.println("2) Update quantity");
        out.println("3) Toggle purchased");
        out.println("4) Remove item");
        out.println("5) Save and exit");
    }

    private void addItem(List<ShoppingItem> items) {
        out.print("Item name: ");
        String name = scanner.nextLine().trim();
        out.print("Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine().trim());
        items.add(new ShoppingItem(name, qty));
    }

    private void updateQuantity(List<ShoppingItem> items) {
        if (items.isEmpty()) {
            out.println("No items to update.");
            return;
        }
        out.print("Item number: ");
        int idx = Integer.parseInt(scanner.nextLine().trim()) - 1;
        if (idx < 0 || idx >= items.size()) {
            out.println("Invalid item.");
            return;
        }
        out.print("New quantity: ");
        int qty = Integer.parseInt(scanner.nextLine().trim());
        items.get(idx).setQuantity(qty);
    }

    private void togglePurchased(List<ShoppingItem> items) {
        if (items.isEmpty()) {
            out.println("No items to update.");
            return;
        }
        out.print("Item number: ");
        int idx = Integer.parseInt(scanner.nextLine().trim()) - 1;
        if (idx < 0 || idx >= items.size()) {
            out.println("Invalid item.");
            return;
        }
        ShoppingItem item = items.get(idx);
        item.setPurchased(!item.isPurchased());
    }

    private void removeItem(List<ShoppingItem> items) {
        if (items.isEmpty()) {
            out.println("No items to remove.");
            return;
        }
        out.print("Item number: ");
        int idx = Integer.parseInt(scanner.nextLine().trim()) - 1;
        if (idx < 0 || idx >= items.size()) {
            out.println("Invalid item.");
            return;
        }
        items.remove(idx);
    }
}
