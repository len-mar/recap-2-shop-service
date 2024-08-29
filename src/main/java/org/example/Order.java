package org.example;

public record Order(String id, Product product, long amount, String customer, double totalPrice) {
    // constructs order with automatically calculated total price
    public Order(String id, Product product, long amount, String customer){
        this(id, product, amount, customer, product.unitPrice() * amount);

    }
}
