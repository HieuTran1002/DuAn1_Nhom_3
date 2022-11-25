/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.TaiKhoan;
import Utilities.DBConnection;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class TaiKhoanReposition {
    
    public List<TaiKhoan> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[Password]\n"
                + "      ,[NgayTao]\n"
                + "      ,[VaiTro]\n"
                + "  FROM [dbo].[TaiKhoan]";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            List<TaiKhoan> listTK = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                listTK.add(tk);
            }
            return listTK;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public TaiKhoan getOne(String tenTK) {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[Password]\n"
                + "      ,[NgayTao]\n"
                + "      ,[VaiTro]\n"
                + "  FROM [dbo].[TaiKhoan]\n"
                + "  WHERE Ten like ?";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tenTK);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                return tk;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public boolean add(TaiKhoan tk) {
        String query = "INSERT INTO [dbo].[TaiKhoan]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[Password]\n"
                + "           ,[NgayTao]\n"
                + "           ,[VaiTro])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        int check = 0;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, tk.getMaTK());
            ps.setObject(2, tk.getTenTK());
            ps.setObject(3, tk.getPassTK());
            ps.setObject(4, tk.getNgayTao());
            ps.setObject(5, tk.getVaiTro());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean update(TaiKhoan tk, String idTK) {
        String query = "UPDATE [dbo].[TaiKhoan]\n"
                + "   SET [Ma] = ?"
                + "      ,[Ten] = ?"
                + "      ,[Password] = ?"
                + "      ,[NgayTao] = ?"
                + "      ,[VaiTro] = ?"
                + " WHERE Id like ?";
        int check = 0;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, tk.getMaTK());
            ps.setObject(2, tk.getTenTK());
            ps.setObject(3, tk.getPassTK());
            ps.setObject(4, tk.getNgayTao());
            ps.setObject(5, tk.getVaiTro());
            ps.setObject(6, idTK);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean delete(String idTK) {
        String query = "DELETE FROM [dbo].[TaiKhoan]\n"
                + "      WHERE Id like ?";
        int check = 0;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idTK);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
