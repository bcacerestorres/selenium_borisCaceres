package IntermedioPractico6.pageObjectPractico6;

import IntermedioPractico6.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;

// clase pagina  mi cuenta
public class MyAccountPage {

    public WebDriver driver;

    // elementos de la pagina
    @FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?mylogout=']")
    public WebElement logoutBtn;

    @FindBy(tagName = "h1")
    public WebElement myAccountH1;

    @FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=identity']")
    public WebElement myPersonalInformationBtn;


    //WebElement searchBar = driver.findElement(By.id("search_query_top"));
    @FindBy(id = "search_query_top")
    public WebElement searchBar;

    //  WebElement searchButton = driver.findElement(By.cssSelector("button[name='submit_search']"));
    @FindBy(css = "button[name='submit_search']")
    public WebElement searchButton;


    // List<WebElement> allTheProducts = driver.findElements(By.cssSelector("li.ajax_block_product"));
    @FindBy(css = "li.ajax_block_product" )
    public List<WebElement> allTheProducts;

    //driver.findElement(By.cssSelector("button[name='Submit']")).click();
    @FindBy(css ="button[name='Submit']")
    public WebElement submitName;

    // driver.findElement(By.cssSelector("a[title='Proceed to checkout']")).click();
    @FindBy(css = "a[title='Proceed to checkout']" )
    public WebElement aTitle ;


    //driver.findElement(By.cssSelector("p a[title='Proceed to checkout']")).click();
    @FindBy(css = "p a[title='Proceed to checkout']"  )
    public WebElement paTitle;

    //driver.findElement(By.cssSelector("button[name='processAddress']")).click();
    @FindBy(css = "button[name='processAddress']" )
    public WebElement ButtonProcessAdress ;

    //driver.findElement(By.id("cgv")).click();
    @FindBy(id = "cgv")
    public WebElement cgv;


    //driver.findElement(By.cssSelector("button[name='processCarrier']")).click();
    @FindBy(css ="button[name='processCarrier']")
    public WebElement processCarrier;

    // driver.findElement(By.className("bankwire")).click();
    @FindBy( className ="bankwire" )
    public WebElement bankwire;

    // driver.findElement(By.className("page-subheading")
    @FindBy( className = "page-subheading" )
    public WebElement subheading;


    //driver.findElement(By.cssSelector("#cart_navigation button"))
    @FindBy( css = "#cart_navigation button" )
    public WebElement navigation ;


    // WebElement buyDetailsBox = driver.findElement(By.className("box"));
    @FindBy( className = "box"  )
    public WebElement buyDetailsBox ;


    // metodo constructor
    public MyAccountPage(WebDriver remoteDriver){
        this.driver = remoteDriver;
        PageFactory.initElements(driver, this);
    }

    // metodo de cerrar sesion
    public AuthenticationPage clickLogoutBtn(){
        //log out....
        logoutBtn.click();
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        return authenticationPage;
    }

// metodo de texto de cuenta
    public String getMyAccountH1Text(){
        return myAccountH1.getText();
    }

// metodo que lleva a la pagina mi informacion personal
    public MyPersonalInformationPage clickOnMyPersonalInformationBtn(){
        myPersonalInformationBtn.click();

        MyPersonalInformationPage myPersonalInformationPage = new MyPersonalInformationPage(driver);
        return myPersonalInformationPage;
    }

    // metodo que lleva a buscar vestido
    public void buscarVestido(){
        searchBar.sendKeys("printed dress");
        searchButton.click();
    }

   public void  comprarVestido(){}
    WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(10));

    // waiting for the Search page
    wait.until(ExpectedConditions.titleContains("Search"));


    //accesing and storing the link of the desired result, in this case the 0 corresponding to the Printed Summer Dress
    String productLink = allTheProducts.get(0).findElement(By.cssSelector("div.product-container a.product_img_link")).getAttribute("href");

    //going to the product page
    driver.get(productLink);

    //waiting for the add to cart button to be clickable
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[name='Submit']")));
    submitName.click();

    //waiting for the modal to open and then clicking on Proceed to checkout
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));
    aTitle.click();

    //waiting to land the checkout page and checking if the cart has products because the div#order-detail-content only appears when products are in the cart
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order-detail-content")));
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p a[title='Proceed to checkout']")));

    //going to the address section
   paTitle.click();

    //waiting for the address box to be displayed
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address_delivery")));
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[name='processAddress']")));

    //going to the shipping section and agreeing to the terms
     ButtonProcessAdress.click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("order_carrier_content")));
     cgv.click();


    //going to the payment section
   processCarrier.click();

    //checking if the payment methods are present, this is easy, just check if the div container is being displayed
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("HOOK_PAYMENT")));

    //selecting the bankwire option
    wait.until(ExpectedConditions.elementToBeClickable(By.className("bankwire")));
   bankwire.click();

    //checking if we selected the payment method correctly
    //  System.out.println(driver.findElement(By.className("page-subheading")).getText());
      System.out.println(subheading.getText());
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("page-subheading"), "BANK-WIRE PAYMENT."));

//confirming order by clicking on the Confirm Order button
    // driver.findElement(By.cssSelector("#cart_navigation button")).click();
    navigation.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cheque-indent")));

    //assertions
    Assert.assertTrue(buyDetailsBox.getText().contains("Your order on My Store is complete"));
    Assert.assertTrue(buyDetailsBox.getText().contains("$30.98"));
    Assert.assertTrue(buyDetailsBox.getText().contains("Name of account owner Pradeep Macharla"));
    Assert.assertTrue(buyDetailsBox.getText().contains("Include these details xyz"));
    Assert.assertTrue(buyDetailsBox.getText().contains("Bank name RTP"));
    Assert.assertTrue(buyDetailsBox.getText().contains("Your order will be sent as soon as we receive payment"));
 
}
