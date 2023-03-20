package com.mobiconnect.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PROJECT_TBL")
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @IdClass(ProjectPKId.class)
public class ProjectTable {
	@Id
	private int ID;
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// private int CLIENT_ID;
	private String OWNER_CLIENT;
	private String NAME;
	private String OWNER_CONSULTANT;
	private String START_DATE;
	private String END_DATE;
	private String STATUS;
	@ManyToOne
    private ClientTable clientTable;

	@ManyToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "id")
    private List<EmployeeTable>employeeTable=new ArrayList<>();

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	// public int getCLIENT_ID() {
	// 	return CLIENT_ID;
	// }
	// public void setCLIENT_ID(int cLIENT_ID) {
	// 	CLIENT_ID = cLIENT_ID;
	// }
	public String getOWNER_CLIENT() {
		return OWNER_CLIENT;
	}
	public void setOWNER_CLIENT(String oWNER_CLIENT) {
		OWNER_CLIENT = oWNER_CLIENT;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getOWNER_CONSULTANT() {
		return OWNER_CONSULTANT;
	}
	public void setOWNER_CONSULTANT(String oWNER_CONSULTANT) {
		OWNER_CONSULTANT = oWNER_CONSULTANT;
	}
	public String getSTART_DATE() {
		return START_DATE;
	}
	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}
	public String getEND_DATE() {
		return END_DATE;
	}
	public void setEND_DATE(String eND_DATE) {
		END_DATE = eND_DATE;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public ClientTable getClientTable() {
		return clientTable;
	}
	public void setClientTable(ClientTable clientTable) {
		this.clientTable = clientTable;
	}
	public ProjectTable(int iD,  String oWNER_CLIENT, String nAME, String oWNER_CONSULTANT,
			String sTART_DATE, String eND_DATE, String sTATUS, ClientTable clientTable) {
		ID = iD;
		//CLIENT_ID = cLIENT_ID;
		OWNER_CLIENT = oWNER_CLIENT;
		NAME = nAME;
		OWNER_CONSULTANT = oWNER_CONSULTANT;
		START_DATE = sTART_DATE;
		END_DATE = eND_DATE;
		STATUS = sTATUS;
		this.clientTable = clientTable;
	}
	
	public ProjectTable()
	{

	}
	public List<EmployeeTable> getEmployeeTable() {
		return employeeTable;
	}
	public void setEmployeeTable(List<EmployeeTable> employeeTable) {
		this.employeeTable = employeeTable;
	}

	

}
