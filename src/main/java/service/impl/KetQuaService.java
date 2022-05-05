package service.impl;

import dao.IKetQuaDAO;
import dao.impl.KetQuaDAO;
import model.DangKiHoc;
import model.KetQua;
import model.MonHocDauDiem;
import service.IKetQuaService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class KetQuaService implements IKetQuaService {

    @Inject
    private IKetQuaDAO ketQuaDAO;
    @Override
    public List<KetQua> findAllByDangKiHocOfSinhVien(DangKiHoc dkh) {
        return ketQuaDAO.findAllByDangKiHocOfSinhVien(dkh);
    }

    //Hàm này để test
    public List<KetQua> findAllByDangKiHocOfSinhVien(DangKiHoc dkh, KetQuaDAO kqDAO) {
        return kqDAO.findAllByDangKiHocOfSinhVien(dkh);
    }

    @Override
    public List<KetQua> formatListKetQua(List<KetQua> kqs) {
        List<KetQua> result = new ArrayList<>();


        KetQua kq = new KetQua();
        kq.setDiem(-1);
        MonHocDauDiem mhdd = new MonHocDauDiem();
        mhdd.setTitle(0);
        kq.setDiemtp(mhdd);

        for (int i = 0; i < 5; i++) {
            result.add(kq);
        }

        for (KetQua d : kqs) {
            if (d.getDiemtp().getDauDiem().getTen().equals("Chuyên cần")) {
                result.set(0, d);
            }
            if (d.getDiemtp().getDauDiem().getTen().equals("Kiểm tra")) {
                result.set(1, d);
            }
            if (d.getDiemtp().getDauDiem().getTen().equals("Thực hành")) {
                result.set(2, d);
            }
            if (d.getDiemtp().getDauDiem().getTen().equals("Bài tập")) {
                result.set(3, d);
            }
            if (d.getDiemtp().getDauDiem().getTen().equals("Thi")) {
                result.set(4, d);
            }
        }

        return result;
    }

}
