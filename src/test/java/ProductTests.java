
import org.example.Product;
import org.example.ProductManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ProductTests {

    ProductManager productManager;
    Product product;

    @BeforeEach
    public void init() {
        productManager = new ProductManager();
        product = new Product("Laptop", 1000, "Electronics");
    }

    @Test
    public void testAddProductToCart() {
        productManager.addProductToCart(product);

        var expected = 1;
        var actual = productManager.getShoppingCart().size();

        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveProductFromCart() {
        productManager.addProductToCart(product);
        productManager.removeProductFromCart(product.getId());

        var expected = 0;
        var actual = productManager.getShoppingCart().size();

        assertEquals(expected, actual);
    }

    @Test
    public void testCheckout() {
        productManager.addProductToCart(product);
        productManager.checkout();

        var expected = 1000;
        var actual = product.getPrice();

        assertEquals(expected, actual);
    }


}
