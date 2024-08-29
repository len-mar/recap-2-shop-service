package org.example;

public record Order(String id, Product product, long amount, String customer, double totalPrice) {
    public Order(String id, Product product, long amount, String customer){
        this(id, product, amount, customer, product.unitPrice() * amount);

    }

    // TODO: Allow the user to specify and modify the quantity of products in an order.
    // specify: already in constructor
    // modify: withAmount

    public Order withAmount(long newAmount){
        return(new Order(this.id, this.product, newAmount, this.customer));
}

}
