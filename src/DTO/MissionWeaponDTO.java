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
public class MissionWeaponDTO implements Serializable{
    private String missionCode;
    private String weaponCode;
    private String expiryDay;

    public MissionWeaponDTO(String missionCode, String weaponCode, String expiryDay) {
        this.missionCode = missionCode;
        this.weaponCode = weaponCode;
        this.expiryDay = expiryDay;
    }

    public String getMissionCode() {
        return missionCode;
    }

    public void setMissionCode(String missionCode) {
        this.missionCode = missionCode;
    }

    public String getWeaponCode() {
        return weaponCode;
    }

    public void setWeaponCode(String weaponCode) {
        this.weaponCode = weaponCode;
    }

    public String getExpiryDay() {
        return expiryDay;
    }

    public void setExpiryDay(String expiryDay) {
        this.expiryDay = expiryDay;
    }
    public Vector toVector(){
        Vector v = new Vector();
        v.add(weaponCode);
        return v;
    }
}
