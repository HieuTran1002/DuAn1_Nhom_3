/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.LoaiSP;
import DomainModels.MauSac;
import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ADMIN
 */
public class LoaiSPRepository {

    public List<LoaiSP> getAll() {
        String query = "SELECT [Id]"
                + "      ,[Ma]"
                + "      ,[Ten]"
                + "  FROM [dbo].[LoaiSP]";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            List<LoaiSP> listLoaiSP = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiSP loaiSP = new LoaiSP(rs.getString(1), rs.getString(2), rs.getString(3));
                listLoaiSP.add(loaiSP);
            }
            System.out.println(listLoaiSP);
            return listLoaiSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public LoaiSP getOneId(String id) {
        String query = "SELECT [Id]"
                + "      ,[Ma]"
                + "      ,[Ten]"
                + "  FROM [dbo].[LoaiSP]"
                + "  WHERE Id = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiSP loaiSP = new LoaiSP(rs.getString(1), rs.getString(2), rs.getString(3));
                return loaiSP;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public LoaiSP getOneTen(String ten) {
        String query = "SELECT [Id]"
                + "      ,[Ma]"
                + "      ,[Ten]"
                + "  FROM [dbo].[LoaiSP]"
                + "  WHERE Ten = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiSP loaiSP = new LoaiSP(rs.getString(1), rs.getString(2), rs.getString(3));
                return loaiSP;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean Add(LoaiSP loaiSP) {
        int check = 0;
        String query = "IF NOT EXISTS (SELECT Id,Ten,Ma FROM dbo.LoaiSP WHERE Ten = ?)\n"
                + "BEGIN\n"
                + "INSERT INTO [dbo].[LoaiSP]\n"
                + "           ([Id]\n"
                + "           ,[Ma]\n"
                + "           ,[Ten])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)"
                + "END";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, loaiSP.getTen());
            ps.setObject(2, UUID.randomUUID());
            ps.setObject(3, loaiSP.getMa());
            ps.setObject(4, loaiSP.getTen());
            check = ps.executeUpdate();
            return check == 1;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check == 0;
    }
}
