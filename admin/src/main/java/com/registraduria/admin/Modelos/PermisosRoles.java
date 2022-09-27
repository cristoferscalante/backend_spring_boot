package com.registraduria.admin.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class PermisosRoles {
    @Id
    private String _id;
    @DBRef
    private Rol rol;
    @DBRef
    private Permisos permisos;

    public PermisosRoles(){
    }

    public String get_id(){
        return _id;
    }

    public Rol getRol(){
        return rol;
    }

    public Permisos getPermisos() {
        return permisos;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }
}
