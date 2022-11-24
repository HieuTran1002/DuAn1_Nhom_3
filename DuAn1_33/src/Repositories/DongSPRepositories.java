/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.DongSP;
import Utilities.DBConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HieuTran
 */
public class DongSPRepositories {

    public List<DongSP> getAll() {
        String query = "SELECT [Id]"
                + "      ,[Ma]"
                + "      ,[Ten]"
                + "  FROM [dbo].[DongSP]";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<DongSP> listdsp = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongSP dsp = new DongSP(rs.getString(1), rs.getString(2), rs.getString(3));
                listdsp.add(dsp);
            }
            return listdsp;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public DongSP getOne(String ma) {
        String query = "SELECT [Id]"
                + "      ,[Ma]"
                + "      ,[Ten]"
                + "  FROM [dbo].[DongSP]"
                + "  WHERE Ten = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongSP dsp = new DongSP(rs.getString(1), rs.getString(2), rs.getString(3));
                return dsp;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean Add(DongSP dsp) {
        int check = 0;
        String query = "INSERT INTO [dbo].[DongSP]\n"
                + "           ([Ma]\n"
                + "           ,[Ten])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, dsp.getMa());
            ps.setObject(2, dsp.getTen());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
