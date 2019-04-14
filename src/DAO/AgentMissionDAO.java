/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.AgentMissionDTO;
import DTO.MissionDTO;
import connect.connectToDatabase;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class AgentMissionDAO implements Serializable{
    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;
    private void closeDB() throws Exception{
        if(rs != null) rs.close();
        if(preStm != null) preStm.close();
        if(conn != null) conn.close();
    }
    public List<AgentMissionDTO> searchByAID(String aID) throws Exception{
        List<AgentMissionDTO> result = null;
        String mCode;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Select MissionCode From AgentMission Where AgentID = ?");
        preStm.setString(1, aID);
        result = new ArrayList();
        rs = preStm.executeQuery();
        while(rs.next()){
            mCode = rs.getString("MissionCode");
            result.add(new AgentMissionDTO(aID,mCode));
        }
        closeDB();
        return result;
    }
    //Agent frame
    public List<MissionDTO> searchMissionByAID(String aID) throws Exception{
        List<MissionDTO> result = null;
        String misCode, misName,  target, description,beginDate,expiryDate, location,status;
        int numofAgent;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Select * from mission,AgentMission Where AgentMission.MissionCode = "
                + "mission.MissionCode AND AgentMission.AgentID = ?");
        preStm.setString(1,aID);
        rs = preStm.executeQuery();
        result = new ArrayList();
        while(rs.next()){
            misCode = rs.getString("MissionCode");
            misName = rs.getString("MissionName");
            target = rs.getString("Target");
            description = rs.getString("Description");
            beginDate = rs.getString("BeginningDate");
            expiryDate = rs.getString("ExpiryDate");
            numofAgent = rs.getInt("NumberOfAgent");
            location = rs.getString("Location");
            status = rs.getString("MissionStatus");
            result.add(new MissionDTO(misCode, misName, target, description, beginDate, expiryDate, numofAgent, location, status));
        }
        closeDB();
        return result;
    }
    public List<AgentMissionDTO> searchByMCode(String mCode) throws Exception{
        List<AgentMissionDTO> result = null;
        String agentID;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Select AgentID From AgentMission Where MissionCode = ?");
        preStm.setString(1, mCode);
        rs = preStm.executeQuery();
        result = new ArrayList();
        while(rs.next()){
            agentID = rs.getString("AgentID");
            result.add(new AgentMissionDTO(agentID, mCode));
        }
        closeDB();
        return result;
    }
    public boolean deleteByAid(String aID)throws Exception{
        boolean check = false;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Delete From AgentMission Where AgentID = ?");
        preStm.setString(1, aID);
        check = preStm.executeUpdate() > 0;
        closeDB();
        return check;
    }
    public boolean deleteByMCode(String mCode)throws Exception{
        boolean check;
        conn =connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Delete From AgentMission Where MissionCode = ?");
        preStm.setString(1, mCode);
        check = preStm.executeUpdate() > 0;
        return check;
    }
    public boolean insert(List<AgentMissionDTO> list) throws Exception{
        boolean check = false;
        conn = connectToDatabase.getMyconnection();
        for(int i =0; i<list.size();i++){
                preStm = conn.prepareStatement("Insert into AgentMission (AgentID,MissionCode) values(?,?)");
                preStm.setString(1, list.get(i).getAgentID());
                preStm.setString(2, list.get(i).getMissionCode());
                check = preStm.executeUpdate() > 0;
        }
        closeDB();
        return check;
    }
}
