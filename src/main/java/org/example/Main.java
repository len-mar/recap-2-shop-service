// FIXME: this string id business is awful, fix it please
// FIXME: some methods take an id, some take the object, decide on one and be consistent

package org.example;

public class Main {
    public static void main(String[] args) {
        ShopService mainShop = new ShopService();

        Product apples = new Product("003", "Apple", .70, 40 );
        mainShop.getProductRepo().addProduct(apples);
        System.out.println("My shop has 40 apples in stock for 70ct a piece.");

        System.out.println("Dora places an order for 20 apples.");
        Order appleOrder = new Order("001", apples, 20, "Dora");
        mainShop.getOrderMapRepo().placeOrder(appleOrder);

        System.out.println("Dora pays " + mainShop.getOrderMapRepo().getSingleOrder(appleOrder.id()).totalPrice() + " Euros for them.");
        System.out.println("Now there's " + mainShop.getProductRepo().getSingleProduct("003").amountInStock() + " apples left in stock.");
        System.out.println("Dora places the same order again.");

        Order appleOrder2 = new Order("002", apples, 20, "Dora");
        mainShop.getOrderMapRepo().placeOrder(appleOrder2);

        System.out.println("And finally there's " + mainShop.getProductRepo().getSingleProduct("003").amountInStock() + " apples left in stock.");
        System.out.println("Dora hasn't had enough apples yet. She tries again to buy 20.");

        Order appleOrder3 = new Order("003", apples, 20, "Dora");
        mainShop.getOrderMapRepo().placeOrder(appleOrder3);
        System.out.println("However, she fails. I'm all out of apples.");




    }
}