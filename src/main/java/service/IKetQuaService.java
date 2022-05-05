package service;

import model.DangKiHoc;
import model.KetQua;

import java.util.List;

public interface IKetQuaService {
    List<KetQua> findAllByDangKiHocOfSinhVien(DangKiHoc dkh);
    List<KetQua> formatListKetQua(List<KetQua> kqs);
}
