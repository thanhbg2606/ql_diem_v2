package service.impl;

import dao.IDangKiHocDAO;
import dao.IKetQuaDAO;
import dao.impl.DangKiHocDAO;
import dao.impl.KetQuaDAO;
import model.DangKiHoc;
import model.KetQua;
import model.KiHoc;
import model.SinhVien;
import service.IDangKiHocService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class DangKiHocService implements IDangKiHocService {

    @Inject
    IDangKiHocDAO dangKiHocDAO;

    @Inject
    IKetQuaDAO ketQuaDAO;

    @Override
    public List<DangKiHoc> findAllByKyHocOfSinhVien(KiHoc kh, SinhVien sv) {
        List<DangKiHoc> dkhs = null;
        //Lấy id của dangkihoc
        dkhs =dangKiHocDAO.findAllByKyHocOfSinhVien(kh, sv);

        int size = dkhs.size();

        //Có id của dangkihoc tìm các đầu điểm của dangkihoc
        for (int i = 0; i < size; i++ ){
            dkhs.get(i).setDsketqua(ketQuaDAO.findAllByDangKiHocOfSinhVien(dkhs.get(i)));
        }
        return dkhs;
    }

    public List<DangKiHoc> findAllByKyHocOfSinhVien(KiHoc kh, SinhVien sv, DangKiHocDAO DAO, KetQuaDAO kqDAO) {

        List<DangKiHoc> dkhs = null;
        dkhs =DAO.findAllByKyHocOfSinhVien(kh, sv);

        int size = dkhs.size();

        for (int i = 0; i < size; i++ ){
            dkhs.get(i).setDsketqua(kqDAO.findAllByDangKiHocOfSinhVien(dkhs.get(i)));
        }
        return dkhs;
    }

    @Override
    public DangKiHoc TinhToanDiemTBMon(DangKiHoc dkkh) {
        float diemTB = 0;
        List<KetQua> dskq = dkkh.getDsketqua();
        for(int i=0; i<dskq.size(); i++){
            diemTB += dskq.get(i).getDiem() * dskq.get(i).getDiemtp().getTitle();
        }
        diemTB =  (float)Math.round(diemTB*10)/10;
        dkkh.setDiemTBM(diemTB);
        return dkkh;
    }

    @Override
    public String XepHangDiem(float diem) {
        String result = "";
        float diemhe4;
        String kq = "Đạt";
        if (diem >= 9.0) {
            result = "A+";
            diemhe4 = (float) 4.0;
        }
        if (diem >= 8.5 && diem < 9.0) {
            result = "A";
            diemhe4 = (float) 3.7;
        }
        if (diem >= 8.0 && diem < 8.5) {
            result = "B+";
            diemhe4 = (float) 3.5;
        }
        if (diem >= 7.0 && diem < 8.0) {
            result = "B";
            diemhe4 = (float) 3.0;
        }
        if (diem >= 6.5 && diem < 7.0) {
            result = "C+";
            diemhe4 = (float) 2.5;
        }
        if (diem >= 5.5 && diem < 6.5) {
            result = "C";
            diemhe4 = (float) 2.0;
        }
        if (diem >= 5.0 && diem < 5.5) {
            result = "D+";
            diemhe4 = (float) 1.5;
        }
        if (diem >= 4.0 && diem < 5.0) {
            result = "D";
            diemhe4 = (float) 1.0;
        }
        if (diem < 4.0) {
            result = "F";
            diemhe4 = (float) 0.0;

        }

        return result;
    }

    @Override
    public List<DangKiHoc> XuLyMonHocLai(List<DangKiHoc> ds) {
        List<DangKiHoc> result = new ArrayList<>();

        //Tính toán điểm TB cho từng môn để so sánh
        for (DangKiHoc d : ds) {
            this.TinhToanDiemTBMon(d);
            result.add(d);
        }
        int size = ds.size();

        //2 môn học trùng ID, sẽ xóa môn học có điểm TB thấp hơn
        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j < size; j++) {
                if(ds.get(i).getMonHocKiHoc().getMh().getId() == ds.get(j).getMonHocKiHoc().getMh().getId()){
                    if(ds.get(i).getDiemTBM() >= ds.get(j).getDiemTBM()){
                        result.remove(j);
                    }
                    else
                        result.remove(i);
                }
            }
        }

        return result;
    }

    @Override
    public List<DangKiHoc> XuLyMonKhongTinhDiem(List<DangKiHoc> ds) {
        List<DangKiHoc> result = new ArrayList<>();

        for (DangKiHoc d : ds) {
            if(d.getMonHocKiHoc().getMh().getIsTinhDiem()==0){
                result.add(d);
            }

        }
        return result;
    }
}
