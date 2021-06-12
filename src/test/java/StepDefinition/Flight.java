package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Flight extends InitSteps {

    @Given("user membuka website {string}")
    public void user_membuka_website(String webUrl) {
        driver.get(webUrl);
    }

    @When("user klik Pesawat icon di main page")
    public void user_klik_pesawat_icon_di_main_page() {
        mainPage.klikPesawatBtn();
    }

    @When("user memilih Pulang Pergi pada pilihan rute terbang")
    public void user_memilih_pulang_pergi_pada_pilihan_rute_terbang() {
        mainPage.klikPulangPergiRadio();
    }

    @When("user memilih penerbangan asal {string} bandara {string}")
    public void user_memilih_penerbangan_asal(String asal, String bandara) {
        mainPage.isiAsalTextBox(asal);
        mainPage.klikBandara(bandara);
    }

    @When("user memilih penerbangan tujuan {string} bandara {string}")
    public void user_memilih_penerbangan_tujuan(String tujuan, String bandara) {
        mainPage.isiTujuanTextBox(tujuan);
        mainPage.klikBandara(bandara);
    }

    @When("user memilih tanggal keberangkatan penerbangan tanggal {string}")
    public void user_memilih_tanggal_keberangkatan_penerbangan_tanggal(String tgl) {
        mainPage.klikTanggalBerangkat(tgl);
    }

    @When("user memilih tanggal pulang penerbangan tanggal {string}")
    public void user_memilih_tanggal_pulang_penerbangan_tanggal(String tgl) {
        mainPage.klikTanggalPulang(tgl);
    }

    @When("user memilih jumlah penumpang dewasa {string}")
    public void user_memilih_jumlah_penumpang_dewasa(String pen) throws InterruptedException {
        mainPage.setPenumpangDewasa(Integer.parseInt(pen));
    }

    @When("user memilih jumlah penumpang anak anak {string}")
    public void user_memilih_jumlah_penumpang_anak_anak(String pen) {
        mainPage.setPenumpangAnak(Integer.parseInt(pen));
    }

    @When("user memilih jumlah penumpang bayi {string}")
    public void user_memilih_jumlah_penumpang_bayi(String pen) {
        mainPage.setPenumpangBayi(Integer.parseInt(pen));
    }

    @When("user memilih kelas penerbangan {string}")
    public void user_memilih_kelas_penerbangan(String kelas) {
        mainPage.pilihKelas(kelas);
    }

    @When("user klik tombol Selesai")
    public void user_klik_tombol_selesai() {
        mainPage.klikSelesaiButton();
    }

    @When("user klik tombol CARI PENERBANGAN")
    public void user_klik_tombol_cari_penerbangan() {
        mainPage.klikCariPenerbangan();
    }

    @Given("user memilih transit {string} untuk penerbangan pergi")
    public void user_memilih_transit_untuk_penerbangan_pergi(String string) {
        penerbanganPergi.pilihJumlahTransit(Integer.parseInt(string));
    }
    @Given("user mimilih pilihan penerbangan pergi ke {string}")
    public void user_mimilih_pilihan_penerbangan_pergi_ke(String string) {
        penerbanganPergi.pilihListPenerbangan(string);
    }
    @Given("user memilih transit {string} untuk penerbangan pulang")
    public void user_memilih_transit_untuk_penerbangan_pulang(String string) {
        penerbanganPulang.pilihJumlahTransit(Integer.parseInt(string));
    }
    @Given("user mimilih pilihan penerbangan pulang ke {string}")
    public void user_mimilih_pilihan_penerbangan_pulang_ke(String string) {
        penerbanganPulang.pilihListPenerbangan(string);
    }

    @Given("user klik login dari detail pemesanan")
    public void user_klik_login_dari_detail_pemesanan() {
        detailPemesanan.navigateLogIn();
    }
    @Given("user login username {string} dan password {string}")
    public void user_login_username_dan_password(String uname, String pass) throws InterruptedException {
        detailPemesanan.inputUsername(uname);
        detailPemesanan.klikLanjutkanBtn();
        detailPemesanan.inputPass(pass);
        detailPemesanan.klikLogInBtn();
        Thread.sleep(20000); //for handling OTP
    }

    @Given("user memilih detail penumpang pesawat sama dengan pemesan")
    public void user_memilih_detail_penumpang_pesawat_sama_dengan_pemesan() {
        detailPemesanan.klikSamaDgPemesanChk();
    }

    @Given("user klik tombol lanjut pembayaran di halaman detail pemesanan")
    public void user_klik_tombol_lanjut_pembayaran_di_halaman_detail_pemesanan() {
        detailPemesanan.klikLanjutPembayaran();
    }

    @Given("user membayar dengan BCA Virtual Account")
    public void user_membayar_dengan_bca_virtual_account() throws InterruptedException {
        payment.payBCAVA();
    }

    @Then("halaman VA BCA dan cara pembayaran tampil")
    public void halaman_va_bca_dan_cara_pembayaran_tampil() {
        payment.assertPembayaranVA("BCA Virtual Account");
    }

    @Then("user melakukan navigasi ke halaman daftar pesanan")
    public void user_melakukan_navigasi_ke_halaman_daftar_pesanan() {
        payment.klikLihatDaftarPesanan();
        payment.klikKeMyOrder();
    }

    @Then("user melakukan logout dari halaman daftar pesanan")
    public void user_melakukan_logout_dari_halaman_daftar_pesanan() {
        myOrder.logoutProcess();
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }



}
