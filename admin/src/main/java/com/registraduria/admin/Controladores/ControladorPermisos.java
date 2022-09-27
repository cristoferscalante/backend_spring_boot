package com.registraduria.admin.Controladores;

import com.registraduria.admin.Modelos.Permisos;
import com.registraduria.admin.Repositorios.RepositorioPermisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/permisos")
public class ControladorPermisos {
    @Autowired
    private RepositorioPermisos miRepositorioPermisos;
    @GetMapping("")
    public List<Permisos> index(){
        return this.miRepositorioPermisos.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Permisos create(@RequestBody Permisos infoPermisos){
        return this.miRepositorioPermisos.save(infoPermisos);
    }
    @GetMapping("{id}")
    public Permisos show(@PathVariable String id){
        Permisos permisosActual=this.miRepositorioPermisos
                .findById(id)
                .orElse(null);
        return permisosActual;
    }
    @PutMapping("{id}")
    public Permisos update(@PathVariable String id,@RequestBody  Permisos infoPermisos){
        Permisos permisosActual=this.miRepositorioPermisos
                .findById(id)
                .orElse(null);
        if(permisosActual!=null){
            permisosActual.setMetodo(infoPermisos.getMetodo());
            permisosActual.setUrl(infoPermisos.getUrl());
            return this.miRepositorioPermisos.save(permisosActual);
        }else{
            return null;
        }

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Permisos permisosActual=this.miRepositorioPermisos
                .findById(id)
                .orElse(null);
        if (permisosActual!=null){
            this.miRepositorioPermisos.delete(permisosActual);
        }
    }
}

