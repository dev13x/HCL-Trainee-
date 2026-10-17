package assignment.assessment2.service;

import assignment.assessment2.exception.InvalidInputException;
import assignment.assessment2.model.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * Assessment 2 - CartManager maintaining user carts with case-insensitive user names.
 */
public class CartManager {

    public static final int MAX_USER_NAME_LENGTH = 20;

    private final Map<String, Cart> cartsByUserName = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public synchronized Cart getCartOf(String userName) {
        String cleanName = validateUserName(userName);
        Cart cart = cartsByUserName.get(cleanName);
        if (cart == null) {
            cart = new Cart(cleanName);
            cartsByUserName.put(cleanName, cart);
        }
        return cart;
    }

    public synchronized List<Cart> getAllCarts() {
        return new ArrayList<>(cartsByUserName.values());
    }

    private static String validateUserName(String userName) {
        String clean = (userName == null) ? "" : userName.trim();
        if (clean.isEmpty()) {
            throw new InvalidInputException("Username must not be empty.");
        }
        if (clean.length() > MAX_USER_NAME_LENGTH) {
            throw new InvalidInputException("Username cannot exceed " + MAX_USER_NAME_LENGTH + " characters.");
        }
        return clean;
    }
}
