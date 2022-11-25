/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.ServiceImpl;

import DomainModels.MauSac;
import Repositories.MauSacRepositories;
import Services.MauSacService;
import java.util.List;

/**
 *
 * @author HieuTran
 */
public class MauSacServiceImpl implements MauSacService {

    public MauSacRepositories msr = new MauSacRepositories();

    @Override
    public List<MauSac> getAll() {
        return msr.getAll();
    }

    @Override
    public MauSac getOne(String ten) {
        return msr.getOne(ten);
    }

    @Override
    public String add(MauSac ms) {
        boolean add = msr.Add(ms);
        if (add == true) {
            return "Thêm Thành Công !";
        } else {
            return "Thêm Thất Bại !";
        }
    }

}
