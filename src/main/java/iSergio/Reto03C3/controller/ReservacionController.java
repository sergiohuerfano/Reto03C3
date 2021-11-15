package iSergio.Reto03C3.controller;

import iSergio.Reto03C3.model.Reservacion;
import iSergio.Reto03C3.service.ReservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Reservation")
public class ReservacionController {

    @Autowired
    private ReservacionService reservacionService;

    @GetMapping("/all")
    public List<Reservacion> getReservas(){
        return reservacionService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservacion> getReserva(@PathVariable("id") int id){
        return reservacionService.getReserva(id);
    }

    /**
     save llama al metodo POST cib el item nuevo
     @return guardar el nuevo elemento en la tabla Reservation
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion save(@RequestBody Reservacion reserva){
        return reservacionService.save(reserva);
    }
}
