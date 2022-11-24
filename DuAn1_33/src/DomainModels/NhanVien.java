/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author HieuTran
 */
public class NhanVien {

    private String id;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String sDT;
    private String matKhau;
    private CuaHang cuaHang;
    private ChucVu chucVu;
    private String idGuiBC;
    private int trangThai;

    public NhanVien() {
    }

    public NhanVien(String id) {
        this.id = id;
    }

    public NhanVien(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public NhanVien(String ma, String ten, String tenDem, String ho, String gioiTinh, String ngaySinh, String diaChi, String sDT, String matKhau, CuaHang cuaHang, ChucVu chucVu, String idGuiBC, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sDT = sDT;
        this.matKhau = matKhau;
        this.cuaHang = cuaHang;
        this.chucVu = chucVu;
        this.idGuiBC = idGuiBC;
        this.trangThai = trangThai;
    }

    public NhanVien(String id, String ma, String ten, String tenDem, String ho, String gioiTinh, String ngaySinh, String diaChi, String sDT, String matKhau, CuaHang cuaHang, ChucVu chucVu, String idGuiBC, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sDT = sDT;
        this.matKhau = matKhau;
        this.cuaHang = cuaHang;
        this.chucVu = chucVu;
        this.idGuiBC = idGuiBC;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public CuaHang getCuaHang() {
        return cuaHang;
    }

    public void setCuaHang(CuaHang cuaHang) {
        this.cuaHang = cuaHang;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public String getIdGuiBC() {
        return idGuiBC;
    }

    public void setIdGuiBC(String idGuiBC) {
        this.idGuiBC = idGuiBC;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    private Object STT() {
        int STT = 1;
        return STT;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", tenDem=" + tenDem + ", ho=" + ho + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", sDT=" + sDT + ", matKhau=" + matKhau + ", cuaHang=" + cuaHang + ", chucVu=" + chucVu + ", idGuiBC=" + idGuiBC + ", trangThai=" + trangThai + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{STT(), ma, ten, gioiTinh, cuaHang.getTen(), chucVu.getTen(), trangThai == 1 ? "Đã Thanh Toán" : "Chưa Thanh Toán"};
    }
}
