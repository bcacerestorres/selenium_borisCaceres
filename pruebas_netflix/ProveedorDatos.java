package pruebas_netflix;

import org.testng.annotations.DataProvider;

public class ProveedorDatos {
    @DataProvider(name = "email")
    public Object[][]correos(){
        return new Object[][]{{"Jose@"},{"Luis@asas"},{"22223@253"}};
    }

}
