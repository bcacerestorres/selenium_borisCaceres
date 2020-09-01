package Practico12;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.GetProperties;
import java.security.Key;
import java.util.List;

public class Ejercicio12_1 {
    WebDriver driver;
    private static String SPOTIFY_URL = "https://www.spotify.com/uy/";
    private final String DIFFERENT_EMAILS_ERROR_MSG = "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com";
    private final String REGISTERED_EMAIL_ERROR_MSG = "Este correo electrónico ya está conectado a una cuenta. Inicia sesión.";
    private final String EMAIL_NOEQUALS="Las direcciones de correo electrónico no coinciden.";
    private final String NO_EMAIL="Es necesario que introduzcas tu correo electrónico.";
    private final String NO_CONFIRMACION_EMAIL="Es necesario que confirmes tu correo electrónico.";
    private final String NO_CONTRASEÑA="Debes introducir una contraseña.";
    private final String NO_PERFIL= "Introduce un nombre para tu perfil.";
    private final String NO_DIA="Indica un día del mes válido.";
    private final String NO_MES ="Selecciona tu mes de nacimiento.";
    private final String NO_AÑO="Indica un año válido.";
    private final String NO_SEXO="Selecciona tu sexo.";
    private final String NO_ROBOT="Confirma que no eres un robot.";

