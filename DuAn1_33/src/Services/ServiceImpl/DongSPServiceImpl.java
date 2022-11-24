/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.ServiceImpl;

import DomainModels.DongSP;
import Repositories.DongSPRepositories;
import Services.DongSPService;
import java.util.List;

/**
 *
 * @author HieuTran
 */
public class DongSPServiceImpl implements DongSPService{

    public DongSPRepositories dspr = new DongSPRepositories();
    
    @Override
    public List<DongSP> getAll() {
        return dspr.getAll();
    }

    @Override
    public DongSP getOne(String id) {
        return dspr.getOne(id);
    }

    @Override
    public String add(DongSP dsp) {
        boolean add = dspr.Add(dsp);
        if (add == true) {
            return "Thêm Thành Công !";
        } else {
            return "Thêm Thất Bại !";
        }
    }
    
}
