public class Perpustakaan26 {
    
    Buku26[] daftarBuku = new Buku26[10];
    Mahasiswa26[] daftarMahasiswa = new Mahasiswa26[10];

    int jumlahBuku = 0;
    int jumlahMahasiswa = 0;

    public void tambahBuku26(String kode, String judul, String penulis){
        daftarBuku[jumlahBuku] = new Buku26(kode, judul, penulis);
        jumlahBuku++;
        System.out.println("Buku berhasil ditambahkan!");
    } 

    public void tambahMahasiswa26(String nim, String nama){
        daftarMahasiswa[jumlahMahasiswa] = new Mahasiswa26(nim, nama);
        jumlahMahasiswa++;
        System.out.println("Mahasiswa berhasil ditambahkan!");
    }

    public Buku26 cariBuku26(String kodeBuku) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].kodeBuku.equals(kodeBuku)) {
                return daftarBuku[i];
            }
        }
        return null;
    }

    public Mahasiswa26 cariMahasiswa26(String nim) {
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (daftarMahasiswa[i].nim.equals(nim)) {
                return daftarMahasiswa[i];
            }
        }
        return null;
    }

    public void pinjamBuku26(String nim, String kodeBuku) {

        Mahasiswa26 mhs = cariMahasiswa26(nim);
        Buku26 buku = cariBuku26(kodeBuku);

        if (mhs == null || buku == null) {
            System.out.println("Mahasiswa atau Buku tidak ditemukan.");
            return;
        }

        if (buku.statusDipinjam) {
            System.out.println("Gagal meminjam buku: " + buku.judul + " karena sudah dipinjam orang lain.");
            return;
        }

        if (mhs.pinjamBuku26(buku)) {
            buku.statusDipinjam = true;
            System.out.println(mhs.nama + " berhasil meminjam " + buku.judul);
        }
    }

    public void kembalikanBuku26(String nim, String kodeBuku) {

        Mahasiswa26 mhs = cariMahasiswa26(nim);

        if (mhs == null) {
            System.out.println("Mahasiswa tidak ditemukan.");
            return;
        }

        if (mhs.kembalikanBuku26(kodeBuku)) {
            System.out.println("Buku berhasil dikembalikan.");
        } else {
            System.out.println("Buku tidak ditemukan dalam daftar pinjaman.");
        }
    }

    public void tampilkanPeminjaman() {
        System.out.println("\nDaftar Peminjaman Buku:");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            daftarMahasiswa[i].tampilkanBuku();
        }
    }
}