/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.KhachHang;
import java.util.List;

/**
 *
 * @author admin
 */
public interface KhachHangService {

    List<KhachHang> getAll();

    KhachHang getOne(String tenKH);

    String add(KhachHang kh);

    String update(KhachHang kh, String idKH);

    String delete(String idKH);
}
