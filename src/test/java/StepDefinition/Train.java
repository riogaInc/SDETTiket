package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Train extends InitSteps{

    @When("user klik Kereta Api icon di main page")
    public void user_klik_kereta_api_icon_di_main_page() {
        mainPage.klikKaiBtn();
        keretaApi.closeOkNotif();
    }

    @When("user memilih keberangkatan dari kota {string} Stasiun {string}")
    public void user_memilih_keberangkatan_dari_kota_stasiun(String kota, String st) throws InterruptedException {
        keretaApi.setStBerangkat(kota,st);
    }

    @When("user memilih tujuan ke kota {string} Stasiun {string}")
    public void user_memilih_tujuan_ke_kota_stasiun(String kota, String st) throws InterruptedException {
        keretaApi.setStasiunTujuan(kota,st);
    }

    @When("user memilih keberangkatan tanggal {string}")
    public void user_memilih_keberangkatan_tanggal(String string) {
        keretaApi.pilihTglBerangkat(string);
    }

    @When("user mengisi jumlah penumpang dewasa {string} orang")
    public void user_mengisi_jumlah_penumpang_dewasa_orang(String string) throws InterruptedException {
        keretaApi.setPenumpangDewasa(Integer.parseInt(string));
    }
    @When("user mengisi jumalh penumpang anak {string} orang")
    public void user_mengisi_jumalh_penumpang_anak_orang(String string) {
        keretaApi.setPenumpangAnak(Integer.parseInt(string));
    }

    @When("user mengklik tombol SELESAI pada halaman Kereta Api")
    public void user_mengklik_tombol_selesai_pada_halaman_kereta_api() {
        keretaApi.klikSelesaiButton();
    }

    @When("user mengklik tombol CARI KERETA API")
    public void user_mengklik_tombol_cari_kereta_api() {
        keretaApi.klikCariKABtn();
    }

    @Given("user mengmilih list kereta yang ke {string}")
    public void user_mengmilih_list_kereta_yang_ke(String string) {
        keretaPergi.pilihKeretaPergi(string);
    }

    @Given("user melengkapi no identitas {string}")
    public void user_melengkapi_no_identitas(String id) {
        detailPemesanan.isiNomorIdentitas(id);
    }

    @Given("user mengklik pilih kursi kreta")
    public void user_mengklik_pilih_kursi_kreta() {
        detailPemesanan.klikPilihKursi();
    }




}
