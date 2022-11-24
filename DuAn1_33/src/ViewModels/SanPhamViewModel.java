/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;

/**
 *
 * @author HieuTran
 */
public class SanPhamViewModel {

    public static int getDonGia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String idSanPham;
    private String maSanPham;
    private String tenSanPham;
    private int namBH;
    private int soLuong;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private String tenDongSanPham;
    private String tenNhaSanXuat;
    private String tenMauSac;
    private String moTa;

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(String idSanPham, String maSanPham, String tenSanPham, int namBH, int soLuong, BigDecimal giaNhap, BigDecimal giaBan, String tenDongSanPham, String tenNhaSanXuat, String tenMauSac, String moTa) {
        this.idSanPham = idSanPham;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.namBH = namBH;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.tenDongSanPham = tenDongSanPham;
        this.tenNhaSanXuat = tenNhaSanXuat;
        this.tenMauSac = tenMauSac;
        this.moTa = moTa;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public String getTenDongSanPham() {
        return tenDongSanPham;
    }

    public void setTenDongSanPham(String tenDongSanPham) {
        this.tenDongSanPham = tenDongSanPham;
    }

    public String getTenNhaSanXuat() {
        return tenNhaSanXuat;
    }

    public void setTenNhaSanXuat(String tenNhaSanXuat) {
        this.tenNhaSanXuat = tenNhaSanXuat;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "SanPhamViewModel{" + "idSanPham=" + idSanPham + ", maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", namBH=" + namBH + ", soLuong=" + soLuong + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", tenDongSanPham=" + tenDongSanPham + ", tenNhaSanXuat=" + tenNhaSanXuat + ", tenMauSac=" + tenMauSac + ", moTa=" + moTa + '}';
    }

}
