package com.mobiconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobiconnect.entities.ProjectTable;
@Repository

public interface ProjectTableRepository extends JpaRepository<ProjectTable,Integer>{
    public ProjectTable findById(int id);
    
}
