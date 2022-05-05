package service.impl;

import model.*;
import service.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class WrapperDangKiHocService implements IWrapperDangKiHocService {

    @Inject
    private IKiHocService kiHocService;

    @Inject
    private IKetQuaService ketQuaService;

    @Inject
    private IDangKiHocService dangKiHocService;

    @Inject
    private ITinhToanBangDiem tinhToanBangDiem;

    @Override
    public List<WrapperDangKiHoc> getAllDangKiHocSapXepTheoKi(SinhVien sv, KiHoc kiHoc) {
        List<WrapperDangKiHoc> wrapperDangKiHocs = new ArrayList<>();
        List<KiHoc> khs = null;
        if(kiHoc == null){
            khs = kiHocService.findAllOfSinhVien(sv);
        }
        else {
            khs = new ArrayList<>();
            khs.add(kiHoc);
        }

        List<DangKiHoc> dangKiHocKyTichLuy = new ArrayList<>();

        for (KiHoc kh: khs) {
            WrapperDangKiHoc wrapperDangKiHoc = new WrapperDangKiHoc();

            //
            List<DangKiHoc> dangKiHocKyHienTai = new ArrayList<>();

            List<DangKiHoc> dkhs = dangKiHocService.findAllByKyHocOfSinhVien(kh, sv);
            for (DangKiHoc dkh : dkhs) {
                //Lấy ds kết quả của môn học
                List<KetQua> kqs = ketQuaService.findAllByDangKiHocOfSinhVien(dkh);

                //Format lại bảng điểm để hiển thị trên giao diện
                kqs = ketQuaService.formatListKetQua(kqs);
                dkh.setDsketqua(kqs);

                //Tính TB môn học
                dangKiHocService.TinhToanDiemTBMon(dkh);

                //Xếp loại dựa trên điểm TB
                dkh.setXepLoai(dangKiHocService.XepHangDiem(dkh.getDiemTBM()));

                dangKiHocKyHienTai.add(dkh);
                dangKiHocKyTichLuy.add(dkh);
            }

            //Tính toán tín chỉ
            //check = true -> tính toán cho kỳ hiện tại
            //check = false -> tính toán cho tích lũy
            int TCKyHienTai = tinhToanBangDiem.TinhToanTinChi(dangKiHocKyHienTai, true);
            int TCKyTichLuy = tinhToanBangDiem.TinhToanTinChi(dangKiHocKyTichLuy, false);

            //Tính toán điểm tích lũy
            float diemTBHienTai = tinhToanBangDiem.DiemTBKyHoc(dangKiHocKyHienTai, true);
            float diemTBTichLuy = tinhToanBangDiem.DiemTBKyHoc(dangKiHocKyTichLuy, false);

            wrapperDangKiHoc.setDkhs(dkhs);
            wrapperDangKiHoc.setSoTCKyHienTai(TCKyHienTai);
            wrapperDangKiHoc.setSoTCKyTichLuy(TCKyTichLuy);
            wrapperDangKiHoc.setDiemTBKiHienTai(diemTBHienTai);
            wrapperDangKiHoc.setGetDiemTBTichLuy(diemTBTichLuy);

            wrapperDangKiHocs.add(wrapperDangKiHoc);
        }
        return wrapperDangKiHocs;
    }
}
