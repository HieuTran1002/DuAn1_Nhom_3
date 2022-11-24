/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.CuaHang;
import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CuaHangReposition {

    public List<CuaHang> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[DiaChi]\n"
                + "      ,[ThanhPho]\n"
                + "      ,[QuocGia]\n"
                + "  FROM [dbo].[CuaHang]";
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            List<CuaHang> listCH = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CuaHang ch = new CuaHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                listCH.add(ch);
            }
            return listCH;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public CuaHang getOne(String ten) {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[DiaChi]\n"
                + "      ,[ThanhPho]\n"
                + "      ,[QuocGia]\n"
                + "  FROM [dbo].[CuaHang]\n"
                + "  WHERE Ten like ? ";
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CuaHang ch = new CuaHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                return ch;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(CuaHang ch) {
        String query = "INSERT INTO [dbo].[CuaHang]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[DiaChi]\n"
                + "           ,[ThanhPho]\n"
                + "           ,[QuocGia])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        int check = 0;
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ch.getMa());
            ps.setObject(2, ch.getTen());
            ps.setObject(3, ch.getDiaChi());
            ps.setObject(4, ch.getThanhPho());
            ps.setObject(5, ch.getQuocGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(CuaHang ch, String id) {
        String query = "UPDATE [dbo].[CuaHang]\n"
                + "   SET [Ma] = ?"
                + "      ,[Ten] = ?"
                + "      ,[DiaChi] = ?"
                + "      ,[ThanhPho] = ?"
                + "      ,[QuocGia] = ?"
                + " WHERE Id like ?";
        int check = 0;
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ch.getMa());
            ps.setObject(2, ch.getTen());
            ps.setObject(3, ch.getDiaChi());
            ps.setObject(4, ch.getThanhPho());
            ps.setObject(5, ch.getQuocGia());
            ps.setObject(6, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String idCH) {
        String query = "DELETE FROM [dbo].[CuaHang]\n"
                + "      WHERE Id like ?";
        int check = 0;
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idCH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
