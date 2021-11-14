package iSergio.Reto03C3.service;

import iSergio.Reto03C3.model.Reservacion;
import iSergio.Reto03C3.repository.ReservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservacionService {

    @Autowired
    private ReservacionRepository reservacionRepository;

    public List<Reservacion> getAll(){return reservacionRepository.getAll();}

    public Optional<Reservacion> getReserva(int id){return reservacionRepository.getReserva(id);}

    public Reservacion save(Reservacion reserva){
        if(reserva.getId()==null){
            return reservacionRepository.save(reserva);
        }else {
            Optional<Reservacion> reservaAux=reservacionRepository.getReserva(reserva.getId());
            if(reservaAux.isEmpty()){
                return reservacionRepository.save(reserva);
            }else{
                return reserva;
            }
        }
    }
}
