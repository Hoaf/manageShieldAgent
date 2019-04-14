/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.MissionWeaponDTO;
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
public class MissionWeaponDAO implements Serializable{
    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;
    
    private void closeDB()throws Exception{
        if(rs != null) rs.close();
        if(preStm != null) preStm.close();
        if(rs != null) rs.close();
    }
    /**
    *
    * return list mission borrow weapon wCode 
    */
    public List<MissionWeaponDTO> searchMission(String wCode) throws Exception{
        String mCode,weaCode,expiryDay;
        List<MissionWeaponDTO> result = null;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Select * From MissionWeapon Where WeaponCode = ?");
        preStm.setString(1, wCode);
        result = new ArrayList();
        rs = preStm.executeQuery();
        while(rs.next()){
            mCode = rs.getString("MissionCode");
            weaCode = rs.getString("WeaponCode");
            expiryDay = rs.getString("ExpiryDate");
            result.add(new MissionWeaponDTO(mCode, weaCode, expiryDay));
        }
        closeDB();
        return result;
    }
    /**
    *
    * return list weapon in mission
    */
    public List<MissionWeaponDTO> searchWeapon(String mCode)throws Exception{
        String misCode,weaCode,expiryDay;
        List<MissionWeaponDTO> result = null;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Select * From MissionWeapon Where MissionCode = ?");
        preStm.setString(1, mCode);
        rs = preStm.executeQuery();
        result = new ArrayList();
        while(rs.next()){
            misCode = rs.getString("MissionCode");
            weaCode = rs.getString("WeaponCode");
            expiryDay = rs.getString("ExpiryDate");
            result.add(new MissionWeaponDTO(misCode, weaCode, expiryDay));
        }
        closeDB();
        return result;
    }
    /**
    *
    * delete mission borrow this weapon
    */
    public boolean delete(String wCode)throws Exception{
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Delete from MissionWeapon Where WeaponCode = ?");
        preStm.setString(1, wCode);
        boolean check = preStm.executeUpdate()>0;
        closeDB();
        return check;
    }
    /**
    *
    * delete weapon in mission
    */
    public boolean deleteByMCode(String mCode)throws Exception{
        boolean check = false;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Delete From MissionWeapon Where MissionCode = ?");
        preStm.setString(1, mCode);
        check = preStm.executeUpdate() > 0;
        closeDB();
        return check;
    }
    public boolean insert(List<MissionWeaponDTO> list)throws Exception{
        conn = connectToDatabase.getMyconnection();
        boolean check = false;
        for(int i=0;i<list.size();i++){
            preStm = conn.prepareStatement("Insert into MissionWeapon (MissionCode,WeaponCode,ExpiryDate) values"
                    + "(?,?,?)");
            preStm.setString(1, list.get(i).getMissionCode());
            preStm.setString(2, list.get(i).getWeaponCode());
            preStm.setString(3, list.get(i).getExpiryDay());
            check = preStm.executeUpdate() > 0;
        }
        return check;
    }
}
