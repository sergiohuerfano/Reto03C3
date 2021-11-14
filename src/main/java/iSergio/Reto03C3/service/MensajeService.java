package iSergio.Reto03C3.service;

import iSergio.Reto03C3.model.Mensaje;
import iSergio.Reto03C3.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    public List<Mensaje> getAll(){return mensajeRepository.getAll();}

    public Optional<Mensaje> getMensaje(int id){return mensajeRepository.getMensaje(id);}

    public Mensaje save(Mensaje msj){
        if(msj.getId()==null){
            return mensajeRepository.save(msj);
        }else {
            Optional<Mensaje> msjAux=mensajeRepository.getMensaje(msj.getId());
            if(msjAux.isEmpty()){
                return mensajeRepository.save(msj);
            }else{
                return msj;
            }
        }
    }
}
