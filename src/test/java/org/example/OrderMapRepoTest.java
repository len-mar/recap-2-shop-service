package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderMapRepoTest {
// note: getSingleOrder is used for all tests' assertions and therefore tested as well


    @Test
    void placeOrder_shouldNotPlaceOrder_ifNotEnoughStock() {
        ShopService shop = new ShopService();
        OrderMapRepo testOrderRepo = shop.getOrderMapRepo();
        ProductRepo testProductRepo = shop.getProductRepo();


        Product soap = new Product("001", "Soap", 0.99, 1);
        Order order2Soap = new Order("001", soap, 2, "Thomas");

        testProductRepo.addProduct(soap);
        testOrderRepo.placeOrder(order2Soap);

        assertThat(testOrderRepo.getSingleOrder("001"))
                .isNull();
    }

    @Test
    void placeOrder_shouldPlaceOrderAndUpdateStock_ifEnoughStock() {
        ShopService shop = new ShopService();
        OrderMapRepo testOrderRepo = shop.getOrderMapRepo();
        ProductRepo testProductRepo = shop.getProductRepo();

        Product soap = new Product("001", "Soap", 0.99, 50);
        Order order2Soap = new Order("001", soap, 2, "Thomas");

        testProductRepo.addProduct(soap);
        testOrderRepo.placeOrder(order2Soap);

        assertThat(testOrderRepo.getSingleOrder("001"))
                .isNotNull()
                .isEqualTo(order2Soap);
        assertThat(testOrderRepo.getSingleOrder("001").totalPrice())
                .isNotNull()
                .isEqualTo(1.98);
        assertThat(testProductRepo.getSingleProduct("001").amountInStock() == 48);
    }

    @Test
    void removeOrder_shouldRemoveOrder() {
        ShopService shop = new ShopService();
        OrderMapRepo testOrderRepo = shop.getOrderMapRepo();
        ProductRepo testProductRepo = shop.getProductRepo();

        Product soap = new Product("001", "Soap", 0.99, 50);
        Order order2Soap = new Order("001", soap, 2, "Thomas");
        testProductRepo.addProduct(soap);
        testOrderRepo.placeOrder(order2Soap);
        assertThat(testOrderRepo.getSingleOrder("001"))
                .isNotNull()
                .isEqualTo(order2Soap);

        testOrderRepo.removeOrder(order2Soap.id());

        assertThat(testOrderRepo.getSingleOrder("001"))
                .isNull();
    }

    @Test
    void getAllOrders_shouldReturnAllOrders() {
        ShopService shop = new ShopService();
        OrderMapRepo testOrderRepo = shop.getOrderMapRepo();
        ProductRepo testProductRepo = shop.getProductRepo();

        Product soap = new Product("001", "Soap", 0.99, 50);
        Product toaster = new Product("002", "Toaster", 25.99, 10);

        Order order2Soap = new Order("001", soap, 2, "Thomas");
        Order order1Toaster = new Order("002", toaster, 1, "Thomas");

        testProductRepo.addProduct(soap);
        testProductRepo.addProduct(toaster);

        testOrderRepo.placeOrder(order2Soap);
        testOrderRepo.placeOrder(order1Toaster);

        assertThat(testOrderRepo.getAllOrders())
                .isNotNull()
                .hasSize(2);
    }
}