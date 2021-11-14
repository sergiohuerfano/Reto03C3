package iSergio.Reto03C3.repository;

import iSergio.Reto03C3.model.Cinema;
import iSergio.Reto03C3.repository.crud.CinemaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CinemaRepository {

    @Autowired
    private CinemaCrudRepository cinemaCrudRepository;

    public List<Cinema> getAll(){
        return (List<Cinema>) cinemaCrudRepository.findAll();
    }

    public Optional<Cinema> getCinema(int id){
        return cinemaCrudRepository.findById(id);
    }

    public Cinema save(Cinema sala){
        return cinemaCrudRepository.save(sala);
    }
}
