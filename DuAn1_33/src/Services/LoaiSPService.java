/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.LoaiSP;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface LoaiSPService {

    boolean Add(LoaiSP loaiSP);

    LoaiSP getOne(String ten);

    List<LoaiSP> getAll();
}
