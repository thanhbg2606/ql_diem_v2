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
public class KiHoc implements Serializable{
    private int id;
    private HocKi hocki;
    private NamHoc namhoc;
    private Boolean danghoc;
    private Boolean dangdk;

    public KiHoc() {
    }

    public KiHoc(HocKi hocki, NamHoc namhoc, Boolean danghoc, Boolean dangdk) {
        this.hocki = hocki;
        this.namhoc = namhoc;
        this.danghoc = danghoc;
        this.dangdk = dangdk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HocKi getHocki() {
        return hocki;
    }

    public void setHocki(HocKi hocki) {
        this.hocki = hocki;
    }

    public NamHoc getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(NamHoc namhoc) {
        this.namhoc = namhoc;
    }

    public Boolean getDanghoc() {
        return danghoc;
    }

    public void setDanghoc(Boolean danghoc) {
        this.danghoc = danghoc;
    }

    public Boolean getDangdk() {
        return dangdk;
    }

    public void setDangdk(Boolean dangdk) {
        this.dangdk = dangdk;
    }
    
   
    
    
    
}
