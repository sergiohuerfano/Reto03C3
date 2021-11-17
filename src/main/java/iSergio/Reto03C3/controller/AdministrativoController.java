package iSergio.Reto03C3.controller;

import iSergio.Reto03C3.model.Administrativo;
import iSergio.Reto03C3.service.AdministrativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Admin")
public class AdministrativoController {

    @Autowired
    private AdministrativoService administrativoService;

    @GetMapping("/all")
    public List<Administrativo> getAdministrativos(){
        return administrativoService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Administrativo> getAdministrativo(@PathVariable("id") int id){
        return administrativoService.getAdministrativo(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrativo save(@RequestBody Administrativo administrativo){
        return administrativoService.save(administrativo);
    }

}
