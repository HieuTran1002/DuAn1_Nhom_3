/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import ViewModels.HoaDonViewModel;
import java.util.List;

/**
 *
 * @author dungp
 */
public interface HoaDonService {

    List<HoaDon> getAll();

    String add(HoaDon hoaDon);

    List<HoaDonViewModel> getFull();

    String update(HoaDon hoaDon, String id);

    String delete(String id);

    String UpdateThanhToan(String id);
}
