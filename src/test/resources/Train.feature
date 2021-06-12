Feature: Train

  @dev
Scenario: NonInstant Payment Train Transaction
    Given user membuka website "http://www.tiket.com"
    When user klik Kereta Api icon di main page
    And user memilih keberangkatan dari kota "Bandung" Stasiun "BandungCimahi"
    And user memilih tujuan ke kota "jakarta" Stasiun "JakartaGambir"
    And user memilih keberangkatan tanggal "21"
    And user mengisi jumlah penumpang dewasa "1" orang
    And user mengisi jumalh penumpang anak "0" orang
    And user mengklik tombol SELESAI pada halaman Kereta Api
    And user mengklik tombol CARI KERETA API
    And user mengmilih list kereta yang ke "1"
    And user klik login dari detail pemesanan
    And user login username "mail@gmail.com" dan password "xxxxxx"
    And user memilih detail penumpang pesawat sama dengan pemesan
    And user melengkapi no identitas "1234567890123456"
    And user mengklik pilih kursi kreta