/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Utilities.DBConnection;
import ViewModels.HoaDonViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dungp
 */
public class HoaDonRepositories {

    public List<HoaDon> getAll() {
        String query = "SELECT dbo.HoaDon.Id, dbo.KhachHang.Ma, dbo.KhachHang.Ten, dbo.NhanVien.Ma AS Expr1, dbo.NhanVien.Ten AS Expr2, dbo.HoaDon.Ma AS Expr3, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThanhToan, dbo.HoaDon.NgayShip,  "
                + "                  dbo.HoaDon.NgayNhan, dbo.HoaDon.TinhTrang, dbo.HoaDon.TenNguoiNhan, dbo.HoaDon.DiaChi, dbo.HoaDon.Sdt "
                + "FROM     dbo.HoaDon INNER JOIN "
                + "                  dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.Id INNER JOIN "
                + "                  dbo.NhanVien ON dbo.HoaDon.IdNV = dbo.NhanVien.Id ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDon> listHoaDon = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getString(2), rs.getString(3));
                NhanVien nhanVien = new NhanVien(rs.getString(4), rs.getString(5));
                listHoaDon.add(new HoaDon(rs.getString(1), khachHang, nhanVien, rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
            }
            return listHoaDon;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDonViewModel> getFull() {
        String query = "SELECT  dbo.HoaDon.Id, dbo.HoaDon.Ma, dbo.HoaDon.NgayTao, dbo.NhanVien.Ten, dbo.HoaDon.TinhTrang, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDonChiTiet.DonGia\n" +
"FROM         dbo.HoaDon INNER JOIN\n" +
"                      dbo.HoaDonChiTiet ON dbo.HoaDon.Id = dbo.HoaDonChiTiet.IdHoaDon INNER JOIN\n" +
"                      dbo.NhanVien ON dbo.HoaDon.IdNV = dbo.NhanVien.Id";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDonViewModel> listHoaDonViewModels = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModel hoaDonViewModel = new HoaDonViewModel();
                hoaDonViewModel.setIdHD(rs.getString(1));
                hoaDonViewModel.setMaHD(rs.getString(2));
                hoaDonViewModel.setNgayTao(rs.getString(3));
                hoaDonViewModel.setTenNV(rs.getString(4));
                hoaDonViewModel.setTinhTrang(rs.getInt(5));
                hoaDonViewModel.setSoLuong(rs.getInt(6));
                hoaDonViewModel.setDonGia(rs.getDouble(7));
                
                listHoaDonViewModels.add(hoaDonViewModel);
            }
            return listHoaDonViewModels;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
public List<HoaDonViewModel> getFulll() {
        String query = "SELECT    dbo.HoaDon.Id, dbo.KhachHang.Ten, dbo.NhanVien.Ten AS Expr1, dbo.HoaDon.Ma, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThanhToan, dbo.HoaDon.NgayShip, dbo.HoaDon.NgayNhan, dbo.HoaDon.TinhTrang, \n"
                + "                      dbo.HoaDon.TenNguoiNhan, dbo.HoaDon.DiaChi, dbo.HoaDon.Sdt, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDonChiTiet.DonGia\n"
                + "FROM         dbo.HoaDon INNER JOIN dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.Id \n"
                + "					INNER JOIN dbo.NhanVien ON dbo.HoaDon.IdNV = dbo.NhanVien.Id \n"
                + "					INNER JOIN dbo.HoaDonChiTiet ON dbo.HoaDonChiTiet.IdHoaDon = dbo.HoaDon.Id";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDonViewModel> listHoaDonViewModels = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModel hoaDonViewModel = new HoaDonViewModel();
                hoaDonViewModel.setIdHD(rs.getString(1));
                hoaDonViewModel.setMaHD(rs.getString(4));
                hoaDonViewModel.setTenKH(rs.getString(2));
                hoaDonViewModel.setTenNV(rs.getString(3));
                hoaDonViewModel.setNgayTao(rs.getString(5));
                hoaDonViewModel.setNgayThanhToan(rs.getString(6));
                hoaDonViewModel.setNgayShip(rs.getString(7));
                hoaDonViewModel.setNgayNhan(rs.getString(8));
                hoaDonViewModel.setTinhTrang(rs.getInt(9));
                hoaDonViewModel.setTenNguoiNhan(rs.getString(10));
                hoaDonViewModel.setDiaChi(rs.getString(11));
                hoaDonViewModel.setSdt(rs.getString(12));
                hoaDonViewModel.setDonGia(rs.getDouble(14));
                hoaDonViewModel.setSoLuong(rs.getInt(13));
                listHoaDonViewModels.add(hoaDonViewModel);
            }
            return listHoaDonViewModels;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public boolean add(HoaDon hoaDon) {
        String query = "INSERT INTO [dbo].[HoaDon] "
                + "           ([IdKH] "
                + "           ,[IdNV] "
                + "           ,[Ma] "
                + "           ,[NgayTao] "
                + "           ,[NgayThanhToan] "
                + "           ,[NgayShip] "
                + "           ,[NgayNhan] "
                + "           ,[TinhTrang] "
                + "           ,[TenNguoiNhan]"
                + "           ,[DiaChi] "
                + "           ,[Sdt]) "
                + "     VALUES "
                + "           (?,?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hoaDon.getKhachHang().getId());
            ps.setObject(2, hoaDon.getNhanVien().getId());
            ps.setObject(3, hoaDon.getMa());
            ps.setObject(4, hoaDon.getNgayTao());
            ps.setObject(5, hoaDon.getNgayThanhToan());
            ps.setObject(6, hoaDon.getNgayShip());
            ps.setObject(7, hoaDon.getNgayNhan());
            ps.setObject(8, hoaDon.getTinhTrang());
            ps.setObject(9, hoaDon.getTenNguoiNhan());
            ps.setObject(10, hoaDon.getDiaChi());
            ps.setObject(11, hoaDon.getsDT());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String id) {
        String query = "DELETE FROM [dbo].[HoaDon] "
                + "      WHERE Id = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(HoaDon hoaDon, String id) {
        String query = "UPDATE [dbo].[HoaDon] "
                + "   SET [IdKH] = ? "
                + "      ,[IdNV] = ? "
                + "      ,[Ma] = ? "
                + "      ,[NgayTao] = ? "
                + "      ,[NgayThanhToan] = ? "
                + "      ,[NgayShip] = ? "
                + "      ,[NgayNhan] = ? "
                + "      ,[TinhTrang] = ? "
                + "      ,[TenNguoiNhan] = ? "
                + "      ,[DiaChi] = ? "
                + "      ,[Sdt] = ? "
                + " WHERE [Id] = ? ";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hoaDon.getKhachHang().getId());
            ps.setObject(2, hoaDon.getNhanVien().getId());
            ps.setObject(3, hoaDon.getMa());
            ps.setObject(4, hoaDon.getNgayTao());
            ps.setObject(5, hoaDon.getNgayThanhToan());
            ps.setObject(6, hoaDon.getNgayShip());
            ps.setObject(7, hoaDon.getNgayNhan());
            ps.setObject(8, hoaDon.getTinhTrang());
            ps.setObject(9, hoaDon.getTenNguoiNhan());
            ps.setObject(10, hoaDon.getDiaChi());
            ps.setObject(11, hoaDon.getsDT());
            ps.setObject(12, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(String id) {
        String query = "UPDATE HoaDon SET TinhTrang = 1WHERE Id = ?";
        int chon = 0;
        try ( Connection cnn = DBConnection.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, id);
            chon = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chon > 0;
    }

    public static void main(String[] args) {
        List<HoaDonViewModel> list = new HoaDonRepositories().getFull();
        for (HoaDonViewModel hoaDon : list) {
            System.out.println(hoaDon.toString());
        }
    }
}
