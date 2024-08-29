// this is not used

//package org.example;
//
//import java.util.*;
//
//public class OrderListRepo{
//    private ArrayList<Order> orderInventory = new ArrayList<>();
//
//    public void addOrder(Order order){
//        orderInventory.add(order);
//    }
//
//    public void removeOrder(String id){
//        orderInventory.remove(orderInventory.stream().filter(order -> id.equals(order.id())).findFirst());
//    }
//
//    public Order getSingleOrders(String id){
//        return orderInventory.stream().filter(order -> id.equals(order.id())).findFirst().orElse(null);
//    }
//
//    public ArrayList<Order> getAllOrders(){
//        return orderInventory;
//    }
//
//
//}
