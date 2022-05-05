package service.impl;

import dao.IKiHocDAO;
import model.KiHoc;
import model.SinhVien;
import service.IKiHocService;

import javax.inject.Inject;
import java.util.List;

public class KiHocService implements IKiHocService {

    @Inject
    private IKiHocDAO  kiHocDAO;

    @Override
    public List<KiHoc> findAllOfSinhVien(SinhVien sv) {
        return kiHocDAO.findAllOfSinhVien(sv);
    }

    @Override
    public KiHoc getKiHocByHocKiNamHoc(SinhVien sv, String hocKy, String namHoc) {
        return kiHocDAO.getKiHocByHocKiNamHoc(sv, hocKy, namHoc);
    }
}
