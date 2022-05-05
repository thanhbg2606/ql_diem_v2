package service;

import model.DangKiHoc;
import model.KiHoc;
import model.SinhVien;

import java.util.List;

public interface IDangKiHocService {
    List<DangKiHoc> findAllByKyHocOfSinhVien(KiHoc kh, SinhVien sv);
    DangKiHoc TinhToanDiemTBMon(DangKiHoc dkkh);

    String XepHangDiem(float diem);
    List<DangKiHoc> XuLyMonHocLai(List<DangKiHoc> ds);
    List<DangKiHoc> XuLyMonKhongTinhDiem(List<DangKiHoc> ds);
}
