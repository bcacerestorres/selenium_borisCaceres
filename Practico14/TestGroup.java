package Practico14;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TestGroup {
    @Test(groups = {"exitoso","fallido"})

    @BeforeTest
    public void vacio(){ }

    @Test (groups = "exitoso")
    public void exitoso_1(){
     System.out.println("prueba exitosa 1");
    }

    @Test (groups = "exitoso")
    public void exitoso_2(){
        System.out.println("prueba exitosa 2");
    }

    @Test(groups = "exitoso")
    public void exitoso_3(){
        System.out.println("prueba exitosa 3");
    }

    @Test (groups = "fallido")
    public void fallido_1(){
        System.out.println("prueba fallido 1");
    }

    @Test (groups = "fallido")
    public void fallido_2(){
        System.out.println("prueba fallido 2");
    }

    @Test (groups = "fallido")
    public void fallido_3(){
        System.out.println("prueba fallido 3");
    }

}
