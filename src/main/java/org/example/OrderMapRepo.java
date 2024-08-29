package org.example;

import java.util.HashMap;
import java.util.Map;

public class OrderMapRepo implements OrderRepo{
    private Map<String, Order> orderInventory = new HashMap<>();

    @Override
    public void addOrder(Order order){
        orderInventory.put(order.id(), order);
    }

    @Override
    public void removeOrder(String id){
        orderInventory.remove(id);
    }

    @Override
    public Order getSingleOrders(String id){
        return orderInventory.get(id);
    }

    @Override
    public Map<String, Order> getAllOrders(){
        return orderInventory;
    }

}
