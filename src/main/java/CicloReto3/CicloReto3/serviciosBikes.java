
package CicloReto3.CicloReto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class serviciosBikes {
    
    @Autowired
    private RepositorioBikes metodosCrud;
    
    public List<Bikes> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Bikes> getBikes(int idBikes){
        return metodosCrud.getBikes(idBikes);
    }
    
    public Bikes save(Bikes bikes){
        if(bikes.getId() == null){
            return metodosCrud.save(bikes);
        }else{
            Optional<Bikes> evt=metodosCrud.getBikes(bikes.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(bikes);
            }else {
                return bikes;
            }
        }
    }
}
