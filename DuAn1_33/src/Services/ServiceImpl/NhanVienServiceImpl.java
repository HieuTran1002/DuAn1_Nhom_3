/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.ServiceImpl;

import DomainModels.NhanVien;
import Repositories.NhanVienRepositories;
import Services.NhanVienService;
import ViewModels.NhanVienViewModel;
import java.util.List;

/**
 *
 * @author HieuTran
 */
public class NhanVienServiceImpl implements NhanVienService{
    
    private NhanVienRepositories nvr = new NhanVienRepositories();
    
    @Override
    public List<NhanVienViewModel> getAll() {
        return nvr.getAll();
    }

    @Override
    public String Add(NhanVien nv) {
        boolean add = nvr.Add(nv);
        if (add) {
            return "Thêm Thành Công !";
        } else {
            return "Thêm Thất Bại !";
        }
    }

    @Override
    public String Update(NhanVien nv, String ma) {
        boolean update = nvr.Update(nv, ma);
        if (update) {
            return "Sửa Thành Công !";
        } else {
            return "Sửa Thất Bại !";
        }
    }

    @Override
    public String Delete(String ma) {
        boolean delete = nvr.delete(ma);
        if (delete) {
            return "Xóa Thành Công !";
        } else {
            return "Xóa Thất Bại !";
        }
    }

    @Override
    public NhanVien getOne(String ma) {
        return nvr.getOne(ma);
    }

    @Override
    public List<NhanVien> getFull() {
        return nvr.getFull();
    }

    @Override
    public NhanVienViewModel getOneT(String id) {
        return nvr.getOneT(id);
    }
    
}
