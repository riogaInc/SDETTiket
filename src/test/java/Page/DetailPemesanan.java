package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailPemesanan extends InitPage {

    WebDriverWait wait;
    JavascriptExecutor executor;
    WebDriver driver;

    public DetailPemesanan(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,15);
        executor = (JavascriptExecutor) driver;
        this.driver = driver;
    }

    @FindBy(xpath = "//button[.='Log In']")
    private WebElement navigateLogIn;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(xpath = "//button[text()='Lanjutkan']")
    private WebElement lanjutkanBtn;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement logInBtn;

    @FindBy(css = ".switch")
    private WebElement samaDgPemesan;

    @FindBy(xpath="//div[text()='Kewarganegaraan']/../input[@class='input-flight-dropdown-searchbox']")
    private WebElement kewarganegaraan;

    @FindBy(xpath = "//button[.='LANJUTKAN KE PEMBAYARAN']")
    private WebElement lanjutPembayaranBtn;

    @FindBy(xpath = "//button[.='YA, LANJUTKAN']")
    private WebElement yaLnjutBtn;

    @FindBy(name = "identityNumber")
    private WebElement nomorIdentitas;

    @FindBy(xpath =  "//button[.='Pilih Kursi']")
    private WebElement pilihKursiBtn;

    public void navigateLogIn(){
        navigateLogIn.click();
    }

    public void inputUsername(String uname){
        username.sendKeys(uname);
    }

    public void klikLanjutkanBtn(){
        lanjutkanBtn.click();
    }

    public void inputPass(String pass){
        password.sendKeys(pass);
    }

    public void klikLogInBtn(){
        logInBtn.click();
    }

    public void klikSamaDgPemesanChk(){
        samaDgPemesan.click();
    }

    public void isiNomorIdentitas(String noID){
        executor.executeScript("arguments[0].scrollIntoView();",nomorIdentitas);
        nomorIdentitas.sendKeys(noID);
    }

    public void klikLanjutPembayaran(){
        //set kewarganaegaraan
        try {
            executor.executeScript("arguments[0].scrollIntoView();",kewarganegaraan);
            kewarganegaraan.click();
            driver.findElement(By.xpath("//div[.='Indonesia']/..")).click();
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }

        executor.executeScript("arguments[0].scrollIntoView();",lanjutPembayaranBtn);
        lanjutPembayaranBtn.click();
        yaLnjutBtn.click();
    }

    public void klikPilihKursi(){
        executor.executeScript("arguments[0].scrollIntoView();",pilihKursiBtn);
        pilihKursiBtn.click();
    }

}
