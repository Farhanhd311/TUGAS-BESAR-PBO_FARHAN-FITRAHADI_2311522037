public class PelangganDetail extends Pelanggan {
    private double volumeSampah;
    private String tanggalLayanan;

    public PelangganDetail(String nama, String alamat, double volumeSampah, String tanggalLayanan) {
        super(nama, alamat);
        this.volumeSampah = volumeSampah;
        this.tanggalLayanan = tanggalLayanan;
    }

    public double getVolumeSampah() {
        return volumeSampah;
    }

    public String getTanggalLayanan() {
        return tanggalLayanan;
    }
}
