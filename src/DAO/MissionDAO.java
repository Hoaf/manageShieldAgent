/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.MissionDTO;
import connect.connectToDatabase;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 *
 * @author Lenovo
 */
public class MissionDAO implements Serializable{
    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;
    
    public MissionDAO() {
       
    }
    private void closeDB()throws Exception{
            if(rs!=null)
                rs.close();
            if(preStm!=null);
                preStm.close();
            if(conn!=null)
                conn.close();            
    }
    public int countMRecord(String aname)throws Exception{
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Select count(*) From Mission Where MissionName LIKE ? ");
        preStm.setString(1,"%"+ aname+"%");
        int num =0;
        rs = preStm.executeQuery();
        if(rs.next())
            num = rs.getInt(1);
        closeDB();
        return num;
    }

    public boolean insert(MissionDTO dto)throws Exception{
        boolean check = false;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Insert into mission (MissionCode,MissionName,Target,Description,"
                + "BeginningDate,ExpiryDate,NumberOfAgent,location,MissionStatus) values (?,?,?,?,?,?,?,?,?)");
        preStm.setString(1,dto.getMisCode());
        preStm.setString(2,dto.getMisName());
        preStm.setString(3,dto.getTarget());
        preStm.setString(4,dto.getDescription());
        preStm.setString(5,dto.getBeginDate());
        preStm.setString(6,dto.getExpiryDate());
        preStm.setInt(7,dto.getNumofAgent());
        preStm.setString(8,dto.getLocation());
        preStm.setString(9,dto.getStatus());
        check = preStm.executeUpdate() > 0;
        closeDB();
        return check;
    }
    public boolean delete(String id)throws Exception{
        boolean check = false;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Delete From mission where missionCode = ?");
        preStm.setString(1, id);
        check = preStm.executeUpdate()>0;
        closeDB();
        return check;
    }
    public boolean update(MissionDTO dto)throws Exception{
        boolean check = false;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Update mission Set missionName=?,"
                + "target=?,description=?,beginningDate=?,expiryDate=?"
                + ",NumberOfAgent=?,location=?,missionstatus=? where MissionCode=?");
        preStm.setString(1,dto.getMisName());
        preStm.setString(2,dto.getTarget());
        preStm.setString(3,dto.getDescription());
        preStm.setString(4,dto.getBeginDate());
        preStm.setString(5,dto.getExpiryDate());
        preStm.setInt(6,dto.getNumofAgent());
        preStm.setString(7,dto.getLocation());
        preStm.setString(8,dto.getStatus());
        preStm.setString(9,dto.getMisCode());
        check = preStm.executeUpdate() > 0;
        closeDB();
        return check;
    }
    public List<MissionDTO> searchName(String name,int mCurPage)throws Exception{
        String missionCode, missionName, target, description, beginDate, expiryDate,location,status;
        int numberAgent;
        
        List<MissionDTO> result = null;
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Select Top 7 * From mission Where MissionName Like ? AND MissionCode not in "
                + "(Select top (? * 7-7) MissionCode From Mission)");
        preStm.setString(1,"%" + name + "%");
        preStm.setInt(2, mCurPage);
        rs = preStm.executeQuery();
        result = new ArrayList<MissionDTO>();
        
        while(rs.next()){
                missionCode = rs.getString("MissionCode");
                missionName = rs.getString("MissionName");
                target = rs.getString("Target");
                description = rs.getString("Description");
                beginDate = rs.getString("BeginningDate");
                expiryDate = rs.getString("ExpiryDate");
                numberAgent = rs.getInt("NumberOfAgent");
                location = rs.getString("location");
                status = rs.getString("MissionStatus");
                result.add(new MissionDTO(missionCode, missionName, target, description, beginDate, expiryDate,numberAgent,location,status));
        }
        closeDB();
        return result;
    }
    //return ExpiryDate
    public String searchByCode(String code)throws Exception{
        String expiryDate="";
        conn = connectToDatabase.getMyconnection();
        preStm = conn.prepareStatement("Select expirydate From Mission Where MissionCode = ?");
        preStm.setString(1, code);
        rs = preStm.executeQuery();
        if(rs.next())
            expiryDate = rs.getString("ExpiryDate");
        closeDB();
        return expiryDate;
    }
}
