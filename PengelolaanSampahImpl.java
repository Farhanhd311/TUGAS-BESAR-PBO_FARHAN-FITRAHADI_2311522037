import java.sql.*;
import java.util.Scanner;

public class PengelolaanSampahImpl implements PengelolaanSampah {
    private Connection conn = DatabaseConnection.getConnection();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void createPelanggan() {
        try {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan Alamat: ");
            String alamat = scanner.nextLine();
            System.out.print("Masukkan Volume Sampah (kg): ");
            double volume = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            System.out.print("Masukkan Tanggal Layanan (yyyy-mm-dd): ");
            String tanggal = scanner.nextLine();

            String query = "INSERT INTO pelanggan (nama, alamat, volume_sampah, tanggal_layanan) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nama);
            pstmt.setString(2, alamat);
            pstmt.setDouble(3, volume);
            pstmt.setDate(4, Date.valueOf(tanggal));
            pstmt.executeUpdate();
            System.out.println("Data pelanggan berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    @Override
    public void readPelanggan() {
        try {
            String query = "SELECT * FROM pelanggan";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\n=== Data Pelanggan ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nama: " + rs.getString("nama"));
                System.out.println("Alamat: " + rs.getString("alamat"));
                System.out.println("Volume Sampah: " + rs.getDouble("volume_sampah") + " kg");
                System.out.println("Tanggal Layanan: " + rs.getDate("tanggal_layanan"));
                System.out.println("--------------------------");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    @Override
    public void updatePelanggan() {
        try {
            System.out.print("Masukkan ID Pelanggan yang ingin diubah: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Masukkan Nama Baru: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan Alamat Baru: ");
            String alamat = scanner.nextLine();
            System.out.print("Masukkan Volume Sampah Baru (kg): ");
            double volume = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            System.out.print("Masukkan Tanggal Layanan Baru (yyyy-mm-dd): ");
            String tanggal = scanner.nextLine();

            String query = "UPDATE pelanggan SET nama = ?, alamat = ?, volume_sampah = ?, tanggal_layanan = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nama);
            pstmt.setString(2, alamat);
            pstmt.setDouble(3, volume);
            pstmt.setDate(4, Date.valueOf(tanggal));
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            System.out.println("Data pelanggan berhasil diubah!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    @Override
    public void deletePelanggan() {
        try {
            System.out.print("Masukkan ID Pelanggan yang ingin dihapus: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String query = "DELETE FROM pelanggan WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Data pelanggan berhasil dihapus!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
