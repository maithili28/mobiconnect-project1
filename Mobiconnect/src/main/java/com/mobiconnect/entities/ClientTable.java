package com.mobiconnect.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CLIENT_TBL")
public class ClientTable {
	@Id
	
	private int ID;
	
	private String NAME;
	private String LOCATION;
	private String START_DATE;
	private String END_DATE;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
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
	public ClientTable(int iD, String nAME, String lOCATION, String sTART_DATE, String eND_DATE) {
		super();
		ID = iD;
		NAME = nAME;
		LOCATION = lOCATION;
		START_DATE = sTART_DATE;
		END_DATE = eND_DATE;
	}
	public ClientTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	@OneToMany(mappedBy = "clientTable",cascade = CascadeType.ALL)
	private List<ProjectTable>projectTable=new ArrayList<>();

	public List<ProjectTable> getProjectTable() {
		return projectTable;
	}
	public void setProjectTable(List<ProjectTable> projectTable) {
		this.projectTable = projectTable;
	}
	public ClientTable(int iD, String nAME, String lOCATION, String sTART_DATE, String eND_DATE,
			List<ProjectTable> projectTable) {
		ID = iD;
		NAME = nAME;
		LOCATION = lOCATION;
		START_DATE = sTART_DATE;
		END_DATE = eND_DATE;
		this.projectTable = projectTable;
	}
	@Override
	public String toString() {
		return "ClientTable [ID=" + ID + ", NAME=" + NAME + ", LOCATION=" + LOCATION + ", START_DATE=" + START_DATE
				+ ", END_DATE=" + END_DATE + ", projectTable=" + projectTable + "]";
	}
	
	




}
