package service;

import model.KiHoc;
import model.SinhVien;

import java.util.List;

public interface IKiHocService {
    List<KiHoc> findAllOfSinhVien(SinhVien sv);

    KiHoc getKiHocByHocKiNamHoc(SinhVien sv, String hocKy, String namHoc);
}
