package IntermedioPractico6.testPractico6;

import IntermedioPractico6.utils.DataFactory;
import com.github.javafaker.Faker;
//import ecommerceSite.pageObject.MyAccountPage;
import IntermedioPractico6.pageObjectPractico6.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import IntermedioPractico6.utils.DataFactory;
import IntermedioPractico6.pageObjectPractico6.MyAccountPage;

// clase de herencia base test para la compra de vestido

public class BuyArticleTest  extends BaseTest{


    @Test
    public void buyingDressTest() throws InterruptedException {
        Faker fake = new Faker();
        String fakeFirstName = fake.name().firstName();
        String fakeLastName = fake.name().firstName();
        String myEmail = "emiliano" + Math.random() +"test"+ "@gmail.com";


        WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(10));

        //logging in to the site
        MyAccountPage myAccountPage = registerAnUser(myEmail, fakeFirstName, fakeLastName);

        // search product via the search bar
        WebElement searchBar = driver.findElement(By.id("search_query_top"));
        WebElement searchButton = driver.findElement(By.cssSelector("button[name='submit_search']"));

        searchBar.sendKeys("printed dress");
        searchButton.click();

       // waiting for the Search page
        wait.until(ExpectedConditions.titleContains("Search"));


        //this return a list of all the products that has been found
        List<WebElement> allTheProducts = driver.findElements(By.cssSelector("li.ajax_block_product"));

        //accesing and storing the link of the desired result, in this case the 0 corresponding to the Printed Summer Dress
       String productLink = allTheProducts.get(0).findElement(By.cssSelector("div.product-container a.product_img_link")).getAttribute("href");

        //going to the product page
        driver.get(productLink);

        //waiting for the add to cart button to be clickable
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[name='Submit']")));
        driver.findElement(By.cssSelector("button[name='Submit']")).click();


        //waiting for the modal to open and then clicking on Proceed to checkout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));
        driver.findElement(By.cssSelector("a[title='Proceed to checkout']")).click();


        //waiting to land the checkout page and checking if the cart has products because the div#order-detail-content only appears when products are in the cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order-detail-content")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p a[title='Proceed to checkout']")));

        //going to the address section
        driver.findElement(By.cssSelector("p a[title='Proceed to checkout']")).click();


        //waiting for the address box to be displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address_delivery")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[name='processAddress']")));

        //going to the shipping section and agreeing to the terms
        driver.findElement(By.cssSelector("button[name='processAddress']")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("order_carrier_content")));
        driver.findElement(By.id("cgv")).click();


        //going to the payment section
        driver.findElement(By.cssSelector("button[name='processCarrier']")).click();



        //checking if the payment methods are present, this is easy, just check if the div container is being displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("HOOK_PAYMENT")));

        //selecting the bankwire option
        wait.until(ExpectedConditions.elementToBeClickable(By.className("bankwire")));
        driver.findElement(By.className("bankwire")).click();

        //checking if we selected the payment method correctly
        System.out.println(driver.findElement(By.className("page-subheading")).getText());
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("page-subheading"), "BANK-WIRE PAYMENT."));

        //confirming order by clicking on the Confirm Order button
        driver.findElement(By.cssSelector("#cart_navigation button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cheque-indent")));
        WebElement buyDetailsBox = driver.findElement(By.className("box"));

        //assertions
        Assert.assertTrue(buyDetailsBox.getText().contains("Your order on My Store is complete"));
        Assert.assertTrue(buyDetailsBox.getText().contains("$30.98"));
        Assert.assertTrue(buyDetailsBox.getText().contains("Name of account owner Pradeep Macharla"));
        Assert.assertTrue(buyDetailsBox.getText().contains("Include these details xyz"));
        Assert.assertTrue(buyDetailsBox.getText().contains("Bank name RTP"));
        Assert.assertTrue(buyDetailsBox.getText().contains("Your order will be sent as soon as we receive payment"));

    }

}
