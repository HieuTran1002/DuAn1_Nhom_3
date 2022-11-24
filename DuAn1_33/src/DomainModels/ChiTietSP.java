/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author HieuTran
 */
public class ChiTietSP {

    private String id;
    private String idSP;
    private String idNSX;
    private String idMauSac;
    private String idDSP;
    private SanPham sanPham;
    private MauSac mauSac;
    private DongSP dongSP;
    private NSX nSX;
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private double giaNhap;
    private double giaBan;

    public ChiTietSP() {
    }

    public ChiTietSP(String id, SanPham sanPham, MauSac mauSac, DongSP dongSP, NSX nSX, int namBH, String moTa, int soLuongTon, double giaNhap, double giaBan) {
        this.id = id;
        this.sanPham = sanPham;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.nSX = nSX;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSP(SanPham sanPham, MauSac mauSac, DongSP dongSP, NSX nSX, int namBH, String moTa, int soLuongTon, double giaNhap, double giaBan) {
        this.sanPham = sanPham;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.nSX = nSX;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(String idNSX) {
        this.idNSX = idNSX;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdDSP() {
        return idDSP;
    }

    public void setIdDSP(String idDSP) {
        this.idDSP = idDSP;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public DongSP getDongSP() {
        return dongSP;
    }

    public void setDongSP(DongSP dongSP) {
        this.dongSP = dongSP;
    }

    public NSX getnSX() {
        return nSX;
    }

    public void setnSX(NSX nSX) {
        this.nSX = nSX;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "ChiTietSP{" + "id=" + id + ", idSP=" + idSP + ", idNSX=" + idNSX + ", idMauSac=" + idMauSac + ", idDSP=" + idDSP + ", sanPham=" + sanPham + ", mauSac=" + mauSac + ", dongSP=" + dongSP + ", nSX=" + nSX + ", namBH=" + namBH + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }

}
