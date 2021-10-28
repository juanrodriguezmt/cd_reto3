package CicloReto3.CicloReto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class RepositorioBikes {
    @Autowired
    private interfaceBikes crud;
    public List<Bikes> getAll(){
        return (List<Bikes>) crud.findAll();
    }
    
    public Optional <Bikes> getBikes (int id){
        return crud.findById(id);
    }
    
    public Bikes save(Bikes bikes){
        return crud.save(bikes);
    }
}
