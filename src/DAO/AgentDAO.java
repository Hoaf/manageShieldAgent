/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.AgentDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connect.connectToDatabase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HOA.f
 */
public class AgentDAO implements Serializable{
    private Connection con = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;
    public AgentDAO() {
       
    }

    
    private void closeDB()throws Exception{
            if(rs!=null)
                rs.close();
            if(preStm!=null);
                preStm.close();
            if(con!=null)
                con.close();            
    }

    public String checkLogin(String id,String password)throws Exception{
        String role="failed";
        con = connectToDatabase.getMyconnection();
        String sql="Select Role From agentInfo where id = ? and password = ?";
            preStm = con.prepareStatement(sql);
            preStm.setString(1, id);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if(rs.next())
                role = rs.getString("role");
            closeDB();
        return role;
    }
    public String getName(String id)throws Exception{
        String name = "";
        con = connectToDatabase.getMyconnection();
        preStm = con.prepareStatement("Select name From agentInfo Where id = ?");
        preStm.setString(1, id);
        rs = preStm.executeQuery();
        if(rs.next())
            name = rs.getString("name");
        closeDB();
        return name;
    }
    public int countARecord(String aname)throws Exception{
        int numOfrecord=0;
        con = connectToDatabase.getMyconnection();
        preStm = con.prepareStatement("Select count(*) from agentInfo Where name LIKE ?");
        preStm.setString(1,"%"+aname+"%");
        rs = preStm.executeQuery();
        if(rs.next())
            numOfrecord = rs.getInt(1);
        closeDB();
        return numOfrecord;
    }
    public int countAisSuper(boolean isSuper)throws Exception{
        int numOfrecord=0;
        con = connectToDatabase.getMyconnection();
        preStm = con.prepareStatement("Select count(*) from agentInfo Where superpower = ?");
        preStm.setBoolean(1, isSuper);
        rs = preStm.executeQuery();
        if(rs.next())
            numOfrecord = rs.getInt(1);
        closeDB();
        return numOfrecord;
    }

    public List<AgentDTO> loadPowerOrNot(boolean isSuper,int aCurPage)throws Exception{
        String id,password,name,major,role,img;
        int degree,birth,height;
        boolean gender,superPow;
        List<AgentDTO> aresultList = null;
            con = connectToDatabase.getMyconnection();
            preStm = con.prepareStatement("Select top 7 * From agentInfo Where superpower = ? AND id not in (Select top (? * 7-7) id From agentInfo)");
            preStm.setBoolean(1, isSuper);
            preStm.setInt(2, aCurPage);
            rs = preStm.executeQuery();
            aresultList = new ArrayList();
            while(rs.next()){
                id = rs.getString("id");
                password = rs.getString("password");
                name = rs.getString("name");
                birth = rs.getInt("year of birth");
                height = rs.getInt("height");
                gender = rs.getBoolean("gender");
                role = rs.getString("role");
                superPow = rs.getBoolean("superpower");
                major = rs.getString("major");
                degree = rs.getInt("degree");
                img = rs.getString("image");
                if(id.matches("AG\\d{3}"))
                    aresultList.add(new AgentDTO(id, password, name, birth, height, gender, role, superPow, major, degree,img));
            }
            closeDB();
            return aresultList;
    }
    public boolean update(AgentDTO dto)throws Exception{
        boolean check = false;
        con = connectToDatabase.getMyconnection();
        preStm = con.prepareStatement("Update agentInfo Set password = ?,name = ?,[year of birth] = ?,height = ?,gender = ?"
                + ",role = ?,superpower = ?,major = ?,degree = ?,image = ? Where id = ?");
        preStm.setString(1, dto.getPassord());
        preStm.setString(2, dto.getName());
        preStm.setInt(3, dto.getYearOfBirth());
        preStm.setInt(4, dto.getHeight());
        preStm.setBoolean(5, dto.isGender());
        preStm.setString(6, dto.getRole());
        preStm.setBoolean(7, dto.isSuperpower());
        preStm.setString(8, dto.getMajor());
        preStm.setInt(9, dto.getDegree());
        preStm.setString(10, dto.getImage());
        preStm.setString(11, dto.getId());
        check = preStm.executeUpdate() > 0;
        closeDB();
        return check;
    }
    public boolean delete(String id)throws Exception{
        boolean check = false;
        con = connectToDatabase.getMyconnection();
        preStm = con.prepareStatement("Delete From agentInfo where id = ?");
        preStm.setString(1, id);
        check = preStm.executeUpdate() > 0;
        closeDB();
        return check;
    }
    public boolean insert(AgentDTO dto) throws Exception{
        boolean check = false;

        con = connectToDatabase.getMyconnection();
        preStm = con.prepareStatement("Insert into agentInfo (id,password,name,[year of birth],height,gender,role,superpower,major,"
                + "degree,image) values (?,?,?,?,?,?,?,?,?,?,?)");
        preStm.setString(1, dto.getId());
        preStm.setString(2, dto.getPassord());
        preStm.setString(3, dto.getName());
        preStm.setInt(4, dto.getYearOfBirth());
        preStm.setInt(5, dto.getHeight());
        preStm.setBoolean(6, dto.isGender());
        preStm.setString(7, dto.getRole());
        preStm.setBoolean(8, dto.isSuperpower());
        preStm.setString(9, dto.getMajor());
        preStm.setInt(10, dto.getDegree());
        preStm.setString(11, dto.getImage());
        check = preStm.executeUpdate() > 0;
        closeDB();
        return check;
    }
    public List<AgentDTO> searchAName(String aname,int aCurPage)throws Exception{
        List<AgentDTO> result=null;
        String id,password,name,major,role,img;
        int degree,birth,height;
        boolean gender,superPow;
        con = connectToDatabase.getMyconnection();
        preStm = con.prepareStatement("Select Top 7 * From agentInfo Where name Like ? AND id not in (Select top (? * 7-7) id From agentInfo)");
        preStm.setString(1,"%"+aname+"%");
        preStm.setInt(2,aCurPage);
        rs = preStm.executeQuery();
        result = new ArrayList();
        while(rs.next()){
                id = rs.getString("id");
                password = rs.getString("password");
                name = rs.getString("name");
                birth = rs.getInt("year of birth");
                height = rs.getInt("height");
                gender = rs.getBoolean("gender");
                role = rs.getString("role");
                superPow = rs.getBoolean("superpower");
                major = rs.getString("major");
                degree = rs.getInt("degree");
                img = rs.getString("image");
                if(id.matches("AG\\d{3}"))
                    result.add(new AgentDTO(id, password, name, birth, height, gender, role, superPow, major, degree,img));
        }
        closeDB();
        return result;
    }
    public AgentDTO searchByID(String aID)throws Exception{
        AgentDTO dto = null;
        String id,password,name,major,role,img;
        int degree,birth,height;
        boolean gender,superPow;
        con = connectToDatabase.getMyconnection();
        preStm = con.prepareStatement("Select * from agentInfo Where id = ?");
        preStm.setString(1, aID);
        rs = preStm.executeQuery();
        if(rs.next()){
            id = rs.getString("id");
            password = rs.getString("password");
            name = rs.getString("name");
            birth = rs.getInt("year of birth");
            height = rs.getInt("height");
            gender = rs.getBoolean("gender");
            role = rs.getString("role");
            superPow = rs.getBoolean("superpower");
            major = rs.getString("major");
            degree = rs.getInt("degree");
            img = rs.getString("image");
            dto = new AgentDTO(id, password, name, birth, height, gender, role, superPow, major, degree, img);
        }
        closeDB();
        return dto;  
    }
}
