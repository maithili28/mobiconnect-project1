package com.mobiconnect.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mobiconnect.entities.ProjectTable;
import com.mobiconnect.repositories.ProjectTableRepository;
import com.mobiconnect.services.ProjectTableService;

@RestController
public class ProjectTableController {
    @Autowired
    private ProjectTableService projectTableService;


     //get all projects handler
     @GetMapping("/projects")
     public ResponseEntity<List<ProjectTable>> getProjects()
     {
         List<ProjectTable>list=projectTableService.getAllProjects();
         if(list.size()<=0)
         {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         return ResponseEntity.of(Optional.of(list));
     }


     //get single book handler
    @GetMapping("/projects/{id}")
    public ResponseEntity<ProjectTable> getProject(@PathVariable("id")int id)
    {
        ProjectTable projectTable=projectTableService.getProjectById(id);
        if(projectTable==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(projectTable));
    }
    

     //new project handler
     @PostMapping("/projects")
     public ResponseEntity<Optional<ProjectTable>> addProject(@RequestBody ProjectTable projectTable)
     {
         ProjectTable p=null;
        try{
             p=this.projectTableService.addProject(projectTable);
             System.out.println(projectTable);
             return ResponseEntity.ok(Optional.of(p));
        }
        catch(Exception e)
        {
             e.printStackTrace();
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
     }


     //delete project handler
    @DeleteMapping("/projects/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable("projectId")int projectId)
    {
       try{
        this.projectTableService.deleteProject(projectId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }
       catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }

     //update book handler
    @PutMapping("/projects/{projectId}")
    public ResponseEntity<ProjectTable>updateBook(@RequestBody ProjectTable projectTable, @PathVariable("projectId")int projectId)
    {
        try{
            this.projectTableService.updateBook(projectTable,projectId);
            return ResponseEntity.ok().body(projectTable);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
