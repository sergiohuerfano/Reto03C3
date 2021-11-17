package iSergio.Reto03C3.service;

import iSergio.Reto03C3.model.Calificacion;
import iSergio.Reto03C3.model.Categoria;
import iSergio.Reto03C3.repository.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    public List<Calificacion> getAll(){
        return calificacionRepository.getAll();
    }

    public Optional<Calificacion> getCalificacion(int id){
        return calificacionRepository.getCalifiacion(id);
    }

    public Calificacion save(Calificacion calificacion){
        if(calificacion.getIdScore()==null){
            return calificacionRepository.save(calificacion);
        }else {
            Optional<Calificacion> califiacionAux=calificacionRepository.getCalifiacion(calificacion.getIdScore());
            if(califiacionAux.isEmpty()){
                return calificacionRepository.save(calificacion);
            }else{
                return calificacion;
            }
        }
    }
}
