/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.ServiceImpl;

import DomainModels.ChiTietSP;
import Repositories.ChiTietSPRepositories;
import Services.ChiTietSPService;
import ViewModels.SanPhamViewModel;
import java.util.List;

/**
 *
 * @author HieuTran
 */
public class ChiTietSPServiceImpl implements ChiTietSPService {

    ChiTietSPRepositories ctspr = new ChiTietSPRepositories();

    public List<ChiTietSP> getAll() {
        return ctspr.getAll();
    }

    @Override
    public String delete(String id) {
        boolean delete = ctspr.delete(id);
        if (delete == true) {
            return "Xóa Thành Công !";
        } else {
            return "Xóa Thất Bại !";
        }
    }

    @Override
    public String update(ChiTietSP ctsp, String id) {
        boolean update = ctspr.update(ctsp, id);
        if (update == true) {
            return "Sửa Thành Công !";
        } else {
            return "Sửa Thất Bại !";
        }
    }

    @Override
    public String add(ChiTietSP ctsp) {
        boolean add = ctspr.add(ctsp);
        if (add == true) {
            return "Thêm Thành Công !";
        } else {
            return "Thêm Thất Bại !";
        }
    }

    @Override
    public List<ChiTietSP> getID() {
        return ctspr.getDelete();
    }

}
