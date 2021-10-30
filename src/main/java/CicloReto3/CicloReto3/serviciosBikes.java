
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
    
    public Bikes update(Bikes bike){
        if(bike.getId()!=null){
            Optional<Bikes> e=metodosCrud.getBikes(bike.getId());
            if(!e.isEmpty()){
                if(bike.getName()!=null){
                    e.get().setName(bike.getName());
                }
                if(bike.getBrand()!=null){
                    e.get().setBrand(bike.getBrand());
                }
                if(bike.getYear()!=null){
                    e.get().setYear(bike.getYear());
                }
                if(bike.getDescription()!=null){
                    e.get().setDescription(bike.getDescription());
                }
                if(bike.getCategory()!=null){
                    e.get().setCategory(bike.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return bike;}
        }else{
            return bike;}
    
    }
    
    public boolean deleteBike(int bikeId){
        Boolean aBoolean = getBikes(bikeId).map(bike -> {
            metodosCrud.delete(bike);
            return true;
        }).orElse(false);
        return aBoolean;
        }
    
    }
    

