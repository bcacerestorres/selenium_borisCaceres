package Practico14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementHelper {
    private WebDriver driver;

    public WebElementHelper(WebDriver adriver){
        driver=adriver;
    }

    public WebElement Byid(String aId){
        return driver.findElement(By.id(aId));
    }

    public WebElement Byname(String aname){
        return driver.findElement(By.name(aname));
    }

    public void write(String aId,String Text){
        driver.findElement(By.id(aId)).sendKeys(Text);
    }

    public String getTextagname(String atagname){
        return driver.findElement(By.tagName(atagname)).getText();
    }

    public void setXpath(String tagname ,String attr ,String attr_value ,String Text){
    String xpathepresion ="//" + tagname + "[@" + attr + "= '" +attr_value + "']";
   driver.findElement(By.xpath(xpathepresion)).sendKeys(Text);
    }

}
