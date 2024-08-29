package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProductRepoTest {
// note: getSingleProduct is used for all tests' assertions and therefore tested as well

    @Test
    void addProductShouldAddProduct() {
        ProductRepo testProductRepo = new ProductRepo();
        Product soap = new Product("001", "Soap", 0.99, 50);
        testProductRepo.addProduct(soap);
        assertThat(testProductRepo.getSingleProduct("001"))
            .isNotNull()
            .isEqualTo(soap);
    }

    @Test
    void removeProductShouldRemoveProduct() {
        ProductRepo testProductRepo = new ProductRepo();
        Product soap = new Product("001", "Soap", 0.99, 50);
        testProductRepo.addProduct(soap);
        assertThat(testProductRepo.getSingleProduct("001"))
                .isNotNull()
                .isEqualTo(soap);

        testProductRepo.removeProduct(soap.id());

        assertThat(testProductRepo.getSingleProduct("001"))
                .isNull();
    }


    @Test
    void getAllProducts() {
        ProductRepo testProductRepo = new ProductRepo();
        Product soap = new Product("001", "Soap", 0.99, 50);
        Product toaster = new Product("002", "Toaster", 25.99, 10);

        testProductRepo.addProduct(soap);
        testProductRepo.addProduct(toaster);

        assertThat(testProductRepo.getAllProducts())
                .isNotNull()
                .hasSize(2);
    }
}