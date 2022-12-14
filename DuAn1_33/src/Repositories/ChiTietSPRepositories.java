/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChiTietSP;
import DomainModels.DongSP;
import DomainModels.MauSac;
import DomainModels.NSX;
import DomainModels.SanPham;
import Utilities.DBConnection;
import ViewModels.SanPhamViewModel;
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
public class ChiTietSPRepositories {

    public List<ChiTietSP> getDelete() {
        String query = "SELECT   dbo.ChiTietSP.ID, dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.ChiTietSP.NamBH, dbo.ChiTietSP.SoLuongTon, dbo.ChiTietSP.GiaNhap, dbo.ChiTietSP.GiaBan, dbo.DongSP.Ten AS Expr1, dbo.NSX.Ten AS Expr2, \n"
                + "                      dbo.MauSac.Ten AS Expr3, dbo.ChiTietSP.MoTa\n"
                + "FROM         dbo.ChiTietSP INNER JOIN\n"
                + "                      dbo.DongSP ON dbo.ChiTietSP.IdDongSP = dbo.DongSP.Id INNER JOIN\n"
                + "                      dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id INNER JOIN\n"
                + "                      dbo.NSX ON dbo.ChiTietSP.IdNsx = dbo.NSX.Id INNER JOIN\n"
                + "                      dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<ChiTietSP> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(2), rs.getString(3));
                MauSac ms = new MauSac(rs.getString(10));
                DongSP dsp = new DongSP(rs.getString(8));
                NSX nsx = new NSX(rs.getString(9));
                ChiTietSP ctsp = new ChiTietSP(rs.getString(1), sp, nsx, ms, dsp, rs.getInt(4), rs.getString(11), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                list.add(ctsp);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<ChiTietSP> getID() {
        String query = "SELECT   dbo.ChiTietSP.ID, dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.ChiTietSP.NamBH, dbo.ChiTietSP.SoLuongTon, dbo.ChiTietSP.GiaNhap, dbo.ChiTietSP.GiaBan, dbo.DongSP.Ten AS Expr1, dbo.NSX.Ten AS Expr2, \n"
                + "                      dbo.MauSac.Ten AS Expr3, dbo.ChiTietSP.MoTa\n"
                + "FROM         dbo.ChiTietSP INNER JOIN\n"
                + "                      dbo.DongSP ON dbo.ChiTietSP.IdDongSP = dbo.DongSP.Id INNER JOIN\n"
                + "                      dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id INNER JOIN\n"
                + "                      dbo.NSX ON dbo.ChiTietSP.IdNsx = dbo.NSX.Id INNER JOIN\n"
                + "                      dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<ChiTietSP> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(2), rs.getString(3));
                MauSac ms = new MauSac(rs.getString(10));
                DongSP dsp = new DongSP(rs.getString(8));
                NSX nsx = new NSX(rs.getString(9));
                ChiTietSP ctsp = new ChiTietSP(rs.getString(1), sp, nsx, ms, dsp, rs.getInt(4), rs.getString(11), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                list.add(ctsp);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


    public List<ChiTietSP> getAll() {
        String query = "SELECT dbo.ChiTietSP.Id AS Expr1, dbo.SanPham.*, dbo.NSX.*, dbo.MauSac.*, dbo.DongSP.*, dbo.ChiTietSP.NamBH, dbo.ChiTietSP.MoTa, dbo.ChiTietSP.SoLuongTon, dbo.ChiTietSP.GiaNhap, dbo.ChiTietSP.GiaBan\n"
                + "FROM     dbo.ChiTietSP INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "                  dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id INNER JOIN\n"
                + "                  dbo.NSX ON dbo.ChiTietSP.IdNsx = dbo.NSX.Id INNER JOIN\n"
                + "                  dbo.DongSP ON dbo.ChiTietSP.IdDongSP = dbo.DongSP.Id INNER JOIN\n"
                + "                  dbo.LoaiSP ON dbo.SanPham.IdLoaiSP = dbo.LoaiSP.Id";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            List<ChiTietSP> listCTSP = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                NSX nsx = new NSX(rs.getString(6), rs.getString(7), rs.getString(8));
                MauSac mauSac = new MauSac(rs.getString(9), rs.getString(10), rs.getString(11));
                DongSP dongSP = new DongSP(rs.getString(12), rs.getString(13), rs.getString(14));
                ChiTietSP ctsp = new ChiTietSP(rs.getString(1), sanPham, nsx, mauSac, dongSP, rs.getInt(15), rs.getString(16), rs.getInt(17), rs.getInt(18), rs.getInt(19));
                listCTSP.add(ctsp);
            }
            return listCTSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

//    public List<ChiTietSP> getTable() {
//        String query = "";
//        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
//            List<ChiTietSP> list = new ArrayList<>();
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                SanPham sp = new SanPham(rs.getString(1), rs.getString(2));
//                MauSac ms = new MauSac(rs.getString(9));
//                DongSP dsp = new DongSP(rs.getString(7));
//                NSX nsx = new NSX(rs.getString(8));
//                ChiTietSP ctsp = new ChiTietSP(sp, ms, dsp, nsx, rs.getInt(3), rs.getString(10), rs.getInt(4), rs.getDouble(5), rs.getDouble(6));
//                list.add(ctsp);
//            }
//            return list;
//        } catch (SQLException e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }

    public boolean update(ChiTietSP ctsp, String id) {
        String query = "UPDATE [dbo].[ChiTietSP]\n"
                + "   SET [IdSP] = ?"
                + "      ,[IdNsx] = ?"
                + "      ,[IdMauSac] = ?"
                + "      ,[IdDongSP] = ?"
                + "      ,[NamBH] = ?"
                + "      ,[MoTa] = ?"
                + "      ,[SoLuongTon] = ?"
                + "      ,[GiaNhap] = ?"
                + "      ,[GiaBan] = ?"
                + " WHERE Id = ?";
        int check = 0;
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ctsp.getSanPham().getId());
            ps.setObject(2, ctsp.getnSX().getId());
            ps.setObject(3, ctsp.getMauSac().getId());
            ps.setObject(4, ctsp.getDongSP().getId());
            ps.setObject(5, ctsp.getNamBH());
            ps.setObject(6, ctsp.getMoTa());
            ps.setObject(7, ctsp.getSoLuongTon());
            ps.setObject(8, ctsp.getGiaNhap());
            ps.setObject(9, ctsp.getGiaBan());
            ps.setObject(10, ctsp.getId());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean add(ChiTietSP ctsp) {
        String query = "INSERT INTO [dbo].[ChiTietSP]\n"
                + "           ([IdSP]\n"
                + "           ,[IdNsx]\n"
                + "           ,[IdMauSac]\n"
                + "           ,[IdDongSP]\n"
                + "           ,[NamBH]\n"
                + "           ,[MoTa]\n"
                + "           ,[SoLuongTon]\n"
                + "           ,[GiaNhap]\n"
                + "           ,[GiaBan])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ctsp.getSanPham().getId());
            ps.setObject(2, ctsp.getnSX().getId());
            ps.setObject(3, ctsp.getMauSac().getId());
            ps.setObject(4, ctsp.getDongSP().getId());
            ps.setObject(5, ctsp.getNamBH());
            ps.setObject(6, ctsp.getMoTa());
            ps.setObject(7, ctsp.getSoLuongTon());
            ps.setObject(8, ctsp.getGiaNhap());
            ps.setObject(9, ctsp.getGiaBan());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String id) {
        String query = "DELETE FROM [dbo].[ChiTietSP]"
                + "      WHERE Id = ?";
        int check = 0;
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
