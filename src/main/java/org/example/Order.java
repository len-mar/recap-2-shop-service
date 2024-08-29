package org.example;

public record Order(String id, Product product, long amount, String customer) {
    // todo: we might need another field, totalPrice (amount*unitPrice)
}
