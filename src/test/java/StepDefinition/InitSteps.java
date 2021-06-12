package StepDefinition;

import Page.*;
import org.openqa.selenium.WebDriver;

public class InitSteps {

    static WebDriver driver = new InitPage().createDriver();

    MainPage mainPage = new MainPage(driver);
    PenerbanganPergi penerbanganPergi = new PenerbanganPergi(driver);
    PenerbanganPulang penerbanganPulang = new PenerbanganPulang(driver);
    DetailPemesanan detailPemesanan = new DetailPemesanan(driver);
    Payment payment = new Payment(driver);
    MyOrder myOrder = new MyOrder(driver);

    KeretaApi keretaApi = new KeretaApi(driver);
    KeretaPergi keretaPergi = new KeretaPergi(driver);

}
