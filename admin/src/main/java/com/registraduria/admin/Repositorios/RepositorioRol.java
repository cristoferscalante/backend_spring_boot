package com.registraduria.admin.Repositorios;

import com.registraduria.admin.Modelos.Rol;
import com.registraduria.admin.Modelos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioRol extends MongoRepository<Rol,String> {
}
