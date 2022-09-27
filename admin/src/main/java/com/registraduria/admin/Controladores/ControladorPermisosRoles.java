package com.registraduria.admin.Controladores;

import com.registraduria.admin.Modelos.Permisos;
import com.registraduria.admin.Modelos.PermisosRoles;
import com.registraduria.admin.Modelos.Rol;
import com.registraduria.admin.Repositorios.RepositorioPermisos;
import com.registraduria.admin.Repositorios.RepositorioPermisosRoles;
import com.registraduria.admin.Repositorios.RepositorioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/permisos-roles")
public class ControladorPermisosRoles {
    @Autowired
    private RepositorioPermisosRoles miRepositorioPermisosRoles;
    @Autowired
    private RepositorioPermisos miRepositorioPermisos;
    @Autowired
    private RepositorioRol miRepositorioRol;
    @GetMapping("")
    public List<PermisosRoles> index(){
        return this.miRepositorioPermisosRoles.findAll();
    }
    /**
     * Asignación rol y permiso
     * @param id_rol
     * @param id_permisos
     * @return
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("rol/{id_rol}/permisos/{id_permisos}")
    public PermisosRoles create(@PathVariable String id_rol,@PathVariable
    String id_permisos){
        PermisosRoles nuevo=new PermisosRoles();
        Rol elRol=this.miRepositorioRol.findById(id_rol).get();
        Permisos elPermisos=this.miRepositorioPermisos.findById(id_permisos).get();
        if (elRol!=null && elPermisos!=null){
            nuevo.setPermisos(elPermisos);
            nuevo.setRol(elRol);
            return this.miRepositorioPermisosRoles.save(nuevo);
        }else{
            return null;
        }
    }
    @GetMapping("{id}")
    public PermisosRoles show(@PathVariable String id){
        PermisosRoles permisosRolesActual=this.miRepositorioPermisosRoles
                .findById(id)
                .orElse(null);
        return permisosRolesActual;
    }
    /**
     * Modificación Rol y Permiso
     * @param id
     * @param id_rol
     * @param id_permisos
     * @return
     */
    @PutMapping("{id}/rol/{id_rol}/permisos/{id_permisos}")
    public PermisosRoles update(@PathVariable String id,@PathVariable
    String id_rol,@PathVariable String id_permisos){
        PermisosRoles permisosRolesActual=this.miRepositorioPermisosRoles
                .findById(id)
                .orElse(null);
        Rol elRol=this.miRepositorioRol.findById(id_rol).get();
        Permisos
                elPermisos=this.miRepositorioPermisos.findById(id_permisos).get();
        if(permisosRolesActual!=null && elPermisos!=null && elRol!=null){
            permisosRolesActual.setPermisos(elPermisos);
            permisosRolesActual.setRol(elRol);
            return
                    this.miRepositorioPermisosRoles.save(permisosRolesActual);
        }else{
            return null;
        }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        PermisosRoles permisosRolesActual=this.miRepositorioPermisosRoles
                .findById(id)
                .orElse(null);
        if (permisosRolesActual!=null){
            this.miRepositorioPermisosRoles.delete(permisosRolesActual);
        }
    }
}


