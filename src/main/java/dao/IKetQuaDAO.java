package dao;

import model.DangKiHoc;
import model.KetQua;

import java.util.List;

public interface IKetQuaDAO {
    List<KetQua> findAllByDangKiHocOfSinhVien(DangKiHoc dkh);
}