    //Ejercicio1
    //  Crear una clase llamada testngSpotify
    //  Crear un método llamado setUp. Debe crear una variable de tipo Properties y
    //  debe inicializar el driver, utilizar el @BeforeMethod
    //  Crear una variable pública con la URL de Spotify
    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(SPOTIFY_URL);
    }
    // Ejercicio2
    //  Crear un método llamado verifySpotifyTitle
    //  Ingresar a https://www.spotify.com/uy/
    //  Verificar que el título sea “ Escuchar es todo - Spotify”
    @Test (priority = 0)
    public void verifySpotifyTitle(){
        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        System.out.println("CURRENT URL " + driver.getCurrentUrl());
        driver.manage().window().maximize();

        String esperado = "Escuchar es todo - Spotify";
        String actual = driver.getTitle();
        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        System.out.print("el titulo actual : "+actual);
        System.out.print("\n");
        System.out.print("el titulo esperado : "+esperado);
        System.out.print("---------------------------------------------------------------------------------------");
        Assert.assertEquals(actual, esperado);
    }
    // Ejercicio3
    //  Crear un método llamado verifySpotifyTitle
    //  Ingresar a https://www.spotify.com/uy/
    //  Verificar que el título sea “ Escuchar es todo - Spotify”
    @Test (priority = 1)
    public void verifySignupUrl(){
        driver.manage().window().maximize();
        // registrar
        driver.findElement(By.xpath("//a[contains(text(),'Registrarse')]")).click();
        // url
        String url= driver.getCurrentUrl();
        String contenga= "signup";
        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        System.out.print("la url es "+url);
        Assert.assertTrue(url.contains(contenga));
        System.out.print("\n");
        System.out.print("---------------------------------------------------------------------------------------");
    }
   // Ejercicio 4
   // Crear un método llamado invalidEmailTest
   // Ingresar a spotify y hacer click en Registrar
   // Completar el email con un email inválido: “test.com”
   // Validar que se despliegue el error: “La dirección de email que proporcionaste no es válida.”
   @Test (priority = 2)
    public void invalidEmailTest() throws InterruptedException{
       driver.manage().window().maximize();
        // registrar
        driver.findElement(By.xpath("//a[contains(text(),'Registrarse')]")).click();
        // email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test.com");
       driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Keys.ENTER);

       Thread.sleep(5000);


        // mensaje de email error
        WebElement emailErrorMessage = driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico no es válido.')]"));

        System.out.print("---------------------------------------------------------------------------------------");
       System.out.print("\n");
        System.out.print("elemento  : "+emailErrorMessage.getText());
        System.out.print("\n");
        System.out.print("variable  : "+DIFFERENT_EMAILS_ERROR_MSG);
       System.out.print("\n");
        System.out.print("---------------------------------------------------------------------------------------");
        Assert.assertEquals(emailErrorMessage.getText(),DIFFERENT_EMAILS_ERROR_MSG);
    }
  //  Ejercicio 5
  //Crear un método llamado validateExistingEmail
  //Ingresar a spotify y hacer click en Registrar
  //Completar el email con uno invalido: “test@test,com”
  //Validar que se despliegue el error: “Lo sentimos, este correo ya está registrado.”
    @Test (priority = 3)
    public void validateExistingEmailTest() throws InterruptedException {
        driver.manage().window().maximize();
        // registrar
        driver.findElement(By.xpath("//a[contains(text(),'Registrarse')]")).click();
        // email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@test.com");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);


        // mensaje de email error
        WebElement emailExiste = driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta.')]"));
        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        System.out.print("elemento existente  : "+emailExiste.getText());
        System.out.print("\n");
        System.out.print("variable existente  : "+REGISTERED_EMAIL_ERROR_MSG);
        System.out.print("\n");
        System.out.print("---------------------------------------------------------------------------------------");
        Assert.assertEquals(emailExiste.getText(),REGISTERED_EMAIL_ERROR_MSG);
    }
   // Ejercicio 6
  //  Crear un método llamado checkEqualEmailsError
 //   Ingresar a spotify y hacer click en Registrar
 //   Completar el email con uno válido: “test999@test.com”
 //   En el campo de confirmar email, colocar otro: “hola@hola.com”
   //   Situarse en otro campo y completarlo
 //   Validar que se despliegue el error: “Las direcciones de correo electrónico no coinciden.”
   @Test (priority = 4)
    public void checkEqualEmailsError(){
       driver.manage().window().maximize();
       // registrar
       driver.findElement(By.xpath("//a[contains(text(),'Registrarse')]")).click();
       // email
       driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test999@test.com");
       // comnfirmacion
       driver.findElement(By.xpath("//input[@id='confirm']")).sendKeys("hola@hola.com");

       //
       driver.findElement(By.xpath("//input[@id='confirm']")).sendKeys(Keys.ENTER);

       // mensaje de email error
       WebElement emailNoiguales = driver.findElement(By.xpath("//*[contains(text(),'Las direcciones de correo electrónico no coinciden.')]"));
       System.out.print("---------------------------------------------------------------------------------------");
       System.out.print("\n");
       System.out.print("elemento existente  : "+emailNoiguales.getText());
       System.out.print("\n");
       System.out.print("variable existente  : "+EMAIL_NOEQUALS);
       System.out.print("\n");
       System.out.print("---------------------------------------------------------------------------------------");
       Assert.assertEquals(emailNoiguales.getText(),EMAIL_NOEQUALS);
    }
   // Ejercicio 7
   // Crear un método llamado checkErrorMessages
   // Ingresar a spotify y hacer click en Registrar
   // Validar que los mensajes de error sean desplegados en los campos obligatorios
   // Agregar variables estáticas para cada mensaje
    @Test (priority = 5)
