package dao;

import model.KiHoc;
import model.SinhVien;

import java.util.List;

public interface IKiHocDAO {
    List<KiHoc> findAllOfSinhVien(SinhVien sv);

    KiHoc getKiHocByHocKiNamHoc(SinhVien sv, String hocKy, String namHoc);
}
