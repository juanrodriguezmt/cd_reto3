package CicloReto3.CicloReto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAPTOP
 */
@Repository

public class RepositorioClient {
    @Autowired
    private interfaceClient crud;
    public List<Client> getAll(){
        return (List<Client>) crud.findAll();
    }
    
    public Optional <Client> getClient (int id){
        return crud.findById(id);
    }
    
    public Client save(Client client){
        return crud.save(client);
    }
}
