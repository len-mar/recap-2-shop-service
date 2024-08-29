package org.example;

import java.util.Map;

public interface OrderRepo {
    public void placeOrder(Order order);
    public void removeOrder(String id);
    public Order getSingleOrder(String id);
    public Map<String, Order> getAllOrders();
}
