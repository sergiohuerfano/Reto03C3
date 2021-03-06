package iSergio.Reto03C3.controller;

import iSergio.Reto03C3.model.Categoria;
import iSergio.Reto03C3.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Category")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/all")
    public List<Categoria> getCategorias(){
        return categoriaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getCategoria(@PathVariable("id") int id){
        return categoriaService.getCategoria(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria categoria){
        return categoriaService.save(categoria);
    }

}
