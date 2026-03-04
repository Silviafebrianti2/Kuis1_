import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Perpustakaan26 perpus = new Perpustakaan26();

        int pilih;

        do {
            System.out.println("\nMenu Perpustakaan:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tambah Mahasiswa");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Tampilkan Peminjaman");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan kode buku: ");
                    String kode = sc.nextLine();
                    System.out.print("Masukkan judul buku: ");
                    String judul = sc.nextLine();
                    System.out.print("Masukkan penulis: ");
                    String penulis = sc.nextLine();
                    perpus.tambahBuku26(kode, judul, penulis);
                    break;

                case 2:
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nim = sc.nextLine();
                    System.out.print("Masukkan nama mahasiswa: ");
                    String nama = sc.nextLine();
                    perpus.tambahMahasiswa26(nim, nama);
                    break;

                case 3:
                    System.out.print("Masukkan NIM mahasiswa: ");
                    nim = sc.nextLine();
                    System.out.print("Masukkan kode buku: ");
                    kode = sc.nextLine();
                    perpus.pinjamBuku26(nim, kode);
                    break;

                case 4:
                    System.out.print("Masukkan NIM mahasiswa: ");
                    nim = sc.nextLine();
                    System.out.print("Masukkan kode buku: ");
                    kode = sc.nextLine();
                    perpus.kembalikanBuku26(nim, kode);
                    break;

                case 5:
                    perpus.tampilkanPeminjaman();
                    break;

                case 6:
                    System.out.println("Terima kasih telah menggunakan sistem perpustakaan.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }

        } while (pilih != 6);

        sc.close();
    }
}