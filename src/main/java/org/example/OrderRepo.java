package org.example;

import java.util.Map;

public interface OrderRepo {
    public void addOrder(Order order);
    public void removeOrder(String id);
    public Order getSingleOrders(String id);
    public Map<String, Order> getAllOrders();
}
