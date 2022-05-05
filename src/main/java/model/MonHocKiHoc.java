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
public class MonHocKiHoc implements Serializable{
    private int id;
    private MonHoc mh;
    private KiHoc kiHoc;

    public MonHocKiHoc() {
    }

    public MonHocKiHoc(int id, MonHoc mh, KiHoc kiHoc) {
        this.id = id;
        this.mh = mh;
        this.kiHoc = kiHoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MonHoc getMh() {
        return mh;
    }

    public void setMh(MonHoc mh) {
        this.mh = mh;
    }

    public KiHoc getKiHoc() {
        return kiHoc;
    }

    public void setKiHoc(KiHoc kiHoc) {
        this.kiHoc = kiHoc;
    } 
}
