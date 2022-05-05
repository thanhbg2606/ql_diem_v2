package dao;

import model.DangKiHoc;
import model.KiHoc;
import model.SinhVien;

import java.util.List;

public interface IDangKiHocDAO {
    List<DangKiHoc> findAllByKyHocOfSinhVien(KiHoc kh, SinhVien sv);
}
