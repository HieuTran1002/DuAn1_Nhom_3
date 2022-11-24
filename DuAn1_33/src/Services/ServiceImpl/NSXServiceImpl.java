/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.ServiceImpl;

import DomainModels.NSX;
import Repositories.NSXRepositories;
import Services.NSXService;
import java.util.List;

/**
 *
 * @author HieuTran
 */
public class NSXServiceImpl implements NSXService{

    public NSXRepositories nsxr = new NSXRepositories();
    
    @Override
    public List<NSX> getAll() {
        return nsxr.getAll();
    }

    @Override
    public NSX getOne(String id) {
        return nsxr.getOne(id);
    }

    @Override
    public String add(NSX nsx) {
        boolean add = nsxr.Add(nsx);
        if (add == true) {
            return "Thêm Thành Công !";
        } else {
            return "Thêm Thất Bại !";
        }
    }
    
}
