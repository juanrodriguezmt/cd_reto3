
package CicloReto3.CicloReto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Bike")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorBikes {
    @Autowired
    private serviciosBikes servicios;
    @GetMapping("/all")
    public List <Bikes> getBikes(){
        return servicios.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Bikes> getBikes(@PathVariable("id") int idBikes){
        return servicios.getBikes(idBikes);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bikes save(@RequestBody Bikes bikes){
        return servicios.save(bikes);
    }
    
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bikes update(@RequestBody Bikes bikes){
        return servicios.update(bikes);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int bikeId){
        return servicios.deleteBike(bikeId);
    }
    
}
