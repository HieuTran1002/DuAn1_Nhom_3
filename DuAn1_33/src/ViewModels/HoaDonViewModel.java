/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author admin
 */
public class HoaDonViewModel {

    private String idHD;
    private String maHD;
    private String tenNV;
    private String tenKH;
    private String ngayTao;
    private String ngayThanhToan;
    private String ngayShip;
    private String ngayNhan;
    private int tinhTrang;
    private String tenNguoiNhan;
    private String diaChi;
    private Double donGia;
    private String sdt;
    private int soLuong;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String idHD, String maHD, String tenNV, String tenKH, String ngayTao, String ngayThanhToan, String ngayShip, String ngayNhan, int tinhTrang, String tenNguoiNhan, String diaChi, Double donGia, String sdt, int soLuong) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.donGia = donGia;
        this.sdt = sdt;
        this.soLuong = soLuong;
    }

    public HoaDonViewModel(String maHD, String tenNV, String tenKH, String ngayTao, String ngayThanhToan, String ngayShip, String ngayNhan, int tinhTrang, String tenNguoiNhan, String diaChi, Double donGia, String sdt, int soLuong) {
        this.maHD = maHD;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.donGia = donGia;
        this.sdt = sdt;
        this.soLuong = soLuong;
    }

    public HoaDonViewModel(String idHD) {
        this.idHD = idHD;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getNgayShip() {
        return ngayShip;
    }

    public void setNgayShip(String ngayShip) {
        this.ngayShip = ngayShip;
    }

    public String getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(String ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "HoaDonViewModel{" + "idHD=" + idHD + ", maHD=" + maHD + ", tenNV=" + tenNV + ", tenKH=" + tenKH + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", ngayShip=" + ngayShip + ", ngayNhan=" + ngayNhan + ", tinhTrang=" + tinhTrang + ", tenNguoiNhan=" + tenNguoiNhan + ", diaChi=" + diaChi + ", donGia=" + donGia + ", sdt=" + sdt + ", soLuong=" + soLuong + '}';
    }

}
