/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CicloReto3.CicloReto3;

/**
 *
 * @author LAPTOP
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class RepositorioReservation {
    @Autowired
    private interfaceReservation crud;
    public List<Reservation> getAll(){
        return (List<Reservation>) crud.findAll();
    }
    
    public Optional <Reservation> getReservation (int id){
        return crud.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return crud.save(reservation);
    }
    
    public void delete(Reservation reservation){
        crud.delete(reservation);
    }
    
    public List<Reservation> getReservationByStatus(String status){
        return crud.findAllByStatus(status);
    }
    
    public List<Reservation> getReservationPeriod(Date a, Date b){
        return crud.findAllByStartDateAfterAndStartDateBefore(a,b);
    }
    
    public List<CountClients> getTopClients(){
        List<CountClients> res= new ArrayList<>();
        
        List<Object[]> report=crud.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            res.add(new CountClients((Long) report.get(i)[1],(Client)report.get(i)[0] ));
        }
        return res;
    }
}
