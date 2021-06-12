package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PenerbanganPergi extends InitPage {

    WebDriverWait wait;
    JavascriptExecutor executor;
    WebDriver driver;

    public PenerbanganPergi(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,15);
        executor = (JavascriptExecutor) driver;
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Mengerti']")
    private WebElement mengertiButn;

    @FindBy(xpath = "//label[.='Langsung']")
    private WebElement transitLangsung;

    @FindBy(xpath = "//label[.='1 Transit']")
    private WebElement transit1;

    @FindBy(xpath = "//label[.='2+ Transit']")
    private WebElement transit2Lebih;

    private String listPenerbangan = "//div[@class='section-box-content']";

    public void pilihJumlahTransit(int transit){
        try{
            mengertiButn.click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }

        if(transit == 0){
            transitLangsung.click();
        }else if(transit==1){
            transit1.click();
        }else{
            transit2Lebih.click();
        }
    }

    public void pilihListPenerbangan(String num){
        driver.findElement(By.xpath(listPenerbangan+"/div["+num+"]//div[@class='v3-btn v3-btn__yellow list-horizontal__middle']")).click();
    }
}
