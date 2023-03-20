package com.mobiconnect.entities;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProjectPKId implements Serializable{
    private int ID;
	private int CLIENT_ID;  
    
}
