package iSergio.Reto03C3.controller;

import iSergio.Reto03C3.model.Cliente;
import iSergio.Reto03C3.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Client")
public class ClienteController {

    /*
     @cinemaService se crea instancia para llamar el Servicio
     */
    @Autowired
    private ClienteService clienteService;

    /**
     getClientes llama a todos los items de la tabla
     @return listado de todos los items
     */
    @GetMapping("/all")
    public List<Cliente> getClientes(){
        return clienteService.getAll();
    }

    /**
     getCliente llama el item de la tabla de acuerdo a su id
     @return item de acuerdo a su id
     */
    @GetMapping("/{id}")
    public Optional<Cliente> getCliente(@PathVariable("id") int id){
        return clienteService.getCliente(id);
    }

    /**
     save llama al metodo POST con el item nuevo
     @return guardar el nuevo elemento en la tabla Cliente
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }
}
