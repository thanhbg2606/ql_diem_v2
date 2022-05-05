/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author NgocThanh
 */
public class DangKiHoc implements Serializable{
    private int id;
    private SinhVien SinhVien;
    private MonHocKiHoc monHocKiHoc;
    private List<KetQua> dsketqua;
    private float diemTBM;
    private float diemTBchu;

    private String xepLoai;

    public DangKiHoc() {
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

    public DangKiHoc(int id, SinhVien SinhVien, MonHocKiHoc monHocKiHoc, List<KetQua> dsketqua, float diemTBM, float diemTBchu, String xepLoai) {
        this.id = id;
        this.SinhVien = SinhVien;
        this.monHocKiHoc = monHocKiHoc;
        this.dsketqua = dsketqua;
        this.diemTBM = diemTBM;
        this.diemTBchu = diemTBchu;
        this.xepLoai = xepLoai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SinhVien getSinhVien() {
        return SinhVien;
    }

    public void setSinhVien(SinhVien SinhVien) {
        this.SinhVien = SinhVien;
    }

    public MonHocKiHoc getMonHocKiHoc() {
        return monHocKiHoc;
    }

    public void setMonHocKiHoc(MonHocKiHoc monHocKiHoc) {
        this.monHocKiHoc = monHocKiHoc;
    }

    public List<KetQua> getDsketqua() {
        return dsketqua;
    }

    public void setDsketqua(List<KetQua> dsketqua) {
        this.dsketqua = dsketqua;
    }

    public float getDiemTBM() {
        return diemTBM;
    }

    public void setDiemTBM(float diemTBM) {
        this.diemTBM = diemTBM;
    }

    //Điểm hệ 4
    public float getDiemTBchu() {
        return diemTBchu;
    }

    public void setDiemTBchu(float diemTBchu) {
        this.diemTBchu = diemTBchu;
    }
    
    public DangKiHoc getData(){
        return this;
    }
    
    
}
