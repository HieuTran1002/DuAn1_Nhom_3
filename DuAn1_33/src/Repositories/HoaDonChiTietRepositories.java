/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDonChiTiet;
import DomainModels.NhanVien;
import Utilities.DBConnection;
import ViewModels.SanPhamUpdateViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HieuTran
 */
public class HoaDonChiTietRepositories {

    public List<SanPhamUpdateViewModel> getAll() {
        String query = "SELECT    dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDonChiTiet.DonGia\n" +
"                 FROM dbo.HoaDonChiTiet  JOIN dbo.SanPham on dbo.SanPham.Id = dbo.HoaDonChiTiet.IdHoaDon";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<SanPhamUpdateViewModel> listHDVM = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamUpdateViewModel chiTietHoaDonViewModel = new SanPhamUpdateViewModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
                listHDVM.add(chiTietHoaDonViewModel);
            }
            return listHDVM;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean insert(HoaDonChiTiet hoaDonChiTiet) {
        int check = 0;
        String query = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "           ([IdHoaDon]\n"
                + "           ,[IdChiTietSP]\n"
                + "           ,[SoLuong]\n"
                + "           ,[DonGia])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, hoaDonChiTiet.getHoaDon().getId());
            ps.setObject(2, hoaDonChiTiet.getChiTietSP().getId());
            ps.setObject(3, hoaDonChiTiet.getSoLuong());
            ps.setObject(4, hoaDonChiTiet.getDonGia());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(HoaDonChiTiet hoaDonChiTiet, String ma) {
        int check = 0;
        String query = "UPDATE [dbo].[HoaDonChiTiet]\n"
                + "   SET [IdHoaDon] = ?"
                + "      ,[IdChiTietSP] = ?"
                + "      ,[SoLuong] = ?"
                + "      ,[DonGia] = ?"
                + " WHERE Id = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, hoaDonChiTiet.getHoaDon().getId());
            ps.setObject(2, hoaDonChiTiet.getChiTietSP().getId());
            ps.setObject(3, hoaDonChiTiet.getSoLuong());
            ps.setObject(4, hoaDonChiTiet.getDonGia());
            ps.setObject(5, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        int check = 0;
        String query = "DELETE FROM [dbo].[HoaDonChiTiet]\n"
                + "      WHERE Id = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(5, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
