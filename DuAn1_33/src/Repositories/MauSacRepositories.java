/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

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
 * @author HieuTran
 */
public class MauSacRepositories {

    public List<MauSac> getAll() {
        String query = "SELECT [Id]"
                + "      ,[Ma]"
                + "      ,[Ten]"
                + "  FROM [dbo].[MauSac]";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            List<MauSac> listms = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac ms = new MauSac(rs.getString(1), rs.getString(2), rs.getString(3));
                listms.add(ms);
            }
            return listms;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public MauSac getOne(String ten) {
        String query = "SELECT [Id]"
                + "      ,[Ma]"
                + "      ,[Ten]"
                + "  FROM [dbo].[MauSac]"
                + "  WHERE Ten = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac ms = new MauSac(rs.getString(1), rs.getString(2), rs.getString(3));
                return ms;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean Add(MauSac mauSac) {
        int check = 0;
        String query = "IF NOT EXISTS (SELECT Id,Ten,Ma FROM dbo.MauSac WHERE Ten = ?)\n"
                + "BEGIN\n"
                + "INSERT INTO dbo.MauSac\n"
                + "(\n"
                + "    Id,\n"
                + "    Ma,\n"
                + "    Ten\n"
                + ")\n"
                + "VALUES\n"
                + "(   ?, -- Id - uniqueidentifier\n"
                + "    ?,   -- Ma - varchar(20)\n"
                + "    ?   -- Ten - nvarchar(30)\n"
                + "    )\n"
                + "END";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, mauSac.getTen());
            ps.setObject(2, UUID.randomUUID());
            ps.setObject(3, mauSac.getMa());
            ps.setObject(4, mauSac.getTen());
            check = ps.executeUpdate();
            return check == 1;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check == 0;
    }
}
