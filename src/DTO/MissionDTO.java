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
 * @author HOA.f
 */
public class MissionDTO implements Serializable{
    private String misCode;
    private String misName;
    private String target;
    private String description;
    private String beginDate;
    private String expiryDate;
    private int numofAgent;
    private String location;
    private String status;

    public MissionDTO(String misCode, String misName, String target, String description, String beginDate, String expiryDate, int numofAgent,String location,String status) {
        this.misCode = misCode;
        this.misName = misName;
        this.target = target;
        this.description = description;
        this.beginDate = beginDate;
        this.expiryDate = expiryDate;
        this.numofAgent = numofAgent; 
        this.location = location;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMisCode() {
        return misCode;
    }

    public void setMisCode(String misCode) {
        this.misCode = misCode;
    }

    public String getMisName() {
        return misName;
    }

    public void setMisName(String misName) {
        this.misName = misName;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getNumofAgent() {
        return numofAgent;
    }

    public void setNumofAgent(int numofAgent) {
        this.numofAgent = numofAgent;
    }
    public Vector toVector(){
        Vector v = new Vector();
        v.add(misCode);
        v.add(misName);
        v.add(target);
        v.add(numofAgent);
        return v;
    }
    public Vector toVectorAgentFrame(){
        Vector v = new Vector();
        v.add(misCode);
        v.add(beginDate);
        v.add(expiryDate);
        return v;
    }
}
