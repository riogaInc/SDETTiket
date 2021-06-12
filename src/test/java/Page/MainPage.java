package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends InitPage{

    @FindBy(css="[alt='Pesawat']")
    private WebElement pesawatButton;

    @FindBy(css="[alt='Kereta Api']")
    private WebElement kaiButton;

    @FindBy(css="[for='roundTrip']")
    private WebElement pulangPergiRadio;

    @FindBy(id="productSearchFrom")
    private WebElement asalTextBox;

    @FindBy(id="productSearchTo")
    private WebElement tujuanTextBox;

    @FindBy(xpath="//div[@id='fromDropDownList']//div[.='Jakarta, IndonesiaHalim PerdanakusumaHLP']")
    private WebElement HLP;

    @FindBy(xpath="//div[text()='Juanda']/../..")
    private WebElement SUB;

    private String kalenderBerangkat = "//*[@id='startDate']/div[2]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div[2]/div/table/tbody";

    private String kalenderPulang = "//*[@id='endDate']/div[2]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div[2]/div/table/tbody";

    @FindBy(xpath = "//div[@class='passenger-cabin-drop-down-content-container']/div[@class='passenger-cabin-content-list']/div[1]//i[@class='tix tix-plus']")
    private WebElement addPassDewasa;

    @FindBy(xpath = "//div[@class='passenger-cabin-drop-down-content-container']/div[@class='passenger-cabin-content-list']/div[2]//i[@class='tix tix-plus']")
    private WebElement addPassAnak;

    @FindBy(xpath = "//div[@class='passenger-cabin-drop-down-content-container']/div[@class='passenger-cabin-content-list']/div[3]//i[@class='tix tix-plus']")
    private WebElement addPassBayi;

    @FindBy(xpath = "//div[@class='passenger-cabin-drop-down-content-container']//div[@class='passenger-cabin-content-list'][1]/div[@class='passenger-cabin-item-list'][1]/div[@class='widget-passenger-counter-container']/div[@class='widget-passenger-counter widget-passenger-counter-item']")
    private WebElement totalPenDewasa;

    @FindBy(xpath = "//div[@class='passenger-cabin-drop-down-content-container']//div[@class='passenger-cabin-content-list'][1]/div[@class='passenger-cabin-item-list'][2]/div[@class='widget-passenger-counter-container']/div[@class='widget-passenger-counter widget-passenger-counter-item']")
    private WebElement totalPenAnak;

    @FindBy(xpath = "//div[@class='passenger-cabin-drop-down-content-container']//div[@class='passenger-cabin-content-list'][1]/div[@class='passenger-cabin-item-list'][3]/div[@class='widget-passenger-counter-container']/div[@class='widget-passenger-counter widget-passenger-counter-item']")
    private WebElement totalPenBayi;

    private String kelas = "//div[@class='passenger-cabin-drop-down-content-container']//div[@class='passenger-cabin-content-list'][2]";

    @FindBy(xpath = "//span[text()='SELESAI']")
    private WebElement selesaiButton;

    @FindBy(xpath = "//button[@class='product-form-search-btn' and text()='CARI PENERBANGAN']")
    private WebElement cariPenerbanganButton;

    WebDriverWait wait;
    JavascriptExecutor executor;
    WebDriver driver;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,15);
        executor = (JavascriptExecutor) driver;
        this.driver = driver;
    }

    public void klikPesawatBtn(){
        pesawatButton.click();
    }

    public void klikKaiBtn(){
        kaiButton.click();
    }

    public void klikPulangPergiRadio(){
        pulangPergiRadio.click();
    }

    public void isiAsalTextBox(String asal){
        executor.executeScript("arguments[0].scrollIntoView();",asalTextBox);
        asalTextBox.sendKeys(asal);
    }

    public void klikBandara(String bandara){
        if(bandara.equals("Halim Perdanakusuma")){
            executor.executeScript("arguments[0].click();", HLP);
        }else if(bandara.equals("Juanda")){
            executor.executeScript("arguments[0].click();", SUB);
        }
    }

    public void isiTujuanTextBox(String tujuan){
        tujuanTextBox.sendKeys(tujuan);
    }

    public void klikTanggalBerangkat(String tgl){
        executor.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath(kalenderBerangkat)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(kalenderBerangkat+"//span[text()='"+tgl+"']")))).click();
    }

    public void klikTanggalPulang(String tgl){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(kalenderPulang+"//span[text()='"+tgl+"']")))).click();
    }

    public void setPenumpangDewasa(int penumpangDewasa) throws InterruptedException {
        Thread.sleep(2000);
        int totalPen = Integer.parseInt(totalPenDewasa.getText());
        System.out.println("totalPen"+totalPen);
        int count = penumpangDewasa - totalPen;
        int i = 0;
        while(i<count){
            addPassDewasa.click();
            i++;
        }

    }

    public void setPenumpangAnak(int penumpangAnak){
        int totalPen = Integer.parseInt(totalPenAnak.getText());
        int count = penumpangAnak - totalPen;
        int i = 0;
        while(i<count){
            addPassAnak.click();
            i++;
        }

    }

    public void setPenumpangBayi(int penumpangBayi){
        int totalPen = Integer.parseInt(totalPenBayi.getText());
        int count = penumpangBayi - totalPen;
        int i = 0;
        while(i<count){
            addPassBayi.click();
            i++;
        }

    }

    public void pilihKelas(String kelas){
        driver.findElement(By.xpath(this.kelas+"//div[@class='widget-passenger-cabin-type' and text()='"+kelas+"']")).click();
    }

    public void klikSelesaiButton(){
        executor.executeScript("arguments[0].scrollIntoView(true);",selesaiButton);
        selesaiButton.click();
    }

    public void klikCariPenerbangan(){
        cariPenerbanganButton.click();
    }



}
