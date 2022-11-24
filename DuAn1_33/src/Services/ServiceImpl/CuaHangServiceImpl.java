/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.ServiceImpl;

import DomainModels.CuaHang;
import Repositories.CuaHangReposition;
import Services.CuaHangService;
import java.util.List;

/**
 *
 * @author admin
 */
public class CuaHangServiceImpl implements CuaHangService {

    CuaHangReposition chr = new CuaHangReposition();

    @Override
    public List<CuaHang> getAll() {
        return chr.getAll();
    }

    @Override
    public CuaHang getOne(String tenCH) {
        return chr.getOne(tenCH);
    }

    @Override
    public String add(CuaHang ch) {
        boolean add = chr.add(ch);
        if (add) {
            return "add thanh cong";
        } else {
            return "add that bai";
        }
    }

    @Override
    public String update(CuaHang ch, String id) {
        boolean update = chr.update(ch, id);
        if (update) {
            return "update thanh cong";
        } else {
            return "update that bai";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = chr.delete(id);
        if (delete) {
            return "delete thanh cong";
        } else {
            return "delete that bai";
        }
    }

}
