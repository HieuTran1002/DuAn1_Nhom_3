/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.KhachHang;
import Utilities.DBConnection;
import Utilities.SQLServerConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class KhachHangRepositories {

    public List<KhachHang> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[TenDem]\n"
                + "      ,[Ho]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[Sdt]\n"
                + "      ,[DiaChi]\n"
                + "      ,[ThanhPho]\n"
                + "      ,[QuocGia]\n"
                + "      ,[MatKhau]\n"
                + "  FROM [dbo].[KhachHang]";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<KhachHang> listKH = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                listKH.add(kh);
            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(KhachHang kh) {
        String query = "INSERT INTO [dbo].[KhachHang]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[TenDem]\n"
                + "           ,[Ho]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[Sdt]\n"
                + "           ,[DiaChi]\n"
                + "           ,[ThanhPho]\n"
                + "           ,[QuocGia]\n"
                + "           ,[MatKhau])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getTenDem());
            ps.setObject(4, kh.getHo());
            ps.setObject(5, kh.getNgaySinh());
            ps.setObject(6, kh.getsDT());
            ps.setObject(7, kh.getDiaChi());
            ps.setObject(8, kh.getThanhPho());
            ps.setObject(9, kh.getQuocGia());
            ps.setObject(10, kh.getMatKhau());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(KhachHang kh, String idKH) {
        String query = "UPDATE [dbo].[KhachHang]\n"
                + "   SET [Ma] = ?"
                + "      ,[Ten] = ?"
                + "      ,[TenDem] =?"
                + "      ,[Ho] = ?"
                + "      ,[NgaySinh] = ?"
                + "      ,[Sdt] = ?"
                + "      ,[DiaChi] = ?"
                + "      ,[ThanhPho] = ?"
                + "      ,[QuocGia] = ?"
                + "      ,[MatKhau] =?"
                + " WHERE Id like ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getTenDem());
            ps.setObject(4, kh.getHo());
            ps.setObject(5, kh.getNgaySinh());
            ps.setObject(6, kh.getsDT());
            ps.setObject(7, kh.getDiaChi());
            ps.setObject(8, kh.getThanhPho());
            ps.setObject(9, kh.getQuocGia());
            ps.setObject(10, kh.getMatKhau());
            ps.setObject(11, idKH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String idKH) {
        String query = "DELETE FROM [dbo].[KhachHang]\n"
                + "      WHERE Id like ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, idKH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public KhachHang getOne(String tenKH) {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[TenDem]\n"
                + "      ,[Ho]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[Sdt]\n"
                + "      ,[DiaChi]\n"
                + "      ,[ThanhPho]\n"
                + "      ,[QuocGia]\n"
                + "      ,[MatKhau]\n"
                + "  FROM [dbo].[KhachHang]\n"
                + "  WHERE Ten like ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tenKH);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                return kh;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        List<KhachHang> list = new KhachHangRepositories().getAll();
        for (KhachHang khachHang : list) {
            System.out.println(khachHang.toString());
        }
    }
}
