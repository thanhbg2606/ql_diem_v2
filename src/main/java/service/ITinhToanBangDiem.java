package service;

import model.DangKiHoc;

import java.util.List;

public interface ITinhToanBangDiem {


    //bien check = true dùng để tính 1 kỳ
    //           = false dùng để tính tích lũy
    int TinhToanTinChi(List<DangKiHoc> dsmh, boolean check);

    float DiemTBKyHoc (List<DangKiHoc> dsmh, boolean check);
}
