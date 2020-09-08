package Practico13;
import org.testng.annotations.Factory;
public class ShopifyFactory_execution {
    @Factory
    public Object[] FactoryMethod (){
        return new Object[]{
                new ShopifyFactory(1),
                new ShopifyFactory(2),
                new ShopifyFactory(3),
                new ShopifyFactory(4),
        };
    }
}
