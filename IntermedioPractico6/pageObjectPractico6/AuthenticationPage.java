package IntermedioPractico6.pageObjectPractico6;

//import ecommerceSite.utils.Constants;
import IntermedioPractico6.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

// clase pagina de autentificacion
public class AuthenticationPage {
   //  elementos de la web de autentificacion
    @FindBy(id = "SubmitLogin")
    public WebElement loginBtn;

    @FindBy(id = "SubmitCreate")
    public WebElement createAccountBtn;

    @FindBy(id = "email_create")
    public WebElement emailTextField;

    @FindBy (xpath = "//*[@id='create_account_error']/ol/li")
    public WebElement createAccountErrorMsg;

   // metodo constructor
    public WebDriver driver;

    public AuthenticationPage(WebDriver remoteDriver){
        this.driver = remoteDriver;
        PageFactory.initElements(driver, this);
    }

    // metodo de validacion
    public void validateAuthPage(){
        WebElement authenticationSection = driver.findElement(By.tagName("h1"));
    //    org.junit.Assert.assertEquals("AUTHENTICATION", authenticationSection.getText());
        Assert.assertEquals("AUTHENTICATION", authenticationSection.getText());
     //   org.junit.Assert.assertTrue(driver.getTitle().contains("Login"));
      Assert.assertTrue(driver.getTitle().contains("Login"));
    }

    // metodo de creacion de cuenta por email
    public NewAccountPage createEmailOfTheAccount(String myEmail){
        driver.findElement(By.id("email_create")).sendKeys(myEmail);
        driver.findElement(By.name("SubmitCreate")).click();

        NewAccountPage newAccountPage = new NewAccountPage(driver);
        return newAccountPage;
    }

    // metodo de login exitosso
    public MyAccountPage successfullLogin(String myEmail) throws InterruptedException {
        //try to login...
        WebElement emailLoginField = driver.findElement(By.id("email"));
        WebElement passwordLoginField = driver.findElement(By.id("passwd"));

        emailLoginField.sendKeys(myEmail);
        passwordLoginField.sendKeys(Constants.PASSWORD);
        System.out.println("before login... " + driver.getTitle());
        //WebElement loginBtn = driver.findElement(By.id("SubmitLogin"));
        Thread.sleep(5000);

        loginBtn.click();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        return myAccountPage;

    }

    // metodo que retorna url
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    // metodo de escribir email
    public void fillEmailField(String anEmail){
        emailTextField.sendKeys(anEmail);
    }

    // metodo de realizar click
    public void clickOnCreateAccountBtn(){
        createAccountBtn.click();
    }

    // metodo de traer el mensaje de texto
    public String getDuplicateEmailErrorMsg(){
        return createAccountErrorMsg.getText();
    }

    // metodo que resgistra usuario
    public MyAccountPage registerAnUser(String myEmail, String fakeFirstName, String fakeLastName) throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver); // page 1
        AuthenticationPage authenticationPage = landingPage.clickOnLoginBtn();// page 2
        authenticationPage.validateAuthPage();

        NewAccountPage newAccountPage = authenticationPage.createEmailOfTheAccount(myEmail);// page 3

        Thread.sleep(2000);
        return newAccountPage.fillingPersonalInfoForm(fakeFirstName, fakeLastName);
    }

}
