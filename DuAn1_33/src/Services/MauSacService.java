/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.MauSac;
import java.util.List;

/**
 *
 * @author HieuTran
 */
public interface MauSacService {

    List<MauSac> getAll();

    MauSac getOne(String id);
    
    String add(MauSac ms);
}
