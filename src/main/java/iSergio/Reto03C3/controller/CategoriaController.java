package iSergio.Reto03C3.controller;

import iSergio.Reto03C3.model.Categoria;
import iSergio.Reto03C3.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 CategoriaController controlador
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Category")
public class CategoriaController {

    /**
     categoriaService llamado a los servicios de categoria
     */
    @Autowired
    private CategoriaService categoriaService;

    /**
     getCategorias llama a todos los items de la tabla
     @return listado de todos los items
     */
    @GetMapping("/all")
    public List<Categoria> getCategorias(){
        return categoriaService.getAll();
    }

    /**
     getCategoria llama el item de la tabla de acuerdo a su id
     @return item de acuerdo a su id
     */
    @GetMapping("/{id}")
    public Optional<Categoria> getCategoria(@PathVariable("id") int id){
        return categoriaService.getCategoria(id);
    }

    /**
     save llama al metodo POST con el item nuevo
     @return guardar el nuevo elemento en la tabla Categoria
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria categoria){
        return categoriaService.save(categoria);
    }
}
