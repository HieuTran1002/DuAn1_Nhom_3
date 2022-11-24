/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.ServiceImpl;

import DomainModels.KhachHang;
import Repositories.KhachHangRepositories;
import Services.KhachHangService;
import java.security.Provider.Service;
import java.util.List;

/**
 *
 * @author admin
 */
public class KhachHangServiceImpl implements KhachHangService {
    
    KhachHangRepositories khr = new KhachHangRepositories();
    
    @Override
    public List<KhachHang> getAll() {
        return khr.getAll();
    }
    
    @Override
    public KhachHang getOne(String tenKH) {
        return khr.getOne(tenKH);
    }
    
    @Override
    public String add(KhachHang kh) {
        boolean add = khr.add(kh);
        if (add) {
            return "add thanh cong";
        } else {
            return "add that bai";
        }
    }
    
    @Override
    public String update(KhachHang kh, String idKH) {
        boolean update = khr.update(kh, idKH);
        if (update) {
            return "update thanh cong";
        } else {
            return "update that bai";
        }
    }
    
    @Override
    public String delete(String idKH) {
        boolean delete = khr.delete(idKH);
        if (delete) {
            return "delete thanh cong";
        } else {
            return "delete that bai";
        }
    }
    
}
