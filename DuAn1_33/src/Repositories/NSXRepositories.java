/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.NSX;
import DomainModels.NSX;
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
public class NSXRepositories {

    public List<NSX> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "  FROM [dbo].[NSX]";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<NSX> listnsx = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NSX nsx = new NSX(rs.getString(1), rs.getString(2), rs.getString(3));
                listnsx.add(nsx);
            }
            return listnsx;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public NSX getOne(String ma) {
        String query = "SELECT [Id]"
                + "      ,[Ma]"
                + "      ,[Ten]"
                + "  FROM [dbo].[NSX]"
                + "  WHERE Ten = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NSX nsx = new NSX(rs.getString(1), rs.getString(2), rs.getString(3));
                return nsx;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public boolean Add(NSX nsx) {
        int check = 0;
        String query = "INSERT INTO [dbo].[NSX]\n"
                + "           ([Ma]\n"
                + "           ,[Ten])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, nsx.getMa());
            ps.setObject(2, nsx.getTen());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
