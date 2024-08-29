package org.example;

import java.util.HashMap;
import java.util.Map;

public class OrderMapRepo implements OrderRepo{
    private Map<String, Order> orderInventory = new HashMap<>();
    private ShopService shopService;
    private ProductRepo productRepo;

    public OrderMapRepo(){

    }
    public OrderMapRepo(ShopService shopService, ProductRepo productRepo) {
        this.shopService = shopService;
        this.productRepo = productRepo;
    }

    @Override
    public void placeOrder(Order order){
        // if available product stock higher than order amount
        if(productRepo.getSingleProduct(order.product().id()).amountInStock() >= order.amount()){
            // adds order to order inventory
            orderInventory.put(order.id(), order);
            // updates the stock by removing the original product and adding another with updated stock
            long updatedStock = productRepo.getSingleProduct(order.product().id()).amountInStock() - order.amount();
            productRepo.removeProduct(order.product().id());
            productRepo.addProduct(order.product().withAmount(updatedStock));
            // prints success message
            System.out.println("Order successful.");
        }
        else{
            System.out.println("Error: Not enough product in stock.");
        }

    }

    @Override
    public void removeOrder(String id){
        orderInventory.remove(id);
    }

    @Override
    public Order getSingleOrder(String id){
        return orderInventory.get(id);
    }

    @Override
    public Map<String, Order> getAllOrders(){
        return orderInventory;
    }

}
