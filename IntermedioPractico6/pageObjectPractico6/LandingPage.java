package IntermedioPractico6.pageObjectPractico6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//  clase pagina de carga prncipal
public class LandingPage {
    // boton login
    @FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=my-account']")
    public WebElement loginBtn;

    public WebDriver driver;
    // metodo constructor
    public LandingPage(WebDriver remoteDriver){
        this.driver = remoteDriver;
        PageFactory.initElements(driver, this);
    }
// metodo de autentificacion
    public AuthenticationPage clickOnLoginBtn(){
        loginBtn.click();
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        return authenticationPage;

    }

}
