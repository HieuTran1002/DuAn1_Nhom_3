/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.ServiceImpl;

import DomainModels.LoaiSP;
import Repositories.LoaiSPRepository;
import Services.LoaiSPService;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class LoaiSPServiceImpl implements LoaiSPService{
    LoaiSPRepository loaiSPRepo = new LoaiSPRepository();
    @Override
    public boolean Add(LoaiSP loaiSP) {
        return loaiSPRepo.Add(loaiSP);
    }

    @Override
    public LoaiSP getOneID(String id) {
        return loaiSPRepo.getOneId(id);
    }

    @Override
    public List<LoaiSP> getAll() {
        return loaiSPRepo.getAll();
    }

    @Override
    public LoaiSP getOneTen(String ten) {
        return loaiSPRepo.getOneTen(ten);
    }
    
}
