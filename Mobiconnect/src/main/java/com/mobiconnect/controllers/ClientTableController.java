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

import com.mobiconnect.entities.ClientTable;
import com.mobiconnect.services.ClientTableService;

@RestController
public class ClientTableController {

    @Autowired
    private ClientTableService clientTableService;



    //get all clients
    @GetMapping("/client")
    public ResponseEntity<List<ClientTable>> getClient()
    {
        List<ClientTable>list=clientTableService.getAllClient();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
       
        return ResponseEntity.of(Optional.of(list));

    }


    //get single client handler
    @GetMapping("/client/{id}")
    public ResponseEntity<ClientTable> getClient(@PathVariable("id")int id)
    {
        ClientTable clientTable=clientTableService.getClientById(id);
        if(clientTable==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(clientTable));
    }



    //post data
    @PostMapping("/client")
    public ResponseEntity<Optional<ClientTable>> addClient(@RequestBody ClientTable clientTable)
    {
        ClientTable  c=null;
       try{
            c=this.clientTableService.addClient(clientTable);
            System.out.println(clientTable);
            return ResponseEntity.ok(Optional.of(c));
       }
       catch(Exception e)
       {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }


    //delete client handler
    @DeleteMapping("/client/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable("clientId")int clientId)
    {
       try{
        this.clientTableService.deleteClient(clientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }
       catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

       }
    }


    //update client handler
    @PutMapping("/client/{clientId}")
    public ResponseEntity<ClientTable>updateClient(@RequestBody ClientTable clientTable, @PathVariable("clientId")int clientId)
    {
        try{
            this.clientTableService.updateClient(clientTable,clientId);
            return ResponseEntity.ok().body(clientTable);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
