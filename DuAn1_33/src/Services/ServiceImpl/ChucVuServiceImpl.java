/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.ServiceImpl;

import DomainModels.ChucVu;
import Repositories.ChucVuReposition;
import Services.ChucVuService;
import java.util.List;

/**
 *
 * @author admin
 */
public class ChucVuServiceImpl implements ChucVuService {

    ChucVuReposition cvr = new ChucVuReposition();

    @Override
    public List<ChucVu> getAll() {
        return cvr.getAll();
    }

    @Override
    public ChucVu getOne(String tenCV) {
        return cvr.getOne(tenCV);
    }

    @Override
    public String add(ChucVu cv) {
        boolean add = cvr.add(cv);
        if (add) {
            return "add thanh cong";
        } else {
            return "add that bai";
        }
    }

    @Override
    public String update(ChucVu cv, String id) {
        boolean update = cvr.update(cv, id);
        if (update) {
            return "update thanh cong";
        } else {
            return "update that bai";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = cvr.delete(id);
        if (delete) {
            return "delete thanh cong";
        } else {
            return "delete that bai";
        }
    }

}
