package assignment.assessment2.ui;

import assignment.assessment2.exception.CartException;
import assignment.assessment2.exception.InvalidInputException;
import assignment.assessment2.model.Cart;
import assignment.assessment2.model.Product;
import assignment.assessment2.model.ProductCategory;
import assignment.assessment2.model.ProductSortOption;
import assignment.assessment2.service.CartManager;
import assignment.assessment2.service.ProductFactory;

import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.NoSuchElementException;

/*
 * Assessment 2 - ShoppingCartApp: Interactive multi-user shopping cart console application.
 */
public class ShoppingCartApp {

    private static final int MENU_EXIT = 0;
    private static final int MENU_ADD_PRODUCT = 1;
    private static final int MENU_REMOVE_PRODUCT = 2;
    private static final int MENU_UPDATE_PRODUCT = 3;
    private static final int MENU_SHOW_CART = 4;
    private static final int MENU_SWITCH_USER = 5;
    private static final int MENU_SHOW_ALL_USERS = 6;

    private final PrintStream out;
    private final ConsoleInput input;
    private final CartPrinter printer;
    private final CartManager cartManager = new CartManager();
    private Cart activeCart;

    public ShoppingCartApp(InputStream in, PrintStream out) {
        this.out = out;
        this.input = new ConsoleInput(in, out);
        this.printer = new CartPrinter(out);
    }

    public static void main(String[] args) {
        new ShoppingCartApp(System.in, System.out).run();
    }

    public void run() {
        out.println("========================================");
        out.println("   ONLINE SHOPPING CART SYSTEM          ");
        out.println("========================================");
        try {
            activeCart = askForUserCart();
            boolean running = true;
            while (running) {
                printMenu();
                running = handleMenuChoice(input.readInt("Enter choice: "));
            }
        } catch (NoSuchElementException inputClosed) {
            out.println();
            out.println("Input stream closed. Exiting shopping cart.");
        }
    }

    private void printMenu() {
        out.println();
        out.println("----- MENU (Active: " + activeCart.getOwnerName() + ") -----");
        out.println(MENU_ADD_PRODUCT + ". Add product");
        out.println(MENU_REMOVE_PRODUCT + ". Remove product");
        out.println(MENU_UPDATE_PRODUCT + ". Update product");
        out.println(MENU_SHOW_CART + ". Show cart");
        out.println(MENU_SWITCH_USER + ". Switch user");
        out.println(MENU_SHOW_ALL_USERS + ". Show all users");
        out.println(MENU_EXIT + ". Exit");
    }

    private boolean handleMenuChoice(int choice) {
        try {
            switch (choice) {
                case MENU_ADD_PRODUCT:
                    addProduct();
                    break;
                case MENU_REMOVE_PRODUCT:
                    removeProduct();
                    break;
                case MENU_UPDATE_PRODUCT:
                    updateProduct();
                    break;
                case MENU_SHOW_CART:
                    showCart();
                    break;
                case MENU_SWITCH_USER:
                    activeCart = askForUserCart();
                    break;
                case MENU_SHOW_ALL_USERS:
                    printer.printUserSummary(cartManager.getAllCarts());
                    break;
                case MENU_EXIT:
                    out.println("Thank you for shopping. Goodbye!");
                    return false;
                default:
                    out.println("Invalid option. Please choose between " + MENU_EXIT + " and " + MENU_SHOW_ALL_USERS + ".");
            }
        } catch (CartException ex) {
            out.println("Error: " + ex.getMessage());
        }
        return true;
    }

    private Cart askForUserCart() {
        while (true) {
            String userName = input.readLine("Enter customer username: ");
            try {
                Cart cart = cartManager.getCartOf(userName);
                if (cart.isEmpty()) {
                    out.println("Welcome, " + cart.getOwnerName() + "! Your cart is currently empty.");
                } else {
                    out.println("Welcome back, " + cart.getOwnerName() + "! You have "
                            + cart.getProductCount() + " product(s) in your cart.");
                }
                return cart;
            } catch (InvalidInputException ex) {
                out.println("Error: " + ex.getMessage());
            }
        }
    }

    private void addProduct() {
        ProductCategory category = askForCategory();
        String id = input.readLine("Product ID (e.g. C101): ");
        String name = input.readLine("Product Name: ");
        BigDecimal price = input.readAmount("Price (Rs.): ");
        int quantity = input.readInt("Quantity: ");
        String extraDetail = input.readLine(category.getExtraDetailLabel() + ": ");

        Product product = ProductFactory.create(category, id, name, price, quantity, extraDetail);
        activeCart.addProduct(product);
        out.println("Successfully added to cart: " + describe(product));
    }

    private void removeProduct() {
        if (activeCart.isEmpty()) {
            out.println("Your cart is empty. Nothing to remove.");
            return;
        }
        String id = input.readLine("Product ID to remove: ");
        Product removed = activeCart.removeProduct(id);
        out.println("Removed from cart: " + describe(removed));
    }

    private void updateProduct() {
        if (activeCart.isEmpty()) {
            out.println("Your cart is empty. Nothing to update.");
            return;
        }
        String id = input.readLine("Product ID to update: ");
        Product current = activeCart.getProduct(id);
        out.println("Current details: " + describe(current));
        out.println("Press Enter without typing to keep the current value.");

        String newName = emptyToNull(input.readLine("New name: "));
        BigDecimal newPrice = input.readOptionalAmount("New price (Rs.): ");
        Integer newQuantity = input.readOptionalInt("New quantity: ");

        if (newName == null && newPrice == null && newQuantity == null) {
            out.println("No changes were made.");
            return;
        }
        Product updated = activeCart.updateProduct(id, newName, newPrice, newQuantity);
        out.println("Updated successfully: " + describe(updated));
    }

    private void showCart() {
        if (activeCart.isEmpty()) {
            out.println("Your cart is empty.");
            return;
        }
        printer.printCart(activeCart, askForSortOption());
    }

    private ProductCategory askForCategory() {
        ProductCategory[] categories = ProductCategory.values();
        out.println("Select Product Category:");
        for (int i = 0; i < categories.length; i++) {
            out.println("  " + (i + 1) + ". " + categories[i].getDisplayName());
        }
        int choice = input.readInt("Choose category (1-" + categories.length + "): ");
        if (choice < 1 || choice > categories.length) {
            throw new InvalidInputException("Category selection must be between 1 and " + categories.length + ".");
        }
        return categories[choice - 1];
    }

    private ProductSortOption askForSortOption() {
        ProductSortOption[] options = ProductSortOption.values();
        out.println("Sort Cart By:");
        for (int i = 0; i < options.length; i++) {
            out.println("  " + (i + 1) + ". " + options[i].getLabel());
        }
        Integer choice = input.readOptionalInt("Choose sort order (1-" + options.length + ", Enter = 1): ");
        if (choice == null) {
            return options[0];
        }
        if (choice < 1 || choice > options.length) {
            throw new InvalidInputException("Sort choice must be between 1 and " + options.length + ".");
        }
        return options[choice - 1];
    }

    private static String describe(Product product) {
        return product + " [" + product.getCategory().getDisplayName() + ", "
                + product.getSpecificDetails() + ", Unit: " + CartPrinter.formatAmount(product.getPrice()) + "]";
    }

    private static String emptyToNull(String text) {
        return (text != null && text.isEmpty()) ? null : text;
    }
}
