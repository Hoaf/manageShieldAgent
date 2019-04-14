/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Lenovo
 */
public class WeaponDTO implements Serializable{
    private String weaponCode;
    private String weaponName;
    private String fund;
    private String des;
    private String image;
        
    public WeaponDTO(String weaponCode, String weaponName, String fund, String des, String image) {
        this.weaponCode = weaponCode;
        this.weaponName = weaponName;
        this.fund = fund;
        this.des = des;
        this.image = image;
    }
    public WeaponDTO(){
        
    }
    public String getWeaponCode() {
        return weaponCode;
    }

    public void setWeaponCode(String weaponCode) {
        this.weaponCode = weaponCode;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public Vector toVector(){
        Vector v = new Vector();
        v.add(weaponCode);
        v.add(weaponName);
        v.add(fund);
        return v;
    }

}
