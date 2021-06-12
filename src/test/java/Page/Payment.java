package Page;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payment extends InitPage {

    WebDriverWait wait;
    JavascriptExecutor executor;
    WebDriver driver;

    public Payment(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,15);
        executor = (JavascriptExecutor) driver;
        this.driver = driver;
    }

    @FindBy(xpath = "//span[.='BCA Virtual Account']")
    private WebElement bcaVAPay;

    @FindBy(xpath = "//button[.='Lanjutkan']")
    private WebElement lanjutkanPayBtn;

    @FindBy(xpath = "//button[.='Lihat Daftar Pesanan']")
    private WebElement lihatDaftarPesananBtn;

    @FindBy(xpath = "//button[.='Ke My Order']")
    private WebElement keMyOrder;

    @FindBy(xpath = "//h2[@class='page-title']")
    private WebElement pageTitle;


    public void payBCAVA() throws InterruptedException {
        executor.executeScript("arguments[0].scrollIntoView(true);",bcaVAPay);
        bcaVAPay.click();
        executor.executeScript("arguments[0].scrollIntoView(true);",lanjutkanPayBtn);
        Thread.sleep(2000);
        executor.executeScript("arguments[0].click();",lanjutkanPayBtn);
    }

    public void assertPembayaranVA(String pembayarn){
        Assert.assertEquals("BCA Virtual Account",pageTitle.getText());
    }

    public void klikLihatDaftarPesanan(){
        executor.executeScript("arguments[0].scrollIntoView(true);",lihatDaftarPesananBtn);
        lihatDaftarPesananBtn.click();
    }

    public void  klikKeMyOrder (){
        keMyOrder.click();
    }
}
