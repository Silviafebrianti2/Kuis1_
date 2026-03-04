public class Mahasiswa26 {
    String nim;
    String nama;
    Buku26[] bukuDipinjam;
    int jumlahPinjam;

    public Mahasiswa26(String nim, String nama){
        this.nim = nim;
        this.nama = nama;
        this.bukuDipinjam = new Buku26[2];
        this.jumlahPinjam = 0;
    }

    public boolean pinjamBuku26(Buku26 buku) {
        if (jumlahPinjam >= 2) {
            System.out.println("Gagal: " + nama + " sudah meminjam 2 buku ");
            return false;
        }

        bukuDipinjam[jumlahPinjam] = buku;
        jumlahPinjam++;
        return true;
    }
    
    public boolean kembalikanBuku26(String kodeBuku){
        for (int i = 0; i < jumlahPinjam; i++) {
            if (bukuDipinjam[i].kodeBuku.equals(kodeBuku)) {

                bukuDipinjam[i].statusDipinjam = false;

                for (int j = i; j < jumlahPinjam - 1; j++) {
                    bukuDipinjam[j] = bukuDipinjam[j + 1];
                }
                bukuDipinjam[jumlahPinjam - 1] = null;
                jumlahPinjam--;
                
                return true;
            }
        }
        return false;
    }

    public void tampilkanBuku() {
        if(jumlahPinjam == 0) {
            return;
        }

        System.out.print(nama + " meminjam: ");
        for (int i = 0; i < jumlahPinjam; i++) {
            System.out.print(bukuDipinjam[i].judul + " ");
        }
        System.out.println();
    }
}
