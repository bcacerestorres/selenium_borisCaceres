package IntermedioPractico6.testPractico6;

import com.github.javafaker.Faker;
//import ecommerceSite.pageObject.*;
import IntermedioPractico6.pageObjectPractico6.MyAccountPage;
import IntermedioPractico6.pageObjectPractico6.AuthenticationPage;
//import ecommerceSite.utils.Constants;
import IntermedioPractico6.utils.Constants;
//import ecommerceSite.utils.DataFactory;
import IntermedioPractico6.utils.DataFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

// clase de herencia de base test  para el login
public class LoginTest extends BaseTest {


    @Test
    public void loginTest() throws InterruptedException {
        String fakeFirstName = DataFactory.getFakeFirstName();
        String fakeLastName = DataFactory.getFakeLastName();
        String randomEmail = DataFactory.randomEmail;

        MyAccountPage myAccountPage = registerAnUser(randomEmail, fakeFirstName, fakeLastName);

        Thread.sleep(2000);

        AuthenticationPage authenticationPage = myAccountPage.clickLogoutBtn();

        myAccountPage = authenticationPage.successfullLogin(randomEmail);
        Assert.assertEquals(Constants.MY_ACCOUNT_TITLE_PAGE, myAccountPage.getMyAccountH1Text());
    }

    @Test
    public void checkUsernameIsUnique() throws InterruptedException {

        String fakeFirstName = DataFactory.getFakeFirstName();
        String fakeLastName = DataFactory.getFakeLastName();
        String randomEmail = DataFactory.randomEmail;

        MyAccountPage myAccountPage = registerAnUser(randomEmail, fakeFirstName, fakeLastName);

        AuthenticationPage authenticationPage = myAccountPage.clickLogoutBtn();
        authenticationPage.fillEmailField(randomEmail);
        authenticationPage.clickOnCreateAccountBtn();

        Assert.assertEquals(authenticationPage.getDuplicateEmailErrorMsg(),
                Constants.ALREADY_REGISTERED_EMAIL_ERROR_MSG);
    }

}
