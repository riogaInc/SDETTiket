package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyOrder extends InitPage {

    WebDriverWait wait;
    JavascriptExecutor executor;
    WebDriver driver;

    public MyOrder(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,15);
        executor = (JavascriptExecutor) driver;
        this.driver = driver;
    }

    @FindBy(xpath = "//button[.='OK']")
    private WebElement okBtn;

    @FindBy(xpath = "//span[@class='account-label']")
    private WebElement akunLabel;

    @FindBy(xpath ="//div[@class='account-item-container']/span[.='Keluar']")
    private WebElement akunKeluar;

    @FindBy(xpath = "//div[@class='logout-button']/div[.='YA']")
    private WebElement yaBtnKeluar;


    public void logoutProcess(){
        try{
            okBtn.click();
        }catch(NoSuchElementException e){

        }

        akunLabel.click();
        akunKeluar.click();
        yaBtnKeluar.click();
    }

}
