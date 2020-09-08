package Practico13;

import org.testng.annotations.Test;

public class DependentTests {
   // Ejercicio
  //  Crear una clase llamada  dependentGroup que importe utilice la notación dependsOnGroups
  //  y groups en el cual el método testOne, testTwo y un método testThree. El método 2 y 3
  //  pertenecen a un mismo grupo, y el método 1, depende de la ejecución del grupo 1
 @Test (dependsOnGroups = {"grupo1"})
     public void testOne(){
     System.out.print("-------------------------------------------------------------------------\n");
     System.out.print("Test uno \n");
     System.out.print("-------------------------------------------------------------------------\n");
     }
 @Test (groups= {"grupo1"})
 public void testTwo(){
     System.out.print("-------------------------------------------------------------------------\n");
     System.out.print("Test 2\n");
     System.out.print("-------------------------------------------------------------------------\n");
     }
 @Test (groups= {"grupo1"})
      public void testThree(){
     System.out.print("-------------------------------------------------------------------------\n");
     System.out.print("Test 3\n");
     System.out.print("-------------------------------------------------------------------------\n");
     }
}
