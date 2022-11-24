/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.ServiceImpl;

import DomainModels.HoaDon;
import Repositories.HoaDonRepositories;
import Services.HoaDonService;
import ViewModels.HoaDonViewModel;
import java.util.List;

/**
 *
 * @author dungp
 */
public class HoaDonServiceImpl implements HoaDonService {

    HoaDonRepositories hoaDonRepository = new HoaDonRepositories();

    @Override
    public List<HoaDon> getAll() {
        return hoaDonRepository.getAll();
    }

    @Override
    public String add(HoaDon hoaDon) {
        boolean add = hoaDonRepository.add(hoaDon);
        if (add) {
            return "Tạo Thành Công";
        } else {
            return "Tạo Thất Bại";
        }
    }

    @Override
    public String update(HoaDon hoaDon, String id) {
        boolean update = hoaDonRepository.update(hoaDon, id);
        if (update) {
            return "Sửa Thành Công";
        } else {
            return "Sửa Thất Bại";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = hoaDonRepository.delete(id);
        if (delete) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Thất Bại";
        }
    }

    @Override
    public String UpdateThanhToan(String id) {
        boolean update = hoaDonRepository.update(id);
        if (update) {
            return "Cập Nhật Thành Công !";
        } else {
            return "Cập Nhật Thất Bại !";
        }
    }

    @Override
    public List<HoaDonViewModel> getFull() {
        return hoaDonRepository.getFull();
    }

}
