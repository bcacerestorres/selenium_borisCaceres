package IntermedioPractico6.pageObjectPractico6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//clase mi pagina personal
public class MyPersonalInformationPage {
    // elementos de la pagina
    public WebDriver driver;

    @FindBy(id = "firstname")
    public WebElement firstNameInputField;

    @FindBy(id = "lastname")
    public WebElement lastNameInputField;

    @FindBy(id = "email")
    public WebElement emailInputField;

    // metodo constructor
    public MyPersonalInformationPage(WebDriver remoteDriver){
        this.driver = remoteDriver;
        PageFactory.initElements(driver, this);

    }
   //metodo que retorna el nombre
    public String getFirstNameValue(){
        return firstNameInputField.getAttribute("value");
    }

    //metodo que retorna el apellido
    public String getLastNameValue(){
        return lastNameInputField.getAttribute("value");
    }

    // metodo que retorna el email
    public String getEmailValue(){
        return emailInputField.getAttribute("value");
    }
}
