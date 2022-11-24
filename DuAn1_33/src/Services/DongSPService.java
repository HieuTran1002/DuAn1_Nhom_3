/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.DongSP;
import java.util.List;

/**
 *
 * @author HieuTran
 */
public interface DongSPService {

    List<DongSP> getAll();

    DongSP getOne(String id);
    
    String add(DongSP dsp);
}
