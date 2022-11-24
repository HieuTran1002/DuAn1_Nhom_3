/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.SanPham;
import Utilities.DBConnection;
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
public class SanPhamRepositories {

    public List<SanPham> getAll() {
        String query = "SELECT [Id]"
                + "      ,[Ma]"
                + "      ,[Ten]"
                + "  FROM [dbo].[SanPham]";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<SanPham> listsp = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3));
                listsp.add(sp);
            }
            return listsp;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public SanPham getOne(String ma) {
        String query = "SELECT [Id]"
                + "      ,[Ma]"
                + "      ,[Ten]"
                + "  FROM [dbo].[SanPham]"
                + "  WHERE Ten = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3));
                return sp;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean Add(SanPham sp) {
        int check = 0;
        String query = "INSERT INTO [dbo].[SanPham]\n"
                + "           ([Ma]\n"
                + "           ,[Ten])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateSoLuong(String Id, int soLuong) {
        int chon = 0;
        String query = "UPDATE ChiTietSP SET SoLuongTon = ? WHERE Id = ?";
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, soLuong);
            ps.setObject(2, Id);
            chon = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chon > 0;
    }
}
