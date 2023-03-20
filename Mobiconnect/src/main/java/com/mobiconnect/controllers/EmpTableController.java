package com.mobiconnect.controllers;


import java.util.Optional;
import java.util.List;
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

import com.mobiconnect.entities.EmployeeTable;
import com.mobiconnect.services.EmpTableService;

@RestController
public class EmpTableController {
    @Autowired
    private EmpTableService empTableService;


     //get all emp handler
     @GetMapping("/emp")
     public ResponseEntity<List<EmployeeTable>> getEmp()
     {
         List<EmployeeTable>list=empTableService.getAllEmp();
         if(list.size()<=0)
         {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         return ResponseEntity.of(Optional.of(list));
     }


      //get single emp handler
    @GetMapping("/emp/{id}")
    public ResponseEntity<EmployeeTable> getEmp(@PathVariable("id")int id)
    {
        EmployeeTable employeeTable=empTableService.getEmpById(id);
        if(employeeTable==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(employeeTable));
    }


    //new emp handler
    @PostMapping("/emp")
    public ResponseEntity<Optional<EmployeeTable>> addEmp(@RequestBody EmployeeTable employeeTable)
    {
        EmployeeTable em=null;
       try{
            em=this.empTableService.addEmp(employeeTable);
            System.out.println(employeeTable);
            return ResponseEntity.ok(Optional.of(em));
       }
       catch(Exception e)
       {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }


    //delete emp handler
    @DeleteMapping("/emp/{empId}")
    public ResponseEntity<Void> deleteEmp(@PathVariable("empId")int empId)
    {
       try{
        this.empTableService.deleteEmp(empId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }
       catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

       }
    }

     //update emp handler
     @PutMapping("/emp/{empId}")
     public ResponseEntity<EmployeeTable>updateEmp(@RequestBody EmployeeTable employeeTable, @PathVariable("empId")int empId)
     {
         try{
             this.empTableService.updateEmp(employeeTable,empId);
             return ResponseEntity.ok().body(employeeTable);
         }
         catch(Exception e)
         {
             e.printStackTrace();
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
     }
}
