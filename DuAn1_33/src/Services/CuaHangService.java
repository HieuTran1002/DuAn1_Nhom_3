/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.CuaHang;
import java.util.List;

/**
 *
 * @author admin
 */
public interface CuaHangService {

    List<CuaHang> getAll();

    CuaHang getOne(String tenCH);

    String add(CuaHang ch);

    String update(CuaHang ch, String idCH);

    String delete(String idCH);
}
