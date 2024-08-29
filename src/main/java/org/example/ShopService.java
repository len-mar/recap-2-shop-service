package org.example;
import org.apache.commons.lang3.RandomStringUtils;


public class ShopService {
    private OrderMapRepo orderMapRepo;
    private ProductRepo productRepo;

    public ShopService(OrderMapRepo orderMapRepo, ProductRepo productRepo){
        this.orderMapRepo = new OrderMapRepo();
        this.productRepo = new ProductRepo();
    }

    public void placeOrder(Product product, long amount){
        if(productRepo.getSingleProduct(product.id()).amount()>= amount){
            orderMapRepo.addOrder(new Order(RandomStringUtils.random(5, false, true), product, amount, "Barbara"));
            productRepo.getSingleProduct(product.id()).withAmount(amount);
        }
        else{
            System.out.println("Error: There might not be enough product in stock.");
        }

    }
}
