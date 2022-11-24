/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
import Utilities.DBConnection;
import ViewModels.NhanVienViewModel;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HieuTran
 */
public class NhanVienRepositories {

    public List<NhanVienViewModel> getAll() {
        String query = "SELECT dbo.NhanVien.Id, dbo.NhanVien.Ma, dbo.NhanVien.Ten, dbo.NhanVien.TenDem, dbo.NhanVien.Ho, dbo.NhanVien.GioiTinh, dbo.NhanVien.NgaySinh, dbo.NhanVien.DiaChi, dbo.NhanVien.Sdt, dbo.NhanVien.MatKhau, \n"
                + "                      dbo.CuaHang.Ten AS Expr2, dbo.ChucVu.Ten AS Expr1, dbo.NhanVien.IdGuiBC, dbo.NhanVien.TrangThai\n"
                + "FROM         dbo.NhanVien INNER JOIN dbo.ChucVu ON dbo.NhanVien.IdCV = dbo.ChucVu.Id \n"
                + "						  INNER JOIN dbo.CuaHang ON dbo.NhanVien.IdCH = dbo.CuaHang.Id";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<NhanVienViewModel> listNhanVienViewModels = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienViewModel nhanVienViewModel = new NhanVienViewModel();
                nhanVienViewModel.setIdNV(rs.getString(1));
                nhanVienViewModel.setMaNV(rs.getString(2));
                nhanVienViewModel.setTenNV(rs.getString(3));
                nhanVienViewModel.setTenDem(rs.getString(4));
                nhanVienViewModel.setHoNV(rs.getString(5));
                nhanVienViewModel.setGioiTinh(rs.getString(6));
                nhanVienViewModel.setDiaChi(rs.getString(8));
                nhanVienViewModel.setNgaySinh(rs.getString(7));
                nhanVienViewModel.setSdt(rs.getString(9));
                nhanVienViewModel.setMatKhau(rs.getString(10));
                nhanVienViewModel.setTenCuaHang(rs.getString(11));
                nhanVienViewModel.setTenChucVu(rs.getString(12));
                nhanVienViewModel.setIdGuiBC(rs.getString(13));
                nhanVienViewModel.setTrangThai(rs.getString(14));
                listNhanVienViewModels.add(nhanVienViewModel);
            }
            return listNhanVienViewModels;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public List<NhanVien> getFull() {
        String query = "SELECT dbo.NhanVien.Id, dbo.NhanVien.Ma, dbo.NhanVien.Ten, dbo.NhanVien.TenDem, dbo.NhanVien.Ho, dbo.NhanVien.GioiTinh, dbo.NhanVien.NgaySinh, dbo.NhanVien.DiaChi, dbo.NhanVien.Sdt, dbo.NhanVien.MatKhau, \n"
                + "                      dbo.CuaHang.Ten AS Expr2, dbo.ChucVu.Ten AS Expr1, dbo.NhanVien.IdGuiBC, dbo.NhanVien.TrangThai\n"
                + "FROM         dbo.NhanVien INNER JOIN dbo.ChucVu ON dbo.NhanVien.IdCV = dbo.ChucVu.Id \n"
                + "						  INNER JOIN dbo.CuaHang ON dbo.NhanVien.IdCH = dbo.CuaHang.Id";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<NhanVien> listNhanViens = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CuaHang cuaHang = new CuaHang(rs.getString(11));
                ChucVu chucVu = new ChucVu(rs.getString(12));
                NhanVien nhanVien = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), cuaHang, chucVu, rs.getString(13), rs.getInt(14));
                listNhanViens.add(nhanVien);
            }
            return listNhanViens;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public NhanVien getOne(String ma) {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[TenDem]\n"
                + "      ,[Ho]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Sdt]\n"
                + "      ,[MatKhau]\n"
                + "      ,[IdCH]\n"
                + "      ,[IdCV]\n"
                + "      ,[IdGuiBC]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien"
                + "  WHERE Ten = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CuaHang cuaHang = new CuaHang(rs.getString(11));
                ChucVu chucVu = new ChucVu(rs.getString(12));
                NhanVien nhanVien = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), cuaHang, chucVu, rs.getString(13), rs.getInt(14));
                return nhanVien;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public NhanVienViewModel getOneT(String tenNV) {
        String query = "SELECT dbo.NhanVien.Id, dbo.NhanVien.Ma, dbo.NhanVien.Ten, dbo.NhanVien.TenDem, dbo.NhanVien.Ho, dbo.NhanVien.GioiTinh, dbo.NhanVien.NgaySinh, \n"
                + "dbo.NhanVien.DiaChi, dbo.NhanVien.Sdt, dbo.NhanVien.MatKhau, \n"
                + "                      dbo.CuaHang.Ten AS Expr1, dbo.ChucVu.Ten AS Expr2, dbo.NhanVien.IdGuiBC, dbo.NhanVien.TrangThai\n"
                + "                FROM NhanVien INNER JOIN CuaHang on  NhanVien.IdCH = CuaHang.Id  INNER JOIN ChucVu on ChucVu.Id = NhanVien.IdCV\n"
                + "				WHERE NhanVien.Ten like ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, tenNV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
                return nv;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean Add(NhanVien nv) {
        int check = 0;
        String query = "INSERT INTO [dbo].[NhanVien]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[TenDem]\n"
                + "           ,[Ho]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[DiaChi]\n"
                + "           ,[Sdt]\n"
                + "           ,[MatKhau]\n"
                + "           ,[IdCH]\n"
                + "           ,[IdCV]\n"
                + "           ,[IdGuiBC]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getTenDem());
            ps.setObject(4, nv.getHo());
            ps.setObject(5, nv.getGioiTinh());
            ps.setObject(6, nv.getNgaySinh());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getsDT());
            ps.setObject(9, nv.getMatKhau());
            ps.setObject(10, nv.getCuaHang().getId());
            ps.setObject(11, nv.getChucVu().getId());
            ps.setObject(12, nv.getIdGuiBC());
            ps.setObject(13, nv.getTrangThai());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean Update(NhanVien nv, String ma) {
        int check = 0;
        String query = "UPDATE [dbo].[NhanVien]\n"
                + "   SET [Ma] = ?"
                + "      ,[Ten] = ?"
                + "      ,[TenDem] = ?"
                + "      ,[Ho] = ?"
                + "      ,[GioiTinh] = ?"
                + "      ,[NgaySinh] = ?"
                + "      ,[DiaChi] = ?"
                + "      ,[Sdt] = ?"
                + "      ,[MatKhau] = ?"
                + "      ,[IdCH] = ?"
                + "      ,[IdCV] = ?"
                + "      ,[IdGuiBC] = ?"
                + "      ,[TrangThai] = ?"
                + " WHERE Id = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getTenDem());
            ps.setObject(4, nv.getHo());
            ps.setObject(5, nv.getGioiTinh());
            ps.setObject(6, nv.getNgaySinh());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getsDT());
            ps.setObject(9, nv.getMatKhau());
            ps.setObject(10, nv.getCuaHang().getId());
            ps.setObject(11, nv.getChucVu().getId());
            ps.setObject(12, nv.getIdGuiBC());
            ps.setObject(13, nv.getTrangThai());
            ps.setObject(14, nv.getId());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[ChiTietSP]"
                + "      WHERE Id = ?";
        int check = 0;
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<NhanVienViewModel> listNhanVienViewModels = new NhanVienRepositories().getAll();
        for (NhanVienViewModel nhanVienViewModel : listNhanVienViewModels) {
            System.out.println(nhanVienViewModel.toString());
        }
    }
}
