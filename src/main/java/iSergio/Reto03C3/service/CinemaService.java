package iSergio.Reto03C3.service;

import iSergio.Reto03C3.model.Cinema;
import iSergio.Reto03C3.repository.CinemaRepository;
import javassist.bytecode.Opcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAll(){
        return cinemaRepository.getAll();
    }

    public Optional<Cinema> getCinema(int id){
        return cinemaRepository.getCinema(id);
    }

    public Cinema save(Cinema a){
        if(a.getId()==null){
            return cinemaRepository.save(a);
        }else {
            Optional<Cinema> aAux=cinemaRepository.getCinema(a.getId());
            if(aAux.isEmpty()){
                return cinemaRepository.save(a);
            }else{
                return a;
            }
        }
    }
}
