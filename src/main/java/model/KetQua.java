/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author NgocThanh
 */
public class KetQua implements Serializable{
    private int id;
    private MonHocDauDiem diemtp;
    private float diem;
    private String note;

    public KetQua() {
    }

    public KetQua(int id, MonHocDauDiem diemtp, float diem, String note) {
        this.id = id;
        this.diemtp = diemtp;
        this.diem = diem;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MonHocDauDiem getDiemtp() {
        return diemtp;
    }

    public void setDiemtp(MonHocDauDiem diemtp) {
        this.diemtp = diemtp;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
