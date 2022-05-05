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
public class MonHocDauDiem implements Serializable{
    private int id;
    private DauDiem dauDiem;
    private float title;

    public MonHocDauDiem() {
    }
    
    

    public MonHocDauDiem(DauDiem dauDiem, float title) {
        this.dauDiem = dauDiem;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DauDiem getDauDiem() {
        return dauDiem;
    }

    public void setDauDiem(DauDiem dauDiem) {
        this.dauDiem = dauDiem;
    }

    public float getTitle() {
        return title;
    }

    public void setTitle(float title) {
        this.title = title;
    }
    
}
