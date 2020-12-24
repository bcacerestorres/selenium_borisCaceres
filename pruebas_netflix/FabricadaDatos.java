package pruebas_netflix;

import com.github.javafaker.Faker;
import java.util.Random;

public class FabricadaDatos {
    public static Faker faker = new Faker();

    public static String getNombre(){
        String nombre = faker.name().firstName();
        return nombre;
    }

    public static String getApellido(){
        String apellido =faker.name().lastName();
        return apellido;
    }

    public static String getCorreo(){
        String email = faker.internet().emailAddress();
        return email;
    }

    public static String getTelefono(){
        Random random = new Random();
        return String.valueOf(random.nextInt(1000000) +100000000);
    }

    public static String getTrabajo(){
        String trabajo = faker.job().title();
        return trabajo;
    }

    public static   String getEmpresa(){
        String empresa = faker.company().name();
        return empresa;
    }

    public static String getClave(){
        String clave= faker.internet().password();
        return clave;
    }

}
