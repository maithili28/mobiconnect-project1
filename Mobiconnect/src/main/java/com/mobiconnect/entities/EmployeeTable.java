package com.mobiconnect.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_TBL")
public class EmployeeTable {
    @Id
    private int ID;
    private String NAME;
    private String EMAIL;
    private String CONTENT;
    private String GENDER;
    private String DOB;
    private String DESIGNATION;
    private String ADDRESS;
    private String WORK_LOCATION;
    private String DATE_OF_JOINING;
    private String DATE_OF_EXIT;
    private String MANAGER;
    private String TOTAL_LEAVES;
    private String LEAVE_BALANCE;

    public EmployeeTable()
    {

    }

    public int getID() {
        return ID;
    }

    public void setID(int empId) {
        ID = empId;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String nAME) {
        NAME = nAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String eMAIL) {
        EMAIL = eMAIL;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String cONTENT) {
        CONTENT = cONTENT;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String gENDER) {
        GENDER = gENDER;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }

    public String getDESIGNATION() {
        return DESIGNATION;
    }

    public void setDESIGNATION(String dESIGNATION) {
        DESIGNATION = dESIGNATION;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String aDDRESS) {
        ADDRESS = aDDRESS;
    }

    public String getWORK_LOCATION() {
        return WORK_LOCATION;
    }

    public void setWORK_LOCATION(String wORK_LOCATION) {
        WORK_LOCATION = wORK_LOCATION;
    }

    public String getDATE_OF_JOINING() {
        return DATE_OF_JOINING;
    }

    public void setDATE_OF_JOINING(String dATE_OF_JOINING) {
        DATE_OF_JOINING = dATE_OF_JOINING;
    }

    public String getDATE_OF_EXIT() {
        return DATE_OF_EXIT;
    }

    public void setDATE_OF_EXIT(String dATE_OF_EXIT) {
        DATE_OF_EXIT = dATE_OF_EXIT;
    }

    public String getMANAGER() {
        return MANAGER;
    }

    public void setMANAGER(String mANAGER) {
        MANAGER = mANAGER;
    }

    public String getTOTAL_LEAVES() {
        return TOTAL_LEAVES;
    }

    public void setTOTAL_LEAVES(String tOTAL_LEAVES) {
        TOTAL_LEAVES = tOTAL_LEAVES;
    }

    public String getLEAVE_BALANCE() {
        return LEAVE_BALANCE;
    }

    public void setLEAVE_BALANCE(String lEAVE_BALANCE) {
        LEAVE_BALANCE = lEAVE_BALANCE;
    }

    public EmployeeTable(int iD, String nAME, String eMAIL, String cONTENT, String gENDER, String dOB,
            String dESIGNATION, String aDDRESS, String wORK_LOCATION, String dATE_OF_JOINING, String dATE_OF_EXIT,
            String mANAGER, String tOTAL_LEAVES, String lEAVE_BALANCE) {
        ID = iD;
        NAME = nAME;
        EMAIL = eMAIL;
        CONTENT = cONTENT;
        GENDER = gENDER;
        DOB = dOB;
        DESIGNATION = dESIGNATION;
        ADDRESS = aDDRESS;
        WORK_LOCATION = wORK_LOCATION;
        DATE_OF_JOINING = dATE_OF_JOINING;
        DATE_OF_EXIT = dATE_OF_EXIT;
        MANAGER = mANAGER;
        TOTAL_LEAVES = tOTAL_LEAVES;
        LEAVE_BALANCE = lEAVE_BALANCE;
    }

    @ManyToMany(mappedBy = "employeeTable",cascade = CascadeType.ALL)

    private List<ProjectTable>projectTable=new ArrayList<>();

    public List<ProjectTable> getProjectTable() {
        return projectTable;
    }

    public void setProjectTable(List<ProjectTable> projectTable) {
        this.projectTable = projectTable;
    }

    

 
    
    
}
