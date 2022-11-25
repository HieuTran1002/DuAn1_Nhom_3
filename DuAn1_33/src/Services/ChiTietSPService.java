/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.ChiTietSP;
import ViewModels.SanPhamViewModel;
import java.util.List;

/**
 *
 * @author HieuTran
 */
public interface ChiTietSPService {

    List<ChiTietSP> getAll();

    List<ChiTietSP> getID();

    String delete(String id);

    String update(ChiTietSP ctsp, String id);

    String add(ChiTietSP ctsp);
}
