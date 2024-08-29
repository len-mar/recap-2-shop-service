package org.example;

public record Product(String id, String name, double unitPrice, long amountInStock) {
    public Product withAmount(long newAmountInStock){
        return new Product(id, name, unitPrice, newAmountInStock);
    }
}
