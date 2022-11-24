/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import java.util.List;

/**
 *
 * @author HieuTran
 */
public interface SanPhamService {

    List<SanPham> getAll();

    SanPham getOne(String id);
    
    String add(SanPham sp);
    
    String update(String id, int soLuong);
}
