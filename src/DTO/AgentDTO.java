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
public class AgentDTO implements Serializable{
    private String id;
    private String passord;
    private String name;
    private int yearOfBirth;
    private int height;
    private boolean gender;
    private String role;
    private boolean superpower;
    private String major;
    private int degree;
    private String image;
    public AgentDTO() {
    }

    public AgentDTO(String id, String passord, String name, int yearOfBirth, int height, boolean gender, String role, boolean superpower, String major, int degree,String image) {
        this.id = id;
        this.passord = passord;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.height = height;
        this.gender = gender;
        this.role = role;
        this.superpower = superpower;
        this.major = major;
        this.degree = degree;
        this.image = image;
    }   

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isSuperpower() {
        return superpower;
    }

    public void setSuperpower(boolean superpower) {
        this.superpower = superpower;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public Vector toVector(){
        Vector v = new Vector();
        v.add(id);
        v.add(name);
        v.add(major);
        v.add(degree);
        return v;
    }
}
