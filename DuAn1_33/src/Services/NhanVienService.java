/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.NhanVien;
import ViewModels.NhanVienViewModel;
import java.util.List;

/**
 *
 * @author HieuTran
 */
public interface NhanVienService {

    List<NhanVienViewModel> getAll();
    
    List<NhanVien> getFull();

    NhanVien getOne(String ma);

    String Add(NhanVien nv);

    String Update(NhanVien nv, String ma);

    String Delete(String ma);
    
    NhanVienViewModel getOneT(String id);
    
}
