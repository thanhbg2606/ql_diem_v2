package service;

import model.DangKiHoc;
import model.KiHoc;
import model.SinhVien;
import model.WrapperDangKiHoc;

import java.util.List;

public interface IWrapperDangKiHocService {
    List<WrapperDangKiHoc> getAllDangKiHocSapXepTheoKi(SinhVien sv, KiHoc kiHoc);
}
