package com.registraduria.admin.Repositorios;

import com.registraduria.admin.Modelos.Permisos;
import com.registraduria.admin.Modelos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPermisos extends MongoRepository<Permisos,String> {
}
