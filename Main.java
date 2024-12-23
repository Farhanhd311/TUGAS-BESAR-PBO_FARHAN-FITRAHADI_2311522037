import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PengelolaanSampah pengelolaan = new PengelolaanSampahImpl();
        int choice;

        do {
            System.out.println("\n=== Sistem Manajemen Pengelolaan Sampah ===");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Lihat Pelanggan");
            System.out.println("3. Ubah Data Pelanggan");
            System.out.println("4. Hapus Data Pelanggan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    pengelolaan.createPelanggan();
                    break;
                case 2:
                    pengelolaan.readPelanggan();
                    break;
                case 3:
                    pengelolaan.updatePelanggan();
                    break;
                case 4:
                    pengelolaan.deletePelanggan();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
