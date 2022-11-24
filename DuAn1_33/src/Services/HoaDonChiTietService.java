/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.HoaDonChiTiet;
import ViewModels.SanPhamUpdateViewModel;
import java.util.List;

/**
 *
 * @author HieuTran
 */
public interface HoaDonChiTietService {

    List<SanPhamUpdateViewModel> getAll();

    String insert(HoaDonChiTiet hoaDonChiTiet);

    String update(HoaDonChiTiet hoaDonChiTiet, String ma);

    String delete(String ma);
}
