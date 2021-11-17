package iSergio.Reto03C3.service;

import iSergio.Reto03C3.model.Administrativo;
import iSergio.Reto03C3.model.Categoria;
import iSergio.Reto03C3.repository.AdministrativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrativoService {

    @Autowired
    private AdministrativoRepository administrativoRepository;

    public List<Administrativo> getAll(){
        return administrativoRepository.getAll();
    }

    public Optional<Administrativo> getAdministrativo(int id){
        return administrativoRepository.getAdministrativo(id);
    }

    public Administrativo save(Administrativo administrativo){
        if(administrativo.getIdAdmin()==null){
            return administrativoRepository.save(administrativo);
        }else {
            Optional<Administrativo> adminAux=administrativoRepository.getAdministrativo(administrativo.getIdAdmin());
            if(adminAux.isEmpty()){
                return administrativoRepository.save(administrativo);
            }else{
                return administrativo;
            }
        }
    }
}
