package pruebas_netflix;
import pruebas_netflix.TestNetflix.TestNetflix;
import org.testng.annotations.Factory;
public class Fabrica {
    @Factory
    public Object[] FactoryMethod (){
      return new Object[]{
          //      new TestNetflix(1),
           //     new TestNetflix(2),
    };
   }
}
