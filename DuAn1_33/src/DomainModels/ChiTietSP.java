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
    private SanPham sanPham;
    private NSX nSX;    
    private MauSac mauSac;
    private DongSP dongSP;
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private int giaNhap;
    private int giaBan;

    public ChiTietSP() {
    }

    public ChiTietSP(String id, SanPham sanPham, NSX nSX, MauSac mauSac, DongSP dongSP, int namBH, String moTa, int soLuongTon, int giaNhap, int giaBan) {
        this.id = id;
        this.sanPham = sanPham;
        this.nSX = nSX;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
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

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public NSX getnSX() {
        return nSX;
    }

    public void setnSX(NSX nSX) {
        this.nSX = nSX;
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

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public Object[] toDataRow() {
        return new Object[]{id, sanPham.getTen(), nSX.getTen(), mauSac.getTen(), dongSP.getTen(), namBH, moTa, soLuongTon, giaNhap, giaBan};
    }
}
