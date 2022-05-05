package model;

import java.util.ArrayList;
import java.util.List;

public class WrapperDangKiHoc {
    private List<DangKiHoc> dkhs;
    private float diemTBKiHienTai;
    private float getDiemTBTichLuy;
    private int soTCKyHienTai;
    private int soTCKyTichLuy;

    private String namHoc;

    private String hocKi;

    public String getNamHoc() {
        if(this.dkhs != null && !dkhs.isEmpty()){
            return dkhs.get(0).getMonHocKiHoc().getKiHoc().getNamhoc().getTem();
        }
        return "";
    }

    public String getHocKi() {
        if(this.dkhs != null && !dkhs.isEmpty()){
            return dkhs.get(0).getMonHocKiHoc().getKiHoc().getHocki().getTen();
        }
        return  "";
    }

    public WrapperDangKiHoc() {
    }

    public WrapperDangKiHoc(List<DangKiHoc> dkhs, float diemTBKiHienTai, float getDiemTBTichLuy, int soTCKyHienTai, int soTCKyTichLuy) {
        this.dkhs = dkhs;
        this.diemTBKiHienTai = diemTBKiHienTai;
        this.getDiemTBTichLuy = getDiemTBTichLuy;
        this.soTCKyHienTai = soTCKyHienTai;
        this.soTCKyTichLuy = soTCKyTichLuy;
    }

    public List<DangKiHoc> getDkhs() {
        return dkhs;
    }

    public void setDkhs(List<DangKiHoc> dkhs) {
        this.dkhs = dkhs;
    }

    public float getDiemTBKiHienTai() {
        return diemTBKiHienTai;
    }

    public void setDiemTBKiHienTai(float diemTBKiHienTai) {
        this.diemTBKiHienTai = diemTBKiHienTai;
    }

    public float getGetDiemTBTichLuy() {
        return getDiemTBTichLuy;
    }

    public void setGetDiemTBTichLuy(float getDiemTBTichLuy) {
        this.getDiemTBTichLuy = getDiemTBTichLuy;
    }

    public int getSoTCKyHienTai() {
        return soTCKyHienTai;
    }

    public void setSoTCKyHienTai(int soTCKyHienTai) {
        this.soTCKyHienTai = soTCKyHienTai;
    }

    public int getSoTCKyTichLuy() {
        return soTCKyTichLuy;
    }

    public void setSoTCKyTichLuy(int soTCKyTichLuy) {
        this.soTCKyTichLuy = soTCKyTichLuy;
    }
}
