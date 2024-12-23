import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            // URL koneksi ke database MySQL
            String url = "jdbc:mysql://localhost:3306/sampah"; // 'sampah' adalah nama database
            String username = "root"; // username default MySQL di XAMPP
            String password = ""; // password kosong jika belum diatur di XAMPP

            // Membuat koneksi ke database
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi ke database berhasil!");
            return conn; // Mengembalikan objek Connection
        } catch (Exception e) {
            System.out.println("Koneksi ke database gagal: " + e.getMessage());
            return null; // Mengembalikan null jika terjadi kesalahan
        }
    }
}
