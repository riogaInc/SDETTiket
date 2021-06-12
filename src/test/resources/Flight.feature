Feature: Flight Product

Scenario: Create Plane Transaction with Virtual Account
  Given user membuka website "http://www.tiket.com"
  When user klik Pesawat icon di main page
  And user memilih Pulang Pergi pada pilihan rute terbang
  And user memilih penerbangan asal "jakarta" bandara "Halim Perdanakusuma"
  And user memilih penerbangan tujuan "surabaya" bandara "Juanda"
  And user memilih tanggal keberangkatan penerbangan tanggal "20"
  And user memilih tanggal pulang penerbangan tanggal "22"
  And user memilih jumlah penumpang dewasa "1"
  And user memilih jumlah penumpang anak anak "0"
  And user memilih jumlah penumpang bayi "0"
  And user memilih kelas penerbangan "Ekonomi"
  And user klik tombol Selesai
  And user klik tombol CARI PENERBANGAN
  And user memilih transit "1" untuk penerbangan pergi
  And user mimilih pilihan penerbangan pergi ke "1"
  And user memilih transit "1" untuk penerbangan pulang
  And user mimilih pilihan penerbangan pulang ke "1"
  And user klik login dari detail pemesanan
  And user login username "mail@gmail.com" dan password "xxxxxx"
  And user memilih detail penumpang pesawat sama dengan pemesan
  And user klik tombol lanjut pembayaran di halaman detail pemesanan
  And user membayar dengan BCA Virtual Account
  Then halaman VA BCA dan cara pembayaran tampil
  And user melakukan navigasi ke halaman daftar pesanan
  And user melakukan logout dari halaman daftar pesanan



