package org.example;

public record Product(String id, String name, double unitPrice, long amount) {
    public Product withAmount(long amount){
        return new Product(id, name, unitPrice, amount);
    }
}
