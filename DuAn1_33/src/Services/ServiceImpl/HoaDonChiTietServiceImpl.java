/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.ServiceImpl;

import DomainModels.HoaDonChiTiet;
import Repositories.HoaDonChiTietRepositories;
import Services.HoaDonChiTietService;
import ViewModels.SanPhamUpdateViewModel;
import java.util.List;

/**
 *
 * @author HieuTran
 */
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    private HoaDonChiTietRepositories hoaDonChiTietRepositories = new HoaDonChiTietRepositories();

    @Override
    public List<SanPhamUpdateViewModel> getAll() {
        return hoaDonChiTietRepositories.getAll();
    }

    @Override
    public String insert(HoaDonChiTiet hoaDonChiTiet) {
        boolean add = hoaDonChiTietRepositories.insert(hoaDonChiTiet);
        if (add == true) {
            return "Thêm Thành Công !";
        } else {
            return "Thêm Thất Bại !";
        }
    }

    @Override
    public String update(HoaDonChiTiet hoaDonChiTiet, String ma) {
        boolean update = hoaDonChiTietRepositories.update(hoaDonChiTiet, ma);
        if (update == true) {
            return "Thêm Thành Công !";
        } else {
            return "Thêm Thất Bại !";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = hoaDonChiTietRepositories.delete(ma);
        if (delete == true) {
            return "Thêm Thành Công !";
        } else {
            return "Thêm Thất Bại !";
        }
    }

}
