package org.example;

public class ShopService {
    private OrderMapRepo orderMapRepo;
    private ProductRepo productRepo;

    // creates new order and product repos at time of instantiation
    public ShopService(){
        this.productRepo = new ProductRepo(this);
        this.orderMapRepo = new OrderMapRepo(this, this.productRepo);
    }

    public OrderMapRepo getOrderMapRepo() {
        return orderMapRepo;
    }

    public void setOrderMapRepo(OrderMapRepo orderMapRepo) {
        this.orderMapRepo = orderMapRepo;
    }

    public ProductRepo getProductRepo() {
        return productRepo;
    }

    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    // todo: how to include the customer dynamically?

}
