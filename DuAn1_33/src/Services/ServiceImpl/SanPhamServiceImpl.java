/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.ServiceImpl;

import DomainModels.SanPham;
import Repositories.SanPhamRepositories;
import Services.SanPhamService;
import java.util.List;

/**
 *
 * @author HieuTran
 */
public class SanPhamServiceImpl implements SanPhamService {

    public SanPhamRepositories spr = new SanPhamRepositories();

    @Override
    public List<SanPham> getAll() {
        return spr.getAll();
    }

    @Override
    public SanPham getOne(String id) {
        return spr.getOne(id);
    }

    @Override
    public String add(SanPham sp) {
        boolean add = spr.Add(sp);
        if (add == true) {
            return "Thêm Thành Công !";
        } else {
            return "Thêm Thất Bại !";
        }
    }

    @Override
    public String update(String id, int soLuong) {
        boolean update = spr.updateSoLuong(id, soLuong);
        if (update == true) {
            return "Cập Nhật Số Lượng Tồn Thất Bại !";
        } else {
            return "Cập Nhật Số Lượng Tồn Thành Công !";
        }
    }

}
