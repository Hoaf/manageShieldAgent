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
public class AgentMissionDTO implements Serializable{
    String agentID;
    String missionCode;

    public AgentMissionDTO(String agentID, String missionCode) {
        this.agentID = agentID;
        this.missionCode = missionCode;
    }

    public String getAgentID() {
        return agentID;
    }

    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }

    public String getMissionCode() {
        return missionCode;
    }

    public void setMissionCode(String missionCode) {
        this.missionCode = missionCode;
    }
    public Vector toVector(){
        Vector v = new Vector();
        v.add(agentID);
        return v;
    }
}
