package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeretaPergi extends InitPage {

    WebDriverWait wait;
    JavascriptExecutor executor;
    WebDriver driver;

    public KeretaPergi(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,15);
        executor = (JavascriptExecutor) driver;
        this.driver = driver;
    }

    private String listKereta = "//div[@class='col-result padding-content list-horizontal__top']/div[2]";

    public void pilihKeretaPergi(String num){
        driver.findElement(By.xpath(listKereta+"/div["+num+"]//button[@class='v3-btn v3-btn-yellow tiny-button']")).click();
    }

}
