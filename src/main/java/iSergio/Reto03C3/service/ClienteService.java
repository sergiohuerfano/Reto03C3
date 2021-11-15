package iSergio.Reto03C3.service;

import iSergio.Reto03C3.model.Cliente;
import iSergio.Reto03C3.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll(){return clienteRepository.getAll();}

    public Optional<Cliente> getCliente(int id){return clienteRepository.getCliente(id);}

    public Cliente save(Cliente cliente){
        if(cliente.getIdClient()==null){
            return clienteRepository.save(cliente);
        }else {
            Optional<Cliente> clienteAux=clienteRepository.getCliente(cliente.getIdClient());
            if(clienteAux.isEmpty()){
                return clienteRepository.save(cliente);
            }else{
                return cliente;
            }
        }
    }
}
