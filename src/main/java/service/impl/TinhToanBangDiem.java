package service.impl;

import model.DangKiHoc;
import service.IDangKiHocService;
import service.ITinhToanBangDiem;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;



public class TinhToanBangDiem implements ITinhToanBangDiem {
    @Inject
    private IDangKiHocService dangKiHocService;

    @Override
    public int TinhToanTinChi(List<DangKiHoc> dsmh, boolean check) {
        List<DangKiHoc> ds = new ArrayList<>();
        if(check == false){
            ds = dangKiHocService.XuLyMonHocLai(dangKiHocService.XuLyMonKhongTinhDiem(dsmh));
        }
        else{
            ds = dangKiHocService.XuLyMonKhongTinhDiem(dsmh);
        }
        int res = 0;
        for (DangKiHoc d : ds) {
            if (d.getDiemTBM() >= 4.0) {
                res+=d.getMonHocKiHoc().getMh().getSoTC();
            }
        }
        return res;
    }

    public int TinhToanTinChi(List<DangKiHoc> dsmh, boolean check, DangKiHocService service) {
        List<DangKiHoc> ds = new ArrayList<>();
        if(check == false){
            ds = service.XuLyMonHocLai(service.XuLyMonKhongTinhDiem(dsmh));
        }
        else{
            ds = service.XuLyMonKhongTinhDiem(dsmh);
        }
        int res = 0;
        for (DangKiHoc d : ds) {
            if (d.getDiemTBM() >= 4.0) {
                res+=d.getMonHocKiHoc().getMh().getSoTC();
            }
        }
        return res;
    }

    @Override
    public float DiemTBKyHoc(List<DangKiHoc> dsmh, boolean check) {
        List<DangKiHoc> ds = new ArrayList<>();
        if(check == false){
            ds = dangKiHocService.XuLyMonHocLai(dangKiHocService.XuLyMonKhongTinhDiem(dsmh));
        }
        else{
            ds = dangKiHocService.XuLyMonKhongTinhDiem(dsmh);
        }
        System.out.println("so mon dau ra tinh diem:" +ds.size());
        float res = 0.0f;
        for (DangKiHoc d : ds) {
            dangKiHocService.TinhToanDiemTBMon(d);
            if (d.getDiemTBM() >= 9.0) {

                d.setDiemTBchu(4.0f);
            }
            if (d.getDiemTBM() >= 8.5 && d.getDiemTBM() < 9.0) {

                d.setDiemTBchu(3.7f);
            }
            if (d.getDiemTBM() >= 8.0 && d.getDiemTBM() < 8.5) {

                d.setDiemTBchu(3.5f);
            }
            if (d.getDiemTBM() >= 7.0 && d.getDiemTBM() < 8.0) {

                d.setDiemTBchu(3.0f);
            }
            if (d.getDiemTBM() >= 6.5 && d.getDiemTBM() < 7.0) {

                d.setDiemTBchu(2.5f);
            }
            if (d.getDiemTBM() >= 5.5 && d.getDiemTBM() < 6.5) {

                d.setDiemTBchu(2.0f);
            }
            if (d.getDiemTBM() >= 5.0 && d.getDiemTBM() < 5.5) {

                d.setDiemTBchu(1.5f);
            }
            if (d.getDiemTBM() >= 4.0 && d.getDiemTBM() < 5.0) {

                d.setDiemTBchu(1.0f);
            }
            if (d.getDiemTBM() < 4.0) {

                d.setDiemTBchu(0.0f);

            }

        }
        int count = 0;
        for (DangKiHoc d1 : ds) {
            res += d1.getMonHocKiHoc().getMh().getSoTC() * d1.getDiemTBchu();
            count += d1.getMonHocKiHoc().getMh().getSoTC();
        }

        res = res / count;
        System.out.println((float) Math.round(res * 100) / 100);
        return (float) Math.round(res * 100) / 100;
    }

    public float DiemTBKyHoc(List<DangKiHoc> dsmh, boolean check, DangKiHocService service) {
        List<DangKiHoc> ds = new ArrayList<>();
        if(check == false){
            ds = service.XuLyMonHocLai(service.XuLyMonKhongTinhDiem(dsmh));
        }
        else{
            ds = service.XuLyMonKhongTinhDiem(dsmh);
        }
        System.out.println("so mon dau ra tinh diem:" +ds.size());
        float res = 0.0f;
        for (DangKiHoc d : ds) {
            service.TinhToanDiemTBMon(d);
            if (d.getDiemTBM() >= 9.0) {

                d.setDiemTBchu(4.0f);
            }
            if (d.getDiemTBM() >= 8.5 && d.getDiemTBM() < 9.0) {

                d.setDiemTBchu(3.7f);
            }
            if (d.getDiemTBM() >= 8.0 && d.getDiemTBM() < 8.5) {

                d.setDiemTBchu(3.5f);
            }
            if (d.getDiemTBM() >= 7.0 && d.getDiemTBM() < 8.0) {

                d.setDiemTBchu(3.0f);
            }
            if (d.getDiemTBM() >= 6.5 && d.getDiemTBM() < 7.0) {

                d.setDiemTBchu(2.5f);
            }
            if (d.getDiemTBM() >= 5.5 && d.getDiemTBM() < 6.5) {

                d.setDiemTBchu(2.0f);
            }
            if (d.getDiemTBM() >= 5.0 && d.getDiemTBM() < 5.5) {

                d.setDiemTBchu(1.5f);
            }
            if (d.getDiemTBM() >= 4.0 && d.getDiemTBM() < 5.0) {

                d.setDiemTBchu(1.0f);
            }
            if (d.getDiemTBM() < 4.0) {

                d.setDiemTBchu(0.0f);

            }

        }
        int count = 0;
        for (DangKiHoc d1 : ds) {
            res += d1.getMonHocKiHoc().getMh().getSoTC() * d1.getDiemTBchu();
            count += d1.getMonHocKiHoc().getMh().getSoTC();
        }

        res = res / count;
        System.out.println((float) Math.round(res * 100) / 100);
        return (float) Math.round(res * 100) / 100;
    }
}