public void checkErrorMessagesTest() throws InterruptedException{
    driver.manage().window().maximize();
    // registrarse
    driver.findElement(By.xpath("//a[contains(text(),'Registrarse')]")).click();

        Thread.sleep(2000);
    //boton de registrar
    driver.findElement(By.xpath("//button[@class='Button-oyfj48-0 eEPJyH SignupButton___StyledButtonPrimary-cjcq5h-1 deUbNh']")).click();

    // mensaje de no mail
        WebElement emailNo = driver.findElement(By.xpath("//*[contains(text(),'Es necesario que introduzcas tu correo electrónico.')]"));

        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        System.out.print("elemento no email  : "+emailNo.getText());
        System.out.print("\n");
        System.out.print("variable existente no email : "+NO_EMAIL);
        System.out.print("\n");
        System.out.print("---------------------------------------------------------------------------------------");
        Assert.assertEquals(emailNo.getText(),NO_EMAIL);

        // mensaje de no confirmacion email
        WebElement emailNoConfirmacion = driver.findElement(By.xpath("//*[contains(text(),'Es necesario que confirmes tu correo electrónico.')]"));

        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        System.out.print("elemento no confirmacion  email  : "+emailNoConfirmacion.getText());
        System.out.print("\n");
        System.out.print("variable existente  no confirmacion email : " +NO_CONFIRMACION_EMAIL);
        System.out.print("\n");
        System.out.print("---------------------------------------------------------------------------------------");
        Assert.assertEquals(emailNoConfirmacion.getText(),NO_CONFIRMACION_EMAIL);

        //mensaje de  no contraseña
        WebElement emailNoContraseña = driver.findElement(By.xpath("//*[contains(text(),'Debes introducir una contraseña.')]"));

        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        System.out.print("elemento no contraseña  : "+emailNoContraseña.getText());
        System.out.print("\n");
        System.out.print("variable existente  no contraseña : " +NO_CONTRASEÑA);
        System.out.print("\n");
        System.out.print("---------------------------------------------------------------------------------------");
        Assert.assertEquals(emailNoContraseña.getText(),NO_CONTRASEÑA);

        // mensaje de no nombre de perfil
        WebElement NoPerfil = driver.findElement(By.xpath("//*[contains(text(),'Introduce un nombre para tu perfil.')]"));

        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        System.out.print("elemento no perfil  : "+NoPerfil.getText());
        System.out.print("\n");
        System.out.print("variable existente  no perfil : " +NO_PERFIL);
        System.out.print("\n");
        System.out.print("---------------------------------------------------------------------------------------");
        Assert.assertEquals(NoPerfil.getText(),NO_PERFIL);

        // mensaje de no dia
        WebElement NoDia = driver.findElement(By.xpath("//*[contains(text(),'Indica un día del mes válido.')]"));

        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        System.out.print("elemento no dia  : "+NoDia.getText());
        System.out.print("\n");
        System.out.print("variable existente  no dia : " +NO_DIA);
        System.out.print("\n");
        System.out.print("---------------------------------------------------------------------------------------");
        Assert.assertEquals(NoDia.getText(),NO_DIA);

        // mensaje de no mes
        WebElement NoMes = driver.findElement(By.xpath("//*[contains(text(),'Selecciona tu mes de nacimiento.')]"));

        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        System.out.print("elemento no mes   : "+NoMes.getText());
        System.out.print("\n");
        System.out.print("variable existente  no mes: " +NO_MES);
        System.out.print("\n");
        System.out.print("---------------------------------------------------------------------------------------");
        Assert.assertEquals(NoMes.getText(),NO_MES);

        // menssaje de no año
        WebElement NoAño = driver.findElement(By.xpath("//*[contains(text(),'Indica un año válido.')]"));

        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        System.out.print("elemento no año: "+NoAño.getText());
        System.out.print("\n");
        System.out.print("variable existente  no año : " +NO_AÑO);
        System.out.print("\n");
        System.out.print("---------------------------------------------------------------------------------------");
        Assert.assertEquals(NoAño.getText(),NO_AÑO);
        //mensaje de no sexo
        WebElement NoSexo = driver.findElement(By.xpath("//*[contains(text(),'Selecciona tu sexo.')]"));

        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        System.out.print("elemento no sexo  : "+NoSexo.getText());
        System.out.print("\n");
        System.out.print("variable existente  no sexo : " +NO_SEXO);
        System.out.print("\n");
        System.out.print("---------------------------------------------------------------------------------------");
        Assert.assertEquals(NoSexo.getText(),NO_SEXO);

        // mensaje de que no eres un robot
        WebElement NoRobot = driver.findElement(By.xpath("//*[contains(text(),'Confirma que no eres un robot.')]"));

        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        System.out.print("elemento no robot  : "+NoRobot.getText());
        System.out.print("\n");
        System.out.print("variable existente  no robot : " +NO_ROBOT);
        System.out.print("\n");
        System.out.print("---------------------------------------------------------------------------------------");
        Assert.assertEquals(NoRobot.getText(),NO_ROBOT);
    }

    @AfterMethod
    public void closedriver() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }

}
