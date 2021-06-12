package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeretaApi extends InitPage {

    WebDriverWait wait;
    JavascriptExecutor executor;
    WebDriver driver;

    public KeretaApi(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,15);
        executor = (JavascriptExecutor) driver;
        this.driver = driver;
    }

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement okNotif;

    @FindBy(xpath = "//div[@class='part-component part-depart']//input[@class='input-airport ']")
    private WebElement asalSt;

    @FindBy(xpath = "//div[@class='part-component part-return']//input[@class='input-airport ']")
    private WebElement tujuanSt;

    private String kalenderPergi = "//*[@id='formhome']/div/div/div[1]/div[3]/div[4]/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div[2]/div/table/tbody";

    @FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[3]/div[6]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]")
    private WebElement totalPenDewasa;

    @FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[3]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]")
    private WebElement totalPenAnak;

    @FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[3]/div[6]/div[2]/div/div/div[2]/div[1]/div[2]/div[3]/button")
    private WebElement addPassDewasa;

    @FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[3]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button")
    private WebElement addPassAnak;

    @FindBy(xpath = "//button[text()='Selesai']")
    private WebElement selesaiButton;

    @FindBy(xpath = "//button[.='Cari Kereta Api']")
    private WebElement cariKA;

    public void closeOkNotif(){
        try{
            okNotif.click();
        }
        catch (NoSuchElementException e){
        }
    }

    public void setStBerangkat(String kota, String stasiun) throws InterruptedException {  //YogyakartaBrambanan
        Thread.sleep(3000);
        executor.executeScript("arguments[0].scrollIntoView(true);",asalSt);
        asalSt.sendKeys(kota);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[.='"+stasiun+"']/..")).click();
    }

    public void setStasiunTujuan(String kota, String stasiun) throws InterruptedException { //JakartaSemua Stasiun
        tujuanSt.sendKeys(kota);
//        driver.findElement(By.xpath("//div[.='"+stasiun+"']/..")).click();
        Thread.sleep(2000);
        executor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[.='"+stasiun+"']/..")));
    }

    public void pilihTglBerangkat(String tgl){
        driver.findElement(By.xpath(kalenderPergi+"//div[.='"+tgl+"']")).click();
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

    public void klikSelesaiButton(){
        executor.executeScript("arguments[0].scrollIntoView(true);",selesaiButton);
        selesaiButton.click();
    }

    public void klikCariKABtn(){
        executor.executeScript("arguments[0].scrollIntoView(true);",cariKA);
        cariKA.click();
    }

}
