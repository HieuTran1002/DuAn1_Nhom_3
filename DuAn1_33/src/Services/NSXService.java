/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.NSX;
import java.util.List;

/**
 *
 * @author HieuTran
 */
public interface NSXService {

    List<NSX> getAll();

    NSX getOne(String id);
    
    String add(NSX nsx);
}
