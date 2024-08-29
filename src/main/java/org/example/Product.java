package org.example;

public record Product(String id, String name, double unitPrice, long amountInStock) {
    // returns new product with updated amountInStock after order (wither)
    public Product withAmount(long newAmountInStock){
        return new Product(id, name, unitPrice, newAmountInStock);
    }
}
