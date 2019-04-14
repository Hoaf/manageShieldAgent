/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import DTO.WeaponDTO;
import connect.connectToDatabase;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Lenovo
 */
public class WeaponDAO implements Serializable{
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;
    private void closeDB()throws Exception{
        if(rs != null) rs.close();
        if(preStm != null) preStm.close();
        if(conn != null) conn.close();
    }
    
    public boolean insert(WeaponDTO dto)throws Exception{
        boolean check = false;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Insert into Weapon (WeaponCode,WeaponName,Fund,Description,Image) values "
                + "(?,?,?,?,?)");
        preStm.setString(1, dto.getWeaponCode());
        preStm.setString(2, dto.getWeaponName());
        preStm.setString(3, dto.getFund());
        preStm.setString(4, dto.getDes());
        preStm.setString(5, dto.getImage());
        check = preStm.executeUpdate()>0;
        closeDB();
        return check;
    }
    public boolean update(WeaponDTO dto) throws Exception{
        boolean check = false;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Update Weapon Set WeaponName = ?,Fund = ?, Description = ?,Image = ? "
                + "Where WeaponCode = ?");
        preStm.setString(1, dto.getWeaponName());
        preStm.setString(2, dto.getFund());
        preStm.setString(3, dto.getDes());
        preStm.setString(4, dto.getImage());
        preStm.setString(5, dto.getWeaponCode());
        check = preStm.executeUpdate()>0;
        closeDB();
        return check;
    }
    public boolean delete(String wCode) throws Exception{
        boolean check = false;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Delete from Weapon Where WeaponCode = ?");
        preStm.setString(1, wCode);
        check = preStm.executeUpdate() > 0;
        closeDB();
        return check;
    }
    public int countWRecord(String wName) throws Exception{
        int count =0;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Select count(*) From Weapon Where WeaponName LIKE ?");
        preStm.setString(1, "%"+wName+"%");
        rs = preStm.executeQuery();
        if(rs.next())
            count =  rs.getInt(1);
        closeDB();
        return count;
    }
    public List<WeaponDTO> searchByWName(String wName,int wCurPage)throws Exception{
        List<WeaponDTO> result = null;
        String code,name,fund,des,img;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Select top 7 * From Weapon Where WeaponName Like ? AND WeaponCode not in "
                + "(Select top (? * 7 - 7) WeaponCode From Weapon)");
        preStm.setString(1, "%" + wName + "%");
        preStm.setInt(2, wCurPage);
        rs = preStm.executeQuery();
        result = new ArrayList();
        while(rs.next()){
            code = rs.getString("WeaponCode");
            name = rs.getString("WeaponName");
            fund = rs.getString("Fund");
            des = rs.getString("Description");
            img = rs.getString("Image");
            result.add(new WeaponDTO(code, name, fund, des, img));
        }
        closeDB();
        return result;
    }
    public WeaponDTO searchByWCode(String wCode)throws Exception{
        String code,name,fund,des,img;
        WeaponDTO dto = null;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Select * From Weapon Where WeaponCode = ?");
        preStm.setString(1, wCode);
        rs = preStm.executeQuery();
        if(rs.next()){
            code = rs.getString("WeaponCode");
            name = rs.getString("WeaponName");
            fund = rs.getString("Fund");
            des = rs.getString("Description");
            img = rs.getString("Image");
            dto = new WeaponDTO(code, name, fund, des, img);
        }
        closeDB();
        return dto;
    }
}
