package iSergio.Reto03C3.controller;

import iSergio.Reto03C3.model.Cinema;
import iSergio.Reto03C3.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
@CrossOrigin permite las instrucciones de una fuente desconocida y con los metodos GET, POST, PUT, DELETE
Se crean los metodos @GetMapping para consultar todos los items (/all), por id (/{id}), y guardar (/save)
@CinemaController es el controlador de los metodos para la tabla Cinema
 */
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Cinema")
public class CinemaController {

    /*
     @cinemaService se crea instancia para llamar el Servicio
     */
    @Autowired
    private CinemaService cinemaService;

    /**
     getCinemas llama todos los items de la tabla
     @return lista de items
     */
    @GetMapping("/all")
    public List<Cinema> getCinemas(){
        return cinemaService.getAll();
    }

    /**
     getCinema llama el item de la tabla de acuerdo a su id
     @return item de acuerdo a su id
     */
    @GetMapping("/{id}")
    public Optional<Cinema> getCinema(@PathVariable("id") int id){
        return cinemaService.getCinema(id);
    }

    /**
     save llama al metodo POST cib el item nuevo
     @return guardar el nuevo elemento en la tabla Cinema
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema save(@RequestBody Cinema sala){
        return cinemaService.save(sala);
    }
}
