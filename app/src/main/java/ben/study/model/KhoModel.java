package ben.study.model;

public class KhoModel {
    private String maHang;
    private String tenHang;
    private String theloaihang;
    private int soLuong;
    private String ngayNhap;
    private String ngayXuat;

    public KhoModel() {
    }

    public KhoModel(String maHang, String tenHang, String theloaihang, int soLuong, String ngayNhap, String ngayXuat) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.theloaihang = theloaihang;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        this.ngayXuat = ngayXuat;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getTheloaihang() {
        return theloaihang;
    }

    public void setTheloaihang(String maTheLoai) {
        this.theloaihang = theloaihang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }


}
