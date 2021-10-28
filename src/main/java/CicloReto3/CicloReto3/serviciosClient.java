/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CicloReto3.CicloReto3;

/**
 *
 * @author LAPTOP
 */
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosClient {
    @Autowired
    private RepositorioClient metodosCrud;
    
    public List<Client> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Client> getClient(int idClient){
        return metodosCrud.getClient(idClient);
    }
    
    public Client save(Client client){
        if(client.getIdClient() == null){
            return metodosCrud.save(client);
        }else{
            Optional<Client> evt=metodosCrud.getClient(client.getIdClient());
            if(evt.isEmpty()){
                return metodosCrud.save(client);
            }else {
                return client;
            }
        }
    }
}
