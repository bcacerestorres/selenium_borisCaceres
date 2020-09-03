package Practico13;

import org.testng.annotations.Factory;

public class DocusignFactory_excution {
   // DocusignFactory debe invocar 3 veces a la clase DocusignFactoryTest creando nuevas
  //  instancias de la misma.
    @Factory
    public Object[] FactoryMethod (){
       return new Object[]{new DocusignFactory(),
                new DocusignFactory(),
                new DocusignFactory()};
    }

}
