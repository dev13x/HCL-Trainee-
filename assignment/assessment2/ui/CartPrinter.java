package assignment.assessment2.ui;

import assignment.assessment2.model.Cart;
import assignment.assessment2.model.Product;
import assignment.assessment2.model.ProductSortOption;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/*
 * Assessment 2 - Formatted table printer for carts and multi-user summaries.
 */
public class CartPrinter {

    private static final String CART_ROW_FORMAT = "%-10s %-12s %-25s %-20s %11s %4s %12s";
    private static final String USER_ROW_FORMAT = "%-20s %9s %16s";
    private static final String CURRENCY_LABEL = "Rs. ";
    private static final int DECIMAL_SCALE = 2;

    private final PrintStream out;

    public CartPrinter(PrintStream out) {
        this.out = out;
    }

    public static String formatAmount(BigDecimal amount) {
        return CURRENCY_LABEL + formatPlain(amount);
    }

    public void printCart(Cart cart, ProductSortOption sortOption) {
        List<Product> products = cart.getProducts(sortOption);
        String header = String.format(CART_ROW_FORMAT,
                "ID", "Category", "Name", "Details", "Price (Rs.)", "Qty", "Subtotal");
        String border = repeat('-', header.length());

        out.println();
        out.println("Cart of " + cart.getOwnerName() + " (" + products.size()
                + " product(s), sorted by " + sortOption.getLabel() + "):");
        out.println(border);
        out.println(header);
        out.println(border);
        for (Product product : products) {
            out.println(String.format(CART_ROW_FORMAT,
                    product.getId(),
                    product.getCategory().getDisplayName(),
                    product.getName(),
                    product.getSpecificDetails(),
                    formatPlain(product.getPrice()),
                    product.getQuantity(),
                    formatPlain(product.getTotalPrice())));
        }
        out.println(border);
        out.println("Grand Total: " + formatAmount(Cart.calculateTotal(products)));
    }

    public void printUserSummary(List<Cart> carts) {
        String header = String.format(USER_ROW_FORMAT, "User", "Products", "Total Amount");
        String border = repeat('-', header.length());

        out.println();
        out.println("All Users (" + carts.size() + " registered)");
        out.println(border);
        out.println(header);
        out.println(border);
        for (Cart cart : carts) {
            List<Product> products = cart.getProducts(ProductSortOption.NAME);
            out.println(String.format(USER_ROW_FORMAT,
                    cart.getOwnerName(),
                    products.size(),
                    formatAmount(Cart.calculateTotal(products))));
        }
        out.println(border);
    }

    private static String formatPlain(BigDecimal amount) {
        return amount.setScale(DECIMAL_SCALE, RoundingMode.HALF_UP).toPlainString();
    }

    private static String repeat(char ch, int count) {
        char[] arr = new char[count];
        Arrays.fill(arr, ch);
        return new String(arr);
    }
}
