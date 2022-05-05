/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author NgocThanh
 */
public class MonHoc implements Serializable{
    private int id;
    private String maTC;
    private String ten;
    private int soTC;
    private int isTinhDiem; //vs 0 là tính TB, 1 là không tính
    private ArrayList<MonHocDauDiem> dsdaudiem;

    public MonHoc() {
    }

    //maTC === maMH; dat ten sai
    public MonHoc(String maTC, String ten, int soTC, ArrayList<MonHocDauDiem> dsdaudiem) {
        this.maTC = maTC;
        this.ten = ten;
        this.soTC = soTC;
        this.dsdaudiem= dsdaudiem;
    }

    public int getIsTinhDiem() {
        return isTinhDiem;
    }

    public void setIsTinhDiem(int isTinhDiem) {
        this.isTinhDiem = isTinhDiem;
    }

    public ArrayList<MonHocDauDiem> getDsdaudiem() {
        return dsdaudiem;
    }

    public void setDsdaudiem(ArrayList<MonHocDauDiem> dsdaudiem) {
        this.dsdaudiem = dsdaudiem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaTC() {
        return maTC;
    }

    public void setMaTC(String maTC) {
        this.maTC = maTC;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoTC() {
        return soTC;
    }

    public void setSoTC(int soTC) {
        this.soTC = soTC;
    }

    public ArrayList<MonHocDauDiem> getDsdiem() {
        return dsdaudiem;
    }

    public void setDsdiem(ArrayList<MonHocDauDiem> dsdaudiem) {
        this.dsdaudiem = dsdaudiem;
    }
    
    
    
    
}
