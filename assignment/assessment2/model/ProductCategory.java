package assignment.assessment2.model;

/*
 * Assessment 2 - Product categories supported by the shopping mall application.
 */
public enum ProductCategory {

    CLOTHES("Clothes", "Size (XS, S, M, L, XL, XXL)"),
    ELECTRONIC("Electronic", "Warranty in months"),
    TOYS("Toys", "Minimum age in years");

    private final String displayName;
    private final String extraDetailLabel;

    ProductCategory(String displayName, String extraDetailLabel) {
        this.displayName = displayName;
        this.extraDetailLabel = extraDetailLabel;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getExtraDetailLabel() {
        return extraDetailLabel;
    }
}
