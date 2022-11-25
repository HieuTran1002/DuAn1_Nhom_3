/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author admin
 */
public class TaiKhoan {

    private String idTK;
    private String maTK;
    private String tenTK;
    private String passTK;
    private String ngayTao;
    private String vaiTro;

    public TaiKhoan() {
    }

    public TaiKhoan(String idTK, String maTK, String tenTK, String passTK, String ngayTao, String vaiTro) {
        this.idTK = idTK;
        this.maTK = maTK;
        this.tenTK = tenTK;
        this.passTK = passTK;
        this.ngayTao = ngayTao;
        this.vaiTro = vaiTro;
    }

    public TaiKhoan(String maTK, String tenTK, String passTK, String ngayTao, String vaiTro) {
        this.maTK = maTK;
        this.tenTK = tenTK;
        this.passTK = passTK;
        this.ngayTao = ngayTao;
        this.vaiTro = vaiTro;
    }

    public TaiKhoan(String maTK, String tenTK) {
        this.maTK = maTK;
        this.tenTK = tenTK;
    }

    public String getIdTK() {
        return idTK;
    }

    public void setIdTK(String idTK) {
        this.idTK = idTK;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getPassTK() {
        return passTK;
    }

    public void setPassTK(String passTK) {
        this.passTK = passTK;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public Object[] toDataRow() {
        return new Object[]{idTK, maTK, tenTK, passTK, ngayTao, vaiTro};
    }

}
